package com.swdbasic.fundamentals;

// By Jimmy
public class DogTest {
	public static void main(String[] args) {
		int numDogs = 5;
		int i = 0;

		Dog[] d = new Dog[numDogs];

		String[] name = { "CarlosB", "Roro", "JonathaM", "Leo", "Frey" };
		short[] age = { 37, 31, 32, 35, 29 };
		String[] weight = { "88Kgs", "72Kgs", "74Kgs", "78Kgs", "80Kgs" };
		String[] bark = { "Groww Groww", "Praff Praff", "Rucck Rucck",
				"Plast Plast", "Guff Guff" };

		while (i < numDogs) {
			d[i] = new Dog();
			d[i].name = name[(int) (Math.random() * name.length)];
			d[i].age = age[(int) (Math.random() * age.length)];
			d[i].weight = weight[(int) (Math.random() * weight.length)];
			d[i].bark = bark[(int) (Math.random() * bark.length)];

			d[i].bark();
			i++;
		}

	}
}
