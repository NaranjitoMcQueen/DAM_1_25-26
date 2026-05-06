package Tasca2;

import java.util.Scanner;

//Donat un vector de 8 nombres enters introduïts per l'usuari, realitza un algorisme que ens digui quin és el valor màxim del vector

public class Activitat2_ACL {

	final static int N = 8;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int i, max;
		int[] v;
		v = new int[N];
		
		System.out.println("Introdueix " + N + " nombres enters.");
		
		for (i=0; i < N; i++) {
			
			v[i] = sc.nextInt();
		
		}
		
		max = v[0];
		for (i=0; i < N; i++) {
			
			if (v[i] > max) {
				max = v[i];
			}
		}
		
		System.out.println("El nombre més gran es el " +  max);
		sc.close();
	}
}
