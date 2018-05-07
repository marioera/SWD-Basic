import java.util.Scanner;

public class ConsoleReader {

	public void printTriangle(int max, String symbol) {
		for (int b = 0; b < max; b++) {		
			for (int a = 0; a <= b; a++) {
				System.out.print(symbol);
			}
			System.out.println("");
		}		
	}
	
	public static void main(String[] args) {		
		ConsoleReader cr = new ConsoleReader();
		
		Scanner s = new Scanner(System.in);
		
		int maxRows = 0;
		String symbol = "";
		do {
			System.out.print("Ingrese el numero de filas:");
			System.out.print("o (-1) para salir.");
			maxRows = s.nextInt();
			s.nextLine();
			System.out.print("Ingrese el simbolo de filas:");
			symbol = s.nextLine();
			cr.printTriangle(maxRows, symbol);
		} while(maxRows != -1);
		
	}

}
