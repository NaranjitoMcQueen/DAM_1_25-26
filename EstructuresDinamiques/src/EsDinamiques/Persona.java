package EsDinamiques;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;
import java.util.regex.Pattern;

public class Persona {

	private String nom;
	private LocalDate dataNaixement;
	private String telefon;

	// CONSTRUCTOR
	public Persona(String nom, LocalDate dataNaixement, String telefon) {
		super();
		this.nom = nom;
		this.dataNaixement = dataNaixement;
		if (telefon != null && validarTelefon(telefon)) {
			this.telefon = telefon;
		} else this.telefon = null;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Persona persona = (Persona) obj;
		return nom.equals(persona.nom) && dataNaixement.equals(persona.dataNaixement);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nom, dataNaixement);
	}

	// SETTERS I GETTERS
	// NOM
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	// DATA
	public LocalDate getDataNaixement() {
		return dataNaixement;
	}

	public void setDataNaixement(LocalDate dataNaixement) {
		this.dataNaixement = dataNaixement;
	}

	public int edat() {
		LocalDate avui = LocalDate.now();
		return Period.between(dataNaixement, avui).getYears();
	}

	// TELÈFON
	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public static boolean validarTelefon(String telefon) {
		if (telefon == null) return true;
		String esquemaTlf1 = "\\+34d{9}";
		String esquemaTlf2 = "\\d{9}";
		if (Pattern.matches(esquemaTlf1, telefon) || Pattern.matches(esquemaTlf2, telefon))
			return true;
		return false;
	}

	@Override
	public String toString() {
		return String.format("\n%-12s,%3d,%13s", nom, edat(), telefon);
	}

}
