package com.swdbasic.fundamentals.figures;

public class FiguresPainter {

	int rows;
	String symbol;
	
	public void square() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < rows; j++) {
				System.out.print(symbol);
			}
			System.out.println();
		}
	}
	
	public void triangleASC_Left() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(symbol);
			}
			System.out.println();
		}
	}
	
	public void triangleDESC_Left() {
		for (int i = 0; i < rows; i++) {
			for (int j = i; j < rows; j++) {
				System.out.print(symbol);
			}
			System.out.println();
		}
	}
	
	public void triangleDESC_Right() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < rows; j++) {
				if (j >= i) {
					System.out.print(symbol);
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	
	public void triangleASC_Right() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < rows; j++) {
				if (i + j + 1 < rows) {
					System.out.print(" ");
				} else {
					System.out.print(symbol);
				}
			}
			System.out.println();
		}
	}
	
	public void pyramidASC() {
		for (int i = 0; i <= rows / 2; i++) {
			for (int j = 0; j < rows; j++) {
				if (j < (rows / 2) - i || j > (rows / 2) + i) {
					System.out.print(" ");		
				} else {
					System.out.print(symbol);
				}
			}
			System.out.println("");
		}
	}
	

	public void pyramidDESC() {
		for (int i = 0; i <= rows / 2; i++) {
			for (int j = 0; j < rows; j++) {
				if (j < i || j > rows - i - 1) {
					System.out.print(" ");		
				} else {
					System.out.print(symbol);
				}
			}
			System.out.println("");
		}
	}
}
