package Hospital;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Persona {
	protected String nom;
	protected String dni;
	protected LocalDate dataNaixement;
	protected String telefon;

	// CONSTRUCTOR
	public Persona(String nom, String dni, String dataNaixement, String telefon) {
		super();
		if (!esDniValid(dni)) {
			throw new IllegalArgumentException("DNI no vàlid");
		}
		this.nom = nom;
		this.dni = dni;
		this.telefon = telefon;
		try {
			DateTimeFormatter formatd1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate d1 = LocalDate.parse(dataNaixement, formatd1);
			this.dataNaixement = d1;
        } catch (Exception e) {
            System.out.println("Format de la data incorrecte" + e.getMessage());
            }
	}

	// NOM
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	// DNI
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public static boolean esDniValid(String dni) {
		if (dni == null || dni.length() != 9)
			return false;
		int num = Integer.parseInt(dni.substring(0, 8));
		char lletra = dni.charAt(8);
		String lletres = "TRWAGMYFPDXBNJZSQVHLCKE";
		return lletres.charAt(num % 23) == lletra;
	}

	// DATA NAIXEMENT
	public LocalDate getDataNaixement() {
		return dataNaixement;
	}

	public void setDataNaixement(LocalDate dataNaixement) {
		this.dataNaixement = dataNaixement;
	}

	public int getEdat() {
		LocalDate avui = LocalDate.now();
		LocalDate dataNaix = dataNaixement;
		
		int anyNaixement = dataNaix.getYear();
		int anyAvui = avui.getYear();
	
		int edat = anyAvui - anyNaixement;
		
		int diaNaixement = dataNaix.getDayOfYear();
		int dia = avui.getDayOfYear();
		if (dia < diaNaixement) edat--;
		
		return edat;
	}
	
	// TELÈFON
	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	// INFO
	@Override
	public String toString() {
		return "Persona [nom=" + nom + ", dni=" + dni + ", dataNaixement=" + dataNaixement + ", telefon=" + telefon
				+ "]";
	}
}