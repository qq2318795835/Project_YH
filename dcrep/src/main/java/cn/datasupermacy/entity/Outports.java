package cn.datasupermacy.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Outports implements Serializable {
    private static final long serialVersionUID = -4567311222088451696L;
    private Integer oid;

    private Integer providerid;

    private String paytype;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    private Date outputtime;

    private String operateperson;

    private Double outportprice;

    private Integer number;

    private String remark;

    private Integer goodsid;

    private Integer sid;

    private Double totalweight;

    private Integer iid;

    public Outports(Integer oid, Integer providerid, String paytype, Date outputtime, String operateperson, Double outportprice, Integer number, String remark, Integer goodsid, Integer sid, Double totalweight, Integer iid) {
        this.oid = oid;
        this.providerid = providerid;
        this.paytype = paytype;
        this.outputtime = outputtime;
        this.operateperson = operateperson;
        this.outportprice = outportprice;
        this.number = number;
        this.remark = remark;
        this.goodsid = goodsid;
        this.sid = sid;
        this.totalweight = totalweight;
        this.iid = iid;
    }

    public Outports() {
        super();
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

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype == null ? null : paytype.trim();
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
        this.operateperson = operateperson == null ? null : operateperson.trim();
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
        this.remark = remark == null ? null : remark.trim();
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

    public Integer getIid() {
        return iid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
    }

    @Override
    public String toString() {
        return "Outports{" +
                "oid=" + oid +
                ", providerid=" + providerid +
                ", paytype='" + paytype + '\'' +
                ", outputtime=" + outputtime +
                ", operateperson='" + operateperson + '\'' +
                ", outportprice=" + outportprice +
                ", number=" + number +
                ", remark='" + remark + '\'' +
                ", goodsid=" + goodsid +
                ", sid=" + sid +
                ", totalweight=" + totalweight +
                ", iid=" + iid +
                '}';
    }
}