package com.xjd.note.web.auth;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/auth")
public class AuthController {

	@RequestMapping("/input")
	public String input(@RequestParam(value="targetUrl", required=false) String targetUrl, Map<String, Object> model) {
		model.put(targetUrl, targetUrl);
		return "/auth/login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@RequestParam(value="targetUrl", required=false) String targetUrl) {
		
		if (!StringUtils.isBlank(targetUrl)) {
			return "redirect:" + targetUrl;
			
		} else {
			return "/main";
		}
	}
}
