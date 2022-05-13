package main;

import java.io.IOException;

public class Main {
    public static void main(String[] args){

        try{
            Server server = new Server();
            server.runServer();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}
