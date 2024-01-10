package com.hil.task2.service;

import org.springframework.stereotype.Service;

@Service
public class ServiceCountingExpression {
	
	public final double ACCURACY = 0.000001;

	public double countExpressionWithFactorial(int number) {
		if(number < 1) {
			return 0;
		}
		
		double sum = 1;
		double current_term = 1;
		
		while(number > 1 && current_term > ACCURACY) {
			current_term /= number--;
			sum += current_term;
		}
		
		return sum;
	}
}
