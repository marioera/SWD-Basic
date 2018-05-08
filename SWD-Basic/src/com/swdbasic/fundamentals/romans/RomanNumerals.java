package com.swdbasic.fundamentals.romans;

public class RomanNumerals {

	private static int[] VALUES = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
	private static String[] SYMBOLS = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

	private static int[] VALUES2 = { 1000, 500, 100, 50, 10, 5, 1 };
	private static char[] SYMBOLS2 = { 'M', 'D', 'C', 'L', 'X', 'V', 'I' };
	
	private int appendRomanNumerals(int remaining, int value, String symbol, StringBuilder sb) {
		while (remaining >= value) {
			sb.append(symbol);
			remaining -= value;
		}
		return remaining;
	}
	
	public String arabicToRoman(int arabic) {
		StringBuilder sb = new StringBuilder();
		
		int remaining = arabic;

		for (int i = 0; i < VALUES.length; i++) {
			remaining = appendRomanNumerals(remaining, VALUES[i], SYMBOLS[i], sb);
		}
		
		return sb.toString();
	}

	private static int getValue(char c) {
		switch(c) {
			case 'I':
				return 1;
			case 'V':
				return 5;
			case 'X':
				return 10;
			case 'L':
				return 50;
			case 'C':
				return 100;
			case 'D':
				return 500;
			case 'M':
				return 1000;
			default:
				return 0;
		}
	}

	public static int romanToArabic(String roman) {
		int total = 0;
		
		int value1 = 0;
		int value2 = 0;
		for (int i = 0; i < roman.length(); i++) {
			value1 = getValue(roman.charAt(i));
			if ((i + 1) < roman.length()) {
				value2 = getValue(roman.charAt(i + 1));
				if (value2 > value1) {
					total += value2 - value1;
					i++;
					continue;
				}
			}
			total += value1;
		}
		
		return total;
	}

	private static int mustSub(char symbol, char symbol2, char symbol3, int value, int toSub, char c, char nextC) {
		if (toSub > 0) {
			return toSub;
		}

		if (c == symbol && (nextC == symbol2 || nextC == symbol3)) {
			toSub = value;
		}
		return toSub;
	}
	
	private static int addArabic(int total, int value, int mustSub, char symbol, char c) {
		if (c == symbol) {
			total += value;
			if (mustSub > 0) {
				total -= mustSub;
			}
		}
		
		return total;
	}

	public static int romanToArabic2(String roman) {
		int total = 0;
		
		int toSub = 0;
		for (int i = 0; i < roman.length(); i++) {
			if (toSub == 0 && (i + 1) < roman.length()) {
				toSub = mustSub('C', 'D', 'M', 100, toSub, roman.charAt(i), roman.charAt(i + 1));
				toSub = mustSub('X', 'L', 'C', 10, toSub, roman.charAt(i), roman.charAt(i + 1));
				toSub = mustSub('I', 'V', 'X', 1, toSub, roman.charAt(i), roman.charAt(i + 1));
				
				if (toSub > 0) {
					continue;
				}
			}

			for (int v = 0; v < VALUES2.length; v++) {
				total = addArabic(total, VALUES2[v], toSub, SYMBOLS2[v], roman.charAt(i));
			}
			toSub = 0;
		}
		return total;
	}
}
