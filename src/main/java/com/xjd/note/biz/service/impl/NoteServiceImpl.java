package com.xjd.note.biz.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.CharBuffer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.xjd.note.biz.exception.NoteRuntimeException;
import com.xjd.note.biz.model.Note;
import com.xjd.note.biz.service.NoteService;
import com.xjd.note.dao.mapper.NoteDoMapper;
import com.xjd.note.dao.model.NoteDo;
import com.xjd.note.dao.model.NoteDoExample;

/**
 * <pre>
 * NoteServiceImpl
 * </pre>
 * 
 * @author elvis.xu
 * @since 2014-1-5 下午8:38:56
 */
@Service
public class NoteServiceImpl implements NoteService {
    private static final Logger log = LoggerFactory.getLogger(NoteServiceImpl.class);
    
    protected SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");

    @Value("#{properties['note.rootDir']}")
    String noteRootDir;
    
    @Autowired
    NoteDoMapper noteDoMapper;
    
    @PostConstruct
    public void init() {
	File f = new File(noteRootDir);
	if (f.exists() && !f.isDirectory()) {
	    throw new NoteRuntimeException("The note root directory '" + noteRootDir + "' is not a directory!");
	}
	if (!f.exists()) {
	    log.info("The note root directory '{}' does not exist, building...", noteRootDir);
	    if (!f.mkdirs()) {
		throw new NoteRuntimeException("The note root directory '" + noteRootDir + "' cannot be built.");
	    }
	}
    }

    @Override
    public Note createNote(Long userId, Long parentId, String name) {
	return createNote(userId, parentId, name, false);
    }

    @Override
    public Note createNotebook(Long userId, Long parentId, String name) {
	return createNote(userId, parentId, name, true);
    }

    protected Note createNote(Long userId, Long parentId, String name, boolean isNotebook) {
	NoteDo noteDo = new NoteDo();
	noteDo.setUserId(userId);
	noteDo.setNoteName(name);
	noteDo.setIsDir(isNotebook);
	noteDo.setParentId(parentId);
	Date date = new Date();
	noteDo.setFileKey(generateFileKey(name, date));
	noteDo.setCreateTimestamp(date);
	noteDo.setLastModifyTimestamp(date);
	noteDoMapper.insertSelective(noteDo);

	Note note = new Note();
	BeanUtils.copyProperties(noteDo, note);
	return note;
    }

    protected String generateFileKey(String name, Date date) {
	return name + "_" + format.format(date);
    }

    @Override
    public Note[] listNotes(Long userId, Long parentId) {
	NoteDoExample example = new NoteDoExample();
	NoteDoExample.Criteria criteria = example.createCriteria().andUserIdEqualTo(userId);
	if (parentId == null) {
	    criteria.andParentIdIsNull();
	} else {
	    criteria.andParentIdEqualTo(parentId);
	}
	List<NoteDo> noteDos = noteDoMapper.selectByExample(example);
	Note[] notes = new Note[noteDos.size()];
	for (int i = 0; i < notes.length; i++) {
	    Note note = new Note();
	    BeanUtils.copyProperties(noteDos.get(i), note);
	    notes[i] = note;
	}

	return notes;
    }

    @Override
    public void saveNote(Long userId, Long noteId, String content) {
	NoteDo noteDo = noteDoMapper.selectByPrimaryKey(noteId);
	if (noteDo == null || !noteDo.getUserId().equals(userId)) {
	    throw new NoteRuntimeException("Cannot find the note for id '" + noteId + "'.");
	}
	
	if (StringUtils.isBlank(noteDo.getFileKey())) {
	    throw new NoteRuntimeException("The fileKey for the note[id='" + noteId + "'] is blank.");
	}
	
	File noteFile = new File(noteRootDir, noteDo.getFileKey());
	try {
	    FileWriter fw = new FileWriter(noteFile);
	    fw.write(content);
	    fw.close();
	} catch (IOException e) {
	    throw new NoteRuntimeException("Save note fail.", e);
	}
    }

    @Override
    public String readNote(Long userId, Long noteId) {
	NoteDo noteDo = noteDoMapper.selectByPrimaryKey(noteId);
	if (noteDo == null || !noteDo.getUserId().equals(userId)) {
	    throw new NoteRuntimeException("Cannot find the note for id '" + noteId + "'.");
	}
	
	if (StringUtils.isBlank(noteDo.getFileKey())) {
	    throw new NoteRuntimeException("The fileKey for the note[id='" + noteId + "'] is blank.");
	}
	
	File noteFile = new File(noteRootDir, noteDo.getFileKey());
	if (!noteFile.exists()) {
	    return null;
	}
	
	CharBuffer buf = CharBuffer.allocate((int)noteFile.length() + 1);
	try {
	    FileReader fr = new FileReader(noteFile);
	    int c = 0;
	    while ((c = fr.read(buf)) != -1) {}
	    fr.close();
	} catch (IOException e) {
	    throw new NoteRuntimeException("Read note fail.", e);
	}
	buf.flip();
	return buf.toString();
    }
    
    

}
