package cn.datasupermacy.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Inports implements Serializable {
    private static final long serialVersionUID = 5687956837042707303L;
    private Integer Iid;

    private String paytype;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    private Date inporttime;

    private String operateperson;

    private Integer number;

    private String remark;

    private Double inportprice;

    private Integer providerid;

    private Integer goodsid;

    private Integer sid;

    private Double totalweight;

    private String outportinfo;

    public Inports(Integer Iid, String paytype, Date inporttime, String operateperson, Integer number, String remark, Double inportprice, Integer providerid, Integer goodsid, Integer sid, Double totalweight, String outportinfo) {
        this.Iid = Iid;
        this.paytype = paytype;
        this.inporttime = inporttime;
        this.operateperson = operateperson;
        this.number = number;
        this.remark = remark;
        this.inportprice = inportprice;
        this.providerid = providerid;
        this.goodsid = goodsid;
        this.sid = sid;
        this.totalweight = totalweight;
        this.outportinfo = outportinfo;
    }

    public Inports() {
        super();
    }

    public Integer getIid() {
        return Iid;
    }

    public void setIid(Integer Iid) {
        this.Iid = Iid;
    }

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype == null ? null : paytype.trim();
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
        this.operateperson = operateperson == null ? null : operateperson.trim();
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
        this.remark = remark == null ? null : remark.trim();
    }

    public Double getInportprice() {
        return inportprice;
    }

    public void setInportprice(Double inportprice) {
        this.inportprice = inportprice;
    }

    public Integer getProviderid() {
        return providerid;
    }

    public void setProviderid(Integer providerid) {
        this.providerid = providerid;
    }

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
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
        return "Inports{" +
                "Iid=" + Iid +
                ", paytype='" + paytype + '\'' +
                ", inporttime=" + inporttime +
                ", operateperson='" + operateperson + '\'' +
                ", number=" + number +
                ", remark='" + remark + '\'' +
                ", inportprice=" + inportprice +
                ", providerid=" + providerid +
                ", goodsid=" + goodsid +
                ", sid=" + sid +
                ", totalweight=" + totalweight +
                ", outportinfo='" + outportinfo + '\'' +
                '}';
    }
}