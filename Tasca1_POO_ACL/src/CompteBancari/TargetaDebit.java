package CompteBancari;

public class TargetaDebit extends Targeta{

	// CONSTRUCTOR
	public TargetaDebit(String numero, Compte compte, Double limit) {
		super(numero, compte, limit);
	}

	// PAGAMENT
	public String pagament(double despesa) {
		double saldo = compte.getSaldo();
		if (despesa > saldo) {
			throw new IllegalArgumentException("No hi ha suficient diners");
		}
		compte.setSaldo(saldo-despesa);
		return ("S'ha descomptat " + despesa);
	}
}
