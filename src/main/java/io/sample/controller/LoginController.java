package io.sample.controller;

import io.sample.bean.Sample;
import io.sample.bean.model.UsersModel;
import io.sample.service.LoginService;

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
	@Autowired
	private LoginService loginService;

    @RequestMapping(value = {"/", "", "index"}, method=RequestMethod.GET)
	public String index(HttpSession session, ModelMap model) throws Exception {

		Sample sample = new Sample();
		sample.setNavi("login");
		model.addAttribute("model", sample);

		return "login/index";
	}

	@RequestMapping(value = {"login"})
	public String login(@RequestParam String userName, @RequestParam String userPwd, HttpSession session) throws Exception {
		logger.info("This is a login process");

		// session clear
		session.removeAttribute("user");
		UsersModel user = loginService.checkLogin(userName);
		if(user == null) {
			logger.warn("There is no the account");
			return "login/index";
		}
		session.setAttribute("user", user);
		logger.info("user status = " + user.getUserStatus());
		session.setMaxInactiveInterval(100*60);

		return "redirect:/";
	}

	@RequestMapping(value = {"logout"})
	public String logout(ModelMap model, HttpSession session) throws Exception {

		Sample sample = new Sample();
		sample.setNavi("login");

		// Clear data in the session.
		session.invalidate();

		model.addAttribute("model", sample);

		return "redirect:/login/";
	}

	@RequestMapping(value = {"denied"})
	public String denied(ModelMap model, HttpSession session) throws Exception {

		return "login/denied";
	}

}