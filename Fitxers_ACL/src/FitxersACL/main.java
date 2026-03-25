package FitxersACL;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
import java.util.Set;

public class main {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		File file = new File("fitxer.txt");
		GestorFitxer gf = new GestorFitxer();
		Set<Vehicle> v;

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

		// Activitat Fitxers: Excercici 1: Llegir fitxer
		System.out.println("<<<<<<<<<< Excercici 1 >>>>>>>>>>");
		System.out.print("Introdueix el nom del fitxer:");
		String nomFitxer = sc.nextLine();
		// nomFitxer = "nombres.txt";

		int sumaTotal = GestorFitxer.llegirFitxer(nomFitxer);
		System.out.println("---------------------------");
		System.out.println("La suma total dels enters és: " + sumaTotal);

		// Activitat Fitxers: Excercici 2: Escriure fitxer
		System.out.println("<<<<<<<<<< Excercici 2 >>>>>>>>>>");
		System.out.print("Introdueix el nom del fitxer:");
		nomFitxer = sc.nextLine();
		// nomFitxer = "fitxer.txt";

		boolean escriure = GestorFitxer.escriureFitxer(nomFitxer, sc);
		System.out.println(escriure);

		// Activitat Fitxers: Excercici 3: Llista de vehicles
		System.out.println("<<<<<<<<<< Excercici 3 >>>>>>>>>>");
		System.out.print("Introdueix el nom del fitxer per llegir: ");
		nomFitxer = sc.nextLine();
		// nomFitxer = "vehicles.txt";

		// Activitat Fitxers: Excercici 4: Llista de vehicles persistent
		System.out.println("<<<<<<<<<< Excercici 4 >>>>>>>>>>");
		try {
			v = gf.llegir(nomFitxer);

			if (v != null && !v.isEmpty()) {
				System.out.print("Introdueix el nom del fitxer CSV per escriure: ");
				nomFitxer = sc.nextLine();
				gf.desaCSV(nomFitxer, v);
				System.out.println("S'han guardat els vehicles correctament.");
			}
		} catch (Exception e) {
			System.out.println("Error general: " + e.getMessage());
		}

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
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			case 8:
				try {
					v = gf.llegir(nomFitxer);
					if (v != null && !v.isEmpty()) {
						System.out.print("Introdueix el nom del fitxer CSV per escriure: ");
						nomFitxer = sc.nextLine();
						gf.desaCSV(nomFitxer, v);
						System.out.println("S'han guardat els vehicles correctament.");
					}
				} catch (Exception e) {
					System.out.println("Error general: " + e.getMessage());
				}
				break;
			case 9:
				try {
					v = gf.llegir(nomFitxer);
					if (v != null && !v.isEmpty()) {
						System.out.print("Introdueix el nom del fitxer CSV per escriure: ");
						nomFitxer = sc.nextLine();
						gf.desaXML(nomFitxer, v);
						System.out.println("S'han guardat els vehicles correctament.");
					}
				} catch (Exception e) {
					System.out.println("Error general: " + e.getMessage());
				}
				break;
			case 10:
				break;
			case 11:
				sortir = true;
				break;
			}
			/*
			 * ◦ Carregar vehicles des d'un fitxer CSV (llegir dades de fitxer) ◦ Carregar
			 * vehicles des d'un fitxer XML (llegir dades de fitxer) *(1) ◦ Carregar
			 * vehicles des d'un fitxer binari (llegir dades de fitxer) *(1) ◦ Mostrar la
			 * llista de vehicles *(2) ◦ Afegir un vehicle (des de teclat) ◦ Eliminar un
			 * vehicle (Per matrícula) ◦ Quin és el cotxe amb més quilòmetres (cotxe no
			 * vehicle) ◦ Desar els vehicles a un fitxer XML ◦ Desar els vehicles a un
			 * fitxer binari
			 */
		}
	}
}
