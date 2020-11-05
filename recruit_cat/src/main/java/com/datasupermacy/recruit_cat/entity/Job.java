package com.datasupermacy.recruit_cat.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Job implements Serializable {
    private static final long serialVersionUID = -917161080426702655L;
    private Integer Jid;
    private String Jname;
    private String Jtype;
    private String Jdescribe;
    private String Jeducation;
    private String Jexperience;
    private String Jsal;
    private String Jtreatment;
    private String Jaddress;
    private Integer Cid;
    private Date JupdateTime;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "jid", nullable = false)
    public Integer getJid() {
        return Jid;
    }

    public void setJid(Integer jid) {
        Jid = jid;
    }

    @Basic
    @Column(name = "jname", nullable = true, length = 255)
    public String getJname() {
        return Jname;
    }

    public void setJname(String jname) {
        Jname = jname;
    }

    @Basic
    @Column(name = "jtype", nullable = true, length = 255)
    public String getJtype() {
        return Jtype;
    }

    public void setJtype(String jtype) {
        Jtype = jtype;
    }

    @Basic
    @Column(name = "jdescribe", nullable = true, length = 255)
    public String getJdescribe() {
        return Jdescribe;
    }

    public void setJdescribe(String jdescribe) {
        Jdescribe = jdescribe;
    }

    @Basic
    @Column(name = "jeducation", nullable = true, length = 255)
    public String getJeducation() {
        return Jeducation;
    }

    public void setJeducation(String jeducation) {
        Jeducation = jeducation;
    }

    @Basic
    @Column(name = "jexperience", nullable = true, length = 255)
    public String getJexperience() {
        return Jexperience;
    }

    public void setJexperience(String jexperience) {
        Jexperience = jexperience;
    }

    @Basic
    @Column(name = "jsal", nullable = true, length = 255)
    public String getJsal() {
        return Jsal;
    }

    public void setJsal(String jsal) {
        Jsal = jsal;
    }

    @Basic
    @Column(name = "jtreatment", nullable = true, length = 255)
    public String getJtreatment() {
        return Jtreatment;
    }

    public void setJtreatment(String jtreatment) {
        Jtreatment = jtreatment;
    }

    @Basic
    @Column(name = "jaddress", nullable = true, length = 255)
    public String getJaddress() {
        return Jaddress;
    }

    public void setJaddress(String jaddress) {
        Jaddress = jaddress;
    }

    @Basic
    @Column(name = "cid", nullable = true)
    public Integer getCid() {
        return Cid;
    }

    public void setCid(Integer cid) {
        Cid = cid;
    }

    @Basic
    @Column(name = "jupdate_time", nullable = true)
    public Date getJupdateTime() {
        return JupdateTime;
    }

    public void setJupdateTime(Date jupdateTime) {
        JupdateTime = jupdateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return Objects.equals(Jid, job.Jid) &&
                Objects.equals(Jname, job.Jname) &&
                Objects.equals(Jtype, job.Jtype) &&
                Objects.equals(Jdescribe, job.Jdescribe) &&
                Objects.equals(Jeducation, job.Jeducation) &&
                Objects.equals(Jexperience, job.Jexperience) &&
                Objects.equals(Jsal, job.Jsal) &&
                Objects.equals(Jtreatment, job.Jtreatment) &&
                Objects.equals(Jaddress, job.Jaddress) &&
                Objects.equals(Cid, job.Cid) &&
                Objects.equals(JupdateTime, job.JupdateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Jid, Jname, Jtype, Jdescribe, Jeducation, Jexperience, Jsal, Jtreatment, Jaddress, Cid, JupdateTime);
    }
}
