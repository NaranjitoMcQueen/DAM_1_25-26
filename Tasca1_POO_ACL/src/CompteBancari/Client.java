package CompteBancari;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Client {

	private String dni;
	private String nom;
	private String adreça;
	private int telefon;
	private LocalDate dataNaixement;

	public Client(String dni, String nom, String adreça, int telefon, String dataNaixement) {
		if (!esDniValid(dni)) {
			throw new IllegalArgumentException("DNI no vàlid");
		}
		this.dni = dni;
		this.nom = nom;
		this.adreça = adreça;
		this.telefon = telefon;
		try {
			DateTimeFormatter formatd1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate d1 = LocalDate.parse(dataNaixement, formatd1);
			this.dataNaixement = d1;
        } catch (Exception e) {
            System.out.println("Format de la data incorrecte" + e.getMessage());
            }
	}

	// DNI
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		if (!esDniValid(dni)) {
			throw new IllegalArgumentException("DNI no vàlid");
		}
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

	// NOM
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	// ADREÇA
	public String getAdreça() {
		return adreça;
	}

	public void setAdreça(String adreça) {
		this.adreça = adreça;
	}

	// TELEFON
	public int getTelefon() {
		return telefon;
	}

	public void setTelefon(int telefon) {
		this.telefon = telefon;
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

	// INFO
	@Override
	public String toString() {
		return "CLIENT DNI: " + dni + ", NOM: " + nom + " \nADREÇA: " + adreça + ", TELÉFON: " + telefon + " \nDATA NAIXEMENT: " + dataNaixement;
	}
}
