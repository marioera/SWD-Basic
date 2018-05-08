package com.swdbasic.fundamentals.picasfijas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PicasFijasGameLauncher {

	private int maxDigits = 4;

	private boolean isValid(int attempt) {
		int minBoundary = (int) Math.pow(10, this.maxDigits - 1);
		int maxBoundary = (int) Math.pow(10, this.maxDigits) - 1;

		/*
		 * if(attempt < 1023 || attempt > 9876) { return false; }
		 */

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

	private int readValidGuess() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));

		System.out.print("Enter your guess: ");
		String userInput = reader.readLine();

		int guess;
		try {
			guess = Integer.parseInt(userInput);

			if (!isValid(guess)) {
				System.out.println("Attempt not valid. Must have "
						+ this.maxDigits + " different digits. Try again.");
				return -1;
			}
		} catch (NumberFormatException e) {
			System.out.println("Attempt must be a number. Try again.");
			return -1;
		}

		return guess;
	}

	private int readValidPFInput() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		String userInput = reader.readLine();

		int inputPF;
		try {
			inputPF = Integer.parseInt(userInput);

			if (inputPF < 0 || inputPF > this.maxDigits) {
				System.out.println("Input not valid. Must be between 0 - "
						+ this.maxDigits + ". Try again.");
				return -1;
			}
		} catch (NumberFormatException e) {
			System.out.println("Attempt must be a number. Try again.");
			return -1;
		}

		return inputPF;
	}

	public PicasFijasGameLauncher() {
		this.maxDigits = 4; // Default value
	}

	public PicasFijasGameLauncher(int maxDigits) {
		if (maxDigits > 1 && maxDigits < 10) {
			this.maxDigits = maxDigits;
		}
	}

	public void runPCAgainstHuman() throws IOException {
		Player p = new Player("PC", this.maxDigits);
		int turn = 1;

		while (true) {
			System.out.println("********* Turn: " + turn + " *********");

			int userGuess = readValidGuess();
			if (userGuess == -1) {
				continue;
			}

			if (p.isCorrect(userGuess)) {
				System.out.println("You are the winner! Secret number: "
						+ userGuess);
				break;
			}

			Results r = p.calculatePF(userGuess);
			System.out.println("Picas: " + r.picas + " Fijas: " + r.fijas);

			if (p.isSure()) {
				System.out.println(p.getName()
						+ " is the winner. Your secret number is: " + p.play());
				break;
			}

			int pcGuess = p.play();

			if (pcGuess == 0) {
				System.out.println("You are wrong!. Learn to play. :P");
				break;
			}

			System.out.println(p.getName() + " guess: " + pcGuess);

			System.out.println("Picas: ");
			int userPicas;
			while ((userPicas = readValidPFInput()) == -1)
				;

			System.out.println("Fijas: ");
			int userFijas;
			while ((userFijas = readValidPFInput()) == -1)
				;

			if (userFijas == this.maxDigits) {
				System.out
						.println(p.getName()
								+ " is the winner. But you have one more chance to guess.");
			}
			p.notify(pcGuess, userPicas, userFijas);

			turn++;
		}

		System.out.println(p.getName() + " secret was: " + p.getSecret());
	}

	private boolean playTurn(Player first, Player second) {
		if (first.isSure()) {
			System.out.println(first.getName() + " is now sure that "
					+ second.getName() + " secret number is: " + first.play());
			return true;
		}

		int p1Guess = first.play();
		System.out.println(first.getName() + " guess: " + p1Guess);

		if (second.isCorrect(p1Guess)) {
			System.out.println(first.getName() + " guessed the "
					+ second.getName() + "'s secret number: " + p1Guess
					+ " (1 of " + first.getTotalPossibilities() + ")");
			return true;
		}

		Results r = second.calculatePF(p1Guess);
		System.out.println("Picas: " + r.picas + " Fijas: " + r.fijas);

		first.notify(p1Guess, r.picas, r.fijas);

		return false;
	}

	public int runPCAgainstPC() {
		Player p1 = new Player("Marco", this.maxDigits);
		Player p2 = new Player("Polo", this.maxDigits);
		int turn = 1;

		boolean player1Wins = false;
		boolean player2Wins = false;

		while (!player1Wins && !player2Wins) {
			System.out.println("********* Turn: " + turn + " *********");

			player1Wins = playTurn(p1, p2);
			player2Wins = playTurn(p2, p1);

			turn++;
		}

		if (player1Wins && player2Wins) {
			System.out.println("It is a tie!");
		} else if (player1Wins) {
			System.out.println(p1.getName() + " is the winner!");
		} else {
			System.out.println(p2.getName() + " is the winner!");
		}

		return turn;
	}

	public static void main(String[] args) throws IOException {
		PicasFijasGameLauncher pf = new PicasFijasGameLauncher(5);
		int tries = 0;
		while (pf.runPCAgainstPC() > 4) {
			tries++;
		}
		System.out.println("Tries to beat in 1 turn: " + tries);

		// pf.runPCAgainstPC();

		// pf.runPCAgainstHuman();
	}
} // FizzBuzz
