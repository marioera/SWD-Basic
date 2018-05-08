package com.swdbasic.fundamentals.guayabita;
public class Dice {

	private int faces = 6;
	
	public Dice() {
		this.faces = 6;
	}
	
	public Dice(int faces) {
		if (faces > 6) {
			this.faces = faces;
		}
	} 
	
	public int roll() {
		return (int)(Math.random() * this.faces) + 1; 
	}
	
	public static void main(String args[]) {
		Dice d = new Dice();
		int[] rolls = new int[6];
		
		int roll = 0;
		for (int i = 0; i < 6000; i++) {
			roll = d.roll();
			rolls[roll - 1]++;
		}
		
		for (int i = 1; i <= rolls.length; i++) {
			System.out.println(i + " : " + rolls[i - 1]);
		}
	}
	
}
