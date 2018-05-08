package com.manticore.funtutorial.samples;
import java.util.function.BiFunction;
import java.util.function.UnaryOperator;

interface TriFunction<T, U, V, R> {
	R apply(T t, U u, V v);
}

public class FunLogicalOps {

	BiFunction<Integer, Integer, Integer> and = (a, b) -> a == 1 && a == b ? 1 : 0;
	BiFunction<Integer, Integer, Integer> or = (a, b) -> a == 1 || b == 1 ? 1 : 0;
	BiFunction<Integer, Integer, Integer> xor = (a, b) -> a != b ? 1 : 0;
	UnaryOperator<Integer> neg = a -> a == 0 ? 1 : 0;
	BiFunction<Integer, Integer, int[]> halfAdder = this::halfAdder;
	TriFunction<Integer, Integer, Integer, int[]> fullAdder = this::fullAdder;
	
	public int[] halfAdder(int i, int j) {
		int[] results = new int[2];
		
		results[0] = xor.apply(i, j);
		results[1] = and.apply(i, j);
		
		return results;
	}
	
	public int[] fullAdder(int i, int j, int carry) {
		int[] results = new int[2];
		
		results[0] = xor.apply(xor.apply(i, j), carry);
		results[1] = or.apply(and.apply(xor.apply(i,  j), carry), and.apply(i, j));
		
		return results;
	}

	public int[] fullAdder_2ha(int i, int j, int carry) {
		int[] results = new int[2];
		
		int[] ha1 = halfAdder.apply(i, j);
		int[] ha2 = halfAdder.apply(ha1[0], carry);
		
		results[0] = ha2[0];
		results[1] = or.apply(ha1[1], ha2[1]);
		
		return results;
	}
	
	public int[] fullAdder_4bits(int[] i, int[] j, int carry) {
		int[] results = new int[5];
		
		int[] temp = fullAdder.apply(i[0], j[0], carry);
		results[0] = temp[0];
		temp = fullAdder.apply(i[1], j[1], temp[1]);
		results[1] = temp[0];
		temp = fullAdder.apply(i[2], j[2], temp[1]);
		results[2] = temp[0];
		temp = fullAdder.apply(i[3], j[3], temp[1]);
		results[3] = temp[0];
		results[4] = temp[1];
		
		return results;
	}
	
}
