package vehiclesBase;

public class Moto extends Vehicle {

	private int cilindrada;
	private String tipus;

	public Moto(String matricula, String marca, String model, String color, double km, int cilindrada, String tipus) {
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

}
