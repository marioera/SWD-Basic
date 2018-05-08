package com.manticore.funtutorial.romans;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FunctionalRomanNumerals {
	
	private int getValue(char c) {
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
	
	public int romanToArabic(String input) {
/*		int[] values = input
				.chars()
				.map(c -> getValue((char)c))
				.toArray();
*/
		int[] values = input
				.chars()
				.mapToObj(c -> (char)c)
				.mapToInt(this::getValue)
				.toArray();
		
		int total = IntStream.range(0, values.length - 1)
			.map(i -> values[i] < values[i + 1] ? -values[i] : values[i])
			.sum();

		return total + values[values.length - 1];
	}
	
	public int romanToArabic_FirstTry(String input) {
		List<Character> roman = new ArrayList<Character>(
				input
				.chars()
				.mapToObj(c -> (char)c)
				.collect(Collectors.toList())
				);
		
		int total = roman
				.stream()
				.mapToInt(c -> getValue(c))
				.sum();
		
		int totalToSubstract = IntStream.range(0, roman.size() - 1)
				.filter(i -> getValue(roman.get(i)) < getValue(roman.get(i + 1)))
				.map(i -> getValue(roman.get(i)) * 2)
				.sum();
		
		return total - totalToSubstract;
	}
}
