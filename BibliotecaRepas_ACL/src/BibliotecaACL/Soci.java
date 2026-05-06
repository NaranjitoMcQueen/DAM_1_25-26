package BibliotecaACL;

import java.time.LocalDate;

public class Soci {
	public int codi;
	public String nom;
	public LocalDate dataNaixement;
	public int puntsPenalitzacio = 0;

	public Soci() {
	}

	public Soci(int codi, String nom, LocalDate data) {
		this.codi = codi;
		this.nom = nom;
		this.dataNaixement = data;
	}

	// Getters i Setters
	public int getCodi() {
		return codi;
	}

	public void setCodi(int c) {
		this.codi = c;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String n) {
		this.nom = n;
	}

	public LocalDate getDataNaixement() {
		return dataNaixement;
	}

	public void setDataNaixement(LocalDate d) {
		this.dataNaixement = d;
	}

	public int getPuntsPenalitzacio() {
		return puntsPenalitzacio;
	}

	public void setPuntsPenalitzacio(int p) {
		this.puntsPenalitzacio = p;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Soci))
			return false;
		return this.codi == ((Soci) obj).codi;
	}

	@Override
	public int hashCode() {
		return Integer.hashCode(codi);
	}
}