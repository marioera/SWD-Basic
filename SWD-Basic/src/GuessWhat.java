import java.io.FileNotFoundException;

public class GuessWhat {

	public static void main(String[] args) {
		int size = 27;
		String name = "Fido";
		
		int x = size - 5;
		Dog dog = new Dog();
		
		// Clarify
		
		if (x < 15) dog.bark();
		
		while (x > 3) {
			dog.bark();
		}
		
		int[] numList = {2, 4, 6, 8};
		
		System.out.println("Hello");
		System.out.println("Dog:" + name);
		
		String num = "8";
		
		int z = Integer.parseInt(num);
		
		try {
			readTheFile("myFile.txt");
		} catch (FileNotFoundException e) {
			System.out.print("File not found.");
		}
		
	}

	public static void readTheFile(String fileName) throws FileNotFoundException {
		
	}
	
}
