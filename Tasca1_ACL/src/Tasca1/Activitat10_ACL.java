package Tasca1;

import java.util.Scanner;

public class Activitat10_ACL {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num, ant, cont;

		System.out.println("Introdueix els nombres: ");
		num = sc.nextInt();
		cont = 0;

		while (num != 0) {
			ant = num;
			while (ant >= num && num != 0) {
				ant = num;
				num = sc.nextInt();
			}
			if (num != 0) {
				cont = cont + 1;
				num = sc.nextInt();
			}
		}
		if (cont > 0)
			System.out.println("Hi ha " + cont + "subseries creixdents");
		else
			System.out.println("Només hi ha una serie creixent");
		sc.close();
	}
}