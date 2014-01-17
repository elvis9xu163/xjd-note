package com.xjd.note.web.note;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.xjd.note.biz.model.Auth;
import com.xjd.note.biz.model.Note;
import com.xjd.note.biz.service.NoteService;

/**
 * <pre>
 * 笔记相关
 * </pre>
 * 
 * @author elvis.xu
 * @since Dec 23, 2013 10:18:46 AM
 */
@Controller
@SessionAttributes("user")
@RequestMapping("/note")
public class NoteController {

	@Autowired
	NoteService noteService;

	@RequestMapping("/listNodes")
	@ResponseBody
	public NoteView[] listNodes(@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "level", required = false) String level, @ModelAttribute("user") Auth auth) {

		Note[] notes = noteService.listNotes(auth.getUser().getId(), StringUtils.isBlank(id) ? null : Long.valueOf(id));

		NoteView[] views = new NoteView[notes.length];
		for (int i = 0; i < notes.length; i++) {
			NoteView view = new NoteView();
			BeanUtils.copyProperties(notes[i], view);
			views[i] = view;
		}

		return views;
	}

	@RequestMapping("/saveNote")
	public String saveNote(@RequestParam("id") String id, @RequestParam("editorContent") String content,
			@ModelAttribute("user") Auth auth, Map<String, Object> map) {
		if (StringUtils.isBlank(id)) {
			map.put("result", false);
			// TODO reason
		} else {
			noteService.saveNote(auth.getUser().getId(), Long.valueOf(id), content);
			map.put("result", true);
		}
		return "/note/save-result";
	}

	@RequestMapping("/rename")
	@ResponseBody
	public Map<String, Object> renameNote(@RequestParam("id") String id, @RequestParam("name") String name, @ModelAttribute("user") Auth auth) {
		name = new String(name.getBytes(Charset.forName("ISO-8859-1")), Charset.forName("UTF-8"));
		noteService.renameNote(auth.getUser().getId(), Long.valueOf(id), name);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", true);
		return map;
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public Map<String, Object> deleteNote(@RequestParam("id") String id, @ModelAttribute("user") Auth auth) {
		noteService.deleteNote(auth.getUser().getId(), Long.valueOf(id));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", true);
		return map;
	}
	
	@RequestMapping("/readNote")
	@ResponseBody
	public String readNote(@RequestParam("id") String id, @ModelAttribute("user") Auth auth, Map<String, Object> map) {
		String content = noteService.readNote(auth.getUser().getId(), Long.valueOf(id));
		return content;
	}

	@RequestMapping("/newNote")
	@ResponseBody
	public NoteView newNote(@RequestParam(value = "id", required = false) String id,
			@RequestParam("value") String value, @RequestParam("isNoteBook") boolean isNoteBook,
			@ModelAttribute("user") Auth auth) {
		value = new String(value.getBytes(Charset.forName("ISO-8859-1")), Charset.forName("UTF-8"));
		Note note = null;
		if (isNoteBook) {
			note = noteService.createNotebook(auth.getUser().getId(),
					StringUtils.isBlank(id) ? null : Long.valueOf(id), value);
		} else {
			note = noteService.createNote(auth.getUser().getId(), StringUtils.isBlank(id) ? null : Long.valueOf(id),
					value);
		}
		NoteView view = new NoteView();
		BeanUtils.copyProperties(note, view);
		return view;
	}
	
	@RequestMapping("/renameNote")
	@ResponseBody
	public Map<String, Object> renameNote(@RequestParam(value="id") String id, @ModelAttribute("user") Auth auth) {
		//TODO
		return null;
	}
}
