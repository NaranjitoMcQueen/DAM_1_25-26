package Hospital;

public class Especialitat {

	private String nom;
	private String descripcio;
	private int edatMinima;
	private int edatMaxima;

	// CONSTRUCTOR
	public Especialitat(String nom, String descripcio, int edatMinima, int edatMaxima) {
		super();
		this.nom = nom;
		this.descripcio = descripcio;
		this.edatMinima = edatMinima;
		this.edatMaxima = edatMaxima;
	}

	// NOM
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	// DESCRIPCIÓ
	public String getDescripcio() {
		return descripcio;
	}

	public void setDescripcio(String descripcio) {
		this.descripcio = descripcio;
	}

	// EDAT MÍNIMA
	public int getEdatMinima() {
		return edatMinima;
	}

	public boolean comprobacioEdat(int edat) {
		if (edat < edatMinima)
			return false;
		return true;
	}

	// Per exemple en pediatria l'edat màxima és 14 anys. En Cirugia Estètica l'edat
	// mínima és 18 anys.
	
	// EDAT MÀXIMA
	public int getEdatMaxima() {
		return edatMaxima;
	}

	public void setEdatMaxima(int edatMaxima) {
		this.edatMaxima = edatMaxima;
	}

	// INFO
	@Override
	public String toString() {
		return "Especialitat [nom=" + nom + ", descripcio=" + descripcio + ", edatMinima=" + edatMinima
				+ ", edatMaxima=" + edatMaxima + "]";
	}
}