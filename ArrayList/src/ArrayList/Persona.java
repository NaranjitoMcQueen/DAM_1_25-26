package ArrayList;

public class Persona {

	protected String nom;
	protected String dni;

	// CONSTRUCTOR
	public Persona(String nom, String dni) {
		super();
		this.nom = nom;
		this.dni = dni;
	}

	// SETTERS I GETTERS
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

	// INFORMACIÓ
	@Override
	public String toString() {
		return "Persona [nom=" + nom + ", dni=" + dni + "]";
	}
}
