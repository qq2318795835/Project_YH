package cn.datasupermacy.util;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class OutportsUtil implements Serializable {
    private static final long serialVersionUID = 1061979884940226258L;
    private Integer oid;

    private Integer providerid;

    private String pname;

    private String paytype;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    private Date outputtime;

    private String operateperson;

    private Double outportprice;

    private Integer number;

    private String remark;

    private Integer goodsid;

    private String gname;

    private Integer sid;

    private String sname;

    private Double totalweight;

    private Integer iid;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getProviderid() {
        return providerid;
    }

    public void setProviderid(Integer providerid) {
        this.providerid = providerid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype;
    }

    public Date getOutputtime() {
        return outputtime;
    }

    public void setOutputtime(Date outputtime) {
        this.outputtime = outputtime;
    }

    public String getOperateperson() {
        return operateperson;
    }

    public void setOperateperson(String operateperson) {
        this.operateperson = operateperson;
    }

    public Double getOutportprice() {
        return outportprice;
    }

    public void setOutportprice(Double outportprice) {
        this.outportprice = outportprice;
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

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
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

    public Integer getIid() {
        return iid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
    }

    @Override
    public String toString() {
        return "OutportsUtil{" +
                "oid=" + oid +
                ", providerid=" + providerid +
                ", pname='" + pname + '\'' +
                ", paytype='" + paytype + '\'' +
                ", outputtime=" + outputtime +
                ", operateperson='" + operateperson + '\'' +
                ", outportprice=" + outportprice +
                ", number=" + number +
                ", remark='" + remark + '\'' +
                ", goodsid=" + goodsid +
                ", gname='" + gname + '\'' +
                ", sid=" + sid +
                ", sname='" + sname + '\'' +
                ", totalweight=" + totalweight +
                ", iid=" + iid +
                '}';
    }
}
