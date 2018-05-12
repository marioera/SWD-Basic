package com.swdbasic.fundamentals.figures;

import java.util.Scanner;

public class Figures_Jonathan {

	int maxRows;
	int option;
	String symbol;

	private void Square() {
		for (int b = 0; b < maxRows; b++) {
			for(int a = 0; a < maxRows; a++) {
				System.out.print(symbol);
			}
			
			System.out.println("");
		}
	}

	private void printTriangleAL() {
		for (int b = 0; b < maxRows; b++) {		
			for (int a = 0; a <= b; a++) {
				System.out.print(symbol);
			}
			
			System.out.println("");
		}		
	}

	private void printTriangleDL() {
		for (int b = maxRows; b > 0; b--) {		
			for (int a = 0; a < b; a++) {
				System.out.print(symbol);
			}
			
			System.out.println("");
		}		
	}

	private void printTriangleAR() {
		int c = maxRows-1;
		String word = "";
		for (int b = 0; b < maxRows; b++) {
			for(int a = 1; a <= maxRows; a++) {
				if(a<=c)
					word = " ";
				else
					word = symbol;
				
				System.out.print(word);
			}
			c--;
			System.out.println("");
		}
	}

	private void printTriangleDR() {
		int c = 0;
		String word = "";
		for (int b = 0; b < maxRows; b++) {
			for(int a = 1; a <= maxRows; a++) {
				if(a>c)
					word = symbol;
				else
					word = " ";
				
				System.out.print(word);
			}
			c++;
			System.out.println("");
		}
	}
	
	private boolean numValidator(int x) {
		if(x % 2 == 0)
			return false;
		return true;
	}
	
	private void printPyramid() {
		int half = (maxRows/2)+1; 
		int b1 = half; 
		int b2 = b1; 
		
		for (int b = 1; b <= half; b++) {
			for(int a = 1; a <= maxRows; a++) {
				if(a >= b1 && a <= b2) {
					System.out.print(symbol);
					b1 = half - b;
					b2 = half + (b-1);
				}
				else {
					System.out.print(" ");
				}
			}
			
			System.out.println("");
		}
	}

	public void printMenu() {
		Scanner s = new Scanner(System.in);
		do {
			System.out.println("\n*******************************************");
			System.out.println("**************** Main Menu ****************");
			System.out.println("*******************************************\n");
			System.out.println("1. Pintar un cuadrado");
			System.out.println("2. Pintar un triangulo Ascendente alineado a la izquierda");
			System.out.println("3. Pintar un triangulo Descendente alineado a la izquierda");
			System.out.println("4. Pintar un triangulo Ascendente alineado a la derecha");
			System.out.println("5. Pintar un triangulo Descendente alineado a la derecha");
			System.out.println("6. Pintar una piramide");
			System.out.println("7. Pintar Todos");
			System.out.println("8. Salir.");
			option = s.nextInt();
			System.out.println("Ingrese el numero de filas de la base de la pintura: ");
			maxRows = s.nextInt();
			s.nextLine();
			System.out.print("Ingrese el simbolo: ");
			symbol = s.nextLine();
			if(option == 1)
				Square();
			if(option == 2)
				printTriangleAL();
			if(option == 3)
				printTriangleDL();
			if(option == 4)
				printTriangleAR();
			if(option == 5)
				printTriangleDR();
			if(option == 6) {
				if(numValidator(maxRows)) {
					printPyramid();
				}else {
					do {
						System.out.println("El número de filas debe ser impar, intente nuevamente");
						System.out.println("Ingrese el numero de filas de la base de la pintura: ");
						maxRows = s.nextInt();
					}while(!numValidator(maxRows));
					printPyramid();
				}
			}
			
			if(option == 7) {
				if(numValidator(maxRows)) {
					Square();
					printTriangleAL();
					printTriangleDL();
					printTriangleAR();
					printTriangleDR();
					printPyramid();
				}else {
					do {
						System.out.println("El número de filas debe ser impar, intente nuevamente");
						System.out.println("Ingrese el numero de filas de la base de la pintura: ");
						maxRows = s.nextInt();
					}while(!numValidator(maxRows));
					Square();
					printTriangleAL();
					printTriangleDL();
					printTriangleAR();
					printTriangleDR();
					printPyramid();
				}
			}
			if(option == 8)
				break;
		} while(maxRows != 8);		
		s.close();
	}
}