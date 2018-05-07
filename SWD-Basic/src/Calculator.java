
public class Calculator {
	
	public int sum(int a, int b) {
		return a + b;
	}
	
	public int sub(int a, int b) {
		return a - b;
	}
	
	public int mul(int a, int b) {
		return a * b;
	}
	
	public int mod(int a, int b) {
		return a % b;
	}
	
	public int random(int a) {
		return (int)(Math.random() * a);
	}
	
	public int[] fullOps(int a, int b) {
		int[] results = new int[4];
		
		results[0] = sum(a, b);
		results[1] = sub(a, b);
		results[2] = mul(a, b);
		results[3] = mod(a, b);
		
		return results;
	}
}
