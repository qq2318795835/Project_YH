package cn.datasupermacy.util;

public class ResponseEntity {

    private int code;//状态码，成功1，失败-1
    private String message;//错误信息
    private Object data;//返回数据

    public ResponseEntity() {
    }

    public ResponseEntity(int code) {
        this.code = code;
    }

    public ResponseEntity(int code, Object data) {
        this.code = code;
        this.data = data;
    }

    public ResponseEntity(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseEntity(int code, String message, Object data) {
        this.code = code;
        this.message = message;
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
