package cn.datasupermacy.entity;

import java.io.Serializable;
import java.util.Date;

public class SalesBack implements Serializable {
    private static final long serialVersionUID = 6765569767589825493L;
    private Integer sbid;

    private Integer customerid;

    private String paytype;

    private Date salesbacktime;

    private Double salebackprice;

    private String operateperson;

    private Integer number;

    private String remark;

    private Integer goodsid;

    private Integer sid;

    private Integer ssid;

    private Double totalweight;

    public SalesBack(Integer sbid, Integer customerid, String paytype, Date salesbacktime, Double salebackprice, String operateperson, Integer number, String remark, Integer goodsid, Integer sid,Integer ssid, Double totalweight) {
        this.sbid = sbid;
        this.customerid = customerid;
        this.paytype = paytype;
        this.salesbacktime = salesbacktime;
        this.salebackprice = salebackprice;
        this.operateperson = operateperson;
        this.number = number;
        this.remark = remark;
        this.goodsid = goodsid;
        this.sid = sid;
        this.ssid = ssid;
        this.totalweight = totalweight;
    }

    public SalesBack() {
        super();
    }

    public Integer getSbid() {
        return sbid;
    }

    public void setSbid(Integer sbid) {
        this.sbid = sbid;
    }

    public Integer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Integer customerid) {
        this.customerid = customerid;
    }

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype == null ? null : paytype.trim();
    }

    public Date getSalesbacktime() {
        return salesbacktime;
    }

    public void setSalesbacktime(Date salesbacktime) {
        this.salesbacktime = salesbacktime;
    }

    public Double getSalebackprice() {
        return salebackprice;
    }

    public void setSalebackprice(Double salebackprice) {
        this.salebackprice = salebackprice;
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

    public Integer getSsid() {
        return ssid;
    }
    public void setSsid(Integer ssid) {
        this.ssid = ssid;
    }

    @Override
    public String toString() {
        return "SalesBack{" +
                "sbid=" + sbid +
                ", customerid=" + customerid +
                ", paytype='" + paytype + '\'' +
                ", salesbacktime=" + salesbacktime +
                ", salebackprice=" + salebackprice +
                ", operateperson='" + operateperson + '\'' +
                ", number=" + number +
                ", remark='" + remark + '\'' +
                ", goodsid=" + goodsid +
                ", sid=" + sid +
                ", ssid=" + ssid +
                ", totalweight=" + totalweight +
                '}';
    }
}