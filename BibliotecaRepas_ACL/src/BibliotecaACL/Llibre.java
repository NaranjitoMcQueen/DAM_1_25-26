package BibliotecaACL;

import java.time.LocalDate;

public class Llibre extends Element {
	private int num_pagines;
	private String autor;
	private String editorial;

	public Llibre() {
	}

	public Llibre(String codi, String titol, int any, int pagines, String autor, String editorial)
			throws InvalidCodiException {
		super(codi, titol, any);
		if (!codi.startsWith("L"))
			throw new InvalidCodiException("Codi de llibre ha de començar per L");
		if (pagines <= 0)
			throw new IllegalArgumentException("El nombre de pàgines ha de ser mayor a 0");
		this.num_pagines = pagines;
		this.autor = autor;
		this.editorial = editorial;
	}

	// Getters i Setters
	public int getNum_pagines() {
		return num_pagines;
	}

	public void setNum_pagines(int n) {
		this.num_pagines = n;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String a) {
		this.autor = a;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String e) {
		this.editorial = e;
	}

	@Override
	public String toString() {
		return String.format("Llibre [%s] %s - %s (%d pàgs.)", codi, titol, autor, num_pagines);
	}
}