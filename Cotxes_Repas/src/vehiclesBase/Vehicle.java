package vehiclesBase;


public abstract class Vehicle implements Comparable<Vehicle> {
	
	protected String matricula, marca, model, color; 
	protected int km;

	public Vehicle(String matricula, String marca, String model, String color, int km) throws IllegalArgumentException {
		if (valMatricula(matricula)) {
			this.matricula = matricula;
		} else
			throw new IllegalArgumentException("Format incorrecte de matricula.");
		this.marca = marca;
		this.model = model;
		this.color = color;
		if (valKm(km)) {
			this.km = km;
		} else
			throw new IllegalArgumentException("Els kilometres son inferior a zero o negatius.");
	}
	
	// Matricula
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public static boolean valMatricula(String matricula) {
	    // Format antic: [A-Z]{1,2}\d{4}[A-Z]{1,2}
	    String esquemaMatrAnt = "^([A-Z]{1,2})\\d{4}[A-Z]{1,2}$";
	    // Format modern: \d{4}[BCDFGHJKLMNPRSTVWXYZ]{3}
	    String esquemaMatr = "^\\d{4}[BCDFGHJKLMNPRSTVWXYZ]{3}$";

	    if (matricula.matches(esquemaMatr) || matricula.matches(esquemaMatrAnt)) {
	        return true;
	    }
	    return false;
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
	
	// KM
	public int getKm() {
		return km;
	}
	public void setKm(int km) {
		this.km = km;
	}
	public static boolean valKm (int km) {
		if (km < 0) {
			return false;
		}
		return true;
	}
	
	// Descompte
	public int calcularDescompte() {
		int descompte = km/10000;
		if (descompte > 10) {
			descompte = 10;
		}
		return descompte;
	}
	
	@Override
	public int compareTo(Vehicle altre) {
	    return this.matricula.compareTo(altre.matricula);
	}

	@Override
	public String toString() {
		return "Vehicle [matricula=" + matricula + ", marca=" + marca + ", model=" + model + ", color=" + color
				+ ", km=" + km + "]";
	}

}