package Hospital;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class Pacient extends Persona {

	private String codi;
	private String historialMedic;
	private int totalPacients;
	private static int contadorPacients = 1;

	// CONSTRUCTOR AMB PARAMETRES
	public Pacient(String nom, String dni, String dataNaixement, String telefon, String codi) {
		super(nom, dni, dataNaixement, telefon);
		if (!esCodiValid(codi)) {
			throw new IllegalArgumentException("Codi no vàlid");
		}
		this.codi = codi;
		this.totalPacients = contadorPacients++;
	}

	// CONSTRUCTOR PER DEFECTE
	public Pacient(String nom, String dni, String dataNaixement, String telefon, String codi, String historialMedic,
			int totalPacients) {
		super(nom, dni, dataNaixement, telefon);
		this.codi = codi;
		this.historialMedic = historialMedic;
		this.totalPacients = contadorPacients++;
	}

	// CODI PACIENT
	public String getCodi() {
		return codi;
	}

	public void setCodi(String codi) {
		this.codi = codi;
	}

	public boolean esCodiValid(String codi) {
		if (codi == null || codi.length() != 11)
			return false;
		return Pattern.matches("[A-Z]{3}[0-9]{8}", codi) == true;
	}


	// HISTORIAL MÈDIC
	public String getHistorialMedic() {
		return historialMedic;
	}

	public void setHistorialMedic(String historialMedic) {
		this.historialMedic = historialMedic;
	}

	// TOTAL PACIENTS
	public int getTotalPacients() {
		return contadorPacients;
	}

	public void setTotalPacients(int totalPacients) {
		this.totalPacients = totalPacients;
	}

	// INFO
	@Override
	public String toString() {
		return "Pacient Codi: " + codi + " Nom: " + nom + " DNI: " + dni + " D.Naixement: " + dataNaixement + " TLF: " + telefon + " Historial Mèdic: " + historialMedic + " Total Pacients: " + totalPacients;
	}
	
}