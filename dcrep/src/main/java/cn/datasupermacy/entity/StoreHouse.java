package cn.datasupermacy.entity;

import java.io.Serializable;

public class StoreHouse implements Serializable {
    private static final long serialVersionUID = -474186989278462893L;
    private Integer sid;

    private String sname;

    private String address;

    private Double total;

    private Double margin;

    public StoreHouse(Integer sid, String sname, String address, Double total, Double margin) {
        this.sid = sid;
        this.sname = sname;
        this.address = address;
        this.total = total;
        this.margin = margin;
    }

    public StoreHouse() {
        super();
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
        this.sname = sname == null ? null : sname.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getMargin() {
        return margin;
    }

    public void setMargin(Double margin) {
        this.margin = margin;
    }

    @Override
    public String toString() {
        return "StoreHouse{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", address='" + address + '\'' +
                ", total=" + total +
                ", margin=" + margin +
                '}';
    }
}