package com.swdbasic.fundamentals;

import java.util.ArrayList;

public class PrimeCalculator {

	public boolean isCircularPrime(int num) {

		boolean circularPrime = true;
		String s = String.valueOf(num);

		for (int i = 0; i < s.length(); i++) {
			int d = num % 10;
			int result = (int) (d * Math.pow(10, s.length() - 1));
			num /= 10;
			num += result;
			if (isPrime(num) == false) {
				circularPrime = false;
				break;
			}
		}
		return circularPrime;
	}

	public boolean isPrime(int num) {
		if (num % 2 == 0) {
			return false;
		}

		for (int i = 3; i < Math.sqrt(num); i += 2) {
			if (num % i == 0) {
				return false;
			}
		}

		return true;
	}

	public int printCircularPrimes(int limit) {
		long startTime = System.nanoTime();

		ArrayList<Integer> numbers = new ArrayList<Integer>();
		int i = 2;
		do {

			if (isCircularPrime(i) == true)
				numbers.add(i);
			i++;
		} while (i <= limit);

		System.out.println("Time: " + (System.nanoTime() - startTime));
		
		return numbers.size();
	}

	public void printPrimes(int min, int max) {
		long startTime = System.nanoTime();

		long stepCount = 0;
		int count = 0;

		for (int n = min; n <= max; n++) {
			boolean isPrime = true;

			if (n % 2 == 0) {
				continue;
			}

			// for (int i = 2; i < n; i++) {
			// for (int i = 2; i < n/2; i++) {
			for (int i = 3; i < Math.sqrt(n); i += 2) {
				stepCount++;
				if (n % i == 0) {
					isPrime = false;
					break;
				}
			}

			/*
			 * if (isPrime) { System.out.println(count++ + " " + n); }
			 */
		}

		System.out.println("Time: " + (System.nanoTime() - startTime) + " StepCount: " + stepCount);
	}

	public static void main(String[] args) {
		PrimeCalculator pc = new PrimeCalculator();
		pc.printPrimes(1, 1000000);
		System.out.println(pc.printCircularPrimes(1000000));
	}

}
