import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {

		// TreeSet sense repetit i ordenat
		// HashSet sense repetit pero desordenat

		try {
			// Concessionari
			Concessionaris conce = new Concessionaris("Carrer Major 25", new TreeSet<>());

			// Cotxes
			Cotxes c1 = new Cotxes("1234-BCD", 50000, "Toyota", "Land Cruiser", "Blanc", 5, false);
			Cotxes c2 = new Cotxes("5678-FGH", 80000, "Ford", "Raptor", "Negre", 5, true);
			Cotxes c3 = new Cotxes("9101-PRS", 20000, "BMW", "X5", "Gris", 7, true);
			Cotxes c4 = new Cotxes("1122-TVW", 30000, "Audi", "Q7", "Negre", 7, false);
			Cotxes c5 = new Cotxes("3344-XYZ", 10000, "Volkswagen", "Tiguan", "Blau", 5, true);

			// Motos
			Motos m1 = new Motos("4321-XYZ", 50000, "Yamaha", "R1", "Blau", 1000, Motos.tipus.ESPORTIVA);
			Motos m2 = new Motos("8765-TRW", 15000, "Honda", "CB500", "Vermell", 500, Motos.tipus.NAKED);
			Motos m3 = new Motos("1023-LMN", 10000, "Kawasaki", "Ninja ZX-6R", "Verd", 600, Motos.tipus.ESPORTIVA);
			Motos m4 = new Motos("5647-HJK", 15000, "Suzuki", "GSX-S750", "Blanc", 750, Motos.tipus.NAKED);
			Motos m5 = new Motos("8910-DFG", 10000, "Ducati", "Monster 801", "Negre", 125, Motos.tipus.TURISME);

			// Afegir vehicles a concessionari
			conce.afegirVehicle(c1);
			conce.afegirVehicle(c2);
			conce.afegirVehicle(c3);
			conce.afegirVehicle(c4);
			conce.afegirVehicle(c5);
			conce.afegirVehicle(m1);
			conce.afegirVehicle(m2);
			conce.afegirVehicle(m3);
			conce.afegirVehicle(m4);
			conce.afegirVehicle(m5);

			// Esborrar per veh i mat
			conce.treureVehicle(c3);
			conce.treureVehicleMatricula("8910-GHI");
			
			// Descompte
			System.out.println("\nDescompte del vehicle: " + c1.getModel() + ": " + c1.descompte());
			System.out.println("Descompte del vehicle: " + c2.getModel() + ": " + c2.descompte());
			System.out.println("Descompte del vehicle: " + m1.getModel() + ": " + m1.descompte());
			System.out.println("Descompte del vehicle: " + m5.getModel() + ": " + m5.descompte());
			
			// Nombre de vehicles
			System.out.println("\nNombre total de vehicles: " + conce.totalVeh());
			System.out.println("\nLlista de vehicles:" + conce.llistaVehicles());

			// Mitjana
			System.out.println("\nMitjana km: " + conce.mitjanaKm());
			
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}