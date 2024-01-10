package com.hil.task3.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class FileService {
	public ArrayList<ArrayList<String>> readFiles(String pathFile, String split) {
		ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();	
		
		String line;
		
		try (BufferedReader br = new BufferedReader(new FileReader(pathFile))) {
			br.readLine();
			while ((line = br.readLine()) != null) {
				if(line.length() > 0) {
					ArrayList<String> buff = new ArrayList<String>();
					String[] values = line.split(split);
					for (String value : values) {
	                	buff.add(value.replaceAll("//s+", " ").trim());
	                }
					data.add(buff);
	            }
			}
	    } catch (Exception e) {
	            e.printStackTrace();
	    }

        return data;
	}
}
