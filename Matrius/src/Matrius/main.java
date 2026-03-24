package Matrius;

import java.util.Scanner;

public class main {

	static Scanner sc = new Scanner(System.in);

	public static void llegirMatriu(int mat[][]) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				mat[i][j] = sc.nextInt();
			}
		}
	}

	public static void mostrarMatriu(int mat[][]) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}

	public static int comptarParells(int mat[][]) {
		int par = 0;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++)
				if (mat[i][j] % 2 == 0) {
					par++;
				}
		}
		return par;
	}

	public static void main(String[] args) {
		int[][] m = new int[3][4];

		System.out.println("Escriu la matriu (3x4): ");
		llegirMatriu(m);
		System.out.println("\nMatriu: ");
		mostrarMatriu(m);
		System.out.println("\nNombre de pars totals: " + comptarParells(m)); 

		/*
		 * Exercici 1: - Demana a l’usuari que introdueixi els valors d’una matriu de 3
		 * x 4. - Mostra els valors de la matriu. - Compta quants parells hi ha. Fes un
		 * mètode diferent per cada apartat i en el main crides als 3 mètodes •
		 * llegirMatriu • mostrarMatriu • comptarParells
		 * 
		 * 
		 * for (int i = 0; i < N; i++) { for (int j = 0; j< M; j++) { mat[i][j] =
		 * sc.nextInt(); } }
		 */

	}
}
