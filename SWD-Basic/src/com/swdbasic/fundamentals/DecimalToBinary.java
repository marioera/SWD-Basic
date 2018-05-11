package com.swdbasic.fundamentals;

public class DecimalToBinary {

	public String toBinary(int decimal) {
		StringBuilder sb = new StringBuilder();

		do {
			sb.append(decimal % 2);
			decimal /= 2;
		} while(decimal > 0);		
		
		return sb.reverse().toString();
	}

	public String toBinary2(int decimal) {
		StringBuilder sb = new StringBuilder();
		
		if (decimal == 0) {
			return "0";
		}

		int temp = decimal;
		
		sb.append(temp % 2);
		temp /= 2;
		sb.append(temp % 2);
		temp /= 2;
		sb.append(temp % 2);
		temp /= 2;
		sb.append(temp % 2);
	
		String result = "";
		boolean firstOne = false;
		for (int i = sb.length() - 1; i >= 0; i--) {
			if (sb.charAt(i) == '1') {
				firstOne = true;
			}
			if (firstOne) {
				result += sb.charAt(i);
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		DecimalToBinary d2b = new DecimalToBinary();

		for (int i = 0; i <= 16; i++) {
			System.out.println(d2b.toBinary(i));
		}
	}
	
}
