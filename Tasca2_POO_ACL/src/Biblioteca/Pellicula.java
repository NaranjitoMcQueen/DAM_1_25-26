package Biblioteca;

import java.time.LocalDate;

public class Pellicula extends Digital {
	private String director;
	private int durada;

	// CONSTRUCTOR AMB PARAMETRES
	public Pellicula(String isbn, String titol, String editorial, int anyEstrena, int edatMinima, String genere,
			String director, int durada) {
		super(isbn, titol, editorial, anyEstrena, edatMinima, genere);
		this.director = director;
		this.durada = durada;
	}

	// CONSTRUCTOR PER DEFECTE
	public Pellicula(String isbn, String titol, String editorial, boolean prestat, Soci soci, LocalDate dataPréstec,
			LocalDate dataDevolució, String productora, int anyEstrena, int edat, String director, int durada) {
		super(isbn, titol, editorial, prestat, soci, dataPréstec, dataDevolució, productora, anyEstrena, edat);
		this.director = director;
		this.durada = durada;
	}

	// DIRECTOR
	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	// DURADA
	public int getDurada() {
		return durada;
	}

	public void setDurada(int durada) {
		this.durada = durada;
	}

	@Override
	public String toString() {
		return "Pellicula [director=" + director + ", durada=" + durada + "]";
	}
}