package com.swdbasic.fundamentals.figures;

public class Figures_Jimmy {
	
	public void printScuare(int max, String symbol) 
	{
		for (int b = 0; b < max; b++) 
		{		
			for (int j = 0; j <max; j++) 
			{
				System.out.print(symbol);
			}
			System.out.println("");
		}		
	}

	public void printTriangleAscIzq(int max, String symbol) 
	{
		for (int b = 0; b < max; b++) 
		{		
			for (int a = 0; a <= b; a++) 
			{
				System.out.print(symbol);
			}
			System.out.println("");
		}		
	}
		
	public void printTriangleDescIzq(int max, String symbol) 
	{
		for (int b = 0; b < max; b++) 
		{		
			for (int a = 0; a < (max-b); a++) 
			{				
				System.out.print(symbol);
			}
			System.out.println("");
		}		
	}
	
	
	public void printTriangleAscDer(int max, String symbol) 
	{
		for (int b = 0; b < max; b++) 
		{				
			for (int j = 0; j < max; j++) 
			{				
				if(j >= (max- (b+1)))
				{
					System.out.print(symbol);
				}	
				else
				{
					System.out.print(" ");
				}
			}	
			
			System.out.println("");
		}		
	}
	
	public void printTriangleDescDer(int max, String symbol) 
	{
		for (int b = 0; b < max; b++) 
		{				
			for (int j = max; j >=0 ; j--) 
			{				
				if(j <= (max-(b+1)))
				{
					System.out.print(symbol);
				}	
				else
				{
					System.out.print(" ");
				}
			}				
			System.out.println("");
		}		
	}
	
	public void printTrianglePiramide(int max, String symbol) 
	{			
		if (max %2 !=0)
		{
			int sp =0;		
			for (int i = 1; i <= max; i++) 
			{				
				if (i%2 != 0)
				{							
					for (int j=(max/2)-sp;j>0; j--)
					{
						System.out.print(" ");
					}
					
					for (int k=0;k<i; k++) 
					{
						System.out.print(symbol);
					}				
					sp++;					
					System.out.println("");
				}
			}	
		}
		else
		{
			System.out.println("\nERROR -- Para poder pintar la piramide debe ingresar un numero impar \n\n");		
		}
	}

}