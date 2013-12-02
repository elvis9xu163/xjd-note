package com.xjd.note.dao.model;

import com.xjd.note.dao.model.custom.BaseDo;
import java.util.Date;

public class TagDo extends BaseDo {
    private Long id;

    private String tagName;

    private Date createTimestamp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Date getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(Date createTimestamp) {
        this.createTimestamp = createTimestamp;
    }
}