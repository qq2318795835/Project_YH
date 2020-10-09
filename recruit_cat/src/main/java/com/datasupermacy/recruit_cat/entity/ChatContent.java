package com.datasupermacy.recruit_cat.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "chat_content", schema = "recruit_cat", catalog = "")
public class ChatContent implements Serializable {
    private Integer ContentId;
    private Integer Rd;
    private Integer RattachId;
    private String Content;
    private Timestamp CcreateTime;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "content_id", nullable = false)
    public Integer getContentId() {
        return ContentId;
    }

    public void setContentId(Integer contentId) {
        ContentId = contentId;
    }

    @Basic
    @Column(name = "rid", nullable = true)
    public Integer getRd() {
        return Rd;
    }

    public void setRd(Integer rd) {
        Rd = rd;
    }

    @Basic
    @Column(name = "rattach_id", nullable = true)
    public Integer getRattachId() {
        return RattachId;
    }

    public void setRattachId(Integer rattachId) {
        RattachId = rattachId;
    }

    @Basic
    @Column(name = "content", nullable = true, length = 255)
    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    @Basic
    @Column(name = "ccreate_time", nullable = true)
    public Timestamp getCcreateTime() {
        return CcreateTime;
    }

    public void setCcreateTime(Timestamp ccreateTime) {
        CcreateTime = ccreateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatContent that = (ChatContent) o;
        return Objects.equals(ContentId, that.ContentId) &&
                Objects.equals(Rd, that.Rd) &&
                Objects.equals(RattachId, that.RattachId) &&
                Objects.equals(Content, that.Content) &&
                Objects.equals(CcreateTime, that.CcreateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ContentId, Rd, RattachId, Content, CcreateTime);
    }
}
