package com.swdbasic.fundamentals.figures;

import java.util.Scanner;

public class Figures_Jimmy_Main {	
		public static void main(String[] args) {		
			Figures_Jimmy cr = new Figures_Jimmy();			
			Scanner s = new Scanner(System.in);			
			int maxRows = 0;
			String symbol = "";
			int Type = 0;
			do {
					System.out.println("Ingrese la opcion del tipo de figura que desea imprimir:");
					System.out.println("--------------------------------------------------------");
					System.out.println("1. Cuadrado");
					System.out.println("2. Triangulo ascendente alineado a la izquierda ");
					System.out.println("3. Triangulo descendente alineado a la izquiera");
					System.out.println("4. Triangulo ascendente alineado a la derecha");
					System.out.println("5. Triangulo descendente alineado a la derecha");
					System.out.println("6. Piramide");
					System.out.println("7. Salir");
					Type = s.nextInt();
				
					switch(Type)
					{
						case 1: System.out.print("Ingrese el numero de filas:");
								maxRows = s.nextInt();			
								s.nextLine();
								System.out.print("Ingrese el simbolo con el que desea imprimir");
								symbol = s.nextLine(); 
								cr.printScuare(maxRows, symbol);
							    System.out.println("Presione Enter para continuar");
						        s.nextLine();
						        break;
						        
						case 2: System.out.print("Ingrese el numero de filas:");
								maxRows = s.nextInt();			
								s.nextLine();
								System.out.print("Ingrese el simbolo con el que desea imprimir");
								symbol = s.nextLine();
								cr.printTriangleAscIzq(maxRows, symbol);
						        System.out.println("Presione Enter para continuar");	
						        s.nextLine();
						        break;
						
						case 3: System.out.print("Ingrese el numero de filas:");
								maxRows = s.nextInt();			
								s.nextLine();
								System.out.print("Ingrese el simbolo con el que desea imprimir");
								symbol = s.nextLine();
								cr.printTriangleDescIzq(maxRows, symbol);
						        System.out.println("Presione Enter para continuar");
						        s.nextLine();
						        break;
						
						case 4: System.out.print("Ingrese el numero de filas:");
								maxRows = s.nextInt();			
								s.nextLine();
								System.out.print("Ingrese el simbolo con el que desea imprimir");
								symbol = s.nextLine();
								cr.printTriangleAscDer(maxRows, symbol);
						        System.out.println("Presione Enter para continuar");	
						        s.nextLine();
						        break;
						
						case 5: System.out.print("Ingrese el numero de filas:");
								maxRows = s.nextInt();			
								s.nextLine();
								System.out.print("Ingrese el simbolo con el que desea imprimir");
								symbol = s.nextLine();
								cr.printTriangleDescDer(maxRows, symbol);
						        System.out.println("Presione Enter para continuar");
						        s.nextLine();
						        break;
						
						case 6: System.out.print("Ingrese el numero de filas:");
								maxRows = s.nextInt();			
								s.nextLine();
								System.out.print("Ingrese el simbolo con el que desea imprimir");
								symbol = s.nextLine();
								cr.printTrianglePiramide(maxRows, symbol);
						        System.out.println("Presione Enter para continuar");
						        s.nextLine();
						        break;
						
						case 7: System.out.println("Ud ha seleccionado la opción de salir, gracias!\n");
								break;
								
						
						default: System.out.println("Número invalido\n");
								 System.out.println("Presione Enter ver de nuevo el menu");
						         s.nextLine();
	                    		 break;
					}
							
			} while(Type!= 7);
		}
}
			