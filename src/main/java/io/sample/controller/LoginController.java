package io.sample.controller;

import io.sample.bean.Sample;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

/***
 * The <code>LoginSampleController</code> class represents action controller.
 * 
 * @adminor  Woong-joon Kim
 * @version 0.1, 15/09/01
 * @see     io.sample.controller.LoginController#login()
 * @see     io.sample.controller.LoginController#logout()
 * @see     io.sample.controller.LoginController#denied()
 * 
 * @since   JDK1.7
 */
@Controller
@RequestMapping("/login")
public class LoginController extends AbstractBaseController {

	final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private Validator validator;
	@Autowired
	private MessageSource message;

    @RequestMapping(value = {"/", "", "index"}, method=RequestMethod.GET)
	public String index(HttpSession session, ModelMap model) throws Exception {

    	logger.info("Login index");

		return "login/index";
	}

	@RequestMapping(value = {"login"})
	public String login(@RequestParam String userName, @RequestParam String userPwd, HttpSession session) throws Exception {

		logger.info("This is a login process");

		session.setAttribute("user", userName);
		logger.info("user name = " + userName);
		logger.info("user pwd = " + userPwd);
		session.setMaxInactiveInterval(100*60);

		return "login/login";
	}

	@RequestMapping(value = {"logout"})
	public String logout(ModelMap model, SessionStatus sessionStatus) throws Exception {

		Sample modelView = new Sample();
		modelView.setNavi("login");

		// Clear data in the session.
		sessionStatus.isComplete();

		model.addAttribute("model", modelView);

		return "redirect:/sample/index/";
	}

	@RequestMapping(value = {"denied"})
	public String denied(ModelMap model, HttpSession session) throws Exception {

		return "login/denied";
	}

}