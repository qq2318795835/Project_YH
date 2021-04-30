package cn.datasupermacy.util;

import java.io.Serializable;
import java.util.Date;

public class InportsUtil implements Serializable {
    private static final long serialVersionUID = -7974269476746306068L;
    private Integer Iid;

    private String paytype;

    private Date inporttime;

    private String operateperson;

    private Integer number;

    private String remark;

    private Double inportprice;

    private Integer pid;

    private String pname;

    private Integer gid;

    private String gname;

    private Integer sid;

    private String sname;

    private Double totalweight;

    private String outportinfo;

    public InportsUtil() {
    }

    public InportsUtil(Integer iid, String paytype, Date inporttime, String operateperson, Integer number, String remark, Double inportprice, Integer pid, String pname, Integer gid, String gname, Integer sid, String sname, Double totalweight, String outportinfo) {
        Iid = iid;
        this.paytype = paytype;
        this.inporttime = inporttime;
        this.operateperson = operateperson;
        this.number = number;
        this.remark = remark;
        this.inportprice = inportprice;
        this.pid = pid;
        this.pname = pname;
        this.gid = gid;
        this.gname = gname;
        this.sid = sid;
        this.sname = sname;
        this.totalweight = totalweight;
        this.outportinfo = outportinfo;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getIid() {
        return Iid;
    }

    public void setIid(Integer iid) {
        Iid = iid;
    }

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype;
    }

    public Date getInporttime() {
        return inporttime;
    }

    public void setInporttime(Date inporttime) {
        this.inporttime = inporttime;
    }

    public String getOperateperson() {
        return operateperson;
    }

    public void setOperateperson(String operateperson) {
        this.operateperson = operateperson;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Double getInportprice() {
        return inportprice;
    }

    public void setInportprice(Double inportprice) {
        this.inportprice = inportprice;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Double getTotalweight() {
        return totalweight;
    }

    public void setTotalweight(Double totalweight) {
        this.totalweight = totalweight;
    }

    public String getOutportinfo() {
        return outportinfo;
    }

    public void setOutportinfo(String outportinfo) {
        this.outportinfo = outportinfo;
    }

    @Override
    public String toString() {
        return "InportsUtil{" +
                "Iid=" + Iid +
                ", paytype='" + paytype + '\'' +
                ", inporttime=" + inporttime +
                ", operateperson='" + operateperson + '\'' +
                ", number=" + number +
                ", remark='" + remark + '\'' +
                ", inportprice=" + inportprice +
                ", pid=" + pid +
                ", pname='" + pname + '\'' +
                ", gid=" + gid +
                ", gname='" + gname + '\'' +
                ", sid=" + sid +
                ", sname='" + sname + '\'' +
                ", totalweight=" + totalweight +
                ", outportinfo='" + outportinfo + '\'' +
                '}';
    }
}
