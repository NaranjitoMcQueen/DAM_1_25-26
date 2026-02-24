package EsDinamiques;

public class Figura {

	protected int posicio_x;
	protected int posicio_y;

	public Figura(int posicio_x, int posicio_y) {
		super();
		this.posicio_x = posicio_x;
		this.posicio_y = posicio_y;
	}

	public int getPosicio_x() {
		return posicio_x;
	}

	public void setPosicio_x(int posicio_x) {
		this.posicio_x = posicio_x;
	}

	public int getPosicio_y() {
		return posicio_y;
	}

	public void setPosicio_y(int posicio_y) {
		this.posicio_y = posicio_y;
	}

	public int numCostats() {
		return 0;
	}

	@Override
	public String toString() {
		return "Figura [posicio_x=" + posicio_x + ", posicio_y=" + posicio_y + "]";
	}

}
