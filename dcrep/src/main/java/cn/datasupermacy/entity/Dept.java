package cn.datasupermacy.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class Dept implements Serializable {
    private static final long serialVersionUID = 7513796164303067577L;
    private Integer did;

    private Integer dpid;

    private String dtitle;

    private Integer dopen;

    private String dremark;

    private String daddress;

    private Integer davailable;

    private Integer dordernum;

    private Date dcreatetime;

    public Dept(Integer did, Integer dpid, String dtitle, Integer dopen, String dremark, String daddress, Integer davailable, Integer dordernum, Date dcreatetime) {
        this.did = did;
        this.dpid = dpid;
        this.dtitle = dtitle;
        this.dopen = dopen;
        this.dremark = dremark;
        this.daddress = daddress;
        this.davailable = davailable;
        this.dordernum = dordernum;
        this.dcreatetime = dcreatetime;
    }

    public Dept() {
        super();
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public Integer getDpid() {
        return dpid;
    }

    public void setDpid(Integer dpid) {
        this.dpid = dpid;
    }

    public String getDtitle() {
        return dtitle;
    }

    public void setDtitle(String dtitle) {
        this.dtitle = dtitle == null ? null : dtitle.trim();
    }

    public Integer getDopen() {
        return dopen;
    }

    public void setDopen(Integer dopen) {
        this.dopen = dopen;
    }

    public String getDremark() {
        return dremark;
    }

    public void setDremark(String dremark) {
        this.dremark = dremark == null ? null : dremark.trim();
    }

    public String getDaddress() {
        return daddress;
    }

    public void setDaddress(String daddress) {
        this.daddress = daddress == null ? null : daddress.trim();
    }

    public Integer getDavailable() {
        return davailable;
    }

    public void setDavailable(Integer davailable) {
        this.davailable = davailable;
    }

    public Integer getDordernum() {
        return dordernum;
    }

    public void setDordernum(Integer dordernum) {
        this.dordernum = dordernum;
    }
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    public Date getDcreatetime() {
        return dcreatetime;
    }
    
    public void setDcreatetime(Date dcreatetime) {
        this.dcreatetime = dcreatetime;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "did=" + did +
                ", dpid=" + dpid +
                ", dtitle='" + dtitle + '\'' +
                ", dopen=" + dopen +
                ", dremark='" + dremark + '\'' +
                ", daddress='" + daddress + '\'' +
                ", davailable=" + davailable +
                ", dordernum=" + dordernum +
                ", dcreatetime=" + dcreatetime +
                '}';
    }
}