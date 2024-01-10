package com.hil.task2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hil.task2.service.ServiceCountingExpression;

@RestController
@RequestMapping("/api")
public class ControllerGettingResult {
	@Autowired
	ServiceCountingExpression service;
	
	@GetMapping("/getResult")
	@ResponseStatus(HttpStatus.OK)
	public double getIP(@RequestParam int number) {
		return service.countExpressionWithFactorial(number);
	}
}
