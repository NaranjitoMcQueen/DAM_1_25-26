package Hospital;

import java.time.LocalDate;

public class Doctor extends Persona{

	private Especialitat especialitat;
	private int codi;
	private int totalDoctors;
	private static int contadorCodiDoctors = 1;
	private static int contadorTotalDoctors = 1;
	
	// CONSTRUCTOR
	public Doctor(String nom, String dni, String dataNaixement, String telefon, Especialitat especialitat, int codi,
			int totalDoctors) {
		super(nom, dni, dataNaixement, telefon);
		this.especialitat = especialitat;
		this.codi = contadorCodiDoctors++;
		this.totalDoctors = contadorTotalDoctors++;
	}

	// Especialitat
	public Especialitat getEspecialitat() {
		return especialitat;
	}

	public void setEspecialitat(Especialitat especialitat) {
		this.especialitat = especialitat;
	}

	// COID DOC
	public int getCodi() {
		return codi;
	}

	public void setCodi(int codi) {
		this.codi = codi;
	}

	// TOTAL DOC
	public int getTotalDoctors() {
		return totalDoctors;
	}

	public void setTotalDoctors(int totalDoctors) {
		this.totalDoctors = totalDoctors;
	}

	// INFO
	@Override
	public String toString() {
		return "Doctor " + nom + " Especialitat: " + especialitat.getNom() + " Codi: " + codi + " T.Doctors: " + totalDoctors;
	}
}