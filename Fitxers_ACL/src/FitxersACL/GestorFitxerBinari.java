package FitxersACL;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Set;
import java.util.TreeSet;

public class GestorFitxerBinari extends GestorFitxer implements InterficieGestorFitxer {

	@Override
	public Set<Vehicle> llegir(String nomFitxer) throws Exception {
		File fitxer = new File(nomFitxer);
		Set<Vehicle> veh = new TreeSet<>();

		try (ObjectInputStream fileIn = new ObjectInputStream(new FileInputStream(nomFitxer))) {
			return (Set<Vehicle>) fileIn.readObject();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public void desa(String nomFitxer, Set<Vehicle> vehicles) {
		try (ObjectOutputStream fileOut = new ObjectOutputStream(new FileOutputStream(nomFitxer))) {
			fileOut.writeObject(vehicles);
		} catch (IOException e) {
			System.out.println("Error en desar: " + e.getMessage());
		}
	}

}
