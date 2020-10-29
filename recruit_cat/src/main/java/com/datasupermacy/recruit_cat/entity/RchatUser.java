package com.datasupermacy.recruit_cat.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "rchat_user", schema = "recruit_cat", catalog = "")
public class RchatUser implements Serializable {
    private static final long serialVersionUID = -1500325645361023316L;
    private Integer Rid;
    private Integer Rjoin_id;
    private Double Rsend_count;
    private Double Runread_count;
    private Timestamp Rulastchat_time;
    private Timestamp Rrlastchat_time;

    @Basic
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rid", nullable = false)
    public Integer getRid() {
        return Rid;
    }

    public void setRid(Integer rid) {
        Rid = rid;
    }

    @Id
    @Column(name = "rjoin_id", nullable = false)
    public Integer getRjoin_id() {
        return Rjoin_id;
    }

    public void setRjoin_id(Integer rjoin_id) {
        Rjoin_id = rjoin_id;
    }

    @Basic
    @Column(name = "rsend_count", nullable = true, precision = 0)
    public Double getRsend_count() {
        return Rsend_count;
    }

    public void setRsend_count(Double rsend_count) {
        Rsend_count = rsend_count;
    }

    @Basic
    @Column(name = "runread_count", nullable = true, precision = 0)
    public Double getRunread_count() {
        return Runread_count;
    }

    public void setRunread_count(Double runread_count) {
        Runread_count = runread_count;
    }

    @Basic
    @Column(name = "rulastchat_time", nullable = true)
    public Timestamp getRulastchat_time() {
        return Rulastchat_time;
    }

    public void setRulastchat_time(Timestamp rulastchat_time) {
        Rulastchat_time = rulastchat_time;
    }

    @Basic
    @Column(name = "rrlastchat_time", nullable = true)
    public Timestamp getRrlastchat_time() {
        return Rrlastchat_time;
    }

    public void setRrlastchat_time(Timestamp rrlastchat_time) {
        Rrlastchat_time = rrlastchat_time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RchatUser rchatUser = (RchatUser) o;
        return Objects.equals(Rid, rchatUser.Rid) &&
                Objects.equals(Rjoin_id, rchatUser.Rjoin_id) &&
                Objects.equals(Rsend_count, rchatUser.Rsend_count) &&
                Objects.equals(Runread_count, rchatUser.Runread_count) &&
                Objects.equals(Rulastchat_time, rchatUser.Rulastchat_time) &&
                Objects.equals(Rrlastchat_time, rchatUser.Rrlastchat_time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Rid, Rjoin_id, Rsend_count, Runread_count, Rulastchat_time, Rrlastchat_time);
    }
}
