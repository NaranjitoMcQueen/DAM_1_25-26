package CompteBancari;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Compte {

	private String iban;
	private double saldo;
	private double descobert;
	private Client titular;
	private LocalDate dataApertura;

	private static double interesAnual = 1.5;
	private static int totalComptes = 0;

	public static final int MAX_NUM_COMPTES = 1000;

	// COMPTES
	public static int getTotalComptes() {
		return totalComptes;
	}

	// CONSTRUCTOR
	public Compte(String iban, double saldo, double descobert, Client titular, String dataApertura) {
		if (!esIbanValid(iban)) {
			throw new IllegalArgumentException("IBAN no vàlid");
		}
		if (totalComptes >= MAX_NUM_COMPTES) {
			throw new IllegalStateException("S'ha superat el nombre màxim de comptes");
		}
		this.iban = iban;
		this.saldo = saldo;
		this.descobert = descobert;
		this.titular = titular;
		DateTimeFormatter fd1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate d1 = LocalDate.parse(dataApertura, fd1);
		this.dataApertura = d1;
		totalComptes++;
	}

	// IBAN
	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		if (!esIbanValid(iban)) {
			throw new IllegalArgumentException("IBAN no vàlid");
		}
		this.iban = iban;
	}

	public static boolean esIbanValid(String iban) {
		return iban != null && iban.startsWith("ES") && iban.length() == 24;
	}

	// SALDO
	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void ingressar(double quantitat) {
		if (quantitat <= 0) {
			throw new IllegalArgumentException("Quantitat no vàlida");
		}
		saldo += quantitat;
	}

	public void retirar(double quantitat) {
		if (quantitat <= 0) {
			throw new IllegalArgumentException("Quantitat no vàlida");
		}
		if (saldo - quantitat < -descobert) {
			throw new IllegalArgumentException("Supera el límit de descobert");
		}
		saldo -= quantitat;
	}

	public void transferir(Compte desti, double quantitat) {
		if (quantitat <= 0) {
			throw new IllegalArgumentException("Quantitat no vàlida");
		}
		if (saldo - quantitat < -descobert) {
			throw new IllegalArgumentException("Supera el límit de descobert");
		}
		this.saldo -= quantitat;
		desti.saldo += quantitat;
	}

	// DESCOBERT
	public double getDescobert() {
		return descobert;
	}

	public void setDescobert(double descobert) {
		if (descobert < 0) {
			throw new IllegalArgumentException("El descobert no pot ser negatiu");
		}
		this.descobert = descobert;
	}

	// CLIENT
	public Client getTitular() {
		return titular;
	}

	public void setTitular(Client titular) {
		this.titular = titular;
	}

	public String getDniTitular() {
		String DniTitular = titular.getDni();
		return DniTitular;
	}

	// DATA
	public LocalDate getDataApertura() {
		return dataApertura;
	}

	public void setDataApertura(LocalDate dataApertura) {
		this.dataApertura = dataApertura;
	}

	// INTERÉS
	public static double getInteresAnual() {
		return interesAnual;
	}

	// BANC
	/*public String getBanc() {
		String codi = iban.substring(4, 8);
		switch (codi) {
		case "0182":
			return "BBVA";
		case "0081":
			return "Banco Sabadell";
		case "0049":
			return "Banco Santander";
		case "0128":
			return "Bankinter";
		case "2100":
			return "Caixabank";
		case "0019":
			return "Deutsche Bank";
		case "1465":
			return "ING";
		default:
			return "Banc desconegut";
		}
	}*/
	
	public String getNomBanc() {
		String codi = iban.substring(4, 8);
		String[][] bancos = { // [2][7] = [i][j]
			    {"0182", "BBVA"},
			    {"0081", "Banc de Sabadell"},
			    {"0049", "Banco Santander"},
			    {"0128", "Bankinter"},
			    {"2100", "Caixabank"},
			    {"0019", "Deutsche Bank"},
			    {"1465", "ING Bank NV"}
			};
		int i = 0;
		boolean coincide = false;
		while (i != 7 && !coincide) {
			if (bancos[i][0].equals(codi)) return bancos[i][1];
			i++;
		}
		return iban;
	}

	// INFORMACIÓ
	public String getInfo() {
		return "COMPTE [IBAN: " + iban + "] \nSALDO: " + saldo + ", DESCOBERT: " + descobert + " \nTITULAR: " + titular
				+ " \nDATA APERTURA: " + dataApertura;
	}

}