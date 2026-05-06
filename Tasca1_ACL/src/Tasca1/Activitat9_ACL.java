package Tasca1;

import java.util.Scanner;

public class Activitat9_ACL {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num, ant, cont, max, nmax;

		System.out.println("Introdueix els nombres: ");
		num = sc.nextInt();
		max = 0;
		nmax = num;
		while (num != 0) {
			ant = num;
			num = sc.nextInt();
			cont = 1;
			while (ant == num && num != 0) {
				cont = cont + 1;
				ant = num;
				num = sc.nextInt();
			}
			if (cont > max) {
				max = cont;
				nmax = ant;
			}
		}
		System.out.println("La cadena més llarga es de " + max + " del nombre " + nmax);

		sc.close();
	}
}
