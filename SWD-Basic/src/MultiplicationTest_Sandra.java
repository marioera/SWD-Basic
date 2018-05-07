public class MultiplicationTest_Sandra {
	public static void main(String args[]){
		Multiplication m = new Multiplication();
		int a = -50;
		while (a <= 50) {
			int b = -10;
			while (b <= 10) {
				int expected = a * b;
				int actual = m.mult(a, b);
				if (actual == expected) {
						  System.out.println("a: " + a + " b: " + b + " a*b: " + actual + " is OK");
					} else {
						   System.out.println("Error " + a + " * " + b + " = " + expected + " actual:" + actual);
					}
				b++;
			}
		    a++;
		}
	}
}