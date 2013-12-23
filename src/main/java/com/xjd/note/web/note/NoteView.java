package com.xjd.note.web.note;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * <pre>
 * NoteView
 * </pre>
 * @author elvis.xu
 * @since Dec 23, 2013 10:37:12 AM
 */
public class NoteView implements Serializable {
	private static final long serialVersionUID = 5406793622767103652L;

	private Long id;

	private String noteName;

	private Boolean isDir;

	private Long parentId;

	private String fileKey;

	private Date createTimestamp;

	private Date lastModifyTimestamp;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JsonProperty("name")
	public String getNoteName() {
		return noteName;
	}

	public void setNoteName(String noteName) {
		this.noteName = noteName;
	}

	@JsonProperty("isParent")
	public Boolean getIsDir() {
		return isDir;
	}

	public void setIsDir(Boolean isDir) {
		this.isDir = isDir;
	}

	@JsonProperty("pid")
	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getFileKey() {
		return fileKey;
	}

	public void setFileKey(String fileKey) {
		this.fileKey = fileKey;
	}

	public Date getCreateTimestamp() {
		return createTimestamp;
	}

	public void setCreateTimestamp(Date createTimestamp) {
		this.createTimestamp = createTimestamp;
	}

	public Date getLastModifyTimestamp() {
		return lastModifyTimestamp;
	}

	public void setLastModifyTimestamp(Date lastModifyTimestamp) {
		this.lastModifyTimestamp = lastModifyTimestamp;
	}

	private NoteView(Builder builder) {
		this.id = builder.id;
		this.noteName = builder.noteName;
		this.isDir = builder.isDir;
		this.parentId = builder.parentId;
		this.fileKey = builder.fileKey;
		this.createTimestamp = builder.createTimestamp;
		this.lastModifyTimestamp = builder.lastModifyTimestamp;
	}

	public static class Builder {

		private Long id;
		private String noteName;
		private Boolean isDir;
		private Long parentId;
		private String fileKey;
		private Date createTimestamp;
		private Date lastModifyTimestamp;

		public Builder withId(Long id) {
			this.id = id;
			return this;
		}

		public Builder withNoteName(String noteName) {
			this.noteName = noteName;
			return this;
		}

		public Builder withIsDir(Boolean isDir) {
			this.isDir = isDir;
			return this;
		}

		public Builder withParentId(Long parentId) {
			this.parentId = parentId;
			return this;
		}

		public Builder withFileKey(String fileKey) {
			this.fileKey = fileKey;
			return this;
		}

		public Builder withCreateTimestamp(Date createTimestamp) {
			this.createTimestamp = createTimestamp;
			return this;
		}

		public Builder withLastModifyTimestamp(Date lastModifyTimestamp) {
			this.lastModifyTimestamp = lastModifyTimestamp;
			return this;
		}

		public NoteView build() {
			return new NoteView(this);
		}
	}

}
