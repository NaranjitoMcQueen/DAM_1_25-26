package Tasca3;

import java.util.Scanner;

public class Activitat1_ACL {
	final static int N = 5;

	/*
	 * Quan declares un mètode, pots escollir si vols que retorni un valor (int,
	 * double, boolean, etc.) o si només vols que faci una acció (void).
	 */

	// 1: Llegir vector
	public static void LlegirVector(int v[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introdueix " + N + " nombres enters:");
		for (int i = 0; i < N; i++) {
			v[i] = sc.nextInt();
		}
	}

	// 2: Mostrar vector
	public static void MostrarVector(int v[]) {
		System.out.println("Aqui hi tens el vecotr: "); // Mostrem el vector.
		for (int i = 0; i < N; i++) {
			System.out.print(v[i] + " "); // SENSE el ln no fa un enter entre cada nombre.
		}
		System.out.println(); // Salt fins a les opcions.
	}

	// 3:Calcular mitjana artimètica
	public static int Mitjana(int v[]) {
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += v[i]; // El símbol += es el mateix que aplicar-hi un sum = sum + v[i].
		}
		int res = sum / N; // (double) es per transformar el resultat en decimal IMPORTANT.
		return res;
	}

	// 4: Contar parells
	public static int Parells(int v[]) {
		int par = 0;
		for (int i = 0; i < N; i++) {
			if (v[i] % 2 == 0) { // Com al pseudo-codi per cercar-ho.
				par++;
			}
		}
		return par;
	}

	// 5: Valor màxim
	public static int NumMaxim(int v[]) {
		int max = v[0];
		int pos = 0; // Corretgir-ho o veure si es pot fer que no to digui des-de 0 IMPORTANT.
		for (int i = 0; i < N; i++) {
			if (max <= v[i]) {
				max = v[i];
				pos = i;
			}
		}
		return pos + 1; // El +1 es per retornar amb una mica de "logica" ja que es compta des de l'ú
						// normalment
	}

	// 6: Cercar un element
	public static int CercarNum(int v[], int num) {
		int i = 0;
		while (i < N) {
			if (v[i] == num) {
				return i + 1;
			}
			i++;
		}
		return -1;
	}

	// 7:Mirar si està ordenat
	public static int VectorOrdenat(int v[]) {
		boolean creixent = false;
		boolean decreixent = false;
		int i = 1;

		while (i < N) {
			while (i < N && v[i] > v[i - 1]) {
				creixent = true;
				i++;
			}
			while (i < N && v[i] < v[i - 1]) {
				decreixent = true;
				i++;
			}
		}
		if (creixent && decreixent) {
			return 0;
		} else if (creixent) {
			return 1;
		} else
			return 2;
	}

	// Main String que executa el Switch.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int opcio;
		int[] v = new int[N];
		opcio = -1;
		boolean llegit = false;
		while (opcio != 0) {
			System.out.println(
					"Opcions\n1: Llegir vector\n2: Mostrar vector\n3:Calcular mitjana artimètica\n4: Contar parells");
			System.out.println("5: Valor màxim\n6: Cercar un element\n7:Mirar si està ordenat\n0: Sortir");
			opcio = sc.nextInt();
			switch (opcio) {
			case 1:
				LlegirVector(v);
				llegit = true;
				break;
			case 2:
				if (llegit == false) {
					LlegirVector(v);
					llegit = true;
				}
				MostrarVector(v);
				break;
			case 3:
				if (llegit == false) {
					LlegirVector(v);
					llegit = true;
				}
				double res = Mitjana(v);
				System.out.println(res);
				break;
			case 4:
				if (llegit == false) {
					LlegirVector(v);
					llegit = true;
				}
				int par = Parells(v);
				System.out.println("Hi ha " + par + " nombres parells.");
				break;
			case 5:
				if (llegit == false) {
					LlegirVector(v);
					llegit = true;
				}
				int pos = NumMaxim(v);
				System.out.println("Es troba en el lloc: " + pos + " del vector");
				break;
			case 6:
				if (llegit == false) {
					LlegirVector(v);
					llegit = true;
				}
				System.out.println("Donam el nombre a cercar:");
				int num = sc.nextInt();
				pos = CercarNum(v, num);
				if (pos == -1)
					System.out.println("No hi ha ninguna coincidencia");
				else
					System.out.println("El nombre es troba a la posició: " + pos);
				break;
			case 7:
				if (llegit == false) {
					LlegirVector(v);
					llegit = true;
				}
				int ordre = VectorOrdenat(v);
				if (ordre == 1)
					System.out.println("El vector es creixent");
				else if (ordre == 2)
					System.out.println("El vector es decreixent");
				else
					System.out.println("No es troba ordenat");
				System.out.println();
				break;
			case 0:
				break;
			}
		}
		sc.close();
	}
}

/*
 * 7) Mirar si el vector està o no ordenat. La funció retorna 1 si està ordenat
 * de forma creixent, 2 si està ordenat de forma decreixent, i 0 si no està
 * ordenat.
 */
