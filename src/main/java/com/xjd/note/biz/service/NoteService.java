package com.xjd.note.biz.service;

import com.xjd.note.biz.model.Note;

/**
 * <pre>
 * TODO
 * </pre>
 * @author elvis.xu
 * @since 2014-1-5 下午8:36:40
 */
public interface NoteService {

    Note createNote(Long userId, Long parentId, String name);
    
    Note createNotebook(Long userId, Long parentId, String name);
    
    Note[] listNotes(Long userId, Long parentId);
    
    void saveNote(Long userId, Long noteId, String content);
    
    String readNote(Long userId, Long noteId);
    
    void renameNote(Long userId, Long noteId, String name);
    
    void deleteNote(Long userId, Long noteId);
}
