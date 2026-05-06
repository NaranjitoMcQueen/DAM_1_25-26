package Biblioteca;

public class Soci {

	private String dni;
	private String nom;
	private int edat;
	private int elementsPrestec;
	private int penalitzacio;

	// CONSTRUCTOR
	public Soci(String dni, String nom, int edat, int penalitzacio) {
		if (!esDniValid(dni)) {
			throw new IllegalArgumentException("DNI no vàlid");
		}
		this.dni = dni;
		this.nom = nom;
		this.edat = edat;
		this.penalitzacio = penalitzacio;
		this.elementsPrestec = 0;
	}

	public Soci(String dni, String nom, int edat, int quantitatPrestec, int penalitzacio) {
		if (!esDniValid(dni)) {
			throw new IllegalArgumentException("DNI no vàlid");
		}
		this.dni = dni;
		this.nom = nom;
		this.edat = edat;
		this.elementsPrestec = quantitatPrestec;
		this.penalitzacio = penalitzacio;
	}

	// DNI
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public static boolean esDniValid(String dni) {
		if (dni == null || dni.length() != 9)
			return false;
		int num = Integer.parseInt(dni.substring(0, 8));
		char lletra = dni.charAt(8);
		String lletres = "TRWAGMYFPDXBNJZSQVHLCKE";
		return lletres.charAt(num % 23) == lletra;
	}

	// NOM
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	// EDAT
	public int getEdat() {
		return edat;
	}

	public void setEdat(int edat) {
		this.edat = edat;
	}

	// QUANTITAT
	public int getElementsPrestec() {
		return elementsPrestec;
	}

	public void incrementarElementsPrestec() {
		elementsPrestec++;
	}

	public void decrementarPrestec() {
		if (elementsPrestec > 0) {
			elementsPrestec--;
		}
	}

	// PENALITZACIÓ
	public int getPenalitzacio() {
		return penalitzacio;
	}

	public void setPenalitzacio(int penalitzacio) {
		this.penalitzacio = penalitzacio;
	}

	// INFO
	@Override
	public String toString() {
		return "Soci [dni=" + dni + ", nom=" + nom + ", edat=" + edat + ", elementsPrestec=" + elementsPrestec
				+ ", penalitzacio=" + penalitzacio + "]";
	}
}
