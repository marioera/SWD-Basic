package com.swdbasic.fundamentals;

public class OperatorSamples {

	public static void main(String[] args) {
		
		double a = 0;
		double b = 0;
		double c = 0;
		double A = 3;
		double B = 4;
		double C = 5;
		
		a = Math.toDegrees(Math.acos((Math.pow(B, 2) + Math.pow(C, 2) - Math.pow(A, 2)) / (2 * B * C)));
		b = Math.toDegrees(Math.acos((Math.pow(A, 2) + Math.pow(C, 2) - Math.pow(B, 2)) / (2 * A * C)));
		c = Math.toDegrees(Math.acos((Math.pow(A, 2) + Math.pow(B, 2) - Math.pow(C, 2)) / (2 * A * B)));
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(a + b + c);
		
		System.out.println("////");
		int i = 0;
		for (i = 0; i <= 100; i += 10) {
			System.out.println(i);
			i += 200;
		}
		
		int z = 5;
		z++;
		++z;
		int y = z++*5;
		
		System.out.println("y: " + y);
		System.out.println("y: " + ++y);
		System.out.println("y: " + y++);
		System.out.println("y: " + y++);
		System.out.println("y: " + y);
		
		double z2 = 5 + 6/3 + 5;
		z2++;
		System.out.println("z: " + z2);
		
		int temp1 = 5;
		int temp2 = 10;
		int temp3 = temp1++ + ++temp2;
		System.out.println("temp3: " + temp3);
		
		int monthNumber = 10;
		String month = "";
		switch(monthNumber) {
			case 1:
				month = "January";
				break;
			case 2:
				month = "February";
				break;
			case 3:
				month = "March";
				break;
			case 4:
				month = "April";
				break;
			case 5:
				month = "May";
				break;
			case 6:
				month = "June";
				break;
			case 7:
				month = "July";
				break;
			case 8:
				month = "August";
				break;
			case 9:
				month = "September";
				break;
			case 10:
				month = "October";
				break;
			case 11:
				month = "November";
				break;
			case 12:
				month = "December";
				break;
			default:
				month = "Not valid month";
				break;
		}
		
		System.out.println(month);
	}
}

