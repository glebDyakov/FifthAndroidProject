package gleb.first_app.myfiveandroidapplication.Models;

public class ChatModel {
    private String message;
    private boolean isSend;

    public ChatModel(String message, boolean isSend) {
        this.message = message;
        this.isSend = isSend;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSend() {
        return isSend;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSend(boolean send) {
        isSend = send;
    }
}
