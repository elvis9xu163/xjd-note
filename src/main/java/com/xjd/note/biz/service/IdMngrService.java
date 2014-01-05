package com.xjd.note.biz.service;

/**
 * <pre>
 * TODO
 * </pre>
 * @author elvis.xu
 * @since 2014-1-5 下午10:39:47
 */
public interface IdMngrService {
    String NOTE_ID = "note_id";

    Long generateId(String name);
}
