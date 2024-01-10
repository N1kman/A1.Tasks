package com.hil.task3.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.hil.task3.entity.Login;
import com.hil.task3.entity.Posting;

@Service
public class ConvertService {
	public ArrayList<Login> convertToLoginEntity(ArrayList<ArrayList<String>> lists) {
		ArrayList<Login> logins = new ArrayList<Login>();
		
		for(ArrayList<String> list : lists) {
			logins.add(new Login(
					list.get(0),
					list.get(1),
					Boolean.valueOf(list.get(2)),
					list.get(3),
					list.get(4)));
		}
		
		return logins;
	}
	
	public ArrayList<Posting> convertToPostingEntity(ArrayList<ArrayList<String>> lists) {
		ArrayList<Posting> logins = new ArrayList<Posting>();
		
		for(ArrayList<String> list : lists) {
			logins.add(new Posting(
					Long.parseLong(list.get(0)),
					Integer.parseInt(list.get(1)),
					list.get(2),
					list.get(3),
					list.get(4),
					Integer.parseInt(list.get(5)),
					list.get(6),
					Float.parseFloat(list.get(7).replaceAll(",", ".")),
					list.get(8),
					list.get(9)));
		}
		
		return logins;
	}
}
