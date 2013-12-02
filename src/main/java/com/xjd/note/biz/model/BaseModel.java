package com.xjd.note.biz.model;

import java.io.Serializable;

public abstract class BaseModel implements Serializable {
	private static final long serialVersionUID = -4096795192891884216L;
	protected Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
