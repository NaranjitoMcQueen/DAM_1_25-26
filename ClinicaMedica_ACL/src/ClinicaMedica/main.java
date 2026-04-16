package ClinicaMedica;

import java.time.LocalDate;
import java.time.LocalTime;

public class main {

	public static void main(String[] args) {

		System.out.println("[]------------------------[] --- Inicialització --- []------------------------[]");
		try {
			System.out.println("[]------------------------[] --- Test Pacients --- []------------------------[]");

			Pacient pct1 = new Pacient("Guillermo", "50511866W", LocalDate.of(2007, 11, 7), "612345678", "MED45678901",
					"Asma");
			Pacient pctE = new Pacient("Error", "505118662", LocalDate.of(2007, 11, 7), "612345678", "error", "Asma");
		} catch (IllegalArgumentException eDNI) {
			System.out.println("Error: " + eDNI.getMessage());
		} catch (InvalidCodiPacientException e) {
			System.out.println("Error: " + e.getMessage());
		}

		Especialitat ept1 = new Especialitat("Cardiologia", "Metge del cor", 18, 80);
		Doctor dct1 = new Doctor("Arnau", "50511866W", LocalDate.of(2000, 10, 18), "653859604", ept1);

		Hospital hp = new Hospital("Sant Joan de Deu", "Carrer de les Mimosses");

		System.out.println("[]------------------------[] --- Test Hospital --- []------------------------[]");

		try {
			Pacient pct2 = new Pacient("Joan", "50511866W", LocalDate.of(2007, 7, 16), "612345678", "MED45678902",
					"Dierna");
			Pacient pctM = new Pacient("Menor", "50511866W", LocalDate.of(2024, 7, 16), "612345678", "MED45678902",
					"Nascut");
			Especialitat ept2 = new Especialitat("Cardiologia", "Metge del cor", 18, 80);
			Doctor dct2 = new Doctor("Arnau", "50511866W", LocalDate.of(2000, 10, 18), "653859604", ept1);
			Cita ct1 = new Cita(pct2, dct2, LocalDate.of(2027, 11, 25), LocalTime.of(13, 45));

			hp.registrarPacient(pct2);
			hp.registrarEspecialitat(ept2);
			hp.registrarDoctor(dct2);

			hp.registrarCites(ct1);

			System.out.println(
					"[]------------------------[] --- Test Hospital [Mostrar cites] --- []------------------------[]");

			hp.mostrarCites(LocalDate.of(2027, 11, 25));
			hp.mostrarCites(LocalDate.of(2031, 3, 2));

			System.out.println(
					"[]------------------------[] --- Test Hospital [Cita menor] --- []------------------------[]");
			Cita ct2 = new Cita(pctM, dct2, LocalDate.of(2027, 11, 25), LocalTime.of(13, 45));
		} catch (InvalidCodiPacientException e) {
			System.out.println("Error: " + e.getMessage());
		} catch (IllegalArgumentException eData) {
			System.out.println("Error: " + eData.getMessage());
		}

		try {
			Pacient pct3 = new Pacient("Didac", "50511866W", LocalDate.of(2007, 7, 16), "612345678", "MED45678902",
					"Autsimo");
			Doctor dct3 = new Doctor("Arnau", "50511866W", LocalDate.of(2000, 10, 18), "653859604", ept1);
			Cita ct2 = new Cita(pct3, dct3, LocalDate.of(2027, 11, 25), LocalTime.of(13, 45));

		} catch (InvalidCodiPacientException e) {
			System.out.println("Error: " + e.getMessage());
		} catch (IllegalArgumentException eData) {
			System.out.println("Error: " + eData.getMessage());
		}

	}
}