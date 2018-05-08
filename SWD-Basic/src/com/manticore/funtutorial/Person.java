package com.manticore.funtutorial;

public class Person {

	public enum Sex {
		MALE, FEMALE
	}

	String name;
	Sex gender;
	String emailAddress;
	int age;

	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public int getAge() {
		return this.age;
	}

	public String getName() {
		return this.name;
	}

	public void printPerson() {
		System.out.println("Person name: " + this.name + " Age: " + this.age);
	}
}
