package Hospital;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Hospital {

	public static void main(String[] args) {
		// DEMANAR A L'USUARI UN DNI:
		/*
		 * Scanner sc = new Scanner(System.in); String testdni;
		 * System.out.println("Escriu les dades d'un pacient:"); testdni =
		 * sc.nextInt(!esDniValid(testdni));
		 */

		// Crear dos pacients i dos doctors de diferents especialitats.
		Pacient p1 = new Pacient("Arnau", "50511866W", "18/10/2000", "653859604", "MED04569001");
		Pacient p2 = new Pacient("Guillermo", "50511866W", "29/08/2002", "689859784", "MED04569002");

		Especialitat e1 = new Especialitat("Pediatria", "Doctor per a infants", 14, 0);
		Especialitat e2 = new Especialitat("Cirugia Estètica", "Doctor per estètica", 18, 0);

		Doctor d1 = new Doctor("Joan", "50511866W", "07/10/2002", "653859604", e1, 0, 0);
		Doctor d2 = new Doctor("Brayan", "50511866W", "19/04/2002", "653859604", e2, 0, 0);

		// Mostrar les dades dels pacients i dels doctors.
		System.out.println("\n" + p1.toString());
		System.out.println("\n" + p2.toString());
		System.out.println("\n" + d1.toString());
		System.out.println("\n" + d2.toString());

		// Mostra quants pacients s'han creat.
		System.out.println("\nPacients Creats: " + p1.getTotalPacients());

		// Agendar una cita per a un pacient amb un doctor.
		Cita c1 = new Cita(p1, d2, null, null, Cita.estatCita.PENDING);
		System.out.println("\nEl pacient " + c1.getPacient().getNom() + " ha reservat una cita amb el doctor "
				+ c1.getDoctor().getNom() + " per al " + c1.getData() + " a les " + c1.getHora() + ".");
		Cita c2 = new Cita(p2, d2, null, null, Cita.estatCita.PENDING);
		System.out.println("\nEl pacient " + c2.getPacient().getNom() + " ha reservat una cita amb el doctor "
				+ c2.getDoctor().getNom() + " per al " + c2.getData() + " a les " + c2.getHora() + ".");

		// Consultar l'historial mèdic d'un pacient donada una cita.

		// Cancel·lar una cita prèviament agendada.
		int res = c2.cancellarCita();
		if (res == -1) {
			System.out.println("\nNo es pot cancel·lar la cita ja que no es troba agendada o ja ha sigut realitzada.");
		} else
			System.out.println("\nLa cita de " + c2.getPacient().getNom() + " amb el docotr " + c2.getDoctor().getNom()
					+ " per al " + c2.getData() + " a les " + c2.getHora() + " ha estat cancel·lada");

		// Consultar l'estat d'una cita.
		System.out.println("\nLa cita de " + c1.getPacient().getNom() + " amb el doctor " + c1.getDoctor().getNom()
				+ " està marcada com a " + c1.getEstat() + ".\n");
		

	}
}