package Biblioteca;

public class Biblioteca {

	public static void main(String[] args) {

		// CREACIÓ ARRAY
		Soci s1 = new Soci("50511866W", "Arnau", 25, 0);
		Soci s2 = new Soci("54772876D", "Guillermo", 18, 1, 0);

		Autor a1 = new Autor("Francesc Torralba i Roselló", "Catalunya");
		Autor a2 = new Autor("Sonsoles Ónega", "Catalunya");

		Llibre l1 = new Llibre("9784567890123", "Anatomia de l'esperança", "Ediciones Destino", false, null, 192, a1);
		Llibre l2 = new Llibre("9788466434737", "Portarà el teu nom", "Columna Cat", false, null, 480, a2);

		Pellicula p1 = new Pellicula("9788498383472", "Interstellar", "Paramount", 2014, 13, "Ciència-ficció",
				"Christopher Nolan", 169);
		Videojoc v1 = new Videojoc("9788498383682", "Astro bot", "Sony", 2024, 13, "Aventura", "PS5", "Un jugador",
				false);

		// TEST INFO
		System.out.println("INFORMACIÓ SOCI:\n" + s1.toString());
		System.out.println("\nINFORMACIÓ AUTOR:\n" + a1.toString());
		System.out.println("\nINFORMACIÓ LLIBRE:\n" + l2.toString());

		// AFEGIR PRESTEC
		if (l1.afegirPrestec(s1)) {
			System.out.println(
					"\nEl llibre \"" + l1.getTitol() + "\" s'ha prestat al soci " + l1.getSoci().getNom() + ".");
		} else {
			System.out.println("\nEl llibre \"" + l1.getTitol() + "\" ja està prestat al soci: " + l1.getSoci().getNom()
					+ " i no és pot tornar a prestar.");
		}

		if (l1.afegirPrestec(s2)) {
			System.out.println(
					"\nEl llibre \"" + l1.getTitol() + "\" s'ha prestat al soci " + l1.getSoci().getNom() + ".");
		} else {
			System.out.println("\nEl llibre \"" + l1.getTitol() + "\" ja està prestat al soci: " + l1.getSoci().getNom()
					+ " i no és pot tornar a prestar.");
		}

		// DATA DEVOLUCIÓ
		System.out.println("La data màxima de devolució del llibre " + l1.getTitol() + " és: " + l1.dataDevolució);

		// COMPROVACIÓ DIES
		if (l1.calcularPrestat() == 0) {
			System.out.println("\nDins de termini. La data de devolució hi es: " + l1.dataDevolució);
		} else if (l1.calcularPrestat() == -1) {
			System.out.println("\nNo es troba prestat.");
		} else
			System.out.println("\n Dies que fa que s'hauria d'haver retornat: " + l1.calcularPrestat());

		// ENDARRERIR DIES
		if (l1.endarrerirPrestec() == -1) {
			System.out.println("\nEl llibre no es troba al teu carrec.");
		} else
			System.out.println("\nLa data de devolució s'ha enderrerit cinc dies mes: " + l1.dataDevolució);

		// TEST RETORNA LLIBRE
		int res = l1.retornarPrestec();
		if (res == -1) {
			System.out.println("\nEl llibre es va retornar o no es troba asociat amb el teu compte.");
		} else if (res > 0) {
			System.out.println("El soci " + l1.getSoci().getNom() + " ha estat penalitzat amb" + res
					+ " punts. Total penalització : " + l1.getSoci().getPenalitzacio() + ".");
		} else
			System.out.println("\nRetorn completat correctament, gràcies.");

		// AFEGIR PRESTEC DESPRÉS DE RETORNAR
		if (l1.afegirPrestec(s1)) {
			System.out.println("\nEl llibre " + l1.getTitol() + " s'ha prestat al soci " + s1.getNom() + ".");
		} else {
			System.out.println("\nEl llibre " + l1.getTitol() + " ja està prestat al soci: " + l1.getSoci().getNom()
					+ " i no és pot tornar a prestar.");
		}

		// AFEGIR PRESTEC VIDEOJOC I PEL·LICULA
		if (p1.afegirPrestec(s1)) {
			System.out.println("\nLa Pel·licula [" + p1.getTitol() + "] s'ha prestat correctament.");
		} else {
			System.out.println("\nNo es pot prestar la pel·lícula [" + v1.getTitol() + "] al soci " + s2.getNom()
					+ " per manca d'edat.");
		}
		if (v1.afegirPrestec(s2)) {
			System.out.println("\nEl Videojoc [" + v1.getTitol() + "] s'ha prestat correctament.");
		} else {
			System.out.println("\nNo es pot prestar la videojoc [" + v1.getTitol() + "] al soci " + s2.getNom()
					+ " per manca d'edat.");
		}

	}
}