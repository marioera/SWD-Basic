public class LogicalSub {

	private int and(int a, int b) {
		if (a == 1 && b ==1) {
			return 1;
		}
		return 0;
	}
	
	private int or(int a, int b) {
		if (a == 0 && b == 0) {
			return 0;
		}
		return 1;
	}
	
	private int xor(int a, int b) {
		if (a == b) {
			return 0;
		}
		return 1;
	}
	
	private int not(int a) {
		if (a == 1) {
			return 0;
		}
		return 1;
	}
	
	public int[] halfSub(int a, int b) {
		int[] results = new int[2];
		
		results[0] = xor(a, b);
		results[1] = and(not(a), b);
		
		return results;
	}
	
	public int[] fullSub(int a, int b, int borrow) {
		int[] results = new int[2];
		
		int[] hf1 = halfSub(a, b);
		int[] hf2 = halfSub(hf1[0], borrow);
		
		results[0] = hf2[0];
		results[1] = or(hf1[1], hf2[1]);
		
		return results;
	}
	
	public int[] fullSub4bits(int[] a, int[] b, int borrow) {
		int[] results = new int[5];
		
		int[] f1 = fullSub(a[0], b[0], borrow);
		int[] f2 = fullSub(a[1], b[1], f1[1]);
		int[] f3 = fullSub(a[2], b[2], f2[1]);
		int[] f4 = fullSub(a[3], b[3], f3[1]);
		
		results[0] = f1[0];
		results[1] = f2[0];
		results[2] = f3[0];
		results[3] = f4[0];
		results[4] = f4[1];

		return results;
	}
}
