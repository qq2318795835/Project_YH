package cn.datasupermacy.util;

public class LoginedUser {
    private int code;//状态码，成功1，失败-1,认证失败-2,token失效301
    private String message;//错误信息
    private String token;
    private Object data;//返回数据

    public LoginedUser() {
    }

    public LoginedUser(int code) {
        this.code = code;
    }

    public LoginedUser(int code, String message) {
        this.code = code;
        this.message = message;
    }


    public LoginedUser(int code, String message, String token) {
        this.code = code;
        this.message = message;
        this.token = token;
    }

    public LoginedUser(int code, String message, String token, Object data) {
        this.code = code;
        this.message = message;
        this.token = token;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
