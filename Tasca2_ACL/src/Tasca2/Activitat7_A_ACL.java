package Tasca2;

import java.util.Scanner;

//Donat un vector de 10 nombres enters introduïts per l'usuari, realitza un algorisme que mostri els elements del vector, suprimint els valors repetits.
//a) el vector està ordenat (1-2-3-4-5-6-7-8-9-10)

public class Activitat7_A_ACL {

	final static int N = 10;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int i;
		int[] v;
		v = new int[N];

		System.out.println("Introdueix " + N + " nombres enters.");

		for (i = 0; i < N; i++) {
			v[i] = sc.nextInt();
		}
		
		System.out.println(v[0]);
		for (i = 1; i < N; i++) {
			if (v[i] != v[i-1]) {
				System.out.println(v[i]);
			}
		}
		sc.close();
	}
}
