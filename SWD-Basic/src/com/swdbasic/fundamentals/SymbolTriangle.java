package com.swdbasic.fundamentals;
import java.util.Scanner;

public class SymbolTriangle {

	public void square(int rows) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < rows; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}

	public void triangleASC_Left(int rows) {
		System.out.println("");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}

	public void triangleDESC_Left(int rows) {
		System.out.println("");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < rows - i; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}
	
	public void triangleASC_Right(int rows) {
		System.out.println("");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < rows; j++) {
				if (j < rows - i - 1) {
					System.out.print(" ");		
				} else {
					System.out.print("*");
				}
			}
			System.out.println("");
		}
	}

	public void triangleDESC_Right(int rows) {
		System.out.println("");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < rows; j++) {
				if (j <= i - 1) {
					System.out.print(" ");		
				} else {
					System.out.print("*");
				}
			}
			System.out.println("");
		}
	}

	public void piramidASC(int rows) {
		System.out.println("");
		for (int i = 0; i <= rows / 2; i++) {
			for (int j = 0; j < rows; j++) {
				if (j < (rows / 2) - i || j > (rows / 2) + i) {
					System.out.print(" ");		
				} else {
					System.out.print("*");
				}
			}
			System.out.println("");
		}
	}
	

	public void piramidDESC(int rows) {
		System.out.println("");
		for (int i = 0; i <= rows / 2; i++) {
			for (int j = 0; j < rows; j++) {
				if (j < i || j > rows - i - 1) {
					System.out.print(" ");		
				} else {
					System.out.print("*");
				}
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		SymbolTriangle st = new SymbolTriangle();
		
		Scanner s = new Scanner(System.in);
		
		int input = 0;
		do {
			System.out.print("Ingrese opción: ");
			input = s.nextInt();
	
			System.out.print("Ingrese cantidad de filas: ");
			int rows = s.nextInt();
			
			switch(input) {
				case 1:
					st.square(rows);
					break;
				case 2:
					st.triangleASC_Left(rows);
					break;
				case 3:
					st.triangleDESC_Left(rows);
					break;
				case 4:
					st.triangleASC_Right(rows);
					break;
				case 5:
					st.triangleDESC_Right(rows);
					break;
				case 6:
					st.piramidASC(rows);
					break;
				case 7:
					st.piramidDESC(rows);
					break;
				default:
					System.out.println("Opción no valida");
			}
		} while (input < 8);
	
	}
	
}
