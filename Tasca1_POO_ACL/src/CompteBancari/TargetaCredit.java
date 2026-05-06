package CompteBancari;

public class TargetaCredit extends Targeta{

	private double credit;
	private double limitMensual;
	
	public TargetaCredit(String numero, Compte compte, Double limit, double credit, double limitMensual) {
		super(numero, compte, limit);
		this.credit = credit;
		this.limitMensual = limitMensual;
	}

	// CREDIT I PAGAMENT
	public double getCredit() {
		return credit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	}

	public double pagament(double despesa) {
		if (despesa > limitMensual) {
			throw new IllegalArgumentException("No pots superar el limit");
		}
		if (despesa > credit) {
			throw new IllegalArgumentException("No pots superar el credit restant");
		}
		credit = credit - despesa;
		return credit;
	}
	
	// LIMIT
	public double getLimitMensual() {
		return limitMensual;
	}

	public void setLimitMensual(double limitMensual) {
		this.limitMensual = limitMensual;
	}
}
