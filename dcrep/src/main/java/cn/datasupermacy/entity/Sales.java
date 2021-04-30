package cn.datasupermacy.entity;

import java.io.Serializable;
import java.util.Date;

public class Sales implements Serializable {
    private static final long serialVersionUID = 2828907095200153885L;
    private Integer ssid;

    private Integer customerid;

    private String paytype;

    private Date salestime;

    private String operateperson;

    private Integer number;

    private String remark;

    private Double saleprice;

    private Integer goodsid;

    private Integer sid;

    private String salebackinfo;

    private Double totalweight;

    public Sales(Integer ssid, Integer customerid, String paytype, Date salestime, String operateperson, Integer number, String remark, Double saleprice, Integer goodsid, Integer sid, String salebackinfo, Double totalweight) {
        this.ssid = ssid;
        this.customerid = customerid;
        this.paytype = paytype;
        this.salestime = salestime;
        this.operateperson = operateperson;
        this.number = number;
        this.remark = remark;
        this.saleprice = saleprice;
        this.goodsid = goodsid;
        this.sid = sid;
        this.salebackinfo = salebackinfo;
        this.totalweight = totalweight;
    }

    public Sales() {
        super();
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getSsid() {
        return ssid;
    }

    public void setSsid(Integer ssid) {
        this.ssid = ssid;
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
        this.paytype = paytype;
    }

    public Date getSalestime() {
        return salestime;
    }

    public void setSalestime(Date salestime) {
        this.salestime = salestime;
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

    public Double getSaleprice() {
        return saleprice;
    }

    public void setSaleprice(Double saleprice) {
        this.saleprice = saleprice;
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

    public String getSalebackinfo() {
        return salebackinfo;
    }

    public void setSalebackinfo(String salebackinfo) {
        this.salebackinfo = salebackinfo;
    }

    public Double getTotalweight() {
        return totalweight;
    }

    public void setTotalweight(Double totalweight) {
        this.totalweight = totalweight;
    }

    @Override
    public String toString() {
        return "Sales{" +
                "ssid=" + ssid +
                ", customerid=" + customerid +
                ", paytype='" + paytype + '\'' +
                ", salestime=" + salestime +
                ", operateperson='" + operateperson + '\'' +
                ", number=" + number +
                ", remark='" + remark + '\'' +
                ", saleprice=" + saleprice +
                ", goodsid=" + goodsid +
                ", sid=" + sid +
                ", salebackinfo=" + salebackinfo +
                ", totalweight=" + totalweight +
                '}';
    }
}