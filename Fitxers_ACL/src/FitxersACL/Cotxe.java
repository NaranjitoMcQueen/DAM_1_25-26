package FitxersACL;

public class Cotxe extends Vehicle {

	private int numPortes;
	private boolean esAutomatic;

	public Cotxe(String matricula, int km, String marca, String model, String color, int numPortes, boolean esAutomatic)
			throws MatriculaInvalidaException {
		super(matricula, km, marca, model, color);
		if (numPortes < 1) {
			this.numPortes = numPortes;
		}
		this.esAutomatic = esAutomatic;
	}

	// Num Portes
	public int getNumPortes() {
		return numPortes;
	}

	public void setNumPortes(int numPortes) {
		this.numPortes = numPortes;
	}

	// Automatic o Manual
	public boolean isEsAutomatic() {
		return esAutomatic;
	}

	public void setEsAutomatic(boolean esAutomatic) {
		this.esAutomatic = esAutomatic;
	}

	@Override
	public String toString() {
		return "cotxe;" + matricula + ";" + km + ";" + marca + ";" + model + ";" + color + ";" + numPortes + ";"
				+ esAutomatic;
	}
}
