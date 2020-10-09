package com.datasupermacy.recruit_cat.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "post_list", schema = "recruit_cat", catalog = "")
public class PostList implements Serializable {
    private Integer Pid;
    private Integer Cid;
    private Integer Jid;
    private String Jname;
    private Timestamp Pupdate_time;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pid", nullable = false)
    public Integer getPid() {
        return Pid;
    }

    public void setPid(Integer pid) {
        Pid = pid;
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
    @Column(name = "jupdate_time", nullable = true)
    public Timestamp getPupdate_time() {
        return Pupdate_time;
    }

    public void setPupdate_time(Timestamp pupdate_time) {
        Pupdate_time = pupdate_time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostList postList = (PostList) o;
        return Objects.equals(Pid, postList.Pid) &&
                Objects.equals(Cid, postList.Cid) &&
                Objects.equals(Jid, postList.Jid) &&
                Objects.equals(Jname, postList.Jname) &&
                Objects.equals(Pupdate_time, postList.Pupdate_time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Pid, Cid, Jid, Jname, Pupdate_time);
    }
}
