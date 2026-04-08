package FitxersACL;

public class Moto extends Vehicle {

	private int cilindrada;
	private TipusMoto tipus;

	public Moto(String matricula, int km, String marca, String model, String color, int cilindrada, TipusMoto tipus)
			throws MatriculaInvalidaException {
		super(matricula, km, marca, model, color);
		this.cilindrada = cilindrada;
		this.tipus = tipus;
	}

	public Moto() {
	}

	// Cilindrada
	public int getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}

	// Tipus
	public TipusMoto getTipus() {
		return tipus;
	}

	public void setTipus(TipusMoto tipus) {
		this.tipus = tipus;
	}

	@Override
	public String toString() {
		return "moto;" + matricula + ";" + km + ";" + marca + ";" + model + ";" + color + ";" + cilindrada + ";"
				+ tipus;
	}
}
