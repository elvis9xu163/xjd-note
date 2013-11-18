package com.xjd.note.dao.model;

import java.util.Date;

import com.xjd.note.dao.model.custom.BaseDo;

public class TagDo extends BaseDo {
    private String tagName;

    private Date createTimestamp;

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