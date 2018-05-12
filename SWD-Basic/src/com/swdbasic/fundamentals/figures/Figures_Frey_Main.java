package com.swdbasic.fundamentals.figures;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Figures_Frey_Main {
    
    public static void main(String[] args) {

    	
    	Figures_Frey cr = new Figures_Frey();
        int maxRows = 0;
        String symbol = "";
        int gen;

        do {
            Scanner s = new Scanner(System.in);

            try {
                gen = 0;
                System.out.println("====MENU DE FIGURAS====");
                System.out.println("");
                System.out.println("1. CUADRADO");
                System.out.println("2. TRIANGULO ASC ALINEADO A LA IZQ");
                System.out.println("3. TRIANGULO DESC ALINEADO A LA IZQ");
                System.out.println("4. TRIANGULO ASC ALINEADO A LA DER");
                System.out.println("5. TRIANGULO DESC ALINEADO A LA DER");
                System.out.println("6. PIRÁMIDE");
                System.out.println("");
                System.out.print("Digite la opción deseada: ");
                int opc = s.nextInt();
                System.out.println("");

                if (opc < 1 || opc > 6) {
                    System.out.println("Por favor solo digite números comprendidos en el rango");
                    gen = 1;
                } else {

                    if (opc == 1) {

                        System.out.print("Ingrese el numero de filas: ");
                        maxRows = s.nextInt();
                        s.nextLine();
                        System.out.print("Ingrese el simbolo de filas: ");
                        symbol = s.nextLine();
                        System.out.println();
                        cr.square(maxRows, symbol);
                        System.out.println();

                    }

                    if (opc == 2) {

                        System.out.print("Ingrese el numero de filas: ");
                       
                        maxRows = s.nextInt();

                        s.nextLine();

                        System.out.print("Ingrese el simbolo de filas: ");

                        symbol = s.nextLine();

                        cr.printTriangle(maxRows, symbol);

                    }

                    if (opc == 3) {

                        System.out.print("Ingrese el numero de filas: ");
                       
                        maxRows = s.nextInt();

                        s.nextLine();

                        System.out.print("Ingrese el simbolo de filas: ");

                        symbol = s.nextLine();

                        cr.printTriangleDes(maxRows, symbol);

                    }

                    if (opc == 4) {

                        System.out.print("Ingrese el numero de filas: ");
                       
                        maxRows = s.nextInt();

                        s.nextLine();

                        System.out.print("Ingrese el simbolo de filas: ");

                        symbol = s.nextLine();

                        cr.printTriangleDesRig(maxRows, symbol);

                    }

                    if (opc == 5) {

                        System.out.print("Ingrese el numero de filas: ");
                      
                        maxRows = s.nextInt();

                        s.nextLine();

                        System.out.print("Ingrese el simbolo de filas: ");

                        symbol = s.nextLine();

                        cr.printTriangleAscRig(maxRows, symbol);
                        System.out.println("");

                    }

                    if (opc == 6) {

                        System.out.print("Ingrese el numero de filas: ");
                        maxRows = s.nextInt();
                        s.nextLine();
                        System.out.print("Ingrese el simbolo de filas: ");
                        symbol = s.nextLine();
                        System.out.println();
                        cr.pyramid(maxRows, symbol);
                        System.out.println();

                    }

                    do {
                        Scanner s2 = new Scanner(System.in);
                        try {
                            System.out.print("Desea generar otra figura (1. - SI 2. - NO): ");
                            gen = s2.nextInt();
                            if (gen != 1 && gen != 2) {
                                System.out.println("Por favor solo digite números comprendidos en el rango");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Por favor, digite solo números.");
                        }
                    } while (gen != 1 && gen != 2);

                }

            } catch (InputMismatchException e) {
                System.out.println("Por favor, digite solo números.");
                gen = 1;
            }

        } while (gen == 1);

    }
}