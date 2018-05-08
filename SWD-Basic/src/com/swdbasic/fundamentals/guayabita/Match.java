package com.swdbasic.fundamentals.guayabita;
import java.util.Collection;

public class Match {

	private int pot;
	private int bet;
	private Collection<Player> players = null;
	
	public Match(int bet, Collection<Player> players) {
		this.bet = bet;
		this.players = players;
		
		for (Player p : this.players) {
			this.pot += p.withdrawCredits(this.bet);
		}
		
		System.out.print(" Initial pot: " + this.pot);
	}
	
	private void addCreditsToPot(int amount) {
		this.pot += amount;
	}
	
	private int withdrawPotCredits(int amount) {
		this.pot -= amount;
		return amount;
	}
	
	public Collection<Player> play(){
		int rounds = 0;
		int amountPlayed = 0;
		
		while (this.pot > 0 && this.players.size() > 1) {
			rounds++;
			System.out.println("\n New round: " + rounds);
			
			for (Player p : this.players) {
				amountPlayed = p.play(this.pot);
				
				if (amountPlayed < 0) {
					addCreditsToPot(p.withdrawCredits(-amountPlayed));
				} else {
					p.addCredits(withdrawPotCredits(amountPlayed));
					if (this.pot <= 0) {
						break;
					}
				}
				System.out.println("  Pot:" + this.pot + " " + p.toString());

				if (p.getCredits() <= 0) {
					System.out.println("*******************Player loss: " + p.toString());
					this.players.remove(p);
					if (this.players.size() == 1) {
						break;
					}
				}
			}
		}
		
		return this.players;
	} 
}
