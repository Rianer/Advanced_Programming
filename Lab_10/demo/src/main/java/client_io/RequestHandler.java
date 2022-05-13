package client_io;

public class RequestHandler {
    private RequestDecoder requestDecoder;

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
        return "Server received the request " + request;
    }

}
