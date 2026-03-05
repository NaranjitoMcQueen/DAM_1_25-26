package vehiclesBase;

import java.util.TreeSet;

public class Concessionari {

	final static int NMAX = 100;
	private String adreça;
	private TreeSet<Vehicle> ConceVeh = new TreeSet<>();

	public Concessionari(String adreça, TreeSet<Vehicle> conceVeh) {
		super();
		this.adreça = adreça;
		ConceVeh = conceVeh;
	}

	public Concessionari(String adreça) {
		this.adreça = adreça;
	}

	public String getAdreça() {
		return adreça;
	}

	public void setAdreça(String adreça) {
		this.adreça = adreça;
	}

	public boolean afegirVehicle(Vehicle v) {
		if (ConceVeh.size() >= NMAX) {
			return false;
		}
		return ConceVeh.add(v);
	}

	public int nombreVehicles() {
		int num = ConceVeh.size();
		return num;
	}

	public void mostrarVehicles() {
		String LlistaCotxes = "Cotxes: ";
		String LlistaMotos = "Motos: ";

		for (Vehicle v : ConceVeh) {
			if (v instanceof Cotxe) {
				LlistaCotxes = LlistaCotxes + "\n" + v.toString();
			} else if (v instanceof Moto) {
				LlistaMotos = LlistaMotos + "\n" + v.toString();
			}
		}
		System.out.println("Llista:\n" + LlistaCotxes + "\n" + LlistaMotos);
	}

	@Override
	public String toString() {
		return "Concessionari [adreça=" + adreça + ", veh=" + ConceVeh + "]";
	}

	public double mitjanaKm() {
		double mitjana = 0;
		for (Vehicle v : ConceVeh) {
			mitjana += v.getKm();
		}
		return mitjana / ConceVeh.size();
	}

	/*public boolean eliminarVehicle(Vehicle v) {
	    return ConceVeh.remove(v);
	}*/
	
	public boolean eliminarVehicle(String matricula, Vehicle v) {
	    for (Vehicle v : ConceVeh) {
	        if (v.getMatricula().equals(matricula)) {
	            ConceVeh.remove(v);
	            return true;
	        }
	    }
	    return false;
	}

}