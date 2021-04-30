package cn.datasupermacy.util;

import java.io.Serializable;

public class SalesAnalysisUtil implements Serializable {
    private static final long serialVersionUID = 8639508716930861622L;

    private Integer ssid;

    private Integer customerid;

    private Integer gid;

    private String gname;

    private Double saleprice;

    private Integer jan;
    private Integer feb;
    private Integer mar;
    private Integer apr;
    private Integer may;
    private Integer june;
    private Integer july;
    private Integer aug;
    private Integer sept;
    private Integer oct;
    private Integer nov;
    private Integer dece;

    private  Integer numberTotal;

    public SalesAnalysisUtil() {
    }

    public SalesAnalysisUtil(Integer ssid, Integer customerid, Integer gid,String gname, Double saleprice,Integer jan, Integer feb, Integer mar, Integer apr, Integer may, Integer june, Integer july, Integer aug, Integer sept, Integer oct, Integer nov, Integer dece, Integer numberTotal) {
        this.ssid = ssid;
        this.customerid = customerid;
        this.gid = gid;
        this.gname = gname;
        this.saleprice = saleprice;
        this.jan = jan;
        this.feb = feb;
        this.mar = mar;
        this.apr = apr;
        this.may = may;
        this.june = june;
        this.july = july;
        this.aug = aug;
        this.sept = sept;
        this.oct = oct;
        this.nov = nov;
        this.dece = dece;
        this.numberTotal = numberTotal;
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

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Double getSprice() {
        return saleprice;
    }

    public void setSprice(Double saleprice) {
        this.saleprice = saleprice;
    }


    public Integer getJan() {
        return jan;
    }

    public void setJan(Integer jan) {
        this.jan = jan;
    }

    public Integer getFeb() {
        return feb;
    }

    public void setFeb(Integer feb) {
        this.feb = feb;
    }

    public Integer getMar() {
        return mar;
    }

    public void setMar(Integer mar) {
        this.mar = mar;
    }

    public Double getSaleprice() {
        return saleprice;
    }

    public void setSaleprice(Double saleprice) {
        this.saleprice = saleprice;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public Integer getApr() {
        return apr;
    }

    public void setApr(Integer apr) {
        this.apr = apr;
    }

    public Integer getMay() {
        return may;
    }

    public void setMay(Integer may) {
        this.may = may;
    }

    public Integer getJune() {
        return june;
    }

    public void setJune(Integer june) {
        this.june = june;
    }

    public Integer getJuly() {
        return july;
    }

    public void setJuly(Integer july) {
        this.july = july;
    }

    public Integer getAug() {
        return aug;
    }

    public void setAug(Integer aug) {
        this.aug = aug;
    }

    public Integer getSept() {
        return sept;
    }

    public void setSept(Integer sept) {
        this.sept = sept;
    }

    public Integer getOct() {
        return oct;
    }

    public void setOct(Integer oct) {
        this.oct = oct;
    }

    public Integer getNov() {
        return nov;
    }

    public void setNov(Integer nov) {
        this.nov = nov;
    }

    public Integer getDece() {
        return dece;
    }

    public void setDece(Integer dece) {
        this.dece = dece;
    }

    public Integer getNumberTotal() {
        return numberTotal;
    }

    public void setNumberTotal(Integer numberTotal) {
        this.numberTotal = numberTotal;
    }

    @Override
    public String toString() {
        return "SalesAnalysisUtil{" +
                "ssid=" + ssid +
                ", customerid=" + customerid +
                ", gid=" + gid +
                ", gname='" + gname + '\'' +
                ", saleprice=" + saleprice +
                ", jan=" + jan +
                ", feb=" + feb +
                ", mar=" + mar +
                ", apr=" + apr +
                ", may=" + may +
                ", june=" + june +
                ", july=" + july +
                ", aug=" + aug +
                ", sept=" + sept +
                ", oct=" + oct +
                ", nov=" + nov +
                ", dece=" + dece +
                ", numberTotal=" + numberTotal +
                '}';
    }
}
