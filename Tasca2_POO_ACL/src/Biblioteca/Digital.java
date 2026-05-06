package Biblioteca;

import java.time.LocalDate;

public class Digital extends Element {
	protected int anyEstrena;
	protected int edatMinima;
	protected String genere;

	// CONSTRUCTOR AMB PARÀMETRES
	public Digital(String isbn, String titol, String editorial, int anyEstrena, int edatMinima, String genere) {
		super(isbn, titol, editorial);
		this.anyEstrena = anyEstrena;
		this.edatMinima = edatMinima;
		this.genere = genere;
	}

	// CONSTRUCTOR PER DEFECTE
	public Digital(String isbn, String titol, String editorial, boolean prestat, Soci soci, LocalDate dataPréstec,
			LocalDate dataDevolució, String productora, int anyEstrena, int edatMinima) {
		super(isbn, titol, editorial, prestat, soci, dataPréstec, dataDevolució);
		this.anyEstrena = anyEstrena;
		this.edatMinima = edatMinima;
	}
	
	// AFEGIR PRESTEC DIGITAL
	@Override
	public boolean afegirPrestec(Soci s) {
		if (!comprobacioEdat(s.getEdat()))
			return false;
		return super.afegirPrestec(s);
	}

	// ANY
	public int getAnyEstrena() {
		return anyEstrena;
	}

	public void setAnyEstrena(int anyEstrena) {
		this.anyEstrena = anyEstrena;
	}

	// EDAT
	public int getEdatMinima() {
		return edatMinima;
	}

	public void setEdatMinima(int edatMinima) {
		this.edatMinima = edatMinima;
	}

	public boolean comprobacioEdat(int edat) {
		if (edat < edatMinima)
			return false;
		return true;
	}

	// GENERE
	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	// INFORMACIÓ
	@Override
	public String toString() {
		return "Digital [anyEstrena=" + anyEstrena + ", edatMinima=" + edatMinima
				+ ", genere=" + genere + "]";
	}

}
