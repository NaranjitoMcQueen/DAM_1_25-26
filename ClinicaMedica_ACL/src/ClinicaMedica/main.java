package ClinicaMedica;

import java.time.LocalDate;

public class main {

	public static void main(String[] args) {
		try {
			Pacient pct1 = new Pacient("Guillermo", "50511866W", LocalDate.of(2007, 11, 7), "612345678", "MED0570112",
					"Asma");
		} catch (InvalidCodiPacientException e) {
			System.out.println("Error: " + e.getMessage());
		}
		Especialitat ept1 = new Especialitat("Cardiologia", "Metge del cor", 18, 80);
		Doctor dcr1 = new Doctor("Arnau", "50511866W", LocalDate.of(2000, 10, 18), "653859604", ept1);
	}
}
