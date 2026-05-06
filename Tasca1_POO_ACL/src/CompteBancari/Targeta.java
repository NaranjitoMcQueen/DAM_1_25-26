package CompteBancari;

public class Targeta {
	
	protected String numero;
	protected Compte compte;
	protected Double limit;
	
	public Targeta(String numero, Compte compte, Double limit) {
		super();
		this.numero = numero;
		this.compte = compte;
		this.limit = limit;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public Double getLimit() {
		return limit;
	}

	public void setLimit(Double limit) {
		this.limit = limit;
	}

	@Override
	public String toString() {
		return "Targeta [numero=" + numero + ", compte=" + compte + ", limit=" + limit + "]";
	}
}
