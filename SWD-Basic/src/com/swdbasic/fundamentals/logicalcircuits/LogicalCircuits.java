package com.swdbasic.fundamentals.logicalcircuits;

public class LogicalCircuits {

	private int and(int a, int b) {
		if (a == 1 && b == 1) {
			return 1;
		}
		return 0;
	}
	
	private int or(int a, int b) {
		if (a == 0 && b == 0) {
			return 0;
		}
		return 1;
	}
	
	private int xor(int a, int b) {
		if (a == b) {
			return 0;
		}
		return 1;
	}
	
	public int[] halfAdder(int a, int b) {
		int[] result = new int[2];
		
		int sum = xor(a, b);
		int carry = and(a, b);
		
		result[0] = sum;
		result[1] = carry;
		
		return result;
	}
	
	public int[] adder(int a, int b, int carry) {
		int[] result = new int[2];
		
		int[] halfAdd1 = halfAdder(a, b);
		int[] halfAdd2 = halfAdder(halfAdd1[0], carry);
		
		result[0] = halfAdd2[0];
		result[1] = or(halfAdd2[1], halfAdd1[1]);
		
		return result;
	}
	
	public int[] adder2(int a, int b, int carry) {
		int[] result = new int[2];
		
		result[0] = xor(xor(a,b), carry);
		result[1] = or(and(xor(a, b), carry), and(a, b));
		
		return result;
	}
	
	public int[] adder4bits(int[] a, int[] b, int c) {
		int[] result = new int[5];
		
		int[] add3 = adder(a[3], b[3], c);
		int[] add2 = adder(a[2], b[2], add3[1]);
		int[] add1 = adder(a[1], b[1], add2[1]);
		int[] add0 = adder(a[0], b[0], add1[1]);
		
		result[0] = add0[0];
		result[1] = add1[0];
		result[2] = add2[0];
		result[3] = add3[0];
		result[4] = add0[1];
		
		return result;
	}
	
	public static void main(String[] args) {
		LogicalCircuits lc = new LogicalCircuits();
		
		int[] response = lc.halfAdder(1, 1);
		System.out.println("Half Sum: " + response[0] + " Carry: " + response[1]);

		response = lc.adder(1, 1, 1);
		System.out.println("Sum: " + response[0] + " Carry: " + response[1]);

		response = lc.adder2(1, 0, 0);
		System.out.println("Sum 2: " + response[0] + " Carry: " + response[1]);
		
		int[] a = {1,1,1,1};
		int[] b = {0,0,0,1};
		
		response = lc.adder4bits(a, b, 0);
		System.out.println("Sum 4 bits: " + response[0] + response[1] + response[2] + response[3] + " Carry: " + response[4]);
		
	}

}
