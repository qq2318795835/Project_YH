package cn.datasupermacy.Exceptions;

public class UserException extends RuntimeException{
    private static final long serialVersionUID = -5679285783161266506L;

    private int code;

    private String message;

    public UserException() {
        super();
    }

    public UserException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
