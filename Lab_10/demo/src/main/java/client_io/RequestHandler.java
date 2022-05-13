package client_io;

import main.Server;

import java.net.ServerSocket;

public class RequestHandler {
    private RequestDecoder requestDecoder;
    private ServerSocket serverSocket;

    public RequestHandler(RequestDecoder requestDecoder) {
        this.requestDecoder = requestDecoder;
    }

    public RequestHandler() {
        this.requestDecoder = new RequestDecoder();
    }

    String prepareResponse(String request){
        if(requestDecoder.decodeRequest(request) == RequestDecoder.STOP_CODE){
            return "Server stopped";
        }
        if(requestDecoder.decodeRequest(request) == RequestDecoder.UNKNOWN_REQUEST_CODE){
            return "Server received unknown request: " + request;
        }
        if(requestDecoder.decodeRequest(request) == RequestDecoder.CLIENT_EXIT_CODE){
            Server.serverStatus = 0;
        }
        return "Server received the request " + request;
    }

}
