package Biblioteca;

import java.time.LocalDate;

public class Videojoc extends Digital {
	private String plataforma;
	private String modeJoc;
	private boolean requereixInternet;

	// CONSTRUCTOR PER DEFECTE
	public Videojoc(String isbn, String titol, String editorial, boolean prestat, Soci soci, LocalDate dataPréstec,
			LocalDate dataDevolució, String productora, int anyEstrena, int edatMinima, String plataforma,
			String modeJoc, boolean requereixInternet) {
		super(isbn, titol, editorial, prestat, soci, dataPréstec, dataDevolució, productora, anyEstrena, edatMinima);
		this.plataforma = plataforma;
		this.modeJoc = modeJoc;
		this.requereixInternet = requereixInternet;
	}

	// CONSTRUCTOR AMB PARAMENTRES
	public Videojoc(String isbn, String titol, String editorial, int anyEstrena, int edatMinima, String genere,
			String plataforma, String modeJoc, boolean requereixInternet) {
		super(isbn, titol, editorial, anyEstrena, edatMinima, genere);
		this.plataforma = plataforma;
		this.modeJoc = modeJoc;
		this.requereixInternet = requereixInternet;
	}

	// PLATAFORMA
	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	// MODE DE JOG
	public String getModeJoc() {
		return modeJoc;
	}

	public void setModeJoc(String modeJoc) {
		this.modeJoc = modeJoc;
	}

	// REQUEREIX INTERNET
	public boolean isRequereixInternet() {
		return requereixInternet;
	}

	public void setRequereixInternet(boolean requereixInternet) {
		this.requereixInternet = requereixInternet;
	}

	@Override
	public String toString() {
		return "Videojoc [plataforma=" + plataforma + ", modeJoc=" + modeJoc + ", requereixInternet="
				+ requereixInternet + "]";
	}
}
