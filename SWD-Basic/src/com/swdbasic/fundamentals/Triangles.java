package com.swdbasic.fundamentals;

public class Triangles {

	public void printSquare(int depth, String symbol) {
		for (int i = 0; i < depth; i++) {
			for (int j = 0; j < depth; j++) {
				System.out.print(symbol);
			}
			System.out.println();
		}
	}
	
	public void printTriangle(int depth, String symbol) {
		for (int i = 0; i < depth; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(symbol);
			}
			System.out.println();
		}
	}
	
	public void printTriangle2(int depth, String symbol) {
		for (int i = 0; i < depth; i++) {
			for (int j = i; j < depth; j++) {
				System.out.print(symbol);
			}
			System.out.println();
		}
	}
	
	public void printTriangle3(int depth, String symbol) {
		for (int i = 0; i < depth; i++) {
			for (int j = 0; j < depth; j++) {
				if (j >= i) {
					System.out.print(symbol);
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	
	public void printTriangle4(int depth, String symbol) {
		for (int i = 0; i < depth; i++) {
			for (int j = 0; j < depth; j++) {
				if (i + j + 1 < depth) {
					System.out.print(" ");
				} else {
					System.out.print(symbol);
				}
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Triangles ts = new Triangles();
		ts.printSquare(10, "*");
		ts.printTriangle(5, "*");
		ts.printTriangle2(6, "*");
		ts.printTriangle3(7, "*");
		ts.printTriangle4(8, "*");
	}

}
