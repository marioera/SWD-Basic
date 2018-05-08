package com.swdbasic.fundamentals;

import java.util.Scanner;

public class ConsoleReader {

	public void sayHi(String name) {
		System.out.println("Hi " + name);
	}

	public void sayGoodbye(String name) {
		System.out.println("Bye " + name);
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		ConsoleReader cr = new ConsoleReader();

		int option = 0;
		String name = null;
		do {
			System.out.println("Select an option");
			System.out.println("(1) Hi");
			System.out.println("(2) Bye");
			System.out.println("(3) Exit");

			System.out.print("Select: ");
			option = s.nextInt();

			if (option == 1) {
				System.out.print("Your name: ");
				s.nextLine();
				name = s.nextLine();
				cr.sayHi(name);
			} else if (option == 2) {
				System.out.print("Your name: ");
				s.nextLine();
				name = s.nextLine();
				cr.sayGoodbye(name);
			}
		} while (option < 3);
	}

}