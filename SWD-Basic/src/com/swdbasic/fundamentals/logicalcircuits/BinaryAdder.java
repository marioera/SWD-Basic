package com.swdbasic.fundamentals.logicalcircuits;

public class BinaryAdder {

	private int and(int a, int b) {
		if (a == 1 && b == 1) {
			return 1;
		}

		return 0;
	}

	private int xor(int a, int b) {
		if (a == b) {
			return 0;
		}

		return 1;
	}

	private int or(int a, int b) {
		if (a == 0 && b == 0) {
			return 0;
		}
		return 1;
	}

	public int[] halfAdder(int a, int b) {
		int sum = xor(a, b);
		int carry = and(a, b);

		int[] result = new int[2];
		result[0] = sum;
		result[1] = carry;

		return result;
	}

	public int[] fullAdder(int a, int b, int carry) {
		int[] result = new int[2];

		result[0] = xor(xor(a ,b), carry);
		result[1] = or(and(xor(a, b), carry), and(a, b));

		return result;
	}

	public static void main(String[] args) {
		BinaryAdder ba = new BinaryAdder();

		int[] results = new int[2];

		results = ba.fullAdder(0, 0, 0);
		System.out.println("Sum: " + results[0] + " Carry: " + results[1]);

		results = ba.fullAdder(0, 1, 0);
		System.out.println("Sum: " + results[0] + " Carry: " + results[1]);

		results = ba.fullAdder(1, 0, 0);
		System.out.println("Sum: " + results[0] + " Carry: " + results[1]);

		results = ba.fullAdder(1, 1, 0);
		System.out.println("Sum: " + results[0] + " Carry: " + results[1]);

		results = ba.fullAdder(0, 0, 1);
		System.out.println("Sum: " + results[0] + " Carry: " + results[1]);

		results = ba.fullAdder(0, 1, 1);
		System.out.println("Sum: " + results[0] + " Carry: " + results[1]);

		results = ba.fullAdder(1, 0, 1);
		System.out.println("Sum: " + results[0] + " Carry: " + results[1]);

		results = ba.fullAdder(1, 1, 1);
		System.out.println("Sum: " + results[0] + " Carry: " + results[1]);

	}

}
