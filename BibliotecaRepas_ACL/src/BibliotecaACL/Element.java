package BibliotecaACL;

import java.time.LocalDate;

public abstract class Element implements Comparable<Element> {
	protected String codi;
	protected String titol;
	protected int any_publicacio;
	protected boolean disponible = true;
	protected boolean prestat = false;
	protected Soci soci;
	protected LocalDate dataPrestec;

	public Element() {
	}

	public Element(String codi, String titol, int any) throws InvalidCodiException {
		if (!valCodi(codi)) {
			throw new InvalidCodiException("Format de codi no vàlid (3 lletres i 4 xifres)");
		}
		if (!valAny(any)) {
			throw new IllegalArgumentException("Any de publicació fora de rang (1500-2026)");
		}
		this.codi = codi;
		this.titol = titol;
		this.any_publicacio = any;
	}

	// Getters i Setters
	public String getCodi() {
		return codi;
	}

	public String getTitol() {
		return titol;
	}

	public static boolean valCodi(String codi) {
		if (codi == null || codi.length() != 11) {
			return false;
		}
		String esquemaCodi = "^[A-Z]{3}\\\\d{4}$";
		return codi.matches(esquemaCodi);
	}

	public void setTitol(String titol) {
		this.titol = titol;
	}

	public int getAny_publicacio() {
		return any_publicacio;
	}

	public static boolean valAny(int any) {
		return any < 1500 || any > 2026;
	}

	public boolean isPrestat() {
		return prestat;
	}

	public void setPrestat(boolean prestat) {
		this.prestat = prestat;
	}

	public Soci getSoci() {
		return soci;
	}

	public void setSoci(Soci soci) {
		this.soci = soci;
	}

	public LocalDate getDataPrestec() {
		return dataPrestec;
	}

	public void setDataPrestec(LocalDate data) {
		this.dataPrestec = data;
	}

	@Override
	public int compareTo(Element o) {
		return this.titol.compareToIgnoreCase(o.getTitol());
	}

	public boolean isDisponible() {
		return disponible;
	}
}