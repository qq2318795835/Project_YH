package cn.datasupermacy.entity;

import java.io.Serializable;

public class Customer implements Serializable {
    private static final long serialVersionUID = 8201181003581242139L;
    private Integer cid;

    private String customernname;

    private String postcode;

    private String caddress;

    private String ctelephone;

    private String contact;

    private String contactnumber;

    private String backaccount;

    private String contactemail;

    public Customer(Integer cid, String customernname, String postcode, String caddress, String ctelephone, String contact, String contactnumber, String backaccount, String contactemail) {
        this.cid = cid;
        this.customernname = customernname;
        this.postcode = postcode;
        this.caddress = caddress;
        this.ctelephone = ctelephone;
        this.contact = contact;
        this.contactnumber = contactnumber;
        this.backaccount = backaccount;
        this.contactemail = contactemail;
    }

    public Customer() {
        super();
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCustomernname() {
        return customernname;
    }

    public void setCustomernname(String customernname) {
        this.customernname = customernname == null ? null : customernname.trim();
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode == null ? null : postcode.trim();
    }

    public String getCaddress() {
        return caddress;
    }

    public void setCaddress(String caddress) {
        this.caddress = caddress == null ? null : caddress.trim();
    }

    public String getCtelephone() {
        return ctelephone;
    }

    public void setCtelephone(String ctelephone) {
        this.ctelephone = ctelephone == null ? null : ctelephone.trim();
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
        return "Customer{" +
                "cid=" + cid +
                ", customernname='" + customernname + '\'' +
                ", postcode='" + postcode + '\'' +
                ", caddress='" + caddress + '\'' +
                ", ctelephone='" + ctelephone + '\'' +
                ", contact='" + contact + '\'' +
                ", contactnumber='" + contactnumber + '\'' +
                ", backaccount='" + backaccount + '\'' +
                ", contactemail='" + contactemail + '\'' +
                '}';
    }
}