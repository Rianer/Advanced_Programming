package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    private String serverAddress;
    private int PORT;

    private boolean running = true;
    private BufferedReader clientInput = new BufferedReader(new InputStreamReader(System.in));
    private String request;

    public Client(String serverAddress, int PORT) {
        this.serverAddress = serverAddress;
        this.PORT = PORT;
    }

    public Client() {
        this.serverAddress = "127.0.0.1";
        this.PORT = 8100;
    }

    public void connect(){
        try{
            Socket socket = new Socket(serverAddress, PORT);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            while(running){
                request = clientInput.readLine();
                out.println(request);
                if(request.equals("stop")) running = false;
                String response = in.readLine ();
                System.out.println(response);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
