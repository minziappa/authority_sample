package io.sample.controller;

import io.sample.bean.Sample;
import io.sample.bean.para.UserDetailPara;
import io.sample.bean.para.UserPara;
import io.sample.service.SampleService;

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
@RequestMapping("/users")
public class UsersController extends AbstractBaseController {

	final Logger logger = LoggerFactory.getLogger(UsersController.class);

    @Autowired
    private Validator validator;
	@Autowired
	private MessageSource message;
	@Autowired
	private SampleService sampleService;

    @RequestMapping(value = {"/", "", "index"}, method=RequestMethod.GET)
	public String index(HttpSession session, ModelMap model) throws Exception {
		Sample sample = new Sample();

		sample.setNavi("aIndex");
	   	model.addAttribute("model", sample);

		return "users/index";
	}

    @RequestMapping(value = {"inputUser"})
	public String inputUser(HttpSession session, ModelMap model) throws Exception {
		Sample sample = new Sample();

		sample.setNavi("inputUser");
	   	model.addAttribute("model", sample);

		return "users/inputUser";
	}

	@RequestMapping(value = {"registerUser"})
	public String registerUser(@Valid UserPara userPara, BindingResult bindingResult, 
			ModelMap model, HttpServletResponse response) throws Exception {

		Sample sample = new Sample();

		Map<String, String> mapErrorMessage = null;

		// If it occurs a error, set the default value.
		if (bindingResult.hasErrors()) {
			logger.error("insertUser - it is occured a parameter error.");
			response.setStatus(400);

			mapErrorMessage = this.handleErrorMessages(bindingResult.getAllErrors());
			model.addAttribute("mapErrorMessage",  mapErrorMessage);
			model.addAttribute("model", sample);
			return "users/inputUser";
		}

		// Execute the transaction
		if(!sampleService.insertSample(userPara)) {
			model.addAttribute("errorMessage", message.getMessage("parameter.error.message", null, LOCALE));
			model.addAttribute("model", sample);
			return "users/inputUser";
		}

		return "redirect:/users/";
	}

	@RequestMapping(value = {"userList"})
	public String userList(ModelMap model) throws Exception {

		Sample sample = new Sample();

		sample.setNavi("userList");
	   	model.addAttribute("model", sample);

		// Execute the transaction
		sample.setUsersList(sampleService.selectSampleList());

		model.addAttribute("model", sample);

		return "users/userList";
	}

	@RequestMapping(value = {"userDetail"})
	public String userDetail(@Valid UserDetailPara userDetailPara, BindingResult bindingResult, 
			ModelMap model, HttpServletResponse response) throws Exception {

		Sample sample = new Sample();
		sample.setNavi("userDetail");

		// If it occurs a error, set the default value.
		if (bindingResult.hasErrors()) {
			logger.error("userDetail - it is occured a parameter error.");
			Map<String, String> mapErrorMessage = this.handleErrorMessages(bindingResult.getAllErrors());
			response.setStatus(400);
			model.addAttribute("errorMessage", mapErrorMessage);
			return "users/userList";
		}

		// Select name's data from User
		sample.setUsers(sampleService.selectSample(userDetailPara.getUserName()));

		model.addAttribute("model", sample);

		return "users/userDetail";
	}

}