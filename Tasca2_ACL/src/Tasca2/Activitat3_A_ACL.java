package Tasca2;

import java.util.Scanner;

//Donat un vector de 10 nombres enters introduïts per l'usuari, realitza dos algorismes
//a) un que compti la quantitat de nombres parells

public class Activitat3_A_ACL {

	final static int N = 10;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int i, par;
		int[] v;
		v = new int[N];
		
		System.out.println("Introdueix " + N + " nombres enters.");
		
		for (i=0; i < N; i++) {
			
			v[i] = sc.nextInt();
		
		}
		
		par = 0;
		for (i=0; i < N; i++) {
			
			if (v[i] % 2 == 0) { // % es IGUAL que mod 2
				par = par + 1;
			}
		}
		
		System.out.println("El nombre de pars hi son " +  par);
		sc.close();
	}
}
