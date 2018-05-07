
public class LogicalSubTest {

	public static void main(String[] args) {
		LogicalSub ls = new LogicalSub();
		
		int[] results;
		
		System.out.println("**** Tests halfSub");
		results = ls.halfSub(0, 0);
		System.out.println("Sub: " + results[0] + " Borrow:" + results[1]);
		results = ls.halfSub(0, 1);
		System.out.println("Sub: " + results[0] + " Borrow:" + results[1]);
		results = ls.halfSub(1, 0);
		System.out.println("Sub: " + results[0] + " Borrow:" + results[1]);
		results = ls.halfSub(1, 1);
		System.out.println("Sub: " + results[0] + " Borrow:" + results[1]);
		
		
		System.out.println("**** Tests fullSub");
		results = ls.fullSub(0, 0, 0);
		System.out.println("Sub: " + results[0] + " Borrow:" + results[1]);
		results = ls.fullSub(0, 1, 0);
		System.out.println("Sub: " + results[0] + " Borrow:" + results[1]);
		results = ls.fullSub(1, 0, 0);
		System.out.println("Sub: " + results[0] + " Borrow:" + results[1]);
		results = ls.fullSub(1, 1, 0);
		System.out.println("Sub: " + results[0] + " Borrow:" + results[1]);
		results = ls.fullSub(0, 0, 1);
		System.out.println("Sub: " + results[0] + " Borrow:" + results[1]);
		results = ls.fullSub(0, 1, 1);
		System.out.println("Sub: " + results[0] + " Borrow:" + results[1]);
		results = ls.fullSub(1, 0, 1);
		System.out.println("Sub: " + results[0] + " Borrow:" + results[1]);
		results = ls.fullSub(1, 1, 1);
		System.out.println("Sub: " + results[0] + " Borrow:" + results[1]);
		
		System.out.println("**** Tests fullSub4bits");
		
		int[] a = {0,0,0,0};
		int[] b = {0,0,0,0};
		
		results = ls.fullSub4bits(a, b, 0);
		System.out.println("Sub: " + results[3] + results[2] + results[1] + results[0] + " Borrow:" + results[4]);
		
		int[] c = {1,1,1,1};
		int[] d = {1,1,1,1};				
		results = ls.fullSub4bits(c, d, 0);
		System.out.println("Sub: " + results[3] + results[2] + results[1] + results[0] + " Borrow:" + results[4]);

		int[] e = {0,0,0,0};
		int[] f = {1,1,1,1};				
		results = ls.fullSub4bits(e, f, 0);
		System.out.println("Sub: " + results[3] + results[2] + results[1] + results[0] + " Borrow:" + results[4]);

		int[] g = {0,0,0,1};
		int[] h = {1,1,0,0};				
		results = ls.fullSub4bits(g, h, 0);
		System.out.println("Sub: " + results[3] + results[2] + results[1] + results[0] + " Borrow:" + results[4]);

		
	}

}
