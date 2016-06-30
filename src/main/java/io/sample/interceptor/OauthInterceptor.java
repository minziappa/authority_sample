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

import io.sample.annotation.Authority;
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

		HttpSession session = request.getSession();
		UserModel user = (UserModel) session.getAttribute("user");

		if(user != null) {
			session.setAttribute("user", user);
			logger.info("PathInfo=" + pathInfo + ", user = " + user.getUserName());
			session.setMaxInactiveInterval(100*60);
		} else {
			if (pathInfo.startsWith("/login") || pathInfo.startsWith("/js") || pathInfo.startsWith("/css")) {
				return true;
			}
			logger.info("redirect");
			RedirectView redirectView = new RedirectView();
			redirectView.setUrl("/login/");
			redirectView.addStaticAttribute("userName", "test");
			ModelAndView mv = new ModelAndView(redirectView);
			ModelAndViewDefiningException mvde = new ModelAndViewDefiningException(mv);
			throw mvde;
		}
		// (pathInfo.startsWith("/login") && user == null) 

//		// Hope this will be used for being strong security.
//		if (handler instanceof HandlerMethod) {
//			HandlerMethod handlerMethod = (HandlerMethod) handler;
//			Authority auth = handlerMethod.getMethodAnnotation(Authority.class);
//			if(auth == null) {
//				return false;
//			} else {
//				logger.info("auth >> " + auth.priority().value);
//			}
//			AuthModel authModel = authService.selectAuth(auth.priority().value);
//			if(authModel == null) {
//				logger.info("auth >> " + auth.priority().value);
//				return false;
//			}
//		}

		return true;
	}

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

}