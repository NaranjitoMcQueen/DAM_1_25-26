package EsDinamiques;

public class Recta extends Figura {

	public Recta(int posicio_x, int posicio_y) {
		super(posicio_x, posicio_y);
	}

	public int numCostats() {
		return 1;
	}

	@Override
	public String toString() {
		return "Recta []";
	}

}
