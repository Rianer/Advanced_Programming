package main;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private int PORT;
    public Server(){
        this.PORT = 8100;
    }

    public Server(int PORT){
        this.PORT = PORT;
    }

    public void runServer() throws IOException{
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            while (true) {
                System.out.println ("Waiting for a client ...");
                Socket socket = serverSocket.accept();
                new ClientThread(socket).start();
            }
        } catch (IOException e) {
            System.err. println ("Error: " + e);
        } finally {
            serverSocket.close();
        }
    }


}
