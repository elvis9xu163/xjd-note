package com.xjd.note.web.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class ErrorController {

	@RequestMapping("/all")
	public String all() {
		return "/error_all";
	}
	
	@RequestMapping("/auth")
	public String auth() {
		return "/auth/not_auth";
	}
}
