package com.swdbasic.fundamentals;

import org.junit.Assert;
import org.junit.Test;

import com.swdbasic.fundamentals.Multiplication;

public class MultiplicationTest {

	Multiplication m = new Multiplication();
	
	@Test
	public void mult_0_0() {
		Assert.assertEquals("0*0", 0, m.mult(0, 0));
	}
	
	@Test
	public void mult_1_0() {
		Assert.assertEquals("1*0", 0, m.mult(1, 0));
	}
	
	@Test
	public void mult_0_1() {
		Assert.assertEquals("0*1", 0, m.mult(0, 1));
	}
	
	@Test
	public void mult_1_1() {
		Assert.assertEquals("1*1", 1, m.mult(1, 1));
	}
	
	@Test
	public void mult_PositiveGreaterEven_PositiveOdd() {
		Assert.assertEquals("20*19", 20*19, m.mult(20, 19));
	}
	
	@Test
	public void mult_PositiveEven_PositiveGreaterOdd() {
		Assert.assertEquals("18*19", 18*19, m.mult(18, 19));
	}
	
	@Test
	public void mult_PositiveOdd_PositiveGreaterEven() {
		Assert.assertEquals("19*20", 19*20, m.mult(19, 20));
	}
	
	@Test
	public void mult_PositiveGreaterOdd_PositiveEven() {
		Assert.assertEquals("21*20", 21*20, m.mult(21, 20));
	}

	@Test
	public void mult_PositiveEquals() {
		Assert.assertEquals("20*20", 20*20, m.mult(20, 20));
	}
	
	@Test
	public void mult_N1_0() {
		Assert.assertEquals("-1*0", 0, m.mult(-1, 0));
	}
	
	@Test
	public void mult_0_N1() {
		Assert.assertEquals("0*-1", 0, m.mult(0, -1));
	}
	
	@Test
	public void mult_N1_N1() {
		Assert.assertEquals("-1*-1", 1, m.mult(-1, -1));
	}
	
	@Test
	public void mult_N1_1() {
		Assert.assertEquals("-1*1", -1, m.mult(-1, 1));
	}
	
	@Test
	public void mult_1_N1() {
		Assert.assertEquals("1*-1", -1, m.mult(1, -1));
	}
	
	@Test
	public void mult_NegativeGreaterEven_NegativeOdd() {
		Assert.assertEquals("-20*-19", -20*-19, m.mult(-20, -19));
	}
	
	@Test
	public void mult_NegativeEven_NegativeGreaterOdd() {
		Assert.assertEquals("-18*-19", -18*-19, m.mult(-18, -19));
	}
	
	@Test
	public void mult_NegativeOdd_NegativeGreaterEven() {
		Assert.assertEquals("-19*-20", -19*-20, m.mult(-19, -20));
	}
	
	@Test
	public void mult_NegativeGreaterOdd_NegativeEven() {
		Assert.assertEquals("-21*-20", -21*-20, m.mult(-21, -20));
	}

	@Test
	public void mult_NegativeEquals() {
		Assert.assertEquals("-20*-20", -20*-20, m.mult(-20, -20));
	}

	@Test
	public void mult_PositiveGreaterEven_NegativeOdd() {
		Assert.assertEquals("20*-19", 20*-19, m.mult(20, -19));
	}
	
	@Test
	public void mult_PositiveEven_NegativeGreaterOdd() {
		Assert.assertEquals("18*-19", 18*-19, m.mult(18, -19));
	}
	
	@Test
	public void mult_PositiveOdd_NegativeGreaterEven() {
		Assert.assertEquals("19*-20", 19*-20, m.mult(19, -20));
	}
	
	@Test
	public void mult_PositiveGreaterOdd_NegativeEven() {
		Assert.assertEquals("21*-20", 21*-20, m.mult(21, -20));
	}

	@Test
	public void mult_PositiveNegativeEquals() {
		Assert.assertEquals("20*-20", 20*-20, m.mult(20, -20));
	}

	@Test
	public void mult_NegativeGreaterEven_PositiveOdd() {
		Assert.assertEquals("-20*19", -20*19, m.mult(-20, 19));
	}
	
	@Test
	public void mult_NegativeEven_PositiveGreaterOdd() {
		Assert.assertEquals("-18*19", -18*19, m.mult(-18, 19));
	}
	
	@Test
	public void mult_NegativeOdd_PositiveGreaterEven() {
		Assert.assertEquals("-19*20", -19*20, m.mult(-19, 20));
	}
	
	@Test
	public void mult_NegativeGreaterOdd_PositiveEven() {
		Assert.assertEquals("-21*20", -21*20, m.mult(-21, 20));
	}

	@Test
	public void mult_NegativePositiveEquals() {
		Assert.assertEquals("-20*20", -20*20, m.mult(-20, 20));
	}
	
	@Test
	public void mult_LimitMaxPositiveInteger() {
		Assert.assertEquals("85687*93753", 85687*93753, m.mult(85687, 93753));
	}
	
	@Test
	public void mult_LimitMaxPositiveInteger2() {
		Assert.assertEquals("-85687*-93753", -85687*-93753, m.mult(-85687, -93753));
	}
	
	@Test
	public void mult_LimitMaxNegativeInteger() {
		Assert.assertEquals("85687*-93753", 85687*-93753, m.mult(85687, -93753));
	}
	
	@Test
	public void mult_LimitMaxNegativeInteger2() {
		Assert.assertEquals("-85687*93753", -85687*93753, m.mult(-85687, 93753));
	}
}
