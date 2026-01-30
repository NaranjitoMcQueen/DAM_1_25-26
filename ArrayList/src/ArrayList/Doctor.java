package ArrayList;

public class Doctor extends Persona {

	private String especialitat;

	// CONSTRUCTOR
	public Doctor(String nom, String dni, String especialitat) {
		super(nom, dni);
		this.especialitat = especialitat;
	}

	// SETTERS I GETTERS
	public String getEspecialitat() {
		return especialitat;
	}

	public void setEspecialitat(String especialitat) {
		this.especialitat = especialitat;
	}

	/*// INFORMACIÓ
	@Override
	public String toString() {
		return "Doctor [especialitat=" + especialitat + "]";
	}*/

}
