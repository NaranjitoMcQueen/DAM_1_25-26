
public class Cotxes extends Vehicles {

	private int numPuertas;
	private boolean esAutomatic;

	public Cotxes(String matricula, int km, String marca, String model, String color, int numPuertas,
			boolean esAutomatic) throws Exception {
		super(matricula, km, marca, model, color);
		if (valPuertas(numPuertas)) {
			this.numPuertas = numPuertas;
		} else
			throw new Exception("El nombre de portes hi es erroni.");
		this.esAutomatic = esAutomatic;
	}

	public int getNumPuertas() {
		return numPuertas;
	}

	public void setNumPuertas(int numPuertas) {
		this.numPuertas = numPuertas;
	}

	public static boolean valPuertas(int numPuertas) {
		if (numPuertas < 1) {
			return false;
		}
		return true;
	}

	//Automatic
	public boolean isEsAutomatic() {
		return esAutomatic;
	}

	public void setEsAutomatic(boolean esAutomatic) {
		this.esAutomatic = esAutomatic;
	}
	
	//Descompte 
	public int descompte() {
		if (esAutomatic) {
			return 0;
		}
		return super.descompte();
	}

	@Override
	public String toString() {
	    return
	               "\n  Matricula = " + matricula +
	               "\n  KM        = " + km +
	               "\n  Marca     = " + marca +
	               "\n  Model     = " + model +
	               "\n  Color     = " + color +
	           	   "\n  Nombre Portes= " + numPuertas +
	           	   "\n  Automatic = " + (esAutomatic ? "Automatic" : "Manual");
	}
}
