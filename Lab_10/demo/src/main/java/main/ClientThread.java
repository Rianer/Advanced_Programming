package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread{
    private Socket socket = null ;
    public ClientThread (Socket socket) { this.socket = socket ; }
    public void run () {
        try {
            boolean running = true;
            int userCommandCode = 0;
            while(running){

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                String request = in.readLine();
                if(request.equals("stop")) userCommandCode = 1;

                PrintWriter out = new PrintWriter(socket.getOutputStream());
                String response = "Server received request: " + request;
                out.println(response);
                out.flush();

                if(userCommandCode == 1) running = false;
            }

        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        } finally {
            try {
                socket.close(); // or use try-with-resources
            } catch (IOException e) { System.err.println (e); }
        }
    }

}
