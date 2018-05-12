package com.swdbasic.fundamentals.figures;

import java.util.Scanner;

public class Figures_Leo_Main {

	public static void main(String[] args) {
		
		Figures_Leo cr = new Figures_Leo();
		
		Scanner s = new Scanner(System.in);
		
		int maxRows = 0, option = 0;
		String symbol = "";
		
		do {
			System.out.println("Programa para imprimir figuras en consola.");
			System.out.println("1. Cuadrado");
			System.out.println("2. Triangulo ascendente alineado a la izquierda");
			System.out.println("3. Triangulo descendente alineado a la izquiera");
			System.out.println("4. Triangulo ascendente alineado a la derecha");
			System.out.println("5. Triangulo descendente alineado a la derecha");
			System.out.println("6. Pirámide");
			System.out.println("7. Salir");
			System.out.print("Seleccione una opción: ");
			
			option = s.nextInt();
			s.nextLine();
			
			switch(option) {
			
				case 1:		System.out.print("Ingrese el numero de filas: ");
							maxRows = s.nextInt();	
							s.nextLine();
							System.out.print("Ingrese el simbolo de filas: ");
							symbol = s.nextLine();
							cr.printSquare(maxRows, symbol);
							break;
				
				case 2:		System.out.print("Ingrese el numero de filas: ");
							maxRows = s.nextInt();	
							s.nextLine();
							System.out.print("Ingrese el simbolo de filas: ");
							symbol = s.nextLine();
							cr.printTriangleAscleft(maxRows, symbol);
							break;
							
				case 3:		System.out.print("Ingrese el numero de filas: ");
							maxRows = s.nextInt();	
							s.nextLine();
							System.out.print("Ingrese el simbolo de filas: ");
							symbol = s.nextLine();
							cr.printTriangleDescleft(maxRows, symbol);
							break;
							
				case 4:		System.out.print("Ingrese el numero de filas: ");
							maxRows = s.nextInt();	
							s.nextLine();
							System.out.print("Ingrese el simbolo de filas: ");
							symbol = s.nextLine();
							cr.printTriangleAscRight(maxRows, symbol);
							break;
							
				case 5:		System.out.print("Ingrese el numero de filas: ");
							maxRows = s.nextInt();	
							s.nextLine();
							System.out.print("Ingrese el simbolo de filas: ");
							symbol = s.nextLine();
							cr.printTriangleDescRight(maxRows, symbol);
							break;
							
				case 6:		System.out.print("Ingrese el numero de filas: ");
							maxRows = s.nextInt();	
							s.nextLine();
							System.out.print("Ingrese el simbolo de filas: ");
							symbol = s.nextLine();
							cr.printpyramid(maxRows, symbol);
							break;
							
				/*default:	System.out.println("La opción ingresada es errada. Ingrésela nuevamente.");	
							break;*/
				}
		} while(option != 7);
	}

}
