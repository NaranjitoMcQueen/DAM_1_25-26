package RepasRA1;

import java.util.Scanner;

public class RepasFrases2_ACL {
	static String paraula;
	static int pos = 0;

	public static char LlegirCaracter() {
		if (pos == 0) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Introdueix la paraula i que termini en .");
			paraula = sc.nextLine();
			if (paraula.charAt(paraula.length() - 1) != '.') {
				System.out.println("La paraula no termina en .");
			}
			pos = 1;
			return paraula.charAt(0);
		} else
			return paraula.charAt(pos++);
	}

	public static void main(String[] args) {
		// comptar paraules que tenen 4 lletres
		int cont = 0;
		int contP = 0;
		char lletra = LlegirCaracter();

		while (lletra != '.') {
			while (lletra != ' ')
				cont++;
				lletra = LlegirCaracter();
				if (cont == 4) {
					contP++;
				} 
		}
		System.out.println("Hi ha " + contP + " paraules que tenen 4 lletres");
	}
}
