package FitxersACL;

import java.util.Objects;

public abstract class Vehicle implements Comparable<Vehicle> {

	protected String matricula;
	protected int km;
	protected String marca;
	protected String model;
	protected String color;

	public Vehicle(String matricula, int km, String marca, String model, String color)
			throws MatriculaInvalidaException {
		if (valMatricula(matricula)) {
			this.matricula = matricula;
		}
		if (km > 0) {
			this.km = km;
		} else {

		}
		this.marca = marca;
		this.model = model;
		this.color = color;
	}

	// Matricula
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) throws MatriculaInvalidaException {
		if (valMatricula(matricula)) {
			this.matricula = matricula;
		}
	}

	public static boolean valMatricula(String matricula) throws MatriculaInvalidaException {
		String regexMat = "^\\d{4}[A-Z]{3}$";
		String regexGuio = "^\\d{4}-[A-Z]{3}$";

		if (matricula.matches(regexMat) || matricula.matches(regexGuio)) {
			return true;
		} else {
			throw new MatriculaInvalidaException();
		}
	}

	// Kilometres
	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}

	// Marca
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	// Model
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	// Color
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	// Override
	@Override
	public int compareTo(Vehicle o) {
		return this.matricula.compareTo(o.matricula);
	}

	@Override
	public int hashCode() {
		return Objects.hash(color, km, marca, matricula, model);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		return Objects.equals(color, other.color) && km == other.km && Objects.equals(marca, other.marca)
				&& Objects.equals(matricula, other.matricula) && Objects.equals(model, other.model);
	}

}
