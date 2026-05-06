package Tasca1;

import java.util.Scanner;

public class Activitat6_ACL {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		float num;

		System.out.println("Introdueix els nombres: ");
		num = sc.nextFloat();

		while (num > 0) {
			num = sc.nextFloat();
		}
		if (num == 0) {
			System.out.println("La serie es positiva,");
		} else {
			System.out.println("No hi es positiva.");
			sc.close();
		}
	}
}
