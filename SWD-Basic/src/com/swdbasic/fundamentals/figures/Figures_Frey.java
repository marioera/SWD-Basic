package com.swdbasic.fundamentals.figures;

public class Figures_Frey{

	public void square(int max, String symbol) {        

        for (int a = 1; a <= max; a++) {
            for (int b = max - 1; b >= 0; b--) {
                
                System.out.print("  " + symbol);
                  
            }
            System.out.println("");
        }
    }          
    
    public void printTriangle(int max, String symbol) {

        for (int b = 0; b < max; b++) {

            for (int a = 0; a <= b; a++) {

                System.out.print(symbol);

            }

            System.out.println("");

        }

    }

    public void printTriangleDes(int max, String symbol) {

        for (int b = (max - 1); b > -1; b--) {

            for (int a = 0; a <= b; a++) {

                System.out.print(symbol);

            }

            System.out.println("");

        }

    }

    public void printTriangleDesRig(int max, String symbol) {

        int d = max-1;
        int c = 0;
        for (int b = 0; b < max; b++) {

            for (int a = 0; a <= b; a++) {
                 
                
                while(c!=d){
                    System.out.print(" ");
                    c++;
                }
                System.out.print(symbol);
            }

            System.out.println("");
            c = 0;
            d--;
        }

    }
    
    public void printTriangleAscRig(int max, String symbol) {

        int d = 0;
        int c = max;
        int esc = 1;
        for (int b = 0; b < max; b++) {

            for (int a = 0; a <= b; a++) {          
                
                while(c!=d){
                    System.out.print(symbol);
                    c--;}
            }
            

            System.out.println("");
            
            for ( int j = 0; j < esc; j++){
            System.out.print(" ");
            }
            esc++;
            c = max;
            d++;
        }
    }   
    
    
    public void pyramid(int max, String symbol) {
        int numRows1 = 0;
        for (int i = 1; i < (max + 1); i++) {
            if (i % 2 != 0) {
                numRows1++;
            }
        }

        for (int alt = 1; alt <= numRows1; alt++) {

            for (int esp = 1; esp <= numRows1 - alt; esp++) {
                System.out.print(" ");
            }

            for (int asterisks = 1; asterisks <= (alt * 2) - 1; asterisks++) {
                System.out.print(symbol);
            }
            System.out.println();
        }

    }
}	