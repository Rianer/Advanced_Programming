package client_io;

import java.util.Locale;

public class RequestDecoder {
    public static final int STOP_CODE = 1;
    public static final int UNKNOWN_REQUEST_CODE = 0;
    public static final int CLIENT_EXIT_CODE = 2;

    public RequestDecoder() {
    }

    public int decodeRequest(String clientRequest){

        if(clientRequest.toLowerCase().equals("stop")){
            return STOP_CODE;
        }
        if (clientRequest.toLowerCase().equals("exit")) {
            return CLIENT_EXIT_CODE;
        }
        return UNKNOWN_REQUEST_CODE;
    }
}
