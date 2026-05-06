package gimnas;

public class Entrenador extends Persona {

	private String especialitat;

	public Entrenador(String dni, String nom, String cognoms, String telefon, String dataNaixement, String especialitat)
			throws InvalidDniException {
		super(dni, nom, cognoms, telefon, dataNaixement);
		this.especialitat = especialitat;
	}

	public void setEspecialitat(String especialitat) {
		this.especialitat = especialitat;
	}

	public String getEspecialitat() {
		return especialitat;
	}

	@Override
	public String toString() {
		return "Entrenador [especialitat=" + especialitat + "]";
	}

}
