package com.swdbasic.fundamentals;

public class SquareTest {

	public static void main(String[] args) {
		Square s1 = new Square();
		s1.height = 10;
		s1.width = 20;

		Square s2 = new Square();
		s2.height = 30;
		s2.width = 30;

		Square s3 = new Square();
		s3.height = 10000;
		s3.width = 200000;

		Square[] myArray = new Square[10];
		myArray[0] = new Square();
		myArray[0].height = 100;
		myArray[0].width = 200;

		myArray[1] = s1;
		myArray[9] = s2;

		System.out.println("Resultado: " + myArray[0].area());
		System.out.println("Reusltado: " + myArray[9].area());

	}

}
