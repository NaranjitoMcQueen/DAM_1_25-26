package Tasca2;

import java.util.Scanner;

//Donats dos vectors de 5 nombres enters cadascun, realitza un algorisme que compti el nombre d’elements comuns als dos vectors.

public class Activitat6_ACL {

	final static int N = 5;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int i, j, cont;
		int[] v1, v2;
		boolean comu = false;
		v1 = new int[N];
		v2 = new int[N];

		System.out.println("Introdueix " + N + " nombres enters.");

		for (i = 0; i < N; i++) {
			v1[i] = sc.nextInt();
		}

		System.out.println("Introdueix " + N + " nombres enters un altre cop.");

		for (i = 0; i < N; i++) {
			v2[i] = sc.nextInt();
		}

		cont = 0;
		for (i = 0; i < N; i++) {
			comu = false;
			j = 0;
			while (j < N && comu == false) {
				if (v1[i] == v2[j]) {
					comu = true;
				}
				j ++;
			}
			if (comu)
				cont++;
		}


		System.out.println("El nombre comuns hi son " + cont);
		sc.close();
	}
}
