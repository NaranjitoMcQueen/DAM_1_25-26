package vehiclesBase;

public class Cotxe extends Vehicle{
	
	private int numPuertas;
	private boolean esAutomatic;
	
	public Cotxe(String matricula, String marca, String model, String color, int km, int numPuertas,
			boolean esAutomatic) throws IllegalArgumentException {
		super(matricula, marca, model, color, km);
		this.numPuertas = numPuertas;
		this.esAutomatic = esAutomatic;
	}

	public int getNumPuertas() {
		return numPuertas;
	}

	public void setNumPuertas(int numPuertas) {
		this.numPuertas = numPuertas;
	}

	public boolean isEsAutomatic() {
		return esAutomatic;
	}

	public void setEsAutomatic(boolean esAutomatic) {
		this.esAutomatic = esAutomatic;
	}
	
	@Override
	public int calcularDescompte() {
		if (esAutomatic) return 0;
		return super.calcularDescompte();
	}
	@Override
	public String toString() {
		return "Cotxe [numPuertas=" + numPuertas + ", esAutomatic=" + esAutomatic + ", matricula=" + matricula
				+ ", marca=" + marca + ", model=" + model + ", color=" + color + ", km=" + km + "]";
	}

}