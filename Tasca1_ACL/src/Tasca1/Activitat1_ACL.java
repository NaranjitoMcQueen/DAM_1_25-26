package Tasca1;

import java.util.Scanner;

	public class Activitat1_ACL {
		
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			float b, h;
			double A;
			System.out.print("Introdueix el valor de la base: ");
			b = sc.nextInt();
			System.out.print("Introdueix l'altura del triangle: ");
			h = sc.nextInt();
			A = b*h/2;
			System.out.println("L'àrea del triangle es: " + A);
			sc.close();
		}
}