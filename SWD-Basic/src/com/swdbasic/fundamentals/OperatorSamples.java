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
	}
}

