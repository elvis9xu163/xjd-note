package com.xjd.note.web.auth;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.xjd.note.biz.exception.AuthException;
import com.xjd.note.biz.exception.AuthExceptionType;
import com.xjd.note.biz.model.Auth;
import com.xjd.note.biz.service.AuthService;

@Controller
@RequestMapping("/auth")
@SessionAttributes("user")
public class AuthController {
	private static final Logger log = LoggerFactory.getLogger(AuthController.class);

	@Autowired
	AuthConfig authConfig;

	@Autowired
	AuthService authService;

	@Autowired
	MessageSourceAccessor messageSourceAccessor;

	@RequestMapping("/input")
	public String input() {
		return "/auth/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("username") String username, @RequestParam("password") String password,
			@RequestParam(value = "rememberme", required = false) String rememberme, @ModelAttribute("targetPath") String targetPath,
			Map<String, Object> model) throws UnsupportedEncodingException {

		Auth auth = null;
		try {
			auth = authService.login(username, password);
		} catch (AuthException e) {
			if (AuthExceptionType.USER_NOT_EXISTS == e.getType()) {
				model.put("errorMsg", messageSourceAccessor.getMessage("user_not_exists"));

			} else if (AuthExceptionType.WRONG_USERNAME_OR_PASSWORD == e.getType()) {
				model.put("errorMsg", messageSourceAccessor.getMessage("wrong_username_or_password"));

			} else if (AuthExceptionType.UNEXPECTED_EXCEPTION == e.getType()) {
				model.put("errorMsg", messageSourceAccessor.getMessage("unexpected_exception"));
				log.error("", e);
			}
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
