package com.datasupermacy.recruit_cat.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Corp implements Serializable {
    private static final long serialVersionUID = 301843518203242550L;
    private Integer Cid;
    private String Cname;
    private String Cpass;
    private String Cphone;
    private String Cemail;
    private String Jid;
    private String Jname;
    private String Caddress;
    private String Cdescribe;
    private String Cimg;
    private String Ctype;
    private String Cscale;
    private String Cbusiness_status;
    private String CrecruitmentStatus;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cid", nullable = false)
    public Integer getCid() {
        return Cid;
    }

    public void setCid(Integer cid) {
        Cid = cid;
    }

    @Basic
    @Column(name = "cname", nullable = true, length = 255)
    public String getCname() {
        return Cname;
    }

    public void setCname(String cname) {
        Cname = cname;
    }

    @Basic
    @Column(name = "cpass", nullable = true, length = 255)
    public String getCpass() {
        return Cpass;
    }

    public void setCpass(String cpass) {
        Cpass = cpass;
    }

    @Basic
    @Column(name = "cphone", nullable = true, length = 255)
    public String getCphone() {
        return Cphone;
    }

    public void setCphone(String cphone) {
        Cphone = cphone;
    }

    @Basic
    @Column(name = "cemail", nullable = true, length = 255)
    public String getCemail() {
        return Cemail;
    }

    public void setCemail(String cemail) {
        Cemail = cemail;
    }

    @Basic
    @Column(name = "jid", nullable = true, length = -1)
    public String getJid() {
        return Jid;
    }

    public void setJid(String jid) {
        Jid = jid;
    }

    @Basic
    @Column(name = "jname", nullable = true, length = -1)
    public String getJname() {
        return Jname;
    }

    public void setJname(String jname) {
        Jname = jname;
    }

    @Basic
    @Column(name = "caddress", nullable = true, length = 255)
    public String getCaddress() {
        return Caddress;
    }

    public void setCaddress(String caddress) {
        Caddress = caddress;
    }

    @Basic
    @Column(name = "cdescribe", nullable = true, length = 255)
    public String getCdescribe() {
        return Cdescribe;
    }

    public void setCdescribe(String cdescribe) {
        Cdescribe = cdescribe;
    }

    @Basic
    @Column(name = "cimg", nullable = true, length = 255)
    public String getCimg() {
        return Cimg;
    }

    public void setCimg(String cimg) {
        Cimg = cimg;
    }

    @Basic
    @Column(name = "ctype", nullable = true, length = 255)
    public String getCtype() {
        return Ctype;
    }

    public void setCtype(String ctype) {
        Ctype = ctype;
    }

    @Basic
    @Column(name = "cscale", nullable = true, length = 255)
    public String getCscale() {
        return Cscale;
    }

    public void setCscale(String cscale) {
        Cscale = cscale;
    }

    @Basic
    @Column(name = "cbusiness_status", nullable = true, length = 255)
    public String getCbusiness_status() {
        return Cbusiness_status;
    }

    public void setCbusiness_status(String cbusiness_status) {
        Cbusiness_status = cbusiness_status;
    }

    @Basic
    @Column(name = "crecruitment_status", nullable = true, length = 255)
    public String getCrecruitmentStatus() {
        return CrecruitmentStatus;
    }

    public void setCrecruitmentStatus(String crecruitmentStatus) {
        CrecruitmentStatus = crecruitmentStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Corp corp = (Corp) o;
        return Objects.equals(Cid, corp.Cid) &&
                Objects.equals(Cname, corp.Cname) &&
                Objects.equals(Cpass, corp.Cpass) &&
                Objects.equals(Cphone, corp.Cphone) &&
                Objects.equals(Cemail, corp.Cemail) &&
                Objects.equals(Jid, corp.Jid) &&
                Objects.equals(Jname, corp.Jname) &&
                Objects.equals(Caddress, corp.Caddress) &&
                Objects.equals(Cdescribe, corp.Cdescribe) &&
                Objects.equals(Ctype, corp.Ctype) &&
                Objects.equals(Cscale, corp.Cscale) &&
                Objects.equals(Cbusiness_status,corp.Cbusiness_status)&&
                Objects.equals(CrecruitmentStatus, corp.CrecruitmentStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Cid, Cname, Cpass, Cphone, Cemail, Jid, Jname, Caddress, Cdescribe, Ctype, Cscale, Cbusiness_status ,CrecruitmentStatus);
    }
}
