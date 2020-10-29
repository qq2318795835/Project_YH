package com.datasupermacy.recruit_cat.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "rchat_room", schema = "recruit_cat", catalog = "")
public class RchatRoom implements Serializable {
    private static final long serialVersionUID = 4834031998570045421L;
    private Integer Rid;
    private Integer RjoinId;
    private Timestamp Rcreate_time;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rid", nullable = false)
    public Integer getRid() {
        return Rid;
    }

    public void setRid(Integer rid) {
        Rid = rid;
    }

    @Basic
    @Column(name = "rjoin_id", nullable = true)
    public Integer getRjoinId() {
        return RjoinId;
    }

    public void setRjoinId(Integer rjoinId) {
        RjoinId = rjoinId;
    }

    @Basic
    @Column(name = "rcreate_time", nullable = true)
    public Timestamp getRcreate_time() {
        return Rcreate_time;
    }

    public void setRcreate_time(Timestamp rcreate_time) {
        Rcreate_time = rcreate_time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RchatRoom rchatRoom = (RchatRoom) o;
        return Objects.equals(Rid, rchatRoom.Rid) &&
                Objects.equals(RjoinId, rchatRoom.RjoinId) &&
                Objects.equals(Rcreate_time, rchatRoom.Rcreate_time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Rid, RjoinId, Rcreate_time);
    }
}
