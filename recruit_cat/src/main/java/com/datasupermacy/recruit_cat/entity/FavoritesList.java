package com.datasupermacy.recruit_cat.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "favorites_list", schema = "recruit_cat", catalog = "")
public class FavoritesList implements Serializable {
    private Integer Fid;
    private Integer Uid;
    private Integer Jid;
    private String Jname;
    private Timestamp Fupdate_time;

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
    public Timestamp getFupdate_time() {
        return Fupdate_time;
    }

    public void setFupdate_time(Timestamp fupdate_time) {
        Fupdate_time = fupdate_time;
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
                Objects.equals(Fupdate_time, that.Fupdate_time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Fid, Uid, Jid, Jname, Fupdate_time);
    }
}
