package FitxersACL;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class GestorFitxer implements InterficieGestorFitxer {

	// LLEGIR

	public static int llegirFitxer(String nomFitxer) throws FileNotFoundException, IOException {
		File fitxer = new File(nomFitxer);
		int total = 0;
		String linia;

		// TRY-WITH-RESOURCES: Tanca automàticament el BufferedReader en acabar
		// FileReader Llegeix caràcters directament del fitxer físic.
		// BufferedReader Agrupa caràcters en memòria per eficiència.
		try (BufferedReader br = new BufferedReader(new FileReader(fitxer))) {

			// Bucle de lectura: llegim línia a línia fins que readLine() retorna null
			// perquè no hi ha més
			while ((linia = br.readLine()) != null) {
				try {
					// Conversió a int: trim() elimina espais en blanc residuals
					total += Integer.parseInt(linia.trim());
				} catch (NumberFormatException e) {
					System.out.println("Error: La línia '" + linia + "' no és un número enter vàlid.");
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Fitxer innexistent");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return total;
	}

	@Override
	public Set<Vehicle> llegir(String nomFitxer) throws Exception {
		File fitxer = new File(nomFitxer);
		Set<Vehicle> veh = new TreeSet<>();

		if (!fitxer.exists())
			return veh;

		try (BufferedReader br = new BufferedReader(new FileReader(fitxer))) {
			String linia;
			while ((linia = br.readLine()) != null) {
				linia = linia.trim();
				if (linia.isEmpty() || linia.startsWith("#")) {
					continue;
				}
				try {
					Vehicle v = toVehicle(linia);
					if (v != null)
						veh.add(v);
				} catch (Exception e) {
					System.out.println("Error processant línia: " + linia + " -> " + e.getMessage());
				}
			}
			return veh;
		}
	}

	/*
	 * El segon paràmetre del constructor de FileWriter (append) és un valor booleà
	 * que serveix per indicar com s’ha d’escriure al fitxer.
	 * 
	 * fWriter = new FileWriter("nom_fitxer.txt", append);
	 * 
	 * Si append és true, el programa afegeix el text nou al final del fitxer sense
	 * esborrar el contingut que ja hi havia. En canvi, si és false, el fitxer es
	 * sobrescriu, és a dir, s’elimina el contingut anterior i es comença a escriure
	 * des del principi.
	 */

	// ESCRIURE

	public static boolean escriureFitxer(String nomFitxer, Scanner sc) {
		try (PrintWriter pr = new PrintWriter(new FileWriter(nomFitxer))) {

			int total = 0;
			String linia;

			System.out.println("Introdueix textos (escriu 'fi' per acabar):");

			while (true) {
				linia = sc.nextLine();
				// Control de sortida: Ús de .equals() per comparar contingut d'Strings, no '=='
				if ("fi".equals(linia)) {
					break;
				}

				// REGEX: \\s+ detecta un o més espais en blanc (tabuladors, espais, etc.)
				String[] paraules = linia.trim().split("\\s+");

				// OPERADOR TERNARI: Condició ? cert : fals
				// isBlank(): Comprova si l'String és buit o només conté espais
				int numParaulesLinia = (linia.isBlank()) ? 0 : paraules.length;
				total += numParaulesLinia;
				pr.println(linia + " (Té " + numParaulesLinia + " paraules)");
			}

			pr.println("Total de paraules: " + total);
			return true;

		} catch (Exception e) {
			System.out.println("Error en l'escriptura, revisar-ho: " + e.getMessage());
			return false;
		}
	}

	// DESAR

	public String toCSV(Vehicle v) {
		return v.toString();
	}

	@Override
	public void desa(String nomFitxer, Set<Vehicle> vehicles) {
		// Usem try-with-resources per assegurar que el fitxer es tanca
		try (PrintWriter pw = new PrintWriter(new FileWriter(nomFitxer))) {
			for (Vehicle veh : vehicles) {
				// Cridem al mètode toCSV que ja tens creat
				pw.println(toCSV(veh));
			}
		} catch (IOException e) {
			System.out.println("Error en l'escriptura del CSV: " + e.getMessage());
		}
	}

	// REVISAR I CLASSIFICAR

	public Vehicle toVehicle(String linia) throws Exception {
		// SPLIT per delimitador: El ";" separa els camps del fitxer CSV/Text
		String[] info = linia.trim().split(";");

		// NETEJA DE DADES: Trim de cada element de l'array per evitar errors de parsing
		for (int i = 0; i < info.length; i++) {
			info[i] = info[i].trim();
		}

		// Si no és cotxe NI és moto, retornem null.
		if (!"cotxe".equals(info[0]) && !"moto".equals(info[0])) {
			return null;
		}

		String matricula = info[1];
		int km = Integer.parseInt(info[2]);
		String marca = info[3];
		String model = info[4];
		String color = info[5];

		if ("cotxe".equals(info[0])) {
			int numPortes = Integer.parseInt(info[6]);
			boolean esAutomatic = Boolean.parseBoolean(info[7]);

			Cotxe ctx = new Cotxe(matricula, km, marca, model, color, numPortes, esAutomatic);
			return ctx;

		} else if ("moto".equals(info[0])) {
			int cilindrada = Integer.parseInt(info[6]);
			TipusMoto tipus = TipusMoto.valueOf(info[7]);

			Moto mt = new Moto(matricula, km, marca, model, color, cilindrada, tipus);
			return mt;
		} else {
			return null;
		}
	}

	// MOSTRAR AMB EL FORMAT DE SEPARACIONS

	public static void mostrarVehicles(Set<Vehicle> llista) {
		if (llista == null || llista.isEmpty()) {
			System.out.println("La llista és buida.");
			return;
		}
		for (Vehicle veh : llista) {
			String tipus = (veh instanceof Cotxe) ? "(Cotxe)" : "(Moto) ";
			String base = String.format(
					"%-8s Matrícula: %-9s | Marca: %-10s | Model: %-10s | Color: %-10s | Km: %8d | ", tipus,
					veh.getMatricula(), veh.getMarca(), veh.getModel(), veh.getColor(), veh.getKm());

			if (veh instanceof Cotxe c) {
				String canvi = c.isEsAutomatic() ? "automàtic" : "manual   ";
				System.out.println(base + String.format("%-10s | numPortes: %d", canvi, c.getNumPortes()));
			} else if (veh instanceof Moto m) {
				System.out.println(base + String.format("%-10s | %s", m.getCilindrada() + " cc", m.getTipus()));
			}
		}
	}

	// Afegir a Vehicle

	public static Vehicle afegirVehicle(String tipus, String matricula, int km, String marca, String model,
			String color, int especific1, String especific2) throws MatriculaInvalidaException {

		if ("cotxe".equalsIgnoreCase(tipus)) {
			boolean auto = Boolean.parseBoolean(especific2);
			return new Cotxe(matricula, km, marca, model, color, especific1, auto);

		} else if ("moto".equalsIgnoreCase(tipus)) {
			TipusMoto tm = TipusMoto.valueOf(especific2.toUpperCase().trim());
			return new Moto(matricula, km, marca, model, color, especific1, tm);
		}

		return null;
	}

	// Cercar amb més KM

	public static Cotxe mesKM(Set<Vehicle> llista) {
		if (llista == null || llista.isEmpty()) {
			return null;
		}
		Cotxe meskm = null;
		for (Vehicle v : llista) {
			if (v instanceof Cotxe c) {
				if (meskm == null || c.getKm() > meskm.getKm()) {
					meskm = c;
				}
			}
		}
		return meskm;
	}

	public static boolean eliminarVehicle(Set<Vehicle> llista, String matricula) {
		if (llista == null || llista.isEmpty() || matricula == null) {
			return false;
		}
		Iterator<Vehicle> iterator = llista.iterator();

		while (iterator.hasNext()) {
			Vehicle v = iterator.next();

			if (v.getMatricula().equalsIgnoreCase(matricula.trim())) {
				iterator.remove();
				return true;
			}
		}
		return false;
	}

}
