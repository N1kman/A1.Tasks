package com.hil.task3.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hil.task3.entity.Login;
import com.hil.task3.entity.Posting;
import com.hil.task3.entity.Response;
import com.hil.task3.service.ConvertService;
import com.hil.task3.service.DatabaseService;
import com.hil.task3.service.FileService;

@RestController
@RequestMapping("/api")
public class ControllerGettingInfo {
	@Autowired
	FileService fileService;
	
	@Autowired
	ConvertService convertService;
	
	@Autowired
	DatabaseService dbservice;
	
	@GetMapping("/saveToDBFromFile")
	@ResponseStatus(HttpStatus.OK)
	public Response saveToDB() {
		ArrayList<Login> listLogin = convertService.convertToLoginEntity(fileService.readFiles("./src/main/resources/static/logins.csv", ","));
		ArrayList<Posting> listPosting = convertService.convertToPostingEntity(fileService.readFiles("./src/main/resources/static/postings.csv", ";"));
		setNewField(listLogin, listPosting);
		dbservice.safeToDatabaseLogins(listLogin);
		dbservice.safeToDatabasePostings(listPosting);
		return new Response(listLogin, listPosting);
	}
	
	@GetMapping("/getPostings")
	@ResponseStatus(HttpStatus.OK)
	public ArrayList<Posting> getPostings() {
		return dbservice.readFromDatabasePostings();
	}
	
	@GetMapping("/getPostingsByDay")
	@ResponseStatus(HttpStatus.OK)
	public ArrayList<Posting> getPostingsByDay(@RequestParam int day, @RequestParam int month, 
			@RequestParam int year, @RequestParam boolean isAuthorized) {
		ArrayList<Posting> list = dbservice.readFromDatabasePostings();
		list.removeIf(x -> checkDay(x.getPstng_date(), x.isAuthorized_delivery(),
				day, month, year, isAuthorized));
		return list;
	}
	
	@GetMapping("/getPostingsByMonth")
	@ResponseStatus(HttpStatus.OK)
	public ArrayList<Posting> getPostingsByMonth(@RequestParam int month, 
			@RequestParam int year, @RequestParam boolean isAuthorized) {
		ArrayList<Posting> list = dbservice.readFromDatabasePostings();
		list.removeIf(x -> checkMonth(x.getPstng_date(), x.isAuthorized_delivery(), month, year, isAuthorized));
		return list;
	}
	
	@GetMapping("/getPostingsByYear")
	@ResponseStatus(HttpStatus.OK)
	public ArrayList<Posting> getPostingsByYear(@RequestParam int year, @RequestParam boolean isAuthorized) {
		ArrayList<Posting> list = dbservice.readFromDatabasePostings();
		list.removeIf(x -> checkYear(x.getPstng_date(), x.isAuthorized_delivery(), year, isAuthorized));
		return list;
	}
	
	@GetMapping("/getPostingsByQuarter")
	@ResponseStatus(HttpStatus.OK)
	public ArrayList<Posting> getPostingsByQuarter(@RequestParam int quarter, @RequestParam int year, @RequestParam boolean isAuthorized) {
		ArrayList<Posting> list = dbservice.readFromDatabasePostings();
		list.removeIf(x -> checkQuarter(x.getPstng_date(), x.isAuthorized_delivery(), quarter, year, isAuthorized));
		return list;
	}
	
	public boolean checkQuarter(String date, boolean isA, int quarter, int year, boolean isACheck) {
		if(isACheck) {
			if(!isA) {
				return true;
			}
		}
		String[] checkDate = date.split("\\.");		
		if(Integer.parseInt(checkDate[2]) == year) {
			int month = Integer.parseInt(checkDate[1]);
			if(quarter == 1) {
				if(1 <= month && month <= 3) {
					return false;
				}
			} else if(quarter == 2) {
				if(4 <= month && month <= 6) {
					return false;
				}
			} else if(quarter == 3) {
				if(7 <= month && month <= 9) {
					return false;
				}
			} else {
				if(10 <= month && month <= 12) {
					return false;
				}
			}
			
		}
		
		return true;
	}
	
	public boolean checkYear(String date, boolean isA, int year, boolean isACheck) {
		if(isACheck) {
			if(!isA) {
				return true;
			}
		}
		String[] checkDate = date.split("\\.");		
		if(Integer.parseInt(checkDate[2]) == year) {
			return false;
		}
		
		return true;
	}
	
	public boolean checkMonth(String date, boolean isA, int month, int year, boolean isACheck) {
		if(isACheck) {
			if(!isA) {
				return true;
			}
		}
		String[] checkDate = date.split("\\.");		
		if(Integer.parseInt(checkDate[1]) == month && Integer.parseInt(checkDate[2]) == year) {
			return false;
		}
		
		return true;
	}
	
	public boolean checkDay(String date, boolean isA, int day, int month, int year, boolean isACheck) {
		if(isACheck) {
			if(!isA) {
				return true;
			}
		}
		String[] checkDate = date.split("\\.");		
		if(Integer.parseInt(checkDate[0]) == day && Integer.parseInt(checkDate[1]) == month
				&& Integer.parseInt(checkDate[2]) == year) {
			return false;
		}
		
		return true;
	}
	
	public void setNewField(ArrayList<Login> listLogin, ArrayList<Posting> listPosting) {
		for(Posting posting: listPosting ) {
			for(Login login: listLogin) {
				if(posting.getUsername() == login.getAppAccountName() && login.isActive()) {
					posting.setAuthorized_delivery(true);
				}
			}
		}
	}
}
