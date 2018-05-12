package com.swdbasic.fundamentals.figures;

import java.util.Scanner;

public class Figures_CarlosR {

	public void printSquare(int maxRows, String symbol) 
	{
		for (int b=0; b<maxRows;b++) 
		{
			for(int a=0; a<maxRows;a++) 
			{
				System.out.print(symbol);
			}	
			System.out.println();
		}		
	}
	
	public void triangleAscLeft(int maxRows, String symbol)
	{	 
		for (int b=0; b<maxRows;b++) 
		{
			for(int a=0; a<=b;a++) 
			{
				System.out.print(symbol);
			}	
			System.out.println();
		}
	}
	
	public void triangleDescLeft(int maxRows, String symbol)
	{		 		
		for (int b=maxRows; b>0;b--) 
		{
			for(int a=0; a<b;a++) 
			{
				System.out.print(symbol);
			}	
			System.out.println();
		}
	}
	
	public void triangleAscRigth(int maxRows, String symbol)
	{
		for (int b=maxRows;b>0;b--) 
		{
			for(int a=1; a<=maxRows;a++) 
			{
				if(a<b) 
				{
					System.out.print(" ");
				}
				else
				{
					System.out.print(symbol);
				}				
			}	
			System.out.println();
		}
	}
	
	public void triangleDescRight(int maxRows, String symbol) 
	{
		int count = -1;
		for (int b=maxRows;b>0;b--) 
		{	
			for(int a=0; a<maxRows;a++) 
			{
			   if(a<=count && count !=-1)
			   {
				   System.out.print(" ");
			   }
			   else
			   {
				   System.out.print(symbol);
			   }				
			}	
			count +=1;
			System.out.println();
		}		 
	}
	
	public void printPyramid(int maxRows, String symbol) {
		
				 
		 int numSpace = maxRows/2;
		 int numItem = maxRows-numSpace;
		 int extCount = 1;
		 int intCount = 1;
		
		 if(maxRows%2 != 0)
		 {
			 for (int b=0;b<numItem;b++)
			  {
				 for(int a=1;a<=maxRows;a++) 
				 {
					 
					 if(a<=numSpace) 
					 {
						 System.out.print(" ");
					 }
					 else if (intCount<=extCount)
					 {
						 System.out.print(symbol);
						 intCount+=1;
					 }
				 }
				 intCount=1;
				 extCount += 2;
				 numSpace -= 1;
				 System.out.println();
			 }
		 }
		 else
		 {
			 System.out.println("El número debe ser impar");
			 
		 }	
	}	
	
	
	public static void main(String[] args) {
		int opt = 0;
		int maxRows=0;
		String symbol="";
		String[] Menu = {"1. Cuadrado","2. Triangulo ascendente alineado a la izquierda",
				         "3. Triangulo descendente alineado a la izquierda",
				         "4. Triangulo ascendente alineado a la derecha","5. Triangulo descendente alineado a la derecha",
				         "6. Piramide","7. Salir"};
		
		Figures_CarlosR fm = new Figures_CarlosR();
		Scanner s = new Scanner (System.in);
		
		for (int i=0;i<Menu.length;i++) {
			System.out.println(Menu[i]);
		}	
				
		do 
		{
			System.out.print("Seleccione una opción:");
			opt = s.nextInt();	
			
			if (opt>=1 && opt <7)
			{
				System.out.print("Ingrese la cantidad de filas:");
				maxRows = s.nextInt();
				s.nextLine();				
				System.out.print("Ingrese el simbolo a pintar:");
				symbol = s.nextLine();
			}
			
			switch(opt)
			{
			case 1:
				 System.out.println(Menu[opt-1]);
				 fm.printSquare(maxRows, symbol);
				 break;
			case 2:
				 System.out.println(Menu[opt-1]);
				 fm.triangleAscLeft(maxRows, symbol);
				 break;
			case 3:
				System.out.println(Menu[opt-1]);
				fm.triangleDescLeft(maxRows, symbol);
				 break;
			case 4:
				System.out.println(Menu[opt-1]);
				fm.triangleAscRigth(maxRows, symbol);
				 break;
			case 5:
				System.out.println(Menu[opt-1]);
				fm.triangleDescRight(maxRows, symbol);
				 break;
			case 6:
				System.out.println(Menu[opt-1]);
				fm.printPyramid(maxRows, symbol);
				break;
			case 7:
				System.out.println("Ha salido del programa");				
			}
			
		} while(opt>=1 && opt <7);						

	}
}
