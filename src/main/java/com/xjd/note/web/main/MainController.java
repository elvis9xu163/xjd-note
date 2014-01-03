package com.xjd.note.web.main;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.xjd.note.biz.model.Auth;

/**
 * <pre>
 * 主体Controller
 * </pre>
 * @author elvis.xu
 * @since Dec 18, 2013 4:08:07 PM
 */
@Controller
@SessionAttributes("user")
public class MainController {

	/**
	 * <pre>
	 * 进入主页面
	 * </pre>
	 * @return
	 * @author elvis.xu
	 * @since Dec 18, 2013 4:09:25 PM
	 */
	@RequestMapping("/main")
	public String main(@ModelAttribute("user") Auth auth, Map<String, Object> map) {
		if (auth != null && auth.getUser() != null) {
			map.put("username", auth.getUser().getUsername());
		}
		return "/note/main";
	}
	
	/**
	 * <pre>
	 * 打开编辑窗口
	 * </pre>
	 * @return
	 * @author elvis.xu
	 * @since Dec 20, 2013 5:20:02 PM
	 */
	@RequestMapping("/editor")
	public String editor() {
		return "/editor";
	}
	
	@RequestMapping("/note/nav")
	public String nav() {
		return "/note/nav";
	}
	
	@RequestMapping("/note/body")
	public String body() {
		return "/note/body";
	}
}
