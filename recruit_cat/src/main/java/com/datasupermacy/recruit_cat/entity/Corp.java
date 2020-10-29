package com.datasupermacy.recruit_cat.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Corp implements Serializable {
    private static final long serialVersionUID = -6659177334478928446L;
    private Integer Cid;
    private String Cname;
    private String Cpass;
    private String Cphone;
    private String Cemail;
    private String Jid;
    private String Jname;
    private String Caddress;
    private String Cdescribe;

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

    @Column(name = "jid", nullable = true,columnDefinition = "TEXT")
    public String getJid() {
        return Jid;
    }

    public void setJid(String jid) {
        Jid = jid;
    }

    @Basic
    @Column(name = "jname", nullable = true,columnDefinition = "TEXT")
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
                Objects.equals(Cdescribe, corp.Cdescribe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Cid, Cname, Cpass, Cphone, Cemail, Jid, Jname, Caddress, Cdescribe);
    }
}
