package vehiclesBase;

public class Moto extends Vehicle{
	
	private int cilindrada;
	private String tipus;
	
	public Moto(String matricula, String marca, String model, String color, int km, int cilindrada, String tipus) throws IllegalArgumentException {
		super(matricula, marca, model, color, km);
		this.cilindrada = cilindrada;
		this.tipus = tipus;
	}

	public int getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}

	public String getTipus() {
		return tipus;
	}

	public void setTipus(String tipus) {
		this.tipus = tipus;
	}

	@Override
	public int calcularDescompte() {
		if (cilindrada > 125) return 0;
		return super.calcularDescompte();
	}
	
	@Override
	public String toString() {
		return "Moto [cilindrada=" + cilindrada + ", tipus=" + tipus + ", matricula=" + matricula + ", marca=" + marca
				+ ", model=" + model + ", color=" + color + ", km=" + km + "]";
	}

}