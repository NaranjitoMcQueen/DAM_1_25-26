package Tasca2;

import java.util.Scanner;

//Donat un vector de 10 nombres enters introduïts per l'usuari, realitza dos algorismes
//b) un altre que ens digui si hi ha algun nombre parell

public class Activitat3_B_ACL {

	final static int N = 10;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int i;
		int[] v;
		boolean parell = false;
		
		v = new int[N];
		
		System.out.println("Introdueix " + N + " nombres enters.");
		
		for (i=0; i < N; i++) {
			
			v[i] = sc.nextInt();
		
		}
		
		for (i=0; i < N; i++) {
			
			if (v[i] % 2 == 0) { // % es IGUAL que mod 2
				parell = true;
			}
		}
		if (parell == true)
		System.out.println("Hi ha un nombre par");
		else
			System.out.println("No hi ha nombre par");
		sc.close();
	}
}
