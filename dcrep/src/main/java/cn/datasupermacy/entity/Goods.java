package cn.datasupermacy.entity;

public class Goods {
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

    public Goods(Integer gid, String gname, String produceplace, String size, String gpackage, String productcode, String promitcode, String description, Double price, Integer number, Integer dangernum, String gimg, Integer available, Integer pid) {
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
    }

    public Goods() {
        super();
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
        this.gname = gname == null ? null : gname.trim();
    }

    public String getProduceplace() {
        return produceplace;
    }

    public void setProduceplace(String produceplace) {
        this.produceplace = produceplace == null ? null : produceplace.trim();
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size == null ? null : size.trim();
    }

    public String getGpackage() {
        return gpackage;
    }

    public void setGpackage(String gpackage) {
        this.gpackage = gpackage == null ? null : gpackage.trim();
    }

    public String getProductcode() {
        return productcode;
    }

    public void setProductcode(String productcode) {
        this.productcode = productcode == null ? null : productcode.trim();
    }

    public String getPromitcode() {
        return promitcode;
    }

    public void setPromitcode(String promitcode) {
        this.promitcode = promitcode == null ? null : promitcode.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
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
        this.gimg = gimg == null ? null : gimg.trim();
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

    @Override
    public String toString() {
        return "Goods{" +
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
                '}';
    }
}