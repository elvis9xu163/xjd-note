package com.xjd.note.web.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <pre>
 * 错误Controller
 * </pre>
 * @author elvis.xu
 * @since Dec 18, 2013 3:35:24 PM
 */
@Controller
@RequestMapping("/error")
public class ErrorController {

	/**
	 * <pre>
	 * 所有其它
	 * </pre>
	 * @return
	 * @author elvis.xu
	 * @since Dec 18, 2013 3:35:42 PM
	 */
	@RequestMapping("/all")
	public String all() {
		return "/error_all";
	}
	
	/**
	 * <pre>
	 * 权限
	 * </pre>
	 * @return
	 * @author elvis.xu
	 * @since Dec 18, 2013 3:35:50 PM
	 */
	@RequestMapping("/auth")
	public String auth() {
		return "/auth/not_auth";
	}
}
