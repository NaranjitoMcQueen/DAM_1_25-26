package FitxersACL;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;
import java.util.TreeSet;

public class GestorFitxerCSV extends GestorFitxer implements InterficieGestorFitxer {

	@Override
	public Set<Vehicle> llegir(String nomFitxer) throws Exception {
		File fitxer = new File(nomFitxer);
		Set<Vehicle> veh = new TreeSet<>();

		try (BufferedReader br = new BufferedReader(new FileReader(nomFitxer))) {
			String linia;
			while ((linia = br.readLine()) != null) {
				Vehicle v = toVehicle(linia);
				if (v != null) {
					veh.add(v);
				}
			}
			return veh;
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public void desa(String nomFitxer, Set<Vehicle> vehicles) {
		try (PrintWriter pw = new PrintWriter(new FileWriter(nomFitxer))) {
			for (Vehicle v : vehicles) {
				// ENUNCIAT: Utilitzar mètode que converteix vehicle a String
				pw.println(toCSV(v));
			}
		} catch (IOException e) {
			System.out.println("Error en desar: " + e.getMessage());
		}
	}

}
