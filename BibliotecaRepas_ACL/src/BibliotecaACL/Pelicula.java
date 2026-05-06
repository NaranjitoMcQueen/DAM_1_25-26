package BibliotecaACL;

import java.time.LocalDate;

public class Pelicula extends Element {
	private int duracio;
	private String classificacio;

	public Pelicula() {
	}

	public Pelicula(String codi, String titol, int any, int duracio, String classificacio) throws InvalidCodiException {
		super(codi, titol, any);
		if (!codi.startsWith("P"))
			throw new InvalidCodiException("Codi de pel·lícula ha de començar per P");
		if (duracio <= 0)
			throw new IllegalArgumentException("La durada ha de ser mayor a 0");
		this.duracio = duracio;
		this.classificacio = classificacio;
	}

	// Getters i Setters
	public int getDuracio() {
		return duracio;
	}

	public void setDuracio(int d) {
		this.duracio = d;
	}

	public String getClassificacio() {
		return classificacio;
	}

	public void setClassificacio(String c) {
		this.classificacio = c;
	}

	@Override
	public String toString() {
		return String.format("Pelicula [%s] %s - %s (%d min.)", codi, titol, classificacio, duracio);
	}
}