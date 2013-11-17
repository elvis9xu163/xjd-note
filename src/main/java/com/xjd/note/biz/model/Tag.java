package com.xjd.note.biz.model;

import java.util.Date;

public class Tag extends BaseModel {
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