package home.loja.exception;

public class ClienteException extends RuntimeException {

    private static final long serialVersionUID = -7491873932486289748L;

    private String message;

    public ClienteException(String message) {

        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
