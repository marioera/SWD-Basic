
public class CalculatorTest {

	public static void main(String[] args) {
		Calculator c = new Calculator();
		int a = c.random(100);
		int b = c.random(100);
		System.out.println("a: " + a + " b: " + b);
		
		int[] results = c.fullOps(a, b);
		
		int count = 0;
		while(count < results.length) {
			System.out.println(results[count]);
			count = count + 1;
		}

	}

}
