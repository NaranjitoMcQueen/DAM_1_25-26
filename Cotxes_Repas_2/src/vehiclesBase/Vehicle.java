package vehiclesBase;

public class Vehicle implements Comparable<Vehicle> {

	protected String matricula, marca, model, color;
	protected double km;

	public Vehicle(String matricula, String marca, String model, String color, double km) {
		super();
		this.matricula = matricula;
		this.marca = marca;
		this.model = model;
		this.color = color;
		this.km = km;
	}

	@Override
	public int compareTo(Vehicle altre) {
		return this.matricula.compareTo(altre.matricula);
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getKm() {
		return km;
	}

	public void setKm(double km) {
		this.km = km;
	}

}
