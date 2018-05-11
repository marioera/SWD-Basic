package com.swdbasic.fundamentals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DecimalToHexTest {

	DecimalToHex d2h;
	
	@Before
	public void setUp() {
		d2h = new DecimalToHex();
	}
	
	@Test
	public void toHex_10to15() {
		Assert.assertEquals("A", d2h.toHex(10));
		Assert.assertEquals("B", d2h.toHex(11));
		Assert.assertEquals("C", d2h.toHex(12));
		Assert.assertEquals("D", d2h.toHex(13));
		Assert.assertEquals("E", d2h.toHex(14));
		Assert.assertEquals("F", d2h.toHex(15));
	}

	@Test
	public void toHex_2bits() {
		Assert.assertEquals("10", d2h.toHex(16));
		Assert.assertEquals("11", d2h.toHex(17));
		Assert.assertEquals("12", d2h.toHex(18));
		Assert.assertEquals("13", d2h.toHex(19));
		Assert.assertEquals("14", d2h.toHex(20));
		Assert.assertEquals("15", d2h.toHex(21));
		Assert.assertEquals("16", d2h.toHex(22));
		Assert.assertEquals("17", d2h.toHex(23));
		Assert.assertEquals("18", d2h.toHex(24));
		Assert.assertEquals("19", d2h.toHex(25));
		Assert.assertEquals("1A", d2h.toHex(26));
		Assert.assertEquals("1B", d2h.toHex(27));
		Assert.assertEquals("1C", d2h.toHex(28));
		Assert.assertEquals("1D", d2h.toHex(29));
		Assert.assertEquals("1E", d2h.toHex(30));
		Assert.assertEquals("1F", d2h.toHex(31));
		Assert.assertEquals("20", d2h.toHex(32));
	}
	
	@Test
	public void toHex_LotOfBits() {
		Assert.assertEquals("100", d2h.toHex(256));
		Assert.assertEquals("1000", d2h.toHex(4096));
		Assert.assertEquals("7FFF", d2h.toHex(Short.MAX_VALUE));
		Assert.assertEquals("7FFFFFFF", d2h.toHex(Integer.MAX_VALUE));
	}
	
}
