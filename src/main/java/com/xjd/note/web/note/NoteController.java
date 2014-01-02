package com.xjd.note.web.note;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xjd.note.biz.model.Note;

/**
 * <pre>
 * 笔记相关
 * </pre>
 * @author elvis.xu
 * @since Dec 23, 2013 10:18:46 AM
 */
@Controller
@RequestMapping("/note")
public class NoteController {

	@RequestMapping("/listNodes")
	@ResponseBody
	public NoteView[] listNodes(@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "level", required = false) String level) {
		System.out.printf("%s, %s, %s%n", id, name, level);

		NoteView[] ns = new NoteView[2];
		ns[0] = new NoteView.Builder().withId(1L).withNoteName("hello").withParentId(0L).withIsDir(true).build();
		ns[1] = new NoteView.Builder().withId(2L).withNoteName("hello2").withParentId(0L).withIsDir(true).build();

		return ns;
	}
}
