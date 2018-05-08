package com.manticore.funtutorial.romans;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class FunctionalRomanNumerals_RomanToArabicTest {

	@Parameters(name = "{index}: {0} {1}")
	public static Collection<Object[]> valuesToTest() {
		return Arrays.asList(new Object[][] {
			{"I", 1},
			{"II", 2},
			{"III", 3},
			{"IV", 4},
			{"V", 5},
			{"VI", 6},
			{"VII", 7},
			{"VIII", 8},
			{"IX", 9},
			{"X", 10},
			{"XI", 11},
			{"XII", 12},
			{"XIII", 13},
			{"XIV", 14},
			{"XV", 15},
			{"XVI", 16},
			{"XVII", 17},
			{"XVIII", 18},
			{"XIX", 19},
			{"XX", 20},
			{"XXXIX", 39},
			{"XL", 40},
			{"XLIX", 49},
			{"LXXXIX", 89},
			{"XC", 90},
			{"CD", 400},
			{"M", 1000},
			{"MDCLXVIII", 1668},
			{"MMMCMXCIX", 3999}
		});
	}
	
	private String input;
	private int expected;
	private FunctionalRomanNumerals frn = null;
	public FunctionalRomanNumerals_RomanToArabicTest(String input, int expected) {
		this.input = input;
		this.expected = expected;
	}

	@Before
	public void setUp() {
		frn = new FunctionalRomanNumerals();
	}
	
	@Test
	public void convert_RomanToArabic_Parameters() {
		Assert.assertEquals(this.expected, frn.romanToArabic(this.input));
	}
}
