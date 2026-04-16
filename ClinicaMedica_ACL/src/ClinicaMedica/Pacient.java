package ClinicaMedica;

import java.time.LocalDate;
import java.util.Objects;
import java.util.regex.Pattern;

public class Pacient extends Persona {

	private String codi;
	private String historialMedic;
	private static int totalPacients = 0;

	public Pacient(String nom, String dni, LocalDate dnaix, String telefon, String codi, String historialMedic)
			throws InvalidCodiPacientException {
		super(nom, dni, dnaix, telefon);
		if (valCodi(codi)) {
			this.codi = codi;
			this.historialMedic = historialMedic;
			totalPacients++;
		} else {
			throw new InvalidCodiPacientException("El codi " + codi + " no és vàlid.");
		}
	}

	public Pacient() {
	}

	// Codi
	public String getCodi() {
		return codi;
	}

	public void setCodi(String codi) {
		this.codi = codi;
	}

	public static boolean valCodi(String codi) {
		if (codi == null || codi.length() != 11) {
			return false;
		}
		String esquemaCodi = "^[A-Z]{3}\\d{8}$";
		return codi.matches(esquemaCodi);
	}

	// Telèfon
	public static boolean valTelefon(String phone) {
		if (phone == null) {
			return true;
		}
		String esquemaTlf1 = "^6\\d{8}$";
		String esquemaTlf2 = "^9\\d{8}$";
		if (Pattern.matches(esquemaTlf1, phone) || Pattern.matches(esquemaTlf2, phone)) {
			return true;
		}
		return false;
	}

	// Historial Medic
	public String getHistorialMedic() {
		return historialMedic;
	}

	public void setHistorialMedic(String historialMedic) {
		this.historialMedic = historialMedic;
	}

	// Total Pacients
	public int getTotalPacients() {
		return totalPacients;
	}

	public void setTotalPacients(int totalPacients) {
		this.totalPacients = totalPacients;
	}

	// Revisió
	@Override
	public int hashCode() {
		return Objects.hash(codi);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pacient other = (Pacient) obj;
		return Objects.equals(codi, other.codi);
	}

	@Override
	public String toString() {
		return "Pacient [codi=" + codi + ", historialMedic=" + historialMedic + ", totalPacients=" + totalPacients
				+ ", nom=" + nom + ", dni=" + dni + ", dnaix=" + dnaix + ", telefon=" + telefon + "]";
	}
}
