package com.datasupermacy.recruit_cat.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class UserPK implements Serializable {
    private Integer uid;
    private String uphone;

    @Column(name = "Uid", nullable = false)
    @Id
    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Column(name = "Uphone", nullable = false, length = 255)
    @Id
    public String getUphone() {
        return uphone;
    }

    public void setUphone(String uphone) {
        this.uphone = uphone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPK userPK = (UserPK) o;
        return Objects.equals(uid, userPK.uid) &&
                Objects.equals(uphone, userPK.uphone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, uphone);
    }
}
