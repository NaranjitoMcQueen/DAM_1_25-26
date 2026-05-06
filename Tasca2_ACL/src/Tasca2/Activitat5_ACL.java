package Tasca2;

import java.util.Scanner;

//Donat un vector de 6 nombres enters introduïts per l'usuari, realitza un algorisme que ens digui si és palíndrom (capicua) o no.

public class Activitat5_ACL {

	final static int N = 6;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int i, j;
		int[] v = new int[N];
		boolean capicua = true;
		
		System.out.println("Introdueix " + N + " nombres enters.");

		for (i = 0; i < N; i++) {

			v[i] = sc.nextInt();

		}
		
		i = 0;
		j = N - 1;
		while (i < N/2 && capicua) {
			if ( v[i] != v[j]) {
			capicua = false;
			}
			i = i + 1;
			j = j - 1;
		}

		if (capicua == true)
			System.out.println("Es capicua");
		else
			System.out.println("No hi es capicua");
		sc.close();
	}
}
