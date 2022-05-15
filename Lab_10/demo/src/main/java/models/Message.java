package models;

public class Message {
    private int userId;
    private int senderId;
    private String message;

    public Message() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "userId=" + userId +
                ", senderId=" + senderId +
                ", message='" + message + '\'' +
                '}';
    }
}
