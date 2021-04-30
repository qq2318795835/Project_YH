package cn.datasupermacy.Exceptions;

public class CustomerException extends RuntimeException{
    private static final long serialVersionUID = 7436852339931799958L;

    private int code;

    private String message;

    public CustomerException() {
        super();
    }

    public CustomerException(int code, String message) {
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
