package com.datasupermacy.recruit_cat.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "favorites_list", schema = "recruit_cat")
public class FavoritesList implements Serializable {
    private static final long serialVersionUID = -6486095935478722376L;
    private Integer Fid;
    private Integer Uid;
    private Integer Jid;
    private String Jname;
    private Timestamp FupdateTime;
    private String Jsal;
    private Integer Cid;
    private String Cname;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fid", nullable = false)
    public Integer getFid() {
        return Fid;
    }

    public void setFid(Integer fid) {
        Fid = fid;
    }

    @Basic
    @Column(name = "uid", nullable = true)
    public Integer getUid() {
        return Uid;
    }

    public void setUid(Integer uid) {
        Uid = uid;
    }

    @Basic
    @Column(name = "jid", nullable = true)
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
    @Column(name = "fupdate_time", nullable = true)
    public Timestamp getFupdateTime() {
        return FupdateTime;
    }

    public void setFupdateTime(Timestamp fupdateTime) {
        FupdateTime = fupdateTime;
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
    @Column(name = "cid", nullable = true)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FavoritesList that = (FavoritesList) o;
        return Objects.equals(Fid, that.Fid) &&
                Objects.equals(Uid, that.Uid) &&
                Objects.equals(Jid, that.Jid) &&
                Objects.equals(Jname, that.Jname) &&
                Objects.equals(FupdateTime, that.FupdateTime) &&
                Objects.equals(Jsal, that.Jsal) &&
                Objects.equals(Cid, that.Cid) &&
                Objects.equals(Cname, that.Cname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Fid, Uid, Jid, Jname, FupdateTime, Jsal, Cid, Cname);
    }
}
