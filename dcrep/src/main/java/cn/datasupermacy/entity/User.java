package cn.datasupermacy.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.sql.Timestamp;

public class User implements Serializable {
    private static final long serialVersionUID = -2384871262132221878L;
    private Integer uid;

    private String uname;

    private String uloginname;

    private String uaddress;

    private Integer usex;

    private String uremark;

    private String upwd;

    private Integer did;

    private Timestamp uhiredate;

    private Integer umgr;

    private Integer uavailable;

    private Integer uordernum;

    private Integer utype;

    private String uimgpath;

    private String usalt;

    public User(Integer uid, String uname, String uloginname, String uaddress, Integer usex, String uremark, String upwd, Integer did, Timestamp uhiredate, Integer umgr, Integer uavailable, Integer uordernum, Integer utype, String uimgpath, String usalt) {
        this.uid = uid;
        this.uname = uname;
        this.uloginname = uloginname;
        this.uaddress = uaddress;
        this.usex = usex;
        this.uremark = uremark;
        this.upwd = upwd;
        this.did = did;
        this.uhiredate = uhiredate;
        this.umgr = umgr;
        this.uavailable = uavailable;
        this.uordernum = uordernum;
        this.utype = utype;
        this.uimgpath = uimgpath;
        this.usalt = usalt;
    }

    public User() {
        super();
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
        this.uname = uname == null ? null : uname.trim();
    }

    public String getUloginname() {
        return uloginname;
    }

    public void setUloginname(String uloginname) {
        this.uloginname = uloginname == null ? null : uloginname.trim();
    }

    public String getUaddress() {
        return uaddress;
    }

    public void setUaddress(String uaddress) {
        this.uaddress = uaddress == null ? null : uaddress.trim();
    }

    public Integer getUsex() {
        return usex;
    }

    public void setUsex(Integer usex) {
        this.usex = usex;
    }

    public String getUremark() {
        return uremark;
    }

    public void setUremark(String uremark) {
        this.uremark = uremark == null ? null : uremark.trim();
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd == null ? null : upwd.trim();
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }


    public Timestamp getUhiredate() {
        return uhiredate;
    }

    public void setUhiredate(Timestamp uhiredate) {
        this.uhiredate = uhiredate;
    }

    public Integer getUmgr() {
        return umgr;
    }

    public void setUmgr(Integer umgr) {
        this.umgr = umgr;
    }

    public Integer getUavailable() {
        return uavailable;
    }

    public void setUavailable(Integer uavailable) {
        this.uavailable = uavailable;
    }

    public Integer getUordernum() {
        return uordernum;
    }

    public void setUordernum(Integer uordernum) {
        this.uordernum = uordernum;
    }

    public Integer getUtype() {
        return utype;
    }

    public void setUtype(Integer utype) {
        this.utype = utype;
    }

    public String getUimgpath() {
        return uimgpath;
    }

    public void setUimgpath(String uimgpath) {
        this.uimgpath = uimgpath == null ? null : uimgpath.trim();
    }

    public String getUsalt() {
        return usalt;
    }

    public void setUsalt(String usalt) {
        this.usalt = usalt == null ? null : usalt.trim();
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", uloginname='" + uloginname + '\'' +
                ", uaddress='" + uaddress + '\'' +
                ", usex=" + usex +
                ", uremark='" + uremark + '\'' +
                ", upwd='" + upwd + '\'' +
                ", did=" + did +
                ", uhiredate=" + uhiredate +
                ", umgr=" + umgr +
                ", uavailable=" + uavailable +
                ", uordernum=" + uordernum +
                ", utype=" + utype +
                ", uimgpath='" + uimgpath + '\'' +
                ", usalt='" + usalt + '\'' +
                '}';
    }
}