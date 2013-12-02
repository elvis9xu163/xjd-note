package com.xjd.note.web.auth;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.xjd.note.biz.exception.AuthException;
import com.xjd.note.biz.model.Auth;
import com.xjd.note.biz.service.AuthService;

@Controller
@RequestMapping("/auth")
@SessionAttributes("user")
public class AuthController {

    @Autowired
    AuthConfig authConfig;

    @Autowired
    AuthService authService;

    @RequestMapping("/input")
    public String input(@RequestParam(value = "targetPath", required = false) String targetPath, Map<String, Object> model) {
	model.put("targetPath", targetPath);
	return "/auth/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("username") String username, @RequestParam("password") String password,
	    @RequestParam(value = "rememberme", required = false) String rememberme,
	    @ModelAttribute("targetPath") String targetPath,
	    Map<String, Object> model) {

	Auth auth = null;
	try {
	    auth = authService.login(username, password);
	} catch (AuthException e) {
	    model.put("errorCode", e.getCode());
	    model.put("targetPath", targetPath);
	    return "forward:/auth/input";
	}

	model.put(authConfig.getAuthVarName(), auth); // 授权
	
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
