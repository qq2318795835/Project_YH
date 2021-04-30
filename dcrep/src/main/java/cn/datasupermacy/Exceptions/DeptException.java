package cn.datasupermacy.Exceptions;

public class DeptException extends RuntimeException{
    private static final long serialVersionUID = -5615828154296115974L;

    private int code;

    private String message;

    public DeptException() {
        super();
    }

    public DeptException(int code) {
        super();
        this.code = code;
    }

    public DeptException(int code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public DeptException(Throwable cause, int code, String message) {
        super(cause);
        this.code = code;
        this.message = message;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
