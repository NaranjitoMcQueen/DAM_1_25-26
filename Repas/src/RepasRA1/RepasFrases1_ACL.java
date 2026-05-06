package RepasRA1;

import java.util.Scanner;

public class RepasFrases1_ACL {
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
		// Comptar paraules que comencen per m i acaben per s
		int cont = 0;
		char lletra = LlegirCaracter();
		char ant = lletra;

		while (lletra != '.') {
			if (lletra == 'm') {
				while (lletra != ' ' && lletra != '.') {
					ant = lletra;
					lletra = LlegirCaracter();
				}
				if (ant == 's') {
					cont++;
				}
			}
			if (lletra != '.') {
				ant = lletra;
				lletra = LlegirCaracter();
			}
		}
		System.out.println("Hi ha " + cont + " que comencen per m i acaben per s");
	}
}
