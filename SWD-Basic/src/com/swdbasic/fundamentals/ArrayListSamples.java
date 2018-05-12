package com.swdbasic.fundamentals;

import java.util.ArrayList;

public class ArrayListSamples {

	// 1. Palabras reservadas
	// 2. Null references - Garbage Collector
	// 3. pass-by-value
	// 4. Encapsulation
	// 4. Instance variables default values
	// 5. Operators bit: & ~ ^ 
	// 5. Operators: - ++ -- !
	// 6. == between primitives and references
	// 7. ArrayList, array, for ( : )
	// 8. switch
	// 9. Separar logica de captura de datos
	
	public static void main(String[] args) {
		ArrayListSamples als = new ArrayListSamples();
		//System.out.println(als.mult(-29, -15));
		als.test();
	}

	private void test() {
		ArrayList<String> al = new ArrayList<String>();
		
		al.add("Hola");
		al.add("Mundo");
		
		System.out.println(al.contains("Mundos"));
		
		for (String s : al) {
			System.out.println(s);
		}
		
	}
	
	private int mult(int a, int b) {
		int mult = 0;

		if (a < 0) {
			a = -a;
			b = -b;
		}
		
		while(a > 0) {
			if (a % 2 == 1) {
				mult += b;
			}

			a >>= 1;
			b <<= 1;
		}
		
		return mult;
	}
}
