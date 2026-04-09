package ClinicaMedica;

public class InvalidCodiPacientException extends Exception {

	public InvalidCodiPacientException() {
		super("El codi és incorrecte.");
	}

	public InvalidCodiPacientException(String missatge) {
		super(missatge);
	}
}
