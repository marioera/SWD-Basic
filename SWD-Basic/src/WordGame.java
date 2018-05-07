
public class WordGame {

	public void play(int maxNumber, String word1, String word2) {
		int count = 1;
		String token = "";
		while (count <= maxNumber) {
			if (count % 3 == 0) {
				token = word1;
			} 
			if (count % 5 == 0) {
				token += word2;
			}
			if (token.isEmpty()) {
				token = String.valueOf(count);
			}
			System.out.println(token);
			token = "";
			count++;
		}
	}
	
	public static void main(String[] args) {
		WordGame wg = new WordGame();
		wg.play(30, "Marco", "Polo");
	}
	
}
