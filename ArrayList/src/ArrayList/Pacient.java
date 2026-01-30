package ArrayList;

public class Pacient extends Persona {

	private String historialMedic;

	// CONSTRUCTOR
	public Pacient(String nom, String dni, String historialMedic) {
		super(nom, dni);
		this.historialMedic = historialMedic;
	}

	// SETTERS I GETTERS
	public String getHistorialMedic() {
		return historialMedic;
	}

	public void setHistorialMedic(String historialMedic) {
		this.historialMedic = historialMedic;
	}

	/*// INFORMACIÓ
	@Override
	public String toString() {
		return "Pacient [historialMedic=" + historialMedic + "]";
	}*/

}