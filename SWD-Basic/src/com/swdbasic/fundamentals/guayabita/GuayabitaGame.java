package com.swdbasic.fundamentals.guayabita;
import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;

public class GuayabitaGame {

	private int numPlayers = 0;
	private int iniCredits = 2000;
	private int bet = 50;

	public GuayabitaGame(int numPlayers, int bet) {
		this.bet = bet;
		this.numPlayers = numPlayers;
	}
	
	private Collection<Player> createPlayers() {
		Collection<Player> players = new CopyOnWriteArrayList<Player>();
		for (int i = 0; i < this.numPlayers; i++) {
			players.add(new Player("P" + i, this.iniCredits));
		}
		return players;
	}

	public void play() {
		Collection<Player> players = createPlayers();
		
		int games = 0;
		Match m = null;
		while (players.size() > 1) {
			games++;
			System.out.print("\n\nGame " + games + " begins.");
			
			m = new Match(this.bet, players);
			players = m.play();
		}
		
		for (Player p : players) {
			System.out.println("\nWinner: " + p);
		}
		
	}

	public static void main(String[] args) {
		GuayabitaGame gg = new GuayabitaGame(4, 200);
		gg.play();
	}

}
