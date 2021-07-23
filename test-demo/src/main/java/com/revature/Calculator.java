package com.revature;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Calculator {
/*
 * Should be able to:
 * 		-add
 * 		-subtract
 * 		-divide
 * 			-throw a CalculatorException when attempting to divide by 0
 * 		-isPrime: checks if a number is a prime number
 * 		-compareThreeDecimals: returns true if the same up to 3 decimals
 * 			-3.123.compare...(3.1233445) should return true
 */
	public double add(double x, double y) {
		return x + y;
		
	}
	public double subtract(double x, double y) {
		return x - y;
		
	}
	public double multiply(double x, double y) {
		return x * y;
		
	}
	public double divide(double x, double y) throws CalculatorException{
		if(y==0) {
			throw new CalculatorException();
		}else {
			return x / y;
		}
		
		
	}
	public boolean isPrime(int x) {
		if (x <= 1)
            return false;
        for (int i = 2; i < x; i++)
            if (x % i == 0)
                return false;
  
        return true;
	}
	public boolean compartThreeDecimals(double x, double y) {
		
		 
		DecimalFormat df = new DecimalFormat("########.###");
		
		df.setRoundingMode(RoundingMode.DOWN);
		
		if (df.format(x).equals(df.format(y))) {
			return true;
		}
		
		return false;
	}
	        
}

