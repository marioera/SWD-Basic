package com.swdbasic.fundamentals.figures;

import java.util.Scanner;

public class Figures {

	private String[] menu = { "Cuadrado", "Tri�ngulo asc - l", "Tri�ngulo desc - l", "Tri�ngulo asc - r",
			"Tri�ngulo desc - r", "Pir�mide asc", "Pir�mide desc", "Todas", "Salir" };

	private int getUserIntInput(String message) {
		Scanner s = new Scanner(System.in);

		System.out.print(message);
		int input = Integer.parseInt(s.nextLine());

		return input;
	}

	private String getUserInput(String message) {
		Scanner s = new Scanner(System.in);
		String inputLine = null;

		System.out.println(message);
		inputLine = s.nextLine();

		return inputLine;
	}

	private void printMenu() {
		System.out.println("-- FIGURAS --");
		System.out.println("");
		for (int i = 0; i < menu.length; i++) {
			System.out.println((i + 1) + ". " + menu[i]);
		}
		System.out.println("");
	}

	private void handleOption(int input, FiguresPainter fp) {
		switch (input) {
			case 1:
				fp.square();
				break;
			case 2:
				fp.triangleASC_Left();
				break;
			case 3:
				fp.triangleDESC_Left();
				break;
			case 4:
				fp.triangleASC_Right();
				break;
			case 5:
				fp.triangleDESC_Right();
				break;
			case 6:
				fp.pyramidASC();
				break;
			case 7:
				fp.pyramidDESC();
				break;
			case 8:
				fp.square();
				fp.triangleASC_Left();
				fp.triangleDESC_Left();
				fp.triangleDESC_Right();
				fp.triangleASC_Right();
				fp.pyramidASC();
				fp.pyramidDESC();
				break;
			case 9:
				System.out.println("Exit.");
				break;
			default:
				System.out.println("Opci�n (" + input + ") inv�lida. Intente de nuevo.");
		}
	}

	private void setup() {
		FiguresPainter fp = new FiguresPainter();
		int input = 0;

		do {
			printMenu();
			input = getUserIntInput("Selecci�n (1-" + menu.length + ") : ");
			System.out.println("");

			if (input >= 1 && input < menu.length) {
				fp.rows = getUserIntInput("Filas: ");
				fp.symbol = getUserInput("S�mbolo: ");
			}

			handleOption(input, fp);
		} while (input != menu.length);
	}

	public static void main(String[] args) {
		Figures f = new Figures();
		f.setup();
	}

}