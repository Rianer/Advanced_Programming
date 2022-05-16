package client_io;

import java.util.Locale;

public class RequestDecoder {
    public static final int UNKNOWN_REQUEST_CODE = 0;
    public static final int STOP_CODE = 1;
    public static final int CLIENT_EXIT_CODE = 2;
    public static final int ADD_USER_CODE = 3;
    public static final int LOGIN_USER_CODE = 4;

    public static final int ADD_FRIEND_CODE = 5;
    public static final int GET_ALL_FRIENDS_CODE = 6;
    public static final int GET_ALL_USERS_CODE = 7;
    public static final int SEND_MESSAGE_CODE = 8;
    public static final int READ_MESSAGES_CODE = 9;
    public static final int READ_MESSAGE_FROM_USER_CODE = 10;
    public static final int DELETE_RECEIVED_MESS_CODE = 11;
    public static final int DELETE_SENT_MESS_CODE = 12;
    public static final int DELETE_FRIEND_CODE = 13;
    public static final int DELETE_USER_FROM_DB_CODE = 14;

    public RequestDecoder() {
    }

    public int decodeRequest(String clientRequest){

        if(clientRequest.toLowerCase().trim().equals("stop")){
            return STOP_CODE;
        }
        if (clientRequest.toLowerCase().trim().equals("exit")) {
            return CLIENT_EXIT_CODE;
        }
        if (clientRequest.toLowerCase().startsWith("register ")){
            return ADD_USER_CODE;
        }
        if (clientRequest.toLowerCase().startsWith("login ")){
            return LOGIN_USER_CODE;
        }
        if (clientRequest.toLowerCase().startsWith("friend ")){
            return ADD_FRIEND_CODE;
        }
        if(clientRequest.toLowerCase().trim().equals("show friends")){
            return  GET_ALL_FRIENDS_CODE;
        }
        if(clientRequest.toLowerCase().trim().equals("show users")){
            return  GET_ALL_USERS_CODE;
        }
        if(clientRequest.toLowerCase().startsWith("send ")){
            return  SEND_MESSAGE_CODE;
        }
        if(clientRequest.toLowerCase().trim().equals("read")){
            return  READ_MESSAGES_CODE;
        }
        if(clientRequest.toLowerCase().startsWith("read from ")){
            return  READ_MESSAGE_FROM_USER_CODE;
        }
        if(clientRequest.toLowerCase().startsWith("delete from ")){
            return  DELETE_RECEIVED_MESS_CODE;
        }
        if(clientRequest.toLowerCase().trim().equals("delete messages")){
            return  DELETE_SENT_MESS_CODE;
        }
        if(clientRequest.toLowerCase().trim().startsWith("remove friend ")){
            return  DELETE_FRIEND_CODE;
        }
        if(clientRequest.toLowerCase().trim().startsWith("delete user ")){
            return  DELETE_USER_FROM_DB_CODE;
        }
        return UNKNOWN_REQUEST_CODE;
    }
}
