package com.jfs.training;

import java.util.Scanner;

public class Calculator {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double num1;
		double num2;
		System.out.println("Enter first Number:"); // NOSONAR
		num1=sc.nextDouble();
		System.out.println("Enter second Number:"); // NOSONAR
		num2=sc.nextDouble();
		char operator;
		do {
			System.out.print("Menu:\n"	// NOSONAR
					+"\tAdd: +\n"
					+"\tSubstract: -\n"
					+"\tMultiply: *\n"
					+"\tDivision: /\n"
					+"\tPower: ^\n"
					+"\tExit: .\n"
					+"\nEnter your choice:");
			operator=sc.next().charAt(0);
		} while(!"+-*/^.".contains(String.valueOf(operator)));
		if (operator == '.') {
            System.out.println("Exiting...");	// NOSONAR
        } else {
        	try {
        		double ans=cal(num1,num2,operator);
        		System.out.println("Answer is: "+ans); // NOSONAR
        	} catch (ArithmeticException e) {
        		System.out.println("Arithematic Exception occured"); // NOSONAR
        		e.printStackTrace();	// NOSONAR
        	} catch (IllegalArgumentException e) {
        		System.out.println("Illegal Argument Exception occured"); // NOSONAR
        		e.printStackTrace(); // NOSONAR
        	} catch (Exception e) {
        		System.out.println("Unknown Exception occured"); //NOSONAR
        		e.printStackTrace(); //NOSONAR
        	}
        }
		sc.close();
		
	}
	public static double cal(double num1, double num2, char operator) throws ArithmeticException, IllegalArgumentException {
		switch(operator) {
			case '+':
				return num1+num2;
			case '-':
				return num1-num2;
			case '*':
				return num1*num2;
			case '/':
				if(num2!=0){
					return num1/num2;
				} else {
					throw new ArithmeticException("Cannot divide by zero");
				}
			case '^':
				return Math.pow(num1, num2);
			default:
				throw new IllegalArgumentException("Invalid operator: " + operator);
		}
	}
	
}
