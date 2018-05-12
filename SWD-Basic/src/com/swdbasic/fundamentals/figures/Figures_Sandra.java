package com.swdbasic.fundamentals.figures;

import java.util.Scanner;

public class Figures_Sandra {
	public void printSquare(int max, String symbol) {
		for (int b = 0; b < max; b++) {		
				for (int a = 0; a < max; a++) {		
					System.out.print(symbol);
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
	
	public void printTriangleDAL(int max, String symbol) {
		for (int b = max; b > 0; b--) {		
			for (int a = b; a > 0; a--) {
				System.out.print(symbol);
			}
			System.out.println("");
		}		
	}
	
	public void printTriangleAAR(int max, String symbol) {
		int d = max;
		for (int b = 0; b < max; b++) {
			for (int a = d; a > 1; a--) {
				System.out.print(" ");
			}
			
			for (int c = 0; c <= b; c++) {
				System.out.print(symbol);
			}
			System.out.println("");
			d--;
		}		
	}
	public void printTriangleDAR(int max, String symbol) {
		int d = max;
		for (int b = 0; b < max; b++) {
			d--;
			for (int a = 0; a < b; a++) {
				System.out.print(" ");
			}
			for (int c = d; c >= 0; c--) {
				System.out.print(symbol);
			}
			
			
			System.out.println("");
			
		}		
	}
	
	public void printPiramid(int max, String symbol) {
		int d = max/2;
		for (int b = 0; b < max/2+1; b++) {
			
			for (int a = d; a > 0; a--) {
				System.out.print(" ");
			}
			for (int c = 0; c <= b; c++) {
				System.out.print(symbol);
			}
			for (int e = 0; e < b; e++) {
				System.out.print(symbol);
			}
			
			System.out.println("");
			d--;
		}		
	}
	public static void main(String[] args) {		
		Figures_Sandra cr = new Figures_Sandra();
		
		Scanner s = new Scanner(System.in);
		
		int maxRows = 0;
		int option = 0;
		String symbol = "";
		do {			
			System.out.println("Seleccione la opción de la figura quiere dibujar:"+ "");
			System.out.println("1. Cuadrado");
			System.out.println("2. Triángulo ascendente alineado a la izquierda");
			System.out.println("3. Triángulo descendente alineado a la izquierda");
			System.out.println("4. Triángulo ascendente alineado a la derecha");
			System.out.println("5. Triángulo descendente alineado a la derecha");
			System.out.println("6. Pirámide");
			System.out.print("o (-1) para salir.");
			option = s.nextInt();
			s.nextLine();
			if (option == 6) {
				while (maxRows % 2 == 0) {
					System.out.print("Ingrese el numero de la base, debe ser un numero impar:");
					System.out.print("o (-1) para salir.");
					maxRows = s.nextInt();
					s.nextLine();
					if (maxRows % 2 == 0) {
						System.out.println("Debe ingrese un numero impar");
					}
					
				}
				System.out.print("Ingrese el simbolo de filas:");
				symbol = s.nextLine();
				System.out.print("Piramide");
				System.out.println("");
				cr.printPiramid(maxRows, symbol);
				
				
			}else if (option != -1) {
				System.out.print("Ingrese el numero de filas:");
				System.out.print("o (-1) para salir.");
				maxRows = s.nextInt();
				s.nextLine();
				System.out.print("Ingrese el simbolo de filas:");
				symbol = s.nextLine();
				if (option == 1) {
					System.out.print("Cuadrado");
					System.out.println("");
					cr.printSquare(maxRows, symbol);
				}
				if (option == 2) {
					System.out.print("Triángulo ascendente alineado a la izquierda");
					System.out.println("");
					cr.printTriangle(maxRows, symbol);
				}
				if (option == 3) {
					System.out.print("Triángulo descendente alineado a la izquierda");
					System.out.println("");
					cr.printTriangleDAL(maxRows, symbol);
				}
				if (option == 4) {
					System.out.print("Triángulo ascendente alineado a la derecha");
					System.out.println("");
					cr.printTriangleAAR(maxRows, symbol);
				}
				if (option == 5) {
					System.out.print("Triángulo descendente alineado a la derecha");
					System.out.println("");
					cr.printTriangleDAR(maxRows, symbol);
				}
			}
				
			
		} while(option != -1);
		
	}

}

