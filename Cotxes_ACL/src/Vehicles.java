
public abstract class Vehicles implements Comparable<Vehicles>{

	protected String matricula;
	protected int km;
	protected String marca;
	protected String model;
	protected String color;

	//Ordenar per tipus (cotxe o moto), marca i model, en comptes de matricula.
	public Vehicles(String matricula, int km, String marca, String model, String color) throws Exception {
		super();
		if (valMatricula(matricula)) {
			this.matricula = matricula;
		} else
			throw new Exception("Format incorrecte de matricula.");
		if (valKm(km)) {
			this.km = km;
		} else
			throw new Exception("Els kilometres son inferior a zero o negatius.");
		this.marca = marca;
		this.model = model;
		this.color = color;
	}

	// Matricula
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public static boolean valMatricula(String matricula) {
	    // Format antic: [A-Z]{1,2}-\d{4}-[A-Z]{1,2}
	    String esquemaMatrAnt = "^([A-Z]{1,2})-\\d{4}-[A-Z]{1,2}$";
	    // Format modern: \d{4}-[BCDFGHJKLMNPRSTVWXYZ]{3}
	    String esquemaMatr = "^\\d{4}-[BCDFGHJKLMNPRSTVWXYZ]{3}$";

	    if (matricula.matches(esquemaMatr) || matricula.matches(esquemaMatrAnt)) {
	        return true;
	    }
	    return false;
	}

	// KM
	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}
	
	public static boolean valKm (int km) {
		if (km < 0) {
			return false;
		}
		return true;
	}
	
	// Descompte per KM
	public int descompte() {
		int descompte = km/10000;
		if (descompte > 10) {
			descompte = 10;
		}
		return descompte;
	}

	// Marca
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

    @Override
    public int compareTo(Vehicles comp) {
    	// Ordenació:
    	// Per Tipus
    	int compararTipus = this.getClass().getSimpleName().compareTo(comp.getClass().getSimpleName());
    	if (compararTipus != 0) return compararTipus;
    	
        // Per Marca
        int compararMarca = this.marca.compareToIgnoreCase(comp.marca);
        if (compararMarca != 0) return compararMarca;

        // Per Model
        int compararModel = this.model.compareToIgnoreCase(comp.model);
        if (compararModel != 0) return compararModel;
        
    	return this.matricula.compareTo(comp.getMatricula());
    }
	
    @Override
    public String toString() {
        return "\nVehicle:" +
               "\n  Matricula = " + matricula +
               "\n  KM        = " + km +
               "\n  Marca     = " + marca +
               "\n  Model     = " + model +
               "\n  Color     = " + color;
    }

}
