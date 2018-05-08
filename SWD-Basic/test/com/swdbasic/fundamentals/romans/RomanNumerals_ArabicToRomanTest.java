package com.swdbasic.fundamentals.romans;


import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.swdbasic.fundamentals.romans.RomanNumerals;

@RunWith(Parameterized.class)
public class RomanNumerals_ArabicToRomanTest {

	@Parameters(name = "{index}: {0} {1}")
	public static Collection<Object[]> valuesToTest() {
		return Arrays.asList(new Object[][] {
			{1, "I"},
			{2, "II"},
			{3, "III"},
			{4, "IV"},
			{5, "V"},
			{6, "VI"},
			{7, "VII"},
			{8, "VIII"},
			{9, "IX"},
			{10, "X"},
			{11, "XI"},
			{12, "XII"},
			{13, "XIII"},
			{14, "XIV"},
			{15, "XV"},
			{16, "XVI"},
			{17, "XVII"},
			{18, "XVIII"},
			{19, "XIX"},
			{20, "XX"},
			{39, "XXXIX"},
			{40, "XL"},
			{49, "XLIX"},
			{89, "LXXXIX"},
			{90, "XC"},
			{400, "CD"},
			{1000, "M"},
			{3999, "MMMCMXCIX"}
		});
	}
	
	RomanNumerals rn = null;
	
	@Before
	public void setUp() {
		rn = new RomanNumerals();
	}
	
	private int input;
	private String expected;
	public RomanNumerals_ArabicToRomanTest(int input, String expected) {
		this.input = input;
		this.expected = expected;
	}

	@Test
	public void convert_ArabicToRoman_Parameters() {
		Assert.assertEquals(this.expected, rn.arabicToRoman(this.input));
	}
}
