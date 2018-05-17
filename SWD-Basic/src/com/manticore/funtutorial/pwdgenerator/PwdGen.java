package com.manticore.funtutorial.pwdgenerator;

public class PwdGen {

	private char[] LETTERS_U = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
	private char[] LETTERS_L = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
	private char[] NUMBERS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
	private char[] SYMBOLS = {'|', '!', '#', '$', '%', '&', '/', '(', ')', '=', '?', '¿', '¡', '{', '}', '[', ']', ';', '@', '-'};
	private char[] AMBIGUOUS = {'i', 'I', 'l', 'L', '1', 'o', 'O', '0'};
	
	private boolean isValid(char c, char[] excluded) {
		int i = excluded.length - 1;
		
		while(i >= 0) {
			if (excluded[i] == c) {
				System.out.println("Invalid " + c);
				return false;
			}
			i--;
		}
		
		return true;
	}
	
	public void generate(char[] excluded) {
		char[][] GROUPS = new char[4][];
		GROUPS[0] = LETTERS_U;
		GROUPS[1] = LETTERS_L;
		GROUPS[2] = NUMBERS;
		GROUPS[3] = SYMBOLS;
		
		boolean excludeAmbiguous = true;
		

		for (int t = 0; t < 3; t++) {
			StringBuilder sb = new StringBuilder();
			
			for (int i = 0; i < 32; i++) {
				boolean isValid = true;
				char generated;
				
				do {
					int base =  (int)(Math.random() * GROUPS.length);
					int character = (int)(Math.random() * GROUPS[base].length);
					
					generated = GROUPS[base][character];
					
					if (excludeAmbiguous) {
						isValid = isValid(generated, AMBIGUOUS);
					}
					
					if (isValid && excluded.length > 0) {
						isValid = isValid(generated, excluded);
					}
				} while(!isValid);
				
				sb.append(generated);
			}
			
			System.out.println("Password: " + sb.toString());
		}
	}
	
	public static void main(String[] args) {
		PwdGen pg = new PwdGen();
		String excluded = "-E:abcdefghijklm12345NOPQRSTUVWXYZ)?¿!%{}@#(¡$=-|[]/;&nopqrstuvwxyABCDEFGHIJKL6789z";
		pg.generate(excluded.substring(3).toCharArray());
	}
	
}
