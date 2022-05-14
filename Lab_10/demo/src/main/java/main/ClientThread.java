package main;

import client_io.RequestDecoder;
import database.DatabaseConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ClientThread extends Thread {


    private Socket socket = null;
    private ServerSocket serverSocket = null;
    private RequestDecoder requestDecoder;
    private boolean servingClient;
    private List<String> users;
    public ClientThread(Socket socket, ServerSocket serverSocket) {
        this.socket = socket;
        this.serverSocket = serverSocket;
        this.requestDecoder = new RequestDecoder();
        this.servingClient = true;
        this.users = DatabaseConnection.getUsersInstance();
    }

    public void run() {
        try {
            while (servingClient) {

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                String request = in.readLine();

                String response = processRequest(request);

                PrintWriter out = new PrintWriter(socket.getOutputStream());
                out.println(response);
                out.flush();
            }

        } catch (IOException e) {
            System.err.println("Communication error... " + e);
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
            return "Server stopped";
        }
        if (requestDecoder.decodeRequest(request) == RequestDecoder.UNKNOWN_REQUEST_CODE) {
            return "Server received unknown request: " + request;
        }
        if (requestDecoder.decodeRequest(request) == RequestDecoder.CLIENT_EXIT_CODE) {
            servingClient = false;
            return "Closing connection...";
        }
        if(requestDecoder.decodeRequest(request) == RequestDecoder.ADD_USER_CODE){
            return registerUser(request);
        }
        if(requestDecoder.decodeRequest(request) == RequestDecoder.LOGIN_USER_CODE){
            return loginUser(request);
        }
        return "Server received the request " + request;
    }

    private String registerUser(String request){
        String userName = request.substring(8).trim();
        if(users.contains(userName)) return "User with name \"" + userName + "\" already exists.\nCouldn't register user!";
        users.add(userName);
        return "User " + userName + " registered!";
    }

    private String loginUser(String request){
        String userName = request.substring(5).trim();
        if(users.contains(userName)) return "User login successfully!";
        return "No such user in database!";
    }
}
