package io.sample.controller;

import io.sample.bean.para.SamplePara;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class IndexValidator implements Validator {

	final Logger logger = LoggerFactory.getLogger(IndexValidator.class);

	@Autowired
	private MessageSource message;

	@Override
	public boolean supports(Class<?> clazz) {
		if(SamplePara.class.equals(clazz)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void validate(Object object, Errors errors) {
	}

}
