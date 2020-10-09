package com.datasupermacy.recruit_cat.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Job implements Serializable {
    private Integer Jid;
    private String Jname;
    private String Jdescribe;
    private String Jsal;
    private String Jtreatment;
    private String Jaddress;
    private Integer Cid;

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
    @Column(name = "jname", nullable = false, length = 255)
    public String getJname() {
        return Jname;
    }

    public void setJname(String jname) {
        Jname = jname;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return Objects.equals(Jid, job.Jid) &&
                Objects.equals(Jname, job.Jname) &&
                Objects.equals(Jdescribe, job.Jdescribe) &&
                Objects.equals(Jsal, job.Jsal) &&
                Objects.equals(Jtreatment, job.Jtreatment) &&
                Objects.equals(Jaddress, job.Jaddress) &&
                Objects.equals(Cid, job.Cid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Jid, Jname, Jdescribe, Jsal, Jtreatment, Jaddress, Cid);
    }
}
