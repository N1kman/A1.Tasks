package com.hil.task1.service;

import org.springframework.stereotype.Service;

@Service
public class serviceGettingIP {
	public String getIpFromNum(long numIp) {
		String binary = Long.toBinaryString(numIp);
		
		while(binary.length() < 32) {
			binary = "0" + binary;
		}
		
		int octet1 = Integer.parseInt(binary.substring(0, 8), 2);
		int octet2 = Integer.parseInt(binary.substring(8, 16), 2);
		int octet3 = Integer.parseInt(binary.substring(16, 24), 2);
		int octet4 = Integer.parseInt(binary.substring(24, 32), 2);
		
		return "" + octet1 + "." + octet2 + "." + octet3 + "." + octet4;
	}
	
	public long getNumFromIp(String ip) {
		String[] binary = ip.split("\\.");
		String octets = "";
		
		for(int i = 0; i < binary.length; ++i) {
			String octet = Integer.toBinaryString(Integer.parseInt(binary[i]));
			while(octet.length() < 8) {
				octet = "0" + octet;
			}
			octets += octet;
		}

		return Long.parseLong(octets, 2);
	}
}
