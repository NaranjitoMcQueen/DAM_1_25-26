package Biblioteca;

public class Llibre extends Element{
	
	private int nombrePagines;
	private Autor autor;
	private int totalLlibres;
	private static int contador = 1;
	
	// CONSTRUCTOR PER DEFECTE
	public Llibre(String isbn, String titol, String editorial, boolean prestat, Soci soci, int nombrePagines,
			Autor autor) {
		super(isbn, titol, editorial, prestat, soci);
		this.nombrePagines = nombrePagines;
		this.autor = autor;
		this.prestat = false;
		this.totalLlibres = contador++;
	}

	// CONSTRUCOR AMB PARÀMETRES
	public Llibre(String isbn, String titol, String editorial, boolean prestat, Soci soci, int nombrePagines,
			Autor autor, int totalLlibres) {
		super(isbn, titol, editorial, prestat, soci);
		this.nombrePagines = nombrePagines;
		this.autor = autor;
		this.totalLlibres = totalLlibres;
	}

	// NOMBRE PAGINES
	public int getNombrePagines() {
		return nombrePagines;
	}

	public void setNombrePagines(int nombrePagines) {
		this.nombrePagines = nombrePagines;
	}

	// AUTOR
	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	// TOTAL LLIBRES
	public int getTotalLlibres() {
		return totalLlibres;
	}

	public void setTotalLlibres(int totalLlibres) {
		this.totalLlibres = totalLlibres;
	}

	@Override
	public String toString() {
		return "Llibre: [ " + titol + " ] de l'Autor: " + autor.getNom() + " amb Editorial: " + editorial + " conté Nº Pagines: " + nombrePagines + "\nPrestat: " + prestat + ", Total Llibres:" + totalLlibres;
	}
}
