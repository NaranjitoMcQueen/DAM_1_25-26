package ClinicaMedica;

public class Especialitat {

	private String nom;
	private String descripcio;
	private int edatmin;
	private int edatmax;

	public Especialitat(String nom, String descripcio, int edatmin, int edatmax) {
		super();
		this.nom = nom;
		this.descripcio = descripcio;
		this.edatmin = edatmin;
		this.edatmax = edatmax;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescripcio() {
		return descripcio;
	}

	public void setDescripcio(String descripcio) {
		this.descripcio = descripcio;
	}

	public int getEdatmin() {
		return edatmin;
	}

	public void setEdatmin(int edatmin) {
		this.edatmin = edatmin;
	}

	public int getEdatmax() {
		return edatmax;
	}

	public void setEdatmax(int edatmax) {
		this.edatmax = edatmax;
	}

	@Override
	public String toString() {
		return "Especialitat [nom=" + nom + ", descripcio=" + descripcio + ", edatmin=" + edatmin + ", edatmax="
				+ edatmax + "]";
	}
}
