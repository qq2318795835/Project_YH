package cn.datasupermacy.util;

import java.io.Serializable;
import java.util.Date;

public class SalesBackUtil implements Serializable {
    private static final long serialVersionUID = -8117818074716674230L;
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

    private String cname;

    private String gname;

    private String sname;

    public SalesBackUtil() {
    }

    public SalesBackUtil(Integer sbid, Integer customerid, String paytype, Date salesbacktime, Double salebackprice, String operateperson, Integer number, String remark, Integer goodsid, Integer sid, Integer ssid, Double totalweight, String cname, String gname, String sname) {
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
        this.cname = cname;
        this.gname = gname;
        this.sname = sname;
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
        this.paytype = paytype;
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

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getSsid() {
        return ssid;
    }

    public void setSsid(Integer ssid) {
        this.ssid = ssid;
    }

    @Override
    public String toString() {
        return "SalesBackUtil{" +
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
                ", cname='" + cname + '\'' +
                ", gname='" + gname + '\'' +
                ", sname='" + sname + '\'' +
                '}';
    }
}
