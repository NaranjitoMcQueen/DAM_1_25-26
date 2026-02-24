package EsDinamiques;

public class Triangle extends Figura {

	private int alcada;
	private int base;

	public Triangle(int posicio_x, int posicio_y, int alcada, int base) {
		super(posicio_x, posicio_y);
		this.alcada = alcada;
		this.base = base;
	}

	public int getAlcada() {
		return alcada;
	}

	public void setAlcada(int alcada) {
		this.alcada = alcada;
	}

	public int getBase() {
		return base;
	}

	public void setBase(int base) {
		this.base = base;
	}

	public int numCostats() {
		return 3;
	}

	public int area() {
		return alcada * base / 2;
	}

	@Override
	public String toString() {
		return "Triangle [alcada=" + alcada + ", base=" + base + "]";
	}
}
