package Biblioteca;

public class Autor {

	private String nom;
	private String nacionalitat;
	private int codiUnic;
	private static int contador = 1;
	

	// CONSTRUCTOR
	public Autor(String nom, String nacionalitat) {
		super();
		this.nom = nom;
		this.nacionalitat = nacionalitat;
		this.codiUnic = contador++;
	}

	// NOM
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	// NACIONALITAT
	public String getNacionalitat() {
		return nacionalitat;
	}

	public void setNacionalitat(String nacionalitat) {
		this.nacionalitat = nacionalitat;
	}

	// CODI ÚNIC
	public int getCodiUnic() {
		return codiUnic;
	}

	public void setCodiUnic(int codiUnic) {
		this.codiUnic = codiUnic;
	}

	// INFO
	@Override
	public String toString() {
		return "NOM: " + nom + " NACIONALITAT: " + nacionalitat + " CODI ÚNIC: " + codiUnic;
	}
}
