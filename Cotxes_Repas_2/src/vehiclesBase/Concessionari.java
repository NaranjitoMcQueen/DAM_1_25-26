package vehiclesBase;

import java.util.TreeSet;

public class Concessionari {

	private String adreça;
	private TreeSet<Vehicle> ConceVeh = new TreeSet<>();
	final static int NMAX = 50;

	public Concessionari(String adreça) {
		super();
		this.adreça = adreça;
	}

	public String getAdreça() {
		return adreça;
	}

	public void setAdreça(String adreça) {
		this.adreça = adreça;
	}

	public TreeSet<Vehicle> getConceVeh() {
		return ConceVeh;
	}

	public void setConceVeh(TreeSet<Vehicle> conceVeh) {
		ConceVeh = conceVeh;
	}

	public boolean afegirVehicle(Vehicle v) {
		if (ConceVeh.size() == NMAX) {
			return false;
		}
		return ConceVeh.add(v);
	}

	public int nombreVehicles() {
		return ConceVeh.size();
	}

	public void mostrarVehicles() {
		String LlistaC = "Cotxe: ";
		String LlistaM = "Moto: ";

		for (Vehicle v : ConceVeh) {
			if (v instanceof Cotxe) {
				LlistaC = LlistaC + "\n" + v.toString();
			} else if (v instanceof Moto) {
				LlistaM = LlistaM + "\n" + v.toString();
			}
		}
		System.out.println("Llista:\n" + LlistaC + "\n" + LlistaM);
	}
}
