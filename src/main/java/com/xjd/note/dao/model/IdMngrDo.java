package com.xjd.note.dao.model;

import com.xjd.note.dao.model.custom.BaseDo;

public class IdMngrDo extends BaseDo {
    private Long id;

    private String name;

    private Long mid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }
}