package vehiclesBase;

public class Cotxe extends Vehicle {

	private int numportes;
	private boolean esAutomatic;

	public Cotxe(String matricula, String marca, String model, String color, double km, int numportes,
			boolean esAutomatic) {
		super(matricula, marca, model, color, km);
		this.numportes = numportes;
		this.esAutomatic = esAutomatic;
	}

	public int getNumportes() {
		return numportes;
	}

	public void setNumportes(int numportes) {
		this.numportes = numportes;
	}

	public boolean isEsAutomatic() {
		return esAutomatic;
	}

	public void setEsAutomatic(boolean esAutomatic) {
		this.esAutomatic = esAutomatic;
	}

}
