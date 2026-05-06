package Tasca2;

import java.util.Scanner;

//Donat un vector A de 8 nombres enters introduïts per l'usuari, realitza un algorisme que ens digui si està ordenat de forma decreixent o no.

public class Activitat4_ACL {

	final static int N = 8;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int i;
		int[] v;
		boolean decreixent = false;
		v = new int[N];

		System.out.println("Introdueix " + N + " nombres enters.");

		for (i = 0; i < N; i++) {

			v[i] = sc.nextInt();

		}

		i = 1;

		while (i < N && v[i - 1] > v[i]) {
			decreixent = true;
			i++;
		}

		if (decreixent == true)
			System.out.println("Es decreixent");
		else
			System.out.println("No hi es decreixent");
		sc.close();
	}
}
