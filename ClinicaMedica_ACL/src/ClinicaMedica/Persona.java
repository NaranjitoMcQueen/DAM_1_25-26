package ClinicaMedica;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class Persona {

	protected String nom;
	protected String dni;
	protected LocalDate dnaix;
	protected String telefon;

	public Persona(String nom, String dni, LocalDate dnaix, String telefon) throws IllegalArgumentException {
		super();
		this.nom = nom;
		if (valDNI(dni)) {
			this.dni = dni;
			this.dnaix = dnaix;
			if (valTelefon(telefon)) {
				this.telefon = telefon;
			}
		} else {
			throw new IllegalArgumentException("El DNI no compleix el format vàlid.");
		}
	}

	public Persona() {
		super();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public static boolean valDNI(String dni) {
		if (dni == null || dni.length() != 9)
			return false;
		int num = Integer.parseInt(dni.substring(0, 8));
		char lletra = dni.charAt(8);
		String lletres = "TRWAGMYFPDXBNJZSQVHLCKE";
		return lletres.charAt(num % 23) == lletra;
	}

	public LocalDate getDnaix() {
		return dnaix;
	}

	public void setDnaix(LocalDate dnaix) {
		this.dnaix = dnaix;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public static boolean valTelefon(String phone) {
		if (phone == null) {
			return true;
		}
		String esquemaTlf1 = "^6\\d{8}";
		String esquemaTlf2 = "^9\\d{8}";
		if (Pattern.matches(esquemaTlf1, phone) || Pattern.matches(esquemaTlf2, phone)) {
			return true;
		}
		return false;
	}

}
