package ClinicaMedica;

import java.time.LocalDate;
import java.util.Objects;

public class Doctor extends Persona {

	private Especialitat especialitat;
	private int codi;
	private int totalDocs = 0;

	public Doctor(String nom, String dni, LocalDate dnaix, String telefon, Especialitat especialitat) {
		super(nom, dni, dnaix, telefon);
		this.especialitat = especialitat;
		codi = totalDocs + 1;
		totalDocs++;
	}

	public Especialitat getEspecialitat() {
		return especialitat;
	}

	public void setEspecialitat(Especialitat especialitat) {
		this.especialitat = especialitat;
	}

	public int getCodi() {
		return codi;
	}

	public void setCodi(int codi) {
		this.codi = codi;
	}

	public int getTotalDocs() {
		return totalDocs;
	}

	public void setTotalDocs(int totalDocs) {
		this.totalDocs = totalDocs;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codi, especialitat);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Doctor other = (Doctor) obj;
		return codi == other.codi && Objects.equals(especialitat, other.especialitat);
	}

	@Override
	public String toString() {
		return "Doctor [especialitat=" + especialitat + ", codi=" + codi + ", totalDocs=" + totalDocs + ", nom=" + nom
				+ ", dni=" + dni + ", dnaix=" + dnaix + ", telefon=" + telefon + "]";
	}

}
