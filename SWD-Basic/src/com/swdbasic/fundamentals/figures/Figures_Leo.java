package com.swdbasic.fundamentals.figures;

public class Figures_Leo {
	
	public void printSquare(int max, String symbol) {
		for (int b = 0; b < max; b++) {		
			for (int a = 0; a <= max; a++) {
				System.out.print(symbol);
			}
			System.out.println("");
		}		
	}
	
	public void printTriangleAscleft(int max, String symbol) {
		for (int b = 0; b < max; b++) {		
			for (int a = 0; a <= b; a++) {
				System.out.print(symbol);
			}
			System.out.println("");
		}		
	}
	

	public void printTriangleDescleft(int max, String symbol) {
		for (int b = max; b >= 0; b--) {		
			for (int a = 0; a <= b; a++) {
				System.out.print(symbol);
			}
			System.out.println("");
		}		
	}
	
	public void printTriangleAscRight(int max, String symbol) {
		
		for (int b = max; b>0; b--) {
			for(int a = 1; a <= max; a++) {
				if(a>=b) {
					System.out.print(symbol);
				}else {
					System.out.print(" ");
				}
			}
			System.out.println("");
		}
	}
	
	public void printTriangleDescRight(int max, String symbol) {
		
		for (int b = 0; b>max; b++) {
			for(int a = 0; a > max; a++) {
				if(a>b) {
					System.out.print(" ");
				}else {
					System.out.print(symbol);
				}
			}
			System.out.println("");
		}
	}

	public void printpyramid(int max, String symbol) {
		
		int half = max/2 + 1;
//		int  = divimas;
		for (int b = max; b>0; b--) {
			for(int a = max; a > 0; a--) {
				if(a==half) {
					System.out.print(symbol);
					
				}else {
					System.out.print(" ");
				}
			}
			System.out.println("");
		}
	}
}

