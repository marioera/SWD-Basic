package com.manticore.funtutorial.samples;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;


public class FunWordGame {

	private IntPredicate mod(int number) {
		return i -> i % number == 0;
/*		return new IntPredicate() {
			public boolean test(int i) {
				return i % number == 0;
			}
		};
*/
	}
	
	private <R> IntFunction<R> ifMod(int number, R word, IntFunction<R> f) {
		return i -> i % number == 0 ? word : f.apply(i);
	}

	public void play(int maxNumber, String word1, String word2) {
		IntStream.rangeClosed(0, maxNumber)
			.mapToObj(ifMod(15, word1 + word2, 
					ifMod(5, word2,
						ifMod(3, word1, Integer::toString))))
			.forEach(System.out::println);
	}
	
	private String toFizzBuzz(int number) {
		String result = "";
		result += mod(3).test(number) ? "Fizz" : "";
		result += mod(5).test(number) ? "Buzz" : "";
		return result.isEmpty() ? String.valueOf(number) : result;
	}
	
	public void play2(int maxNumber, String word1, String word2) {
		IntStream.rangeClosed(0, maxNumber)
			.mapToObj(this::toFizzBuzz)
			.forEach(System.out::println);
	}
	
	public static void main(String[] args) {
		FunWordGame fwg = new FunWordGame();
		fwg.play(100, "Marco", "Polo");
	}
}
