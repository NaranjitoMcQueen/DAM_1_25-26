package Biblioteca;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Element {

	protected String isbn;
	protected String titol;
	protected String editorial;
	protected boolean prestat = false;
	protected Soci soci;
	protected LocalDate dataPréstec;
	protected LocalDate dataDevolució;

	protected static final int MAX_ELEMENTS = 3;

	// CONSTRUCTOR AMB PARÀMETRES
	public Element(String isbn, String titol, String editorial, boolean prestat, Soci soci) {
		if (!esISBNvalid(isbn)) {
			throw new IllegalArgumentException("L'ISBN no hi es válid");
		}
		this.isbn = isbn;
		this.titol = titol;
		this.editorial = editorial;
		this.prestat = false;
		this.soci = soci;
	}

	// CONSTRUCTOR AMB PARÀMENTRES PER DIGITAL
	public Element(String isbn, String titol, String editorial) {
		if (!esISBNvalid(isbn)) {
			throw new IllegalArgumentException("L'ISBN no hi es válid");
		}
		this.isbn = isbn;
		this.titol = titol;
		this.editorial = editorial;
	}

	// CONSTRUCTOR PER DEFECTE
	public Element(String isbn, String titol, String editorial, boolean prestat, Soci soci, LocalDate dataPréstec,
			LocalDate dataDevolució) {
		if (!esISBNvalid(isbn)) {
			throw new IllegalArgumentException("L'ISBN no hi es válid");
		}
		this.isbn = isbn;
		this.titol = titol;
		this.editorial = editorial;
		this.prestat = prestat;
		this.soci = soci;
		this.dataPréstec = dataPréstec;
		this.dataDevolució = dataDevolució;
	}

	// ISBN
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		if (!esISBNvalid(isbn)) {
			throw new IllegalArgumentException("ISBN no hi és vàlid");
		}
		this.isbn = isbn;
	}

	public static boolean esISBNvalid(String isbn) {
		return isbn != null && isbn.startsWith("978") && isbn.length() == 13;
	}

	// TITOL
	public String getTitol() {
		return titol;
	}

	public void setTitol(String titol) {
		this.titol = titol;
	}

	// EDITORIAL
	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	// SOCI
	public Soci getSoci() {
		return soci;
	}

	public void setSoci(Soci soci) {
		this.soci = soci;
	}

	// PRESTAT
	public boolean isPrestat() {
		return prestat;
	}

	public void setPrestat(boolean prestat) {
		this.prestat = prestat;
	}

	public boolean afegirPrestec(Soci s) {
		if (this.prestat)
			return false;
		if (s.getElementsPrestec() >= MAX_ELEMENTS) {
			throw new IllegalArgumentException("S'ha arribat al máxim d'elements permesos.");
		}
		this.prestat = true;
		this.soci = s;
		s.incrementarElementsPrestec();
		LocalDate avui = LocalDate.now();
		this.dataPréstec = avui;
		this.dataDevolució = avui.plusDays(5);
		return true;
	}

	// PRESTAT ENDARRERIR
	public int endarrerirPrestec() {
		if (!prestat)
			return 1;
		dataDevolució = dataDevolució.plusDays(5);
		return 0;
	}

	public int retornarPrestec() {
		if (!prestat)
			return -1;

		if (penalitzacio() > 0) {
			int dies = penalitzacio();
			soci.setPenalitzacio(dies);
			this.soci.decrementarPrestec();
			this.dataDevolució = null;
			this.dataPréstec = null;
			this.prestat = false;
			this.soci = null;
			return dies;
		}
		this.soci.decrementarPrestec();
		this.dataDevolució = null;
		this.dataPréstec = null;
		this.prestat = false;
		this.soci = null;
		return 0;
	}

	public int calcularPrestat() {
		if (!prestat)
			return -1;
		int dies = (int) ChronoUnit.DAYS.between(dataDevolució, LocalDate.now());
		if (dies <= 0)
			return 0;
		return dies;
	}

	// PENALITZACIÓ PRESTAT
	public int penalitzacio() {
		int dies = calcularPrestat();
		if (dies > 0)
			return dies;
		return 0;
	}

	// DATA PRÉSTEC
	public LocalDate getDataPréstec() {
		return dataPréstec;
	}

	public void setDataPréstec(LocalDate dataPréstec) {
		this.dataPréstec = dataPréstec;
	}

	// DATA DEVOLUCIÓ
	public LocalDate getDataDevolució() {
		return dataDevolució;
	}

	public void setDataDevolució(LocalDate dataDevolució) {
		this.dataDevolució = dataDevolució;
	}
}
