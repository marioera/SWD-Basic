package com.swdbasic.fundamentals;

public class DecimalToHex {

	private String[] SYMBOLS = {"A", "B", "C", "D", "E", "F"};
	
	public String toHex(int decimal) {
		StringBuilder result = new StringBuilder();
		
		do {
			int mod = decimal % 16;
			decimal >>= 4;
			if (mod > 9) {
				result.append(SYMBOLS[mod - 10]);
			} else {
				result.append(mod);
			}
		} while (decimal > 0);
	
		return result.reverse().toString();
	}

}
