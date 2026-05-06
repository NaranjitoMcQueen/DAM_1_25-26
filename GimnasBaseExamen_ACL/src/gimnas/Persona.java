package gimnas;

import java.util.Objects;

public class Persona implements Comparable<Persona> {
	private String dni;
	private String nom;
	private String cognoms;
	private String telefon;
	private String dataNaixement;

	public Persona(String dni, String nom, String cognoms, String telefon, String dataNaixement)
			throws InvalidDniException {
		super();
		if (!valDNI(dni)) {
			throw new InvalidDniException("El DNI no compleix el format vàlid.");
		}
		this.dni = dni;
		this.nom = nom;
		this.cognoms = cognoms;
		this.telefon = telefon;
		this.dataNaixement = dataNaixement;
	}

	public Persona(String dni, String nom, String cognoms, String dataNaixement) throws InvalidDniException {
		super();
		this.dni = dni;
		this.nom = nom;
		this.cognoms = cognoms;
		this.dataNaixement = dataNaixement;
	}

	public Persona() {
		super();
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public static boolean valDNI(String dni) {
		if (dni == null || dni.length() != 9) {
			return false;
		}
		/*String esquemaCodi = "^d{8}\\[A-Z]{1}$";
		return dni.matches(esquemaCodi);*/
		return true;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCognoms() {
		return cognoms;
	}

	public void setCognoms(String cognoms) {
		this.cognoms = cognoms;
	}

	public String getDataNaixement() {
		return dataNaixement;
	}

	public void setDataNaixement(String dataNaixement) {
		this.dataNaixement = dataNaixement;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(dni, other.dni);
	}

	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nom=" + nom + ", cognoms=" + cognoms + ", telefon=" + telefon
				+ ", dataNaixement=" + dataNaixement + "]";
	}

	@Override
	public int compareTo(Persona o) {
		return this.dni.compareToIgnoreCase(o.getDni());
	}

}
