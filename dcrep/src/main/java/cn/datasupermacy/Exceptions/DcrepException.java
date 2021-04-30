package cn.datasupermacy.Exceptions;

public class DcrepException extends RuntimeException{
    private static final long serialVersionUID = -4076992856610549299L;
    private int code;

    private String message;

    public DcrepException() {

    }

    public DcrepException(int code, String message) {
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

    @Override
    public String toString() {
        return "DcrepException{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
