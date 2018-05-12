package com.swdbasic.fundamentals.figures;

public class Figures_Myriam {

	public void printSquare(int max, String symbol) {
		for (int b = 0; b < max; b++) {
			for (int a = 0; a < max; a++) {
				System.out.print(" " + symbol);
			}
			System.out.println("");
		}
	}

	public void printTriangle(int max, String symbol) {
		for (int b = 0; b < max; b++) {
			for (int a = 0; a <= b; a++) {
				System.out.print(symbol);
			}
			System.out.println("");
		}
	}

	public void printTriangleVs(int max, String symbol) {
		for (int b = 0; b < max; b++) {
			for (int a = max; a > b; a--) {
				System.out.print(symbol);
			}
			System.out.println("");
		}
	}

	public void printTriangleR(int max, String symbol) {
		String blank = "";
		while (max != 0) {
			for (int i = 0; i < max; i++) {
				System.out.print(" ");
			}
			blank = blank + "" + symbol;
			System.out.println(blank);
			max--;
		}
	}

	public void printTriangleRVs(int max, String symbol) {
		int j = max;
		int k = max;
		String blank = "";
		while (max != 0) {
			System.out.print(blank);
			for (int i = 0; i < max; i++) {
				System.out.print(symbol);
			}
			blank = "";
			j = k - max;
			for (int o = 0; o <= j; o++) {
				blank += " ";
			}
			System.out.println("");
			max--;
		}
	}

	public void printPiramide(int max, String symbol) {
		int j = max;
		int k = max;
		String blank = "";
		while (max != 0) {
			System.out.print(blank);
			for (int i = 0; i < max; i++) {
				System.out.print(symbol);
			}
			blank = "";
			j = k - max;
			for (int o = 0; o <= j; o++) {
				blank += " ";
			}
			System.out.println("");
			max--;
		}
	}
}