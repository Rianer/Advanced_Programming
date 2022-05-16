package main;

import DAO.PostgresSQLDAO;
import client_io.RequestDecoder;
import models.Message;
import models.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ClientThread extends Thread {

    class Control{
        public volatile boolean inputReceived = false;
        public volatile boolean clientLeft = false;
    }
    final Control control = new Control();

    class Timeout extends Thread{

        private Socket socket;
        private int timeOutSeconds;

        public Timeout(Socket socket, int seconds) {
            this.socket = socket;
            this.timeOutSeconds = seconds;
        }

        public void run(){
            int remainingTime = timeOutSeconds;
            while(remainingTime > 0){
                if(control.clientLeft){
                    remainingTime = 0;
                    break;
                }
                if(control.inputReceived){
                    control.inputReceived = false;
                    remainingTime = timeOutSeconds;
                }
                if(remainingTime == 5){
                    System.out.println("Closing connection in 5 seconds!");
                }
                try {
                    Thread.sleep(1000);
                    remainingTime--;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            if(!control.clientLeft){
                try {
                    socket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private Socket socket = null;
    private ServerSocket serverSocket = null;
    private RequestDecoder requestDecoder;
    private boolean servingClient;

    private User currentUser;
    private final PostgresSQLDAO sqldao = new PostgresSQLDAO();
    public ClientThread(Socket socket, ServerSocket serverSocket) {
        this.socket = socket;
        this.serverSocket = serverSocket;
        this.requestDecoder = new RequestDecoder();
        this.servingClient = true;
        currentUser = new User(-1, "noUser");
    }

    public void run() {
        try {
            Timeout timer = new Timeout(socket, 60);
            timer.start();
            while (servingClient) {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                String request = in.readLine();
                control.inputReceived = true;
                String response = processRequest(request);
                response += "*";
                PrintWriter out = new PrintWriter(socket.getOutputStream());
                out.print(response);
                out.flush();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                socket.close(); // or use try-with-resources
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String processRequest(String request) throws IOException {
        if (requestDecoder.decodeRequest(request) == RequestDecoder.STOP_CODE) {
            serverSocket.close();
            return "Server stopped!";
        }
        if (requestDecoder.decodeRequest(request) == RequestDecoder.UNKNOWN_REQUEST_CODE) {
            return "Server received unknown request: " + request;
        }
        if (requestDecoder.decodeRequest(request) == RequestDecoder.CLIENT_EXIT_CODE) {
            servingClient = false;
            control.clientLeft = true;
            return "Closing connection...";
        }
        if(requestDecoder.decodeRequest(request) == RequestDecoder.ADD_USER_CODE){
            //return registerUser(request);
            return addUserToDB(request);
        }
        if(requestDecoder.decodeRequest(request) == RequestDecoder.LOGIN_USER_CODE){
            return loginUser(request);
        }
        if(requestDecoder.decodeRequest(request) == RequestDecoder.ADD_FRIEND_CODE){
            return addFriends(request);
        }
        if(requestDecoder.decodeRequest(request) == RequestDecoder.GET_ALL_FRIENDS_CODE){
            return showFriends();
        }
        if(requestDecoder.decodeRequest(request) == RequestDecoder.GET_ALL_USERS_CODE){
            return showUsers();
        }
        if(requestDecoder.decodeRequest(request) == RequestDecoder.SEND_MESSAGE_CODE){
            return sendMessage(request);
        }
        if(requestDecoder.decodeRequest(request) == RequestDecoder.SEND_MESSAGE_CODE){
            return sendMessage(request);
        }
        if(requestDecoder.decodeRequest(request) == RequestDecoder.READ_MESSAGES_CODE){
            return readMessages();
        }
        if(requestDecoder.decodeRequest(request) == RequestDecoder.READ_MESSAGE_FROM_USER_CODE){
            return readMessagesFromUser(request);
        }
        if(requestDecoder.decodeRequest(request) == RequestDecoder.DELETE_RECEIVED_MESS_CODE){
            return deleteReceivedMessages(request);
        }
        if(requestDecoder.decodeRequest(request) == RequestDecoder.DELETE_SENT_MESS_CODE){
            return deleteSentMessages();
        }
        if(requestDecoder.decodeRequest(request) == RequestDecoder.DELETE_FRIEND_CODE){
            return deleteFriend(request);
        }
        if(requestDecoder.decodeRequest(request) == RequestDecoder.DELETE_USER_FROM_DB_CODE){
            return deleteUser(request);
        }
        return "Server received the request " + request;
    }

    private String loginUser(String request){
        String userName = request.substring(5).trim();
        try{
            User user = sqldao.getUser(userName);
            if(user != null){
                currentUser = user;
                return "Logged in as " + currentUser.getName() + "!";
            }
        }
        catch (SQLException e){
            return e.getMessage();
        }

        return "No such user in database!";
    }

    private String addUserToDB(String request){
        String userName = request.substring(8).trim();
        int executionCode = 0;
        if(userName.contains("*")) return "Forbidden character: '*' !";
        if(userName.contains(" ")) return "Forbidden character: ' ' !";
        try{
            executionCode = sqldao.addUser(userName);
            if(executionCode == -1) return "User with name " + userName + " is already registered!";
            return "Added user " + userName + " to database!";
        }
        catch (SQLException e){
            return e.getMessage();
        }
    }

    private String addFriends(String request){

        if(currentUser.getId() == -1){
            return "Must be logged in to add friend!";
        }
        String names = request.substring(6).trim();
        List<String> friends = Arrays.asList(names.split(" "));

        String response = "Status:\n";

        for(String friend : friends){
            response += friend + ": ";
            try{
                int executeCode = sqldao.addFriend(currentUser.getName(), friend);
                if(executeCode == -1){
                    response += "Data not found!\n";
                }
                else if(executeCode == -2){
                    response += "Friend's name is the same as current user's name!\n";
                }
                else if(executeCode == -3){
                    response += "Friend already recorded!\n";
                }
                else {
                    response += "Added friend " + friend + " to user " + currentUser.getName() + "!\n";
                }
            }
            catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
        response = response.substring(0, response.length()-1);
        return response;
    }

    private String showFriends(){
        if(currentUser.getId() == -1){
            return "Must be logged in to show friends!";
        }
        List<User> friendList = new ArrayList<>();
        try{
            friendList = sqldao.getFriends(currentUser.getName());
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        if(friendList.isEmpty()){
            return "No friends registered!";
        }
        String response = "Your friends: ";
        for(User friend : friendList){
            response += friend.getName() + ", ";
        }
        response = response.substring(0,response.length()-2);
        response += ".";
        return response;
    }

    private String showUsers(){
        String response = "All users: ";
        List<User> users = new ArrayList<>();
        try {
            users = sqldao.getAllUsers();
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        if(users.isEmpty()) return "No users registered!";
        for(User user : users){
            response += user.getName() + ", ";
        }
        response = response.substring(0, response.length()-2);
        response += ".";
        return  response;
    }

    private String sendMessage(String request) {
        String message = request.substring(5);
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd, HH.mm.ss").format(new Date());
        message = "[" + timeStamp + "] " + message;
        String response = "";
        if(currentUser.getId() == -1) return "You need to be logged in to send messages!";
        List<User> friendList = new ArrayList<>();
        try{
            friendList = sqldao.getFriends(currentUser.getName());
            for(User friend : friendList){
                sqldao.sendMessage(currentUser.getId(), friend.getId(), message);
                response+="Sent message to " + friend.getName() + ";\n";
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return response;
    }

    private String readMessages(){
        if(currentUser.getId() == -1) return "You need to be logged in to read messages!";
        String response = "";
        List<Message> messages = new ArrayList<>();
        try {
            messages = sqldao.getMessagesByReceiver(currentUser.getId());
            if(messages.isEmpty()) return "No messages found!";
            for(Message message : messages){
                User sender = sqldao.getUser(message.getSenderId());
                response += sender.getName() + ": " + message.getMessage() + ";\n";
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }

        response = response.substring(0,response.length()-1);
        return response;
    }

    private String readMessagesFromUser(String request){
        String name = request.substring(9).trim();
        String response = "Messages from " + name + ":\n";
        List<Message> messages = new ArrayList<>();
        try{
            messages = sqldao.getMessagesBySender(name);
            if(messages.isEmpty()) return "No messages found!";
            for(Message message : messages){
                response += message.getMessage() + ";\n";
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }

        response = response.substring(0,response.length()-1);
        return response;
    }

    private String deleteReceivedMessages(String request){
        String name = request.substring(11).trim();
        int executionCode = 0;
        try{
            executionCode = sqldao.deleteReceivedMessagesFrom(name);
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        if(executionCode == 0) return "No messages from user " + name + " have been recorded";
        return "Messages from user " + name + " have been deleted!";
    }

    private String deleteSentMessages(){
        try{
            sqldao.deleteSentMessages(currentUser.getId());
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return "Deleted all sent messages!";
    }

    private String deleteFriend(String request){
        int executionCode = 0;
        String friendName = request.substring(13).trim();
        try{
            executionCode = sqldao.deleteFriend(currentUser.getId(), friendName);
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        if(executionCode == -1) return "User " + friendName + " not found in database!";
        if(executionCode == 0) return "User " + friendName + " not found in friend list!";
        return "Removed " + friendName + " from friend list!";
    }

    private String deleteUser(String request){
        if(currentUser.getId() != 1) return "Only admin user may delete other users!";
        User target = new User();
        int executionCode = 0;
        try{
            target = sqldao.getUser(request.substring(11).trim());
            if(target == null) return "No user with name [ " + request.substring(11).trim() + " ] found!";
            if(target.getId() == 1) return "Can not delete an admin user!";
            executionCode = sqldao.deleteUser(target.getId());
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return "User [ " + target.getName() + " ] deleted!";
    }
}
