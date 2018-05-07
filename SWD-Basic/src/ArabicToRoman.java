
public class ArabicToRoman {

	private String[] SYMBOLS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
	private int[] VALUES = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
	
	private int toSymbol(int remainder, int value, String symbol, StringBuilder sb) {
		while (remainder >= value) {
			sb.append(symbol);
			remainder -= value;
		}
		return remainder;
	}
	
	public String toRoman(int arabic) {
		StringBuilder sb = new StringBuilder();
		
		int remainder = arabic;
		
		for(int i = 0; i < SYMBOLS.length; i++) {
			remainder = toSymbol(remainder, VALUES[i], SYMBOLS[i], sb);
		}
		
		return sb.toString();
	}
}
