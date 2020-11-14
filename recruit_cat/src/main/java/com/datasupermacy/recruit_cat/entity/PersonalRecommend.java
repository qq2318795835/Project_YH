package com.datasupermacy.recruit_cat.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "personal_recommend", schema = "recruit_cat")
public class PersonalRecommend implements Serializable {
    private static final long serialVersionUID = -7191741530825613418L;
    private Integer id;
    private String uid;
    private String jid;
    private Integer exp;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "uid", nullable = true, length = 255)
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "jid", nullable = true, length = 255)
    public String getJid() {
        return jid;
    }

    public void setJid(String jid) {
        this.jid = jid;
    }

    @Basic
    @Column(name = "exp", nullable = true)
    public Integer getExp() {
        return exp;
    }

    public void setExp(Integer exp) {
        this.exp = exp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonalRecommend that = (PersonalRecommend) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(uid, that.uid) &&
                Objects.equals(jid, that.jid) &&
                Objects.equals(exp, that.exp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, uid, jid, exp);
    }
}
