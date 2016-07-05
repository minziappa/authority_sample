package io.sample.controller;

import io.sample.annotation.Authority;
import io.sample.bean.Authorities;
import io.sample.bean.para.auth.AuthDetailPara;
import io.sample.bean.para.auth.AuthPara;
import io.sample.bean.para.auth.UpdateUsersPara;
import io.sample.bean.para.user.UserDetailPara;
import io.sample.bean.para.user.UserPara;
import io.sample.service.AuthService;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/auth")
public class AuthController extends AbstractBaseController {

	final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private Validator validator;
	@Autowired
	private MessageSource message;
	@Autowired
	private AuthService authService;

	@Authority(priority = Authority.Priority.SUPER_ADMIN)
    @RequestMapping(value = {"/", "", "index"}, method=RequestMethod.GET)
	public String index(HttpSession session, ModelMap model) throws Exception {
		Authorities sample = new Authorities();

		sample.setNavi("auth");
		sample.setMenu("index");
		// Execute the transaction
		sample.setAuthList(authService.selectAuthList());

	   	model.addAttribute("model", sample);

		return "auth/index";
	}

    @RequestMapping(value = {"inputAuth"})
	public String inputAuth(HttpSession session, ModelMap model) throws Exception {
    	Authorities sample = new Authorities();

		sample.setNavi("auth");
		sample.setMenu("inputAuth");
	   	model.addAttribute("model", sample);

		return "auth/inputAuth";
	}

	@RequestMapping(value = {"registerAuth"})
	public String registerAuth(@Valid AuthPara authPara, BindingResult bindingResult, 
			ModelMap model, HttpServletResponse response) throws Exception {

		Authorities sample = new Authorities();
		sample.setNavi("auth");
		sample.setMenu("inputAuth");

		Map<String, String> mapErrorMessage = null;

		// If it occurs a error, set the default value.
		if (bindingResult.hasErrors()) {
			logger.error("insertUser - it is occured a parameter error.");
			response.setStatus(400);

			mapErrorMessage = this.handleErrorMessages(bindingResult.getAllErrors());
			model.addAttribute("mapErrorMessage",  mapErrorMessage);
			model.addAttribute("model", sample);
			return "auth/inputAuth";
		}

		// Execute the transaction
		if(!authService.insertAuth(authPara)) {
			model.addAttribute("errorMessage", message.getMessage("parameter.error.message", null, LOCALE));
			model.addAttribute("model", sample);
			return "auth/inputAuth";
		}

		return "redirect:/auth/";
	}

	@RequestMapping(value = {"authList"})
	public String authList(ModelMap model) throws Exception {

		Authorities sample = new Authorities();
		sample.setNavi("auth");
		sample.setMenu("authList");
	   	model.addAttribute("model", sample);

		// Execute the transaction
		sample.setAuthList(authService.selectAuthList());

		model.addAttribute("model", sample);

		return "auth/authList";
	}

	@RequestMapping(value = {"authDetail"})
	public String authDetail(@Valid AuthDetailPara authDetailPara, BindingResult bindingResult, 
			ModelMap model, HttpServletResponse response) throws Exception {

		Authorities authorityModel = new Authorities();
		authorityModel.setNavi("auth");
		authorityModel.setMenu("authDetail");

		// If it occurs a error, set the default value.
		if (bindingResult.hasErrors()) {
			logger.error("userDetail - it is occured a parameter error.");
			Map<String, String> mapErrorMessage = this.handleErrorMessages(bindingResult.getAllErrors());
			response.setStatus(400);
			model.addAttribute("errorMessage", mapErrorMessage);
			return "auth/authList";
		}

		// Select name's data from User
		authorityModel.setAuth(authService.selectAuth(authDetailPara.getAuthority()));

		model.addAttribute("model", authorityModel);

		return "auth/authDetail";
	}

	@RequestMapping(value = {"authJoinUsers"})
	public String authJoinUsers(@Valid AuthDetailPara authDetailPara, BindingResult bindingResult, 
			ModelMap model, HttpServletResponse response) throws Exception {

		Authorities authorityModel = new Authorities();
		authorityModel.setNavi("auth");
		authorityModel.setMenu("index");

		// Select name's data from User
		authorityModel.setAuthUsersList(authService.selectAuthAndUsers(null));

		model.addAttribute("model", authorityModel);

		return "auth/authDetail";
	}
	
	@RequestMapping(value = {"updateUsers"})
	public String updateUsers(@Valid UpdateUsersPara updateUsersPara, BindingResult bindingResult, 
			ModelMap model, HttpServletResponse response) throws Exception {

		Authorities authorityModel = new Authorities();
		authorityModel.setNavi("auth");
		authorityModel.setMenu("index");

		Map<String, String> mapErrorMessage = null;

		// If it occurs a error, set the default value.
		if (bindingResult.hasErrors()) {
			logger.error("insertUser - it is occured a parameter error.");
			response.setStatus(400);

			mapErrorMessage = this.handleErrorMessages(bindingResult.getAllErrors());
			model.addAttribute("mapErrorMessage",  mapErrorMessage);
			model.addAttribute("model", authorityModel);
			return "auth/index";
		}

		// Execute the transaction
		if(!authService.updateUsers(updateUsersPara)) {
			model.addAttribute("errorMessage", message.getMessage("parameter.error.message", null, LOCALE));
			model.addAttribute("model", authorityModel);
			return "auth/inputAuth";
		}

		return "redirect:/auth/";
	}

}