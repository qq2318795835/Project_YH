package cn.datasupermacy.util;

import java.io.Serializable;

public class UserUtil implements Serializable {
    private static final long serialVersionUID = -5981555100892968275L;
    private Integer uid;
    private String uname;
    private String uloginName;
    private String upwd;
    private String uremark;
    private String deptName;
    private String uaddress;
    private String umgr;


    public UserUtil() {
    }

    public UserUtil(Integer uid, String uname, String uloginName, String upwd, String uremark, String deptName, String uaddress, String umgr) {
        this.uid = uid;
        this.uname = uname;
        this.uloginName = uloginName;
        this.upwd = upwd;
        this.uremark = uremark;
        this.deptName = deptName;
        this.uaddress = uaddress;
        this.umgr = umgr;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUloginName() {
        return uloginName;
    }

    public void setUloginName(String uloginName) {
        this.uloginName = uloginName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getUaddress() {
        return uaddress;
    }

    public void setUaddress(String uaddress) {
        this.uaddress = uaddress;
    }

    public String getUmgr() {
        return umgr;
    }

    public void setUmgr(String umgr) {
        this.umgr = umgr;
    }

    public String getUremark() {
        return uremark;
    }

    public void setUremark(String uremark) {
        this.uremark = uremark;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    @Override
    public String toString() {
        return "UserUtil{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", uloginName='" + uloginName + '\'' +
                ", upwd='" + upwd + '\'' +
                ", uremark='" + uremark + '\'' +
                ", deptName='" + deptName + '\'' +
                ", uaddress='" + uaddress + '\'' +
                ", umgr='" + umgr + '\'' +
                '}';
    }
}
