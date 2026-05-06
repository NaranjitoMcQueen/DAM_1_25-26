package Tasca2;

import java.util.Scanner;

// Donat un vector de 10 nombres enters introduïts per l'usuari, realitza un algorisme que calculi la mitjana aritmètica del vector

public class Activitat1_ACL {

	final static int N = 10;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int i, suma;
		int[] v;
		v = new int[N];

		System.out.println("Introduce " + N + " números");

		for (i = 0; i < N; i++) {

			v[i] = sc.nextInt();
			
		}
		
		suma = 0;

		for (i = 0; i < N; i++) {

			suma = suma + v[i];

		}
		
		System.out.println("La mitjana aritmètica es: " + suma / N);
		sc.close();
	}
}
