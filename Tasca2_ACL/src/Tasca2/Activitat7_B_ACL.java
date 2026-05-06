package Tasca2;

import java.util.Scanner;

//Donat un vector de 10 nombres enters introduïts per l'usuari, realitza un algorisme que mostri els elements del vector, suprimint els valors repetits.
//b) el vector no està ordenat (6-8-5-9-4-2-7-1-0-8)

public class Activitat7_B_ACL {

	final static int N = 10;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int i, j;
		int[] v;
		boolean repetit = false;
		v = new int[N];

		System.out.println("Introdueix " + N + " nombres enters.");
		for (i = 0; i < N; i++) {
			v[i] = sc.nextInt();
		}

		System.out.println(v[0]);
		for (i = 1; i < N; i++) {
			for (j = 0; j < i; j++) {
				if (v[i] == v[j]) {
					repetit = true;
				}
			}
			if (repetit) {
				repetit = false;
			}
			else {
				System.out.println(v[i]);
				repetit = false;
			}
		}

		sc.close();
	}
}
