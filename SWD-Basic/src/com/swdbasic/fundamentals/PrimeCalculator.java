package com.swdbasic.fundamentals;

public class PrimeCalculator {

	public void printPrimes(int min, int max) {
		long startTime = System.nanoTime();
		
		long stepCount = 0;
		int count = 0;
		
		for(int n = min; n <= max; n++) {
			boolean isPrime = true;
		
			if (n % 2 == 0) {
				continue;
			}
			
			//for (int i = 2; i < n; i++) {
			//for (int i = 2; i < n/2; i++) {
			for (int i = 3; i < Math.sqrt(n); i += 2) {
				stepCount++;
				if (n % i == 0) {
					isPrime = false;
					break;
				}
			}
			
			if (isPrime) {
				System.out.println(count++ + " " + n);
			}
		}

		System.out.println("Time: " + (System.nanoTime() - startTime) + " StepCount: " + stepCount);
	}
	
	public static void main(String[] args) {
		PrimeCalculator pc = new PrimeCalculator();
		pc.printPrimes(1, 1000000);
	}

}
