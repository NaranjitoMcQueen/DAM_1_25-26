package Penjat;

import java.util.Scanner;

public class Penjat_B_ACL {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String cadena;
		System.out.println("Escriu una paraula: ");
		cadena = sc.nextLine();
		int i; // Index.
		int intents = 10; // Es declara el máxim d'intents posibles.
		int longitud = cadena.length(); // S'inicia la longitud = a cadena (que es la paraula escrita en sysout) i dona
		// la longitud del vector ja que no la declarem.

		char[] paraula;
		paraula = cadena.toCharArray(); // Convertir un String a un vector de caracteres.

		char[] paraulaOculta;
		paraulaOculta = new char[longitud]; // Declarar e instanciar un vector.

		for (i = 0; i < longitud; i++) { // Omplir el vector amb els simbols - per coneixer la longitud.
			paraulaOculta[i] = '-';
		}

		char lletra;
		int descobert = 0; // Nombre d'intent.

		while (intents > 0 && descobert != longitud) { // Mentres intents sigui superior a 0 i descobert no sigui igual
														// a la longitud avançem.
			lletra = sc.nextLine().charAt(0); // Llegir una lletra
			int acertats = 0; // Declarem quan acertes alguna lletra.
			for (i = 0; i < longitud; i++) { //
				if (lletra == paraula[i]) {
					paraulaOculta[i] = paraula[i];
					descobert++;
					acertats++;
				}
			}
			if (acertats > 1)
				System.out.println("Has trobat " + acertats + " " + lletra); // Si hi has acertat més d'una lletra al
																				// mateix temps.
			else if (acertats == 1) {
				System.out.println("Només has trobat 1 una " + lletra); // Només si acertas una lletra de la paraula
			} else {
				intents--; // Resta els intents
				System.out.println("Has fallat"); // Indica que hi has fallat
				System.out.println("Tens " + intents + " restants"); // Indica els intents restants
			}
			System.out.println(paraulaOculta); // Resultat
		}

		if (descobert == longitud)
			System.out.println("Has guanyat"); // Victoria
		else
			System.out.println("Has perdut"); // Derrota
		
		sc.close();
	}

}
/*
 * Part 2. Modifica el programa anterior de manera que el jugador B pugui donar
 * les lletres o intentar encertar la paraula directament en qualsevol moment
 * del joc. Si intenta encertar la paraula i el jugador B s’equivoca aleshores
 * ha perdut i ja no té més intents. Si endevina, evidentment guanya.
 * 
 * 
 */