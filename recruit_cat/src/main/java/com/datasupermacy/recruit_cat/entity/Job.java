package com.datasupermacy.recruit_cat.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Job implements Serializable {
    private static final long serialVersionUID = -3886842566611037786L;
    private Integer jid;
    private String jname;
    private String jtype;
    private String jdescribe;
    private String jsal;
    private String jtreatment;
    private String jaddress;
    private Integer cid;
    private Date jupdateTime;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "jid", nullable = false)
    public Integer getJid() {
        return jid;
    }

    public void setJid(Integer jid) {
        this.jid = jid;
    }

    @Basic
    @Column(name = "jname", nullable = true, length = 255)
    public String getJname() {
        return jname;
    }

    public void setJname(String jname) {
        this.jname = jname;
    }

    @Basic
    @Column(name = "jtype", nullable = true, length = 255)
    public String getJtype() {
        return jtype;
    }

    public void setJtype(String jtype) {
        this.jtype = jtype;
    }

    @Basic
    @Column(name = "jdescribe", nullable = true, length = 255)
    public String getJdescribe() {
        return jdescribe;
    }

    public void setJdescribe(String jdescribe) {
        this.jdescribe = jdescribe;
    }

    @Basic
    @Column(name = "jsal", nullable = true, length = 255)
    public String getJsal() {
        return jsal;
    }

    public void setJsal(String jsal) {
        this.jsal = jsal;
    }

    @Basic
    @Column(name = "jtreatment", nullable = true, length = 255)
    public String getJtreatment() {
        return jtreatment;
    }

    public void setJtreatment(String jtreatment) {
        this.jtreatment = jtreatment;
    }

    @Basic
    @Column(name = "jaddress", nullable = true, length = 255)
    public String getJaddress() {
        return jaddress;
    }

    public void setJaddress(String jaddress) {
        this.jaddress = jaddress;
    }

    @Basic
    @Column(name = "cid", nullable = true)
    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    @Basic
    @Column(name = "jupdate_time", nullable = true)
    public Date getJupdateTime() {
        return jupdateTime;
    }

    public void setJupdateTime(Date jupdateTime) {
        this.jupdateTime = jupdateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return Objects.equals(jid, job.jid) &&
                Objects.equals(jname, job.jname) &&
                Objects.equals(jtype,job.jtype)&&
                Objects.equals(jdescribe, job.jdescribe) &&
                Objects.equals(jsal, job.jsal) &&
                Objects.equals(jtreatment, job.jtreatment) &&
                Objects.equals(jaddress, job.jaddress) &&
                Objects.equals(cid, job.cid) &&
                Objects.equals(jupdateTime, job.jupdateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jid, jname,jtype, jdescribe, jsal, jtreatment, jaddress, cid, jupdateTime);
    }
}
