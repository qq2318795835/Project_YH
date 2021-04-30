package cn.datasupermacy.entity;

import java.io.Serializable;

public class Provider implements Serializable {
    private static final long serialVersionUID = -8571822363101977098L;
    private Integer pid;

    private String providername;

    private String postcode;

    private String address;

    private String telephone;

    private String contact;

    private String contactnumber;

    private String backaccount;

    private String contactemail;

    public Provider(Integer pid, String providername, String postcode, String address, String telephone, String contact, String contactnumber, String backaccount, String contactemail) {
        this.pid = pid;
        this.providername = providername;
        this.postcode = postcode;
        this.address = address;
        this.telephone = telephone;
        this.contact = contact;
        this.contactnumber = contactnumber;
        this.backaccount = backaccount;
        this.contactemail = contactemail;
    }

    public Provider() {
        super();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getProvidername() {
        return providername;
    }

    public void setProvidername(String providername) {
        this.providername = providername == null ? null : providername.trim();
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode == null ? null : postcode.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public String getContactnumber() {
        return contactnumber;
    }

    public void setContactnumber(String contactnumber) {
        this.contactnumber = contactnumber == null ? null : contactnumber.trim();
    }

    public String getBackaccount() {
        return backaccount;
    }

    public void setBackaccount(String backaccount) {
        this.backaccount = backaccount == null ? null : backaccount.trim();
    }

    public String getContactemail() {
        return contactemail;
    }

    public void setContactemail(String contactemail) {
        this.contactemail = contactemail == null ? null : contactemail.trim();
    }

    @Override
    public String toString() {
        return "Provider{" +
                "pid=" + pid +
                ", providername='" + providername + '\'' +
                ", postcode='" + postcode + '\'' +
                ", address='" + address + '\'' +
                ", telephone='" + telephone + '\'' +
                ", contact='" + contact + '\'' +
                ", contactnumber='" + contactnumber + '\'' +
                ", backaccount='" + backaccount + '\'' +
                ", contactemail='" + contactemail + '\'' +
                '}';
    }
}