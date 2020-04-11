package com.rapidcart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.rapidcart.swagger.SwaggerApiResponses;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@SwaggerApiResponses
@Controller
public class HomeController {

	@GetMapping("/")
	public String home() {
		return "index";
	}
}
