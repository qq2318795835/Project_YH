package cn.datasupermacy.util;

import java.io.Serializable;

public class DangerNumGoods implements Serializable {
    private static final long serialVersionUID = -939888977562415791L;
    private Integer gid;

    private String gname;

    private Integer number;

    private Integer dangernum;

    public DangerNumGoods() {
    }

    public DangerNumGoods(Integer gid, String gname, Integer number, Integer dangernum) {
        this.gid = gid;
        this.gname = gname;
        this.number = number;
        this.dangernum = dangernum;
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

    @Override
    public String toString() {
        return "DangerNumGoods{" +
                "gid=" + gid +
                ", gname='" + gname + '\'' +
                ", number=" + number +
                ", dangernum=" + dangernum +
                '}';
    }
}
