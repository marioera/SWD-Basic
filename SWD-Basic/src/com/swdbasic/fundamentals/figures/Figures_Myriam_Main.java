package com.swdbasic.fundamentals.figures;

import java.util.Scanner;

public class Figures_Myriam_Main {
	public static void main(String[] args) {

		Figures_Myriam x = new Figures_Myriam();

		Scanner s = new Scanner(System.in);

		int opcion;

		do {
			System.out.println("\n  ---------------------------------------------------");
			System.out.println("                  Menú de opciones");
			System.out.println("   -------------------------------------------------");
			System.out.println("   1. Cuadrado");
			System.out.println("   2. Triángulo ascendente alineado a la izquierda");
			System.out.println("   3. Triángulo descendente alineado a la izquierda");
			System.out.println("   4. Triángulo ascendente alineado a la derecha");
			System.out.println("   5. Triángulo descendente alineado a la derecha");
			//System.out.println("   6. Pirámide");
			System.out.println("   6. Salir\n");

			System.out.print("Elija una opción:  ");
			opcion = s.nextInt();

			switch (opcion) {
			case 1:
				System.out.println("\nHa seleccionado Cuadrado...\n");
				int maxRows = 0;
				String symbol = "";
				System.out.print("Ingrese el numero de filas:");
				maxRows = s.nextInt();
				s.nextLine();
				System.out.print("Ingrese el simbolo de filas:");
				symbol = s.nextLine();
				System.out.print("\n");
				x.printSquare(maxRows, symbol);
				System.out.print("\nEnter para continuar");
				s.nextLine();
				break;
			case 2:
				System.out.println("\nHa seleccionado Triángulo ascendente alineado a la izquierda...\n");
				System.out.print("Ingrese el numero de filas:");
				maxRows = s.nextInt();
				s.nextLine();
				System.out.print("Ingrese el simbolo de filas:");
				symbol = s.nextLine();
				System.out.print("\n");
				x.printTriangle(maxRows, symbol);
				System.out.print("\nEnter para continuar");
				s.nextLine();
				break;
			case 3:
				System.out.println("\nHa seleccionado Triángulo descendente alineado a la izquierda...\n");
				System.out.print("Ingrese el numero de filas:");
				maxRows = s.nextInt();
				s.nextLine();
				System.out.print("Ingrese el simbolo de filas:");
				symbol = s.nextLine();
				System.out.print("\n");
				x.printTriangleVs(maxRows, symbol);
				System.out.print("\nEnter para continuar");
				s.nextLine();
				break;
			case 4:
				System.out.println("\nHa seleccionado Triángulo ascendente alineado a la derecha...\n");
				System.out.print("Ingrese el numero de filas:");
				maxRows = s.nextInt();
				s.nextLine();
				System.out.print("Ingrese el simbolo de filas:");
				symbol = s.nextLine();
				System.out.print("\n");
				x.printTriangleR(maxRows, symbol);
				System.out.print("\nEnter para continuar");
				s.nextLine();
				break;
			case 5:
				System.out.println("\nHa seleccionado Triángulo descendente alineado a la derecha...\n");
				System.out.print("Ingrese el numero de filas:");
				maxRows = s.nextInt();
				s.nextLine();
				System.out.print("Ingrese el simbolo de filas:");
				symbol = s.nextLine();
				System.out.print("\n");
				x.printTriangleRVs(maxRows, symbol);
				System.out.print("\nEnter para continuar");
				s.nextLine();
				break;
			/*case 6:
				System.out.println("\nHa seleccionado Triángulo descendente alineado a la derecha...\n");
				System.out.print("Ingrese el numero de filas:");
				maxRows = s.nextInt();
				s.nextLine();
				System.out.print("Ingrese el simbolo de filas:");
				symbol = s.nextLine();
				System.out.print("\n");
				x.printTriangleRVs(maxRows, symbol);
				System.out.print("\nEnter para continuar");
				s.nextLine();
				break;*/
			case 6:
				System.out.println("\n    Gracias...");
				break;
			}
		} while (opcion != 6);
		s.close();
	}
}
