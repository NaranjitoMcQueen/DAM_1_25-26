package Tasca6_ACL;

public class TascaDebug {

	public static void main(String[] args) {

		boolean b;
		int x = 1;
		int y = 3;

		System.out.println("Inici Bucle for");
		for (int i = 0; i < 1000; i++) {
			x++;
			y--;
			x = (x + y) * 4;
			b = (x > y || x == y);
			if (b)
				System.out.println("Ok");
		}
		System.out.println("Fi Bucle for");
	}
}
