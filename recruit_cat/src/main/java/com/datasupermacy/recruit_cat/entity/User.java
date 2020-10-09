package com.datasupermacy.recruit_cat.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Entity
@IdClass(UserPK.class)
public class User implements Serializable {
    private Integer Uid;
    private String Uname;
    private String Ugender;
    private String Uphone;
    private String Uemail;
    private String Upass;
    private Date Ubirth;
    private String Uidentify;
    private String UjobS_status;
    private String Uexperience;
    private String Uqualifications;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid", nullable = false)
    public Integer getUid() {
        return Uid;
    }

    public void setUid(Integer uid) {
        Uid = uid;
    }

    @Basic
    @Column(name = "uname", nullable = false, length = 255)
    public String getUname() {
        return Uname;
    }

    public void setUname(String uname) {
        Uname = uname;
    }

    @Basic
    @Column(name = "ugender", nullable = true, length = 255)
    public String getUgender() {
        return Ugender;
    }

    public void setUgender(String ugender) {
        Ugender = ugender;
    }

    @Id
    @Column(name = "uphone", nullable = false, length = 255)
    public String getUphone() {
        return Uphone;
    }

    public void setUphone(String uphone) {
        Uphone = uphone;
    }

    @Basic
    @Column(name = "uemail", nullable = false, length = 255)
    public String getUemail() {
        return Uemail;
    }

    public void setUemail(String uemail) {
        Uemail = uemail;
    }

    @Basic
    @Column(name = "upass", nullable = true, length = 255)
    public String getUpass() {
        return Upass;
    }

    public void setUpass(String upass) {
        Upass = upass;
    }

    @Basic
    @Column(name = "ubirth", nullable = true)
    public Date getUbirth() {
        return Ubirth;
    }

    public void setUbirth(Date ubirth) {
        Ubirth = ubirth;
    }

    @Basic
    @Column(name = "uidentify", nullable = true, length = 255)
    public String getUidentify() {
        return Uidentify;
    }

    public void setUidentify(String uidentify) {
        Uidentify = uidentify;
    }

    @Basic
    @Column(name = "ujob_status", nullable = true, length = 255)
    public String getUjobS_status() {
        return UjobS_status;
    }

    public void setUjobS_status(String ujobS_status) {
        UjobS_status = ujobS_status;
    }

    @Basic
    @Column(name = "uexperience", nullable = true, length = 255)
    public String getUexperience() {
        return Uexperience;
    }

    public void setUexperience(String uexperience) {
        Uexperience = uexperience;
    }

    @Basic
    @Column(name = "uqualifications", nullable = true, length = 255)
    public String getUqualifications() {
        return Uqualifications;
    }

    public void setUqualifications(String uqualifications) {
        Uqualifications = uqualifications;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(Uid, user.Uid) &&
                Objects.equals(Uname, user.Uname) &&
                Objects.equals(Ugender, user.Ugender) &&
                Objects.equals(Uphone, user.Uphone) &&
                Objects.equals(Uemail, user.Uemail) &&
                Objects.equals(Upass, user.Upass) &&
                Objects.equals(Ubirth, user.Ubirth) &&
                Objects.equals(Uidentify, user.Uidentify) &&
                Objects.equals(UjobS_status, user.UjobS_status) &&
                Objects.equals(Uexperience, user.Uexperience) &&
                Objects.equals(Uqualifications, user.Uqualifications);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Uid, Uname, Ugender, Uphone, Uemail, Upass, Ubirth, Uidentify, UjobS_status, Uexperience, Uqualifications);
    }
}
