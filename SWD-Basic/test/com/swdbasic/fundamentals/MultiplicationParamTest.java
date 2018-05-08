package com.swdbasic.fundamentals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert; //vs junit
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.swdbasic.fundamentals.Multiplication;

@RunWith(Parameterized.class)
public class MultiplicationParamTest {
	
	@Parameters(name = "{index}: mult({0}, {1})")
	public static Collection<Object[]> valuesToTest() {
		return Arrays.asList(new Object[][] {
			{0, 0},
			{1, 0},
			{0, 1},
			{1, 1},
			{0, -1},
			{-1, 0},
			{-1, -1},
			{1, -1},
			{-1, 1},
			{4, 20},
			{5, 20},
			{4, 21},
			{5, 21},
			{20, 20},
			{148, 37},
			{147, 37},
			{148, 38},
			{147, 38},
			{-4, 20},
			{-5, 20},
			{-4, 21},
			{-5, 21},
			{-20, 20},
			{-148, 37},
			{-147, 37},
			{-148, 38},
			{-147, 38},
			{4, -20},
			{5, -20},
			{4, -21},
			{5, -21},
			{20, -20},
			{148, -37},
			{147, -37},
			{148, -38},
			{147, -38},
			{-4, -20},
			{-5, -20},
			{-4, -21},
			{-5, -21},
			{-20, -20},
			{-148, -37},
			{-147, -37},
			{-148, -38},
			{-147, -38},
			{23463, 34278},
			{23463, -34278},
			{-23463, 34278},
			{-23463, -34278},
		});
	}
	
	private int expected;
	private int inputA;
	private int inputB;
	private Multiplication m;
	
	public MultiplicationParamTest(int inputA, int inputB) {
		this.inputA = inputA;
		this.inputB = inputB;
		this.expected = this.inputA * this.inputB;
	}
	
	@Before
	public void setUp() {
		this.m = new Multiplication();
	}
	
	@Test
	public void multiplication_test() {
		Assert.assertEquals(this.expected, m.mult(this.inputA, this.inputB));
	}

}
