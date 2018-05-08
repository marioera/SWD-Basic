package com.swdbasic.fundamentals.guayabita;
public class Player {

	private int credits;
	private String name;
	
	public Player(String name, int credits) {
		this.name = name;
		this.credits = credits;
	}
	
	public int getCredits() {
		return this.credits;
	}
	
	public int withdrawCredits(int amount) {
		if (this.credits < amount) {
			amount = this.credits;
		}
		
		this.credits -= amount;
		return amount;
	}
	
	public void addCredits(int amount) {
		this.credits += amount;
	}
	
	private int betPlay(int pot, int roll) {
		int amount = this.credits;
		if (this.credits >= pot) {
			amount = pot;
		}

		Dice d = new Dice();
		int secondRoll = d.roll();
		
		if (secondRoll > roll) {
			System.out.println("  " + this + " Wins: " + amount);
			return amount;
		}
		
		System.out.println("  " + this + " Loss: " + amount);
		return -amount;
	}
	
	public int play(int pot) {
		Dice d = new Dice();
		int roll = d.roll();
		//System.out.println("Player " + this.name + " rolls: " + roll);
		
		switch (roll) {
			case 1:
				return -50;
			case 2:
			case 3:
			case 4:
				return betPlay(pot, roll);
			case 5:
				return 0;
			case 6:
				return +50;
			default:
				return 0;
		}
	}
	
	@Override
	public String toString() {
		return "Player " + this.name + " Credits: " + this.credits;
	}
	
}
