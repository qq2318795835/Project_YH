package cn.datasupermacy.util;

import java.io.Serializable;

public class GoodsUtil implements Serializable {
    private Integer gid;

    private String gname;

    private String produceplace;

    private String size;

    private String gpackage;

    private String productcode;

    private String promitcode;

    private String description;

    private Double price;

    private Integer number;

    private Integer dangernum;

    private String gimg;

    private Integer available;

    private Integer pid;

    private String pname;

    public GoodsUtil() {
    }

    public GoodsUtil(Integer gid, String gname, String produceplace, String size, String gpackage, String productcode, String promitcode, String description, Double price, Integer number, Integer dangernum, String gimg, Integer available, Integer pid, String pname) {
        this.gid = gid;
        this.gname = gname;
        this.produceplace = produceplace;
        this.size = size;
        this.gpackage = gpackage;
        this.productcode = productcode;
        this.promitcode = promitcode;
        this.description = description;
        this.price = price;
        this.number = number;
        this.dangernum = dangernum;
        this.gimg = gimg;
        this.available = available;
        this.pid = pid;
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

    public String getProduceplace() {
        return produceplace;
    }

    public void setProduceplace(String produceplace) {
        this.produceplace = produceplace;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getGpackage() {
        return gpackage;
    }

    public void setGpackage(String gpackage) {
        this.gpackage = gpackage;
    }

    public String getProductcode() {
        return productcode;
    }

    public void setProductcode(String productcode) {
        this.productcode = productcode;
    }

    public String getPromitcode() {
        return promitcode;
    }

    public void setPromitcode(String promitcode) {
        this.promitcode = promitcode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getDangernum() {
        return dangernum;
    }

    public void setDangernum(Integer dangernum) {
        this.dangernum = dangernum;
    }

    public String getGimg() {
        return gimg;
    }

    public void setGimg(String gimg) {
        this.gimg = gimg;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
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

    @Override
    public String toString() {
        return "GoodsUtil{" +
                "gid=" + gid +
                ", gname='" + gname + '\'' +
                ", produceplace='" + produceplace + '\'' +
                ", size='" + size + '\'' +
                ", gpackage='" + gpackage + '\'' +
                ", productcode='" + productcode + '\'' +
                ", promitcode='" + promitcode + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", number=" + number +
                ", dangernum=" + dangernum +
                ", gimg='" + gimg + '\'' +
                ", available=" + available +
                ", pid=" + pid +
                ", pname='" + pname + '\'' +
                '}';
    }
}
