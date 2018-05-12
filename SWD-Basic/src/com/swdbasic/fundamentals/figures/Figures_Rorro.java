package com.swdbasic.fundamentals.figures;

//import java.util.Scanner;

public class Figures_Rorro {

	public void printTrianglePRD(int max, String symbol) {
		String sp = " ";
		if (max % 2 != 0) {
			int longR = max / 2;
			for (int b = 0; b <= max-longR ; b++) {
				for (int sps = max - b; sps > 0; sps--)
					System.out.print(sp);
				for (int a = 1; a <2*b; a++)
					System.out.print(symbol);
				System.out.println("");

			}
			System.exit(0);
		}
		System.out.println("El numero ingresado debe ser impar");
	}		

	public void printcuadrado(int max, String symbol) {
		for(int b=0;b<max;b++)
		{
			for(int a=0;a<max;a++)
			{
				System.out.print(symbol);
			}
			System.out.print("\n");
		}
	}

	public void printTriangleDES(int max, String symbol) {
		String sp = " ";
		for (int b = max; b > 0; b--) {
			for (int sps = max - b; sps > 0; sps--)
				System.out.print(sp);
			for (int a = b; a < 2 * b; a++)
				System.out.print(symbol);
			System.out.println("");
		}
	}

	public void printTriangleDAS(int max, String symbol) {
		String sp = " ";
		for (int b = 0; b <= max; b++) {
			for (int sps = max - b; sps > 0; sps--)
				System.out.print(sp);
			for (int a = b; a < 2 * b; a++)
				System.out.print(symbol);
			System.out.println("");
		}
	}

	public void printTriangles(int max, String symbol) {
		for (int b = 0; b < max; b++) {
			for (int a = 0; a <= b; a++) {
				System.out.print(symbol);
			}
			System.out.println("");
		}
	}

	public void printTrianglede(int max, String symbol) {
		for (int b = max; b >= 0; b--) {
			for (int a = 0; a <= b; a++) {
				System.out.print(symbol);
			}
			System.out.println("");
		}
	}
}
