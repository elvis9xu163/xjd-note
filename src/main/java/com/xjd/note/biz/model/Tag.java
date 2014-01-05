package com.xjd.note.biz.model;

import java.util.Date;

public class Tag extends BaseModel {
    private static final long serialVersionUID = -146162374990620754L;

    private Long id;

    private String tagName;

    private Date createTimestamp;

    private Long userId;

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

    public Long getUserId() {
	return userId;
    }

    public void setUserId(Long userId) {
	this.userId = userId;
    }
}