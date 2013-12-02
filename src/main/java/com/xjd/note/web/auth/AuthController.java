package com.xjd.note.web.auth;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/auth")
@SessionAttributes("user")
public class AuthController {
	
	@Autowired
	AuthConfig authConfig;

	@RequestMapping("/input")
	public String input(@RequestParam(value = "targetPath", required = false) String targetPath, Map<String, Object> model) {
		model.put("targetPath", targetPath);
		return "/auth/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("username") String username, @RequestParam("password") String password,
			@RequestParam(value = "targetPath", required = false) String targetPath,
			@RequestParam(value = "rememberme", required = false) String rememberme,
			Map<String, Object> model) {

		model.put(authConfig.getAuthVarName(), "OK"); //授权
		
		if (!StringUtils.isBlank(targetPath)) {
			return "redirect:" + targetPath;

		} else {
			return "forward:/main";
		}
	}
	
	@RequestMapping("/logout")
	public String logout(SessionStatus status) {
		status.setComplete();
		return "/auth/login";
	}
}
