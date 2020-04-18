package com.rapidcart.advice;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.exception.SQLGrammarException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.rapidcart.constant.ViewConstant;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

	@ExceptionHandler(value = NoHandlerFoundException.class)
	public ModelAndView handleNoHandlerFoundException(HttpServletRequest req) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("url", req.getRequestURL());
		mav.setViewName(ViewConstant.NOT_FOUND_VIEW);
		return mav;
	}

	@ExceptionHandler(value = Exception.class)
	public ModelAndView handleInternalServerError(HttpServletRequest req, Exception e) throws Exception {
		ModelAndView mav = new ModelAndView();
		if (e instanceof SQLGrammarException) {
			mav.addObject("exception", e);
			mav.addObject("url", req.getRequestURL());
			mav.setViewName(ViewConstant.GLOBAL_ERROR_VIEW);
		} else {
			mav.setViewName(ViewConstant.INTERNAL_SERVER_ERROR_VIEW);
		}
		return mav;
	}
}
