package com.swdbasic.fundamentals.picasfijas;

import java.util.ArrayList;

class Results {
	int picas;
	int fijas;
}

public class Player {

	private int secret;
	private int maxDigits;
	private String name;
	private ArrayList<Integer> possibleValues = new ArrayList<Integer>();

	private boolean isValid(int attempt) {
		int minBoundary = (int) Math.pow(10, this.maxDigits - 1);
		int maxBoundary = (int) Math.pow(10, this.maxDigits) - 1;

		if (attempt < minBoundary || attempt > maxBoundary) {
			return false;
		}

		String temp = String.valueOf(attempt);
		for (int i = 0; i < temp.length() - 1; i++) {
			for (int j = i + 1; j < temp.length(); j++) {
				if (temp.charAt(i) == temp.charAt(j)) {
					return false;
				}
			}
		}
		return true;
	}

	private void generatePossibleValues() {
		int minBoundary = (int) Math.pow(10, this.maxDigits - 1);
		int maxBoundary = (int) Math.pow(10, this.maxDigits) - 1;

		for (int i = minBoundary; i < maxBoundary; i++) {
			if (isValid(i)) {
				possibleValues.add(i);
			}
		}
	}

	private int generateRandomAttempt() {
		int minBoundary = (int) Math.pow(10, this.maxDigits - 1);
		int maxBoundary = (int) Math.pow(10, this.maxDigits) - 1;

		int attempt;

		do {
			// attempt = (int)(Math.random() * 8853) + 1023;
			attempt = (int) (Math.random() * (maxBoundary - minBoundary))
					+ minBoundary;
		} while (!isValid(attempt));

		return attempt;
	}

	public Player(String name, int maxDigits) {
		this.name = name;
		this.maxDigits = maxDigits;
		this.secret = generateRandomAttempt();
		generatePossibleValues();
		System.out.println(this.name + " number to guess: " + this.secret);
		System.out.println(this.name + " possible values: "
				+ this.possibleValues.size());
	}

	public boolean isSure() {
		return this.possibleValues.size() == 1;
	}

	public boolean isCorrect(int guess) {
		return this.secret == guess;
	}

	public int getTotalPossibilities() {
		return this.possibleValues.size();
	}

	public String getName() {
		return this.name;
	}

	public int getSecret() {
		return this.secret;
	}

	public int play() {
		if (this.possibleValues.size() == 0) {
			return 0;
		}
		int index = (int) (Math.random() * this.possibleValues.size());
		return this.possibleValues.get(index);
	}

	public void notify(int guess, int picas, int fijas) {
		ArrayList<Integer> newPossibleValues = new ArrayList<Integer>();

		Results r = null;
		for (int i = 0; i < this.possibleValues.size(); i++) {
			int value = this.possibleValues.get(i);
			r = calculatePF(value, guess);
			if (r.picas == picas && r.fijas == fijas) {
				newPossibleValues.add(value);
			}
		}

		this.possibleValues = newPossibleValues;
		System.out.println(this.name + " new possible values: "
				+ this.possibleValues.size());
	}

	public Results calculatePF(int guess) {
		return calculatePF(guess, this.secret);
	}

	private Results calculatePF(int guess, int goal) {
		Results r = new Results();

		String tempGuess = String.valueOf(guess);
		String tempGoal = String.valueOf(goal);

		for (int i = 0; i < tempGuess.length(); i++) {
			for (int j = 0; j < tempGoal.length(); j++) {
				if (tempGuess.charAt(i) == tempGoal.charAt(j)) {
					if (i == j) {
						r.fijas++;
					} else {
						r.picas++;
					}
					break;
				}
			}

		}

		return r;
	}

}
