package com.hil.task1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.hil.task1.service.serviceGettingIP;

@RestController
@RequestMapping("/api")
public class controllerGettingIP {
	@Autowired
	serviceGettingIP service;
	
	@GetMapping("/getIP")
	@ResponseStatus(HttpStatus.OK)
	public String getIP(@RequestParam long numIP) {
		return service.getIpFromNum(numIP);
	}
	
	@GetMapping("/getNum")
	@ResponseStatus(HttpStatus.OK)
	public long getNum(@RequestParam String ip) {
		return service.getNumFromIp(ip);
	}
	
}
