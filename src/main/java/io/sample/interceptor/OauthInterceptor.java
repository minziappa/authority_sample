package io.sample.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.configuration.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.view.RedirectView;

import io.sample.annotation.Auth;
import io.sample.bean.model.UserModel;
import io.sample.bean.model.auth.AuthModel;
import io.sample.service.AuthService;

public class OauthInterceptor implements HandlerInterceptor {

	final Logger logger = LoggerFactory.getLogger(OauthInterceptor.class);

	@Autowired
    private Configuration configuration;
	@Autowired
	private MessageSource message;
	@Autowired
	private AuthService authService;

	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object object, ModelAndView modelAndView) throws Exception {
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {

		String pathInfo = request.getPathInfo();
		logger.info("pathInfo >>> " + pathInfo);

		if(pathInfo.equals("/login/callback") || pathInfo.equals("/error/error")) {
			return true;
		}

		HttpSession session = request.getSession();
		UserModel user = (UserModel) session.getAttribute("user");

		// This is a login process in your local machine
		if(!pathInfo.equals("/login/login") && user == null) {
			RedirectView redirectView = new RedirectView();
			redirectView.setUrl("/login/login");
			redirectView.addStaticAttribute("userName", "test");
			redirectView.addStaticAttribute("userPwd", "test");
			ModelAndView mv = new ModelAndView(redirectView);
			ModelAndViewDefiningException mvde = new ModelAndViewDefiningException(mv);
			throw mvde;
		}

//		// Hope this will be used for being strong security.
//		if (handler instanceof HandlerMethod) {
//			HandlerMethod handlerMethod = (HandlerMethod) handler;
//			Auth auth = handlerMethod.getMethodAnnotation(Auth.class);
//			if(auth == null) {
//				return true;
//			} else {
//				logger.info("auth >> " + auth.priority().value);
//			}
//			AuthModel authModel = authService.selectAuth(auth.priority().value);
//			if(authModel == null) {
//				logger.info("auth >> " + auth.priority().value);
//				return true;
//			}
//		}

		return true;
	}

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

}