package cn.datasupermacy.Exceptions;

public class LoginExcepinon extends Throwable{
    private static final long serialVersionUID = 3220677121041285390L;

    private int code;

    private String message;

    public LoginExcepinon() {
        super();
    }

    public LoginExcepinon(int code, String message) {
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
