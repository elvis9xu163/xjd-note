package com.xjd.note.dao.model;

import com.xjd.note.dao.model.custom.BaseDo;
import java.util.Date;

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