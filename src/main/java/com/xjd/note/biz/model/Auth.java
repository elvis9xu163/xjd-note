package com.xjd.note.biz.model;

import java.util.List;

/**
 * <pre>
 * 授权对象
 * </pre>
 * @author elvis.xu
 * @since Dec 17, 2013 1:58:09 PM
 */
public class Auth extends BaseModel {
    private static final long serialVersionUID = -5925838534107542064L;

    private User user;

    private List<Authority> authorities;

    public User getUser() {
	return user;
    }

    public void setUser(User user) {
	this.user = user;
    }

    public List<Authority> getAuthorities() {
	return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
	this.authorities = authorities;
    }

}
