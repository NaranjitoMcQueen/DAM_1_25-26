package EsDinamiques;

public class Quadrat extends Figura {

	private int costat;

	public Quadrat(int posicio_x, int posicio_y, int costat) {
		super(posicio_x, posicio_y);
		this.costat = costat;
	}

	public int getCostat() {
		return costat;
	}

	public void setCostat(int costat) {
		this.costat = costat;
	}

	public int numCostats() {
		return 4;
	}

	public int area() {
		return costat * costat;
	}

	@Override
	public String toString() {
		return "Quadrat [costat=" + costat + "]";
	}
}
