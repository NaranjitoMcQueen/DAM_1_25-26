package FitxersACL;

public class MatriculaInvalidaException extends Exception {

	public MatriculaInvalidaException() {
		super("El format o la propia matricula hi son incorrectes.");
	}
}
