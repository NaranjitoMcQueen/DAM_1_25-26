public class Motos extends Vehicles {

	private int cilindrada;

	// ENUM
	public enum tipus {
		ESPORTIVA, TURISME, NAKED
	}

	private tipus t;

	public Motos(String matricula, int km, String marca, String model, String color, int cilindrada, tipus tipus)
			throws Exception {
		super(matricula, km, marca, model, color);
		if (valCilindrada(cilindrada)) {
			this.cilindrada = cilindrada;
		} else {
			this.cilindrada = 0;
		}
		if (valTipus(tipus)) {
			this.t = tipus;
		} else {
			this.t = null;
		}
	}

	public static boolean valCilindrada(int cilindrada) {
		return cilindrada > 0;
	}

	public static boolean valTipus(tipus tipus) {
		return tipus != null;
	}

	// -------- GETTERS & SETTERS --------

	public int getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(int cilindrada) {
		if (valCilindrada(cilindrada)) {
			this.cilindrada = cilindrada;
		}
	}

	public tipus getTipus() {
		return t;
	}

	public void setTipus(tipus tipus) {
		if (valTipus(tipus)) {
			this.t = tipus;
		}
	}
	
	//Descompte 
	public int descompte() {
		if (cilindrada <= 125) {
			int descompte = km / 5000 * 2;
			if (descompte >= 20) {
				return 20;
			}
			return descompte;
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
	           "\n  Cilindrada = " + cilindrada +
	           "\n  Tipus      = " + t;
	}
}