package com.swdbasic.fundamentals.figures;

import java.util.Scanner;
public class Figures_Rorro_Main {

	public static void main(String[] args) {
		Figures_Rorro cr = new  Figures_Rorro();

		Scanner s = new Scanner(System.in);

		int start = 0;
		String symbol = "";
		do {
			System.out.println("Buen dia. Elija una de las siguientes opciones. ");
			System.out.println("1. Dibujar un cuadrado");
			System.out.println("2. Dibujar un Triangulo ascendente alineado a la izquierda");
			System.out.println("3. Dibujar un Triangulo descendente alineado a la izquiera");
			System.out.println("4. Dibujar un Triangulo ascendente alineado a la derecha");
			System.out.println("5. Dibujar un Triangulo descendente alineado a la derecha");
			System.out.println("6. Dibujar una Pirámide (Funciona con numeros impares)");
			System.out.println("7. Dibujar todas las figuras ");
			System.out.println("8. Salir");
			System.out.print("Eleja el dibujo que desea : ");

			start = s.nextInt();
			s.nextLine();
			switch (start) {

			case 1:
				int maxRows = 10;
					System.out.print("Ingrese el numero de filas:");
					System.out.print("o (-7) para salir.");
					maxRows = s.nextInt();
					s.nextLine();
					System.out.print("Ingrese el simbolo de filas:");
					symbol = s.nextLine();
					cr. printcuadrado(maxRows, symbol);
					System.exit(0);
				break;
			case 2:
					System.out.print("Ingrese el numero de filas:");
					System.out.print("o (-7) para salir.");
					maxRows = s.nextInt();
					s.nextLine();
					System.out.print("Ingrese el simbolo de filas:");
					symbol = s.nextLine();
					cr.printTriangles(maxRows, symbol);
					System.exit(0);
				break;
			case 3:
					System.out.print("Ingrese el numero de filas:");
					System.out.print("o (-7) para salir.");
					maxRows = s.nextInt();
					s.nextLine();
					System.out.print("Ingrese el simbolo de filas:");
					symbol = s.nextLine();
					cr.printTrianglede(maxRows, symbol);
					System.exit(0);
				break;
			case 4:
					System.out.print("Ingrese el numero de filas:");
					System.out.print("o (-7) para salir.");
					maxRows = s.nextInt();
					s.nextLine();
					System.out.print("Ingrese el simbolo de filas:");
					symbol = s.nextLine();
					cr.printTriangleDAS(maxRows, symbol);
					System.exit(0);
				break;
			case 5:
					System.out.print("Ingrese el numero de filas:");
					System.out.print("o (-7) para salir.");
					maxRows = s.nextInt();
					s.nextLine();
					System.out.print("Ingrese el simbolo de filas:");
					symbol = s.nextLine();
					cr.printTriangleDES(maxRows, symbol);
					System.exit(0);
				break;
			case 6:
					System.out.print("Ingrese el numero de filas:");
					System.out.print("o (-7) para salir.");
					maxRows = s.nextInt();
					s.nextLine();
					System.out.print("Ingrese el simbolo de filas:");
					symbol = s.nextLine();
					cr.printTrianglePRD(maxRows, symbol);
					System.exit(0);
				break;
			case 7:
					System.out.print("Ingrese el numero de filas:");
					System.out.print("o (-7) para salir.");
					maxRows = s.nextInt();
					s.nextLine();
					System.out.print("Ingrese el simbolo de filas:");
					symbol = s.nextLine();
					cr.printTriangleDAS(maxRows, symbol);
					cr.printTriangleDES(maxRows, symbol);
					cr. printcuadrado(maxRows, symbol);
					cr.printTriangles(maxRows, symbol);
					cr.printTrianglede(maxRows, symbol);
					cr.printTrianglePRD(maxRows, symbol);
					System.exit(0);
				break;
			}
		} while (start != 8);
	}
}