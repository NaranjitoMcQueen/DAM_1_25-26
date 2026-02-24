package EsDinamiques;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// Exercici 1. Crea un ArrayList de String a partir de l’array següent:
		System.out.println("Exercici 1:");
		System.out.println(
				"--------------------------------------------------------------------------------------------");

		String[] dades = { "rojo", "verde", "azul claro", "azul marino" };
		String[] mesdades = { "amarillo", "naranja", "rosa fucsia" };

		List<String> llista = new ArrayList<>(Arrays.asList(dades));
		List<String> mesDades = new ArrayList<>(Arrays.asList(mesdades));

		llista.addAll(mesDades);

		// Afegeix el text “gris marengo” a la posició 2

		llista.add(2, "gris marengo");

		// Mostra:
		// La mida del vector

		System.out.println("Mida del vector: " + llista.size());

		// Si conté l'element “naranja”

		System.out.println("Conté l'element “naranja”: " + llista.contains("naranja"));

		// Si conté l'element “morado”

		System.out.println("Conté l'element “morado”: " + llista.contains("morado"));

		// L'element de la posició 5

		System.out.println("L'element de la posició 5: " + llista.get(5));

		// Esborra l'element de la posició 0

		String res = llista.remove(0);
		if (res != null)
			System.out.println("L'element eliminat de la posició 0 hi era: " + res);

		// Intenta esborrar l’element de la posició 10

		try {
			res = llista.remove(10);
			if (res != null)
				System.out.println("L'element eliminat de la posició 10 hi era: " + res);
			else
				System.out.println("No hi ha element a la posició 10.");
		} catch (Exception e) {
			System.out.println("La longitud no arriba a 10.");
		}

		// Esborra “verde”
		String color = "verde";
		if (llista.remove(color))
			System.out.println("El color: " + color + " ha sigut esborrat correctament.");
		else
			System.out.println("No hi ha element amb el nom de: " + color + " o no es va trobar cap coinicidencia.");

		// Intenta esborrar “negro”

		color = "negro";
		if (llista.remove(color))
			System.out.println("El color: " + color + " ha sigut esborrat correctament.");
		else
			System.out.println("No hi ha element amb el nom de: " + color);

		// Converteix els elements de la posició 3 fins al final en una llista enllaçada
		// (LinkedList) (utilitza subList)

		List<String> subLlista = new LinkedList<>(llista.subList(3, llista.size()));

		// Mostra el contingut de la llista enllaçada

		System.out.println("Contingut de la llista enllaçada: " + subLlista);

		// Exercici 2. A partir d'una llista enllaçada (LinkedList), crea un programa
		// que es comporti com una Cua: First In, First Out (add/offer, poll)
		System.out.println("\nExercici 2:");
		System.out.println(
				"--------------------------------------------------------------------------------------------");

		// Donada la següent seqüència d'operacions :
		// Afegir a la cua per aquest ordre “1”, “2”, “3”, “4”, “5”, “6”

		List<String> Cua = new LinkedList<>();

		Cua.add("1");
		Cua.add("2");
		Cua.add("3");
		Cua.add("4");
		Cua.add("5");
		Cua.add("6");

		System.out.println("Estat de la cua: " + Cua);

		// Treure de la cua 3 elements

		Cua.removeFirst();
		Cua.removeFirst();
		Cua.removeFirst();

		System.out.println("Estat de la cua: " + Cua);

		// Afegir a la cua per aquest ordre “A”, “B”, “C”

		Cua.add("A");
		Cua.add("B");
		Cua.add("C");

		System.out.println("Estat de la cua: " + Cua);

		// Treure de la cua 2 elements

		Cua.removeFirst();
		Cua.removeFirst();

		System.out.println("Estat de la cua: " + Cua);

		// El resultat és : , “6” -> “A” -> “B” -> “C”, Després de cada apartat mostra
		// la cua.

		/*
		 * Exercici 3. A partir d'una llista enllaçada (LinkedList), crea un programa
		 * que es comporti com una Pila: Last In, First Out (push, pop)
		 */
		System.out.println("\nExercici 3:");
		System.out.println(
				"--------------------------------------------------------------------------------------------");

		// Donada la següent seqüència d'operacions :
		// Afegir a la pila per aquest ordre “1”, “2”, “3”, “4”, “5”, “6”

		List<String> Pila = new LinkedList<>();

		Pila.addFirst("1");
		Pila.addFirst("2");
		Pila.addFirst("3");
		Pila.addFirst("4");
		Pila.addFirst("5");
		Pila.addFirst("6");

		System.out.println("Estat de la pila: " + Pila);

		// Treure de la pila 3 elements

		Pila.removeFirst();
		Pila.removeFirst();
		Pila.removeFirst();

		System.out.println("Estat de la pila: " + Pila);

		// Afegir a la pila per aquest ordre “A”, “B”, “C”

		Pila.addFirst("A");
		Pila.addFirst("B");
		Pila.addFirst("C");

		System.out.println("Estat de la pila: " + Pila);

		// Treure de la pila 2 elements

		Pila.removeFirst();
		Pila.removeFirst();

		System.out.println("Estat de la pila: " + Pila);

		// El resultat és : “A” -> “3” -> “2” -> “1”, Després de cada apartat mostra la
		// pila.

		System.out.println("\nExercici 4:");
		System.out.println(
				"--------------------------------------------------------------------------------------------");

		// Exercici 4. A partir de la classe Persona (amb els atributs nom, data de
		// naixement, tlf), crea un programa que permeti entrar les dades de diferents
		// persones. Guarda les dades en una estructura que garanteixi que no hi ha
		// repetits.

		HashSet<Persona> p = new HashSet<>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Les dades s’han d’introduir des de teclat d’aquesta manera:\n"
				+ "(Nom) nom cognom, (Data naixement) dd/MM/yyyy, (Telèfon) 123456789");

		while (true) {
			String llegirInfo = sc.nextLine();

			// Si hi fas un enter buit surt
			if (llegirInfo.isBlank()) {
				System.out.println("No hi ha més informació, sortint del programa.");
				break;
			}

			// Es genera l'string i comença la separació
			String[] info;
			try {
				info = llegirInfo.split(",");

				if (info.length < 2) {
					System.out.println("Manca informació.");
					continue;
				}
				// Agafar per omplir la llista
				// Arnau Campos, 18/10/2000, 657892367
				// Guillermo Martin, 15/11/2007
				// Joan Diaz,11/05/2007, 658942144

				String infoNom = info[0].trim();
				String infoData = info[1].trim();
				String infoTlf = (info.length == 3) ? info[2].trim() : null;

				// Si no compleix el format transforma a null i donem error
				DateTimeFormatter formatData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate dataNaixement = null;

				try {
					dataNaixement = LocalDate.parse(infoData, formatData);
				} catch (DateTimeParseException e) {
					System.out.println("Aquest format es l'únic valid: dd/MM/yyyy.");
					continue;
				}
				if (dataNaixement == null) {
					System.out.println("Data de naixement obligatòria.");
					continue;
				}

				Persona persona = new Persona(infoNom, dataNaixement, infoTlf);

				if (!p.add(persona)) {
					System.out.println("El registre està duplicat.");
				}

			} catch (Exception e) {
				System.out.println("Les dades introduïdes contenen un error.");
			}
		}

		// Mostra llista
		System.out.println("\nLlistat de persones:");
		for (Persona persona : p) {
			System.out.println(persona);
		}

		sc.close();

		System.out.println("\nExercici 5:");
		System.out.println(
				"--------------------------------------------------------------------------------------------");
		List<Figura> figura = new LinkedList<>();

		figura.add(new Triangle(0, 0, 15, 15));
		figura.add(new Recta(0, 0));
		figura.add(new Quadrat(0, 0, 5));

		Iterator<Figura> fitr = figura.iterator();

		// hasNext - hasPrevious
		// Recorre en ordre
		System.out.println("Figures en ordre d'entrada:");
		while (fitr.hasNext()) {
			Figura fig = fitr.next();
			System.out.println("Costats: " + fig.numCostats());
		}

		// Recorre invers
		ListIterator<Figura> figPrev = figura.listIterator(figura.size());

		System.out.println("Figures en ordre invers: ");
		while (figPrev.hasPrevious()) {
			Figura figRev = figPrev.previous();
			System.out.println("Costats: " + figRev.numCostats());
		}

	}
}
