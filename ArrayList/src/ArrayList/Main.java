package ArrayList;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// En el main de prova crea un arrayList d’objectes de la classe Persona.
		// Afegeix almenys 4 persones.
		ArrayList<Persona> persones = new ArrayList<>();

		persones.add(new Persona("Arnau", "12345678A"));
		persones.add(new Persona("Biel", "12345678B"));
		persones.add(new Persona("Joan", "12345678R"));
		persones.add(new Persona("Guillermo", "12345678G"));

		// Mostra les dades de la persona que està en la posició 1 (get)
		System.out.println("La persona a la primera posició hi es: " + persones.get(1));

		// Mostra quantes persones hi ha a la llista (size)
		System.out.println("\nPersones que hi ha a la llista: " + persones.size());

		// Canvia les dades de la persona que està en la posició 1 (set)
		persones.set(1, new Persona("Didac", "60600866W"));

		// Esborra la persona que està en la posició 2 (remove)
		persones.remove(2);

		// Mostra la llista sencera amb un forEach
		for (Persona Persona : persones) {
			System.out.print("\n" + Persona + " ");
		}

		// Crea un arrayList de persones amb 2 pacients i 2 doctors.
		ArrayList<Persona> p = new ArrayList<>();

		p.add(new Pacient("Raul", "12345678R", "Al·lèrgia a la pols"));
		p.add(new Pacient("Bryan", "12345678Y", "Ausentisme"));

		p.add(new Doctor("Marga", "12354678M", "Metge de Cap"));
		p.add(new Doctor("Miguel", "12354678L", "Metge de Cap"));

		// Mostra la informació de tota la llista utilitzant instanceof i sense
		// utilitzar el mètode toString
		int i = 0;
		System.out.println("\n");
		for (Persona persona1 : p) {
			if (persona1 instanceof Doctor) {
				Doctor doctor = (Doctor) persona1;
				System.out.println("L’element " + i + " de la llista és un Doctor: " + "nom=" + doctor.getNom()
						+ ", dni=" + doctor.getDni() + ", especialitat=" + doctor.getEspecialitat());
			} else if (persona1 instanceof Pacient) {
				Pacient pacient = (Pacient) persona1;
				System.out.println("L’element " + i + " de la llista és un Pacient: " + "nom=" + pacient.getNom()
						+ ", dni=" + pacient.getDni() + ", historial=" + pacient.getHistorialMedic());
			}
			i++;
		}

	}

}
