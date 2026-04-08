package FitxersACL;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class main {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		File file = new File("fitxer.txt");
		GestorFitxer gf = new GestorFitxer();
		Set<Vehicle> v = new TreeSet<>();
		String nomFitxer;

		if (file.exists()) {
			System.out.println("El fitxer existeix");
		} else {
			System.out.println("El fitxer NO existeix, el creem");
			file.createNewFile();
		}

		System.out.println("Path: " + file.getPath());
		System.out.println("Path absolut: " + file.getAbsolutePath());
		System.out.println("Última modificació: " + new Date(file.lastModified()));
		System.out.println("Longitud: " + file.length() + " bytes");

		// Verificació de permisos
		if (file.canExecute())
			System.out.println("Permís d'execució: SÍ");
		else
			System.out.println("Permís d'execució: NO");

		if (file.canRead())
			System.out.println("Permís de lectura: SÍ");
		else
			System.out.println("Permís de lectura: NO");

		if (file.canWrite())
			System.out.println("Permís d'escriptura: SÍ");
		else
			System.out.println("Permís d'escriptura: NO");

		File dir = new File("Directori");
		if (dir.exists()) {
			System.out.println("\nEl directori '" + dir.getName() + "' existeix");
		} else {
			System.out.println("\nEl directori NO existeix, el creem");
			dir.mkdir();
		}

		// Llistar contingut del directori
		String[] fitxers = dir.list();
		if (fitxers != null) {
			for (String f : fitxers) {
				System.out.println("Contingut de la carpeta: " + f);
			}
		}
		/*
		 * // Activitat Fitxers: Excercici 1: Llegir fitxer
		 * System.out.println("<<<<<<<<<< Excercici 1 >>>>>>>>>>");
		 * System.out.print("Introdueix el nom del fitxer:"); nomFitxer = sc.nextLine();
		 * // nomFitxer = "nombres.txt";
		 * 
		 * int sumaTotal = GestorFitxer.llegirFitxer(nomFitxer);
		 * System.out.println("---------------------------");
		 * System.out.println("La suma total dels enters és: " + sumaTotal);
		 * 
		 * // Activitat Fitxers: Excercici 2: Escriure fitxer
		 * System.out.println("<<<<<<<<<< Excercici 2 >>>>>>>>>>");
		 * System.out.print("Introdueix el nom del fitxer:"); nomFitxer = sc.nextLine();
		 * // nomFitxer = "fitxer.txt";
		 * 
		 * boolean escriure = GestorFitxer.escriureFitxer(nomFitxer, sc);
		 * System.out.println(escriure);
		 * 
		 * // Activitat Fitxers: Excercici 3: Llista de vehicles
		 * System.out.println("<<<<<<<<<< Excercici 3 >>>>>>>>>>");
		 * System.out.print("Introdueix el nom del fitxer per llegir: "); nomFitxer =
		 * sc.nextLine(); // nomFitxer = "vehicles.txt";
		 * 
		 * // Activitat Fitxers: Excercici 4: Llista de vehicles persistent
		 * System.out.println("<<<<<<<<<< Excercici 4 >>>>>>>>>>"); try { v =
		 * gf.llegir(nomFitxer); // nomFitxer = "vehicles2.csv";
		 * 
		 * if (v != null && !v.isEmpty()) {
		 * System.out.print("Introdueix el nom del fitxer CSV per escriure: ");
		 * nomFitxer = sc.nextLine(); gf.desa(nomFitxer, v);
		 * System.out.println("S'han guardat els vehicles correctament."); } } catch
		 * (Exception e) { System.out.println("Error general: " + e.getMessage()); }
		 */
		// Activitat Fitxers: Excercici 5:
		System.out.println("<<<<<<<<<< Excercici 5 >>>>>>>>>>");

		String opcio = "";
		boolean sortir = false;

		while (!sortir) {
			System.out.println("Quina operació vols fer?");
			System.out.println("1 - Carregar vehicles des d'un fitxer CSV (llegir dades de fitxer):");
			System.out.println("2 - Carregar vehicles des d'un fitxer XML (llegir dades de fitxer):");
			System.out.println("3 - Carregar vehicles des d'un fitxer binari (llegir dades de fitxer):");
			System.out.println("4 - Mostrar la llista de vehicles:");
			System.out.println("5 - Afegir un vehicle (des de teclat):");
			System.out.println("6 - Eliminar un vehicle (Per matrícula):");
			System.out.println("7 - Quin és el cotxe amb més quilòmetres (cotxe no vehicle):");
			System.out.println("8 - Desar els vehicles a un fitxer CSV:");
			System.out.println("9 - Desar els vehicles a un fitxer XML:");
			System.out.println("10 - Desar els vehicles a un fitxer binari:");
			System.out.println("11 - Sortir.");
			int cas = sc.nextInt();
			sc.nextLine();

			switch (cas) {
			case 1:
				System.out.print("Introdueix el nom del fitxer CSV per llegir: ");
				nomFitxer = sc.nextLine();
				try {
					InterficieGestorFitxer llegirCSV = new GestorFitxerCSV();
					v = llegirCSV.llegir(nomFitxer);
					System.out.println("S'ha carregat correctament");
				} catch (Exception e) {
					System.out.println("Error en carregar el CSV: " + e.getMessage());
				}
				break;
			case 2:
				System.out.print("Introdueix el nom del fitxer XML per llegir: ");
				nomFitxer = sc.nextLine();
				try {
					InterficieGestorFitxer llegirXML = new GestorFitxerXML();
					v = llegirXML.llegir(nomFitxer);
					System.out.println("S'ha carregat correctament");
				} catch (Exception e) {
					System.out.println("Error en carregar el CSV: " + e.getMessage());
				}
				break;
			case 3:
				System.out.print("Introdueix el nom del fitxer Binari per llegir: ");
				nomFitxer = sc.nextLine();
				try {
					InterficieGestorFitxer llegirBinari = new GestorFitxerBinari();
					v = llegirBinari.llegir(nomFitxer);
					System.out.println("S'ha carregat correctament");
				} catch (Exception e) {
					System.out.println("Error en carregar el Binari: " + e.getMessage());
				}
				break;
			case 4:
				GestorFitxer.mostrarVehicles(v);
				break;
			case 5:
				try {
					System.out.print("Tipus (cotxe/moto): ");
					String t = sc.nextLine();
					System.out.print("Matrícula: ");
					String mat = sc.nextLine();
					System.out.print("Km: ");
					int km = sc.nextInt();
					sc.nextLine();
					System.out.print("Marca: ");
					String mar = sc.nextLine();
					System.out.print("Model: ");
					String mod = sc.nextLine();
					System.out.print("Color: ");
					String col = sc.nextLine();

					Vehicle veh = null;

					if (t.equalsIgnoreCase("cotxe")) {
						System.out.print("Portes: ");
						int p = sc.nextInt();
						System.out.print("Automàtic? (true/false): ");
						String a = sc.next();
						sc.nextLine();
						veh = GestorFitxer.afegirVehicle("cotxe", mat, km, mar, mod, col, p, a);

					} else if (t.equalsIgnoreCase("moto")) {
						System.out.print("Cilindrada: ");
						int cil = sc.nextInt();
						sc.nextLine();
						System.out.print("Tipus (Scooter, Naked...): ");
						String tm = sc.nextLine();

						veh = GestorFitxer.afegirVehicle("moto", mat, km, mar, mod, col, cil, tm);
					}
					if (v != null) {
						v.add(veh);
						System.out.println("Vehicle afegit amb èxit!");
					}

				} catch (MatriculaInvalidaException e) {
					System.out.println("Error de matrícula: " + e.getMessage());
				} catch (Exception e) {
					System.out.println("Error general: " + e.getMessage());
				}
				break;
			case 6:
				System.out.print("Introdueix la matrícula del vehicle que vols eliminar: ");
				String matricula = sc.nextLine();

				boolean cercat = GestorFitxer.eliminarVehicle(v, matricula);

				if (cercat) {
					System.out.println("Vehicle eliminat correctament.");
				} else {
					System.out.println("No s'ha trobat la matrícula.");
				}
				break;
			case 7:
				Cotxe km = GestorFitxer.mesKM(v);
				if (km != null) {
					System.out.println("RESULTAT DE LA CERCA:");
					System.out.println("=====================");
					GestorFitxer.mostrarVehicles(Set.of(km));
				} else {
					System.out.println("No s'ha trobat cap cotxe a la llista actual.");
				}
				break;
			case 8:
				System.out.print("Introdueix el nom del fitxer CSV per escriure: ");
				nomFitxer = sc.nextLine();
				InterficieGestorFitxer gCSV = new GestorFitxerCSV();
				gCSV.desa(nomFitxer, v);
				break;
			case 9:
				System.out.print("Introdueix el nom del fitxer XML per escriure: ");
				nomFitxer = sc.nextLine();
				new GestorFitxerXML().desa(nomFitxer, v);
				break;
			case 10:
				System.out.print("Introdueix el nom del fitxer Binari per escriure: ");
				nomFitxer = sc.nextLine();
				InterficieGestorFitxer gBin = new GestorFitxerBinari();
				gBin.desa(nomFitxer, v);
				break;
			case 11:
				sortir = true;
				break;
			}
		}
	}
}
