package Tasca1;

import java.util.Scanner;

public class Activitat7_A_ACL {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cont, cercar, num;

		System.out.println("Introdueix el nombre a cercar: ");
		cercar = sc.nextInt();
		System.out.println("Introdueix els nombres: ");
		num = sc.nextInt();
		cont = 0;

		while (num != 0) {
			if (cercar == num) {
				cont ++;
			}
			num = sc.nextInt();

		}
		System.out.println("El nombre " + cercar + " es repiteix " + cont + " de cops.");
		sc.close();
	}
}
