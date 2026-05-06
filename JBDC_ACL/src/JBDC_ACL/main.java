package JBDC_ACL;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class main {

	public static void main(String[] args) throws SQLException {

		GestorConnexions gc = new GestorConnexions();
		Connection connexio = gc.obtenirConnexio();
		Scanner sc = new Scanner(System.in);
		GestorJDBC gbd = new GestorJDBC();

		System.out.println("----------------------- JDBC 2 -----------------------\n");
		boolean continuar = true;

		while (continuar) {
			System.out.println("\nSelecciona l'opció:");
			System.out.println("1. Mostrar Departaments");
			System.out.println("2. Mostrar Empleats");
			System.out.println("3. Afegir un Departament");
			System.out.println("4. Eliminar un Departament");
			System.out.println("5. Eliminar un Empleat");
			System.out.println("6. Afegir un Empleat");
			System.out.println("7. Modificar salari empleats d'un departament");
			System.out.println("8. Modificar la comissió d'un Empleat");
			System.out.println("0. Sortir");
			System.out.print("Selecciona una opció: \n");
			int opcio = Integer.parseInt(sc.nextLine());

			switch (opcio) {
			case 1:
				System.out.println("Selecciona l'opció:");
				System.out.println("1 - Mostrar departaments amb empleats:  2 - Mostrar departaments sense empleats:");
				int mostrarCodi = Integer.parseInt(sc.nextLine());
				if (mostrarCodi == 2) {
					gbd.getDepartaments(false);
				} else if (mostrarCodi == 1) {
					gbd.getDepartaments(true);
				} else {
					System.out.println("No entra en els valors macrats");
				}
				break;
			case 2:
				gbd.getDepartaments(true);
				break;
			case 3:
				System.out.println("Introdueix el codi del departament:");
				int c_dpt = Integer.parseInt(sc.nextLine());
				System.out.println("Introdueix el nom del departament:");
				String n_dpt = sc.nextLine();
				System.out.println("Introdueix la ciutat del departament:");
				String ciu_dpt = sc.nextLine();
				Departament newDep = new Departament(c_dpt, n_dpt, ciu_dpt);
				int resultatD = gbd.afegirDepartament(newDep);
				if (resultatD > 0) {
					System.out.println("Departament Afegit correctament.");
				} else {
					if (resultatD == -1062) {
						System.out.println("Departament duplicat");
					} else {
						System.out.println("Error a l'inserir el Departament.");
					}
				}
				break;
			case 4:
				try {
					System.out.println("Introdueix el codi del departament a esborrar:");
					int codiD = Integer.parseInt(sc.nextLine());
					Departament dept = gbd.cercarDepartament(codiD);
					if (dept != null) {
						System.out.println("1 - Vols esborrar també els empleats?  2 - NO esborrar empleats:");
						int codiEsborrar = Integer.parseInt(sc.nextLine());
						int files = 0;
						if (codiEsborrar == 2) {
							files = gbd.esborrarDepartament(dept, false);
						} else if (codiEsborrar == 1) {
							files = gbd.esborrarDepartament(dept, true);
						}
						System.out.println("S'han esborrat " + files + " departament(s).");
					} else {
						System.out.println("Aquest departament no existeix al sistema.");
					}
				} catch (SQLException e) {
					System.out.println("Error a la base de dades");
				} catch (Exception e) {
					System.out.println("Error: " + e.getMessage());
				}
				break;
			case 5:
				System.out.println("Introdueix el codi del empleat a eliminar:");
				int codiEmp = Integer.parseInt(sc.nextLine());
				gbd.esborrarEmpleat(codiEmp);
				break;
			case 6:
				try {
					System.out.print("CODI:");
					int codiE = Integer.parseInt(sc.nextLine());
					System.out.print("COGNOM: ");
					String cognom = sc.nextLine();
					System.out.print("OFICI: ");
					String ofici = sc.nextLine();
					System.out.print("Data d'alta: ");
					String dataString = sc.nextLine();
					java.sql.Date dataAlta = java.sql.Date.valueOf(dataString);
					System.out.print("SALARI: ");
					double salari = Double.parseDouble(sc.nextLine());
					System.out.print("COMISSIÓ: ");
					double comissio = Double.parseDouble(sc.nextLine());
					System.out.print("CODI DEPARTAMENT: ");
					int codiD = Integer.parseInt(sc.nextLine());
					Departament dEmp = gbd.cercarDepartament(codiD);
					if (dEmp != null) {
						Empleat e = new Empleat(codiE, cognom, ofici, dataAlta, salari, comissio, dEmp);
						int filesEmp = gbd.afegirEmpleat(e);
						if (filesEmp > 0) {
							System.out.println("Empleat afegit correctament.");
						} else {
							System.out.println("No s'ha pogut afegir l'empleat.");
						}
					} else {
						System.out.println("Error: El departament " + codiD + " no existeix.");
					}
				} catch (IllegalArgumentException e) {
					System.out.println("Error: El format de la data ha de ser AAAA-MM-DD.");
				} catch (SQLException e) {
					System.out.println("Error de base de dades: " + e.getMessage());
				}
				break;
			case 7:
				System.out.println("Introdueix el codi del departament:");
				int modS = Integer.parseInt(sc.nextLine());
				Departament dept = gbd.cercarDepartament(modS);
				if (dept != null) {
					System.out.println("Introdueix el % per pujar el salari (ex: 10 per un 10%):");
					int percentatge = Integer.parseInt(sc.nextLine());
					int filesModificades = gbd.modificarSalari(dept, percentatge);
					if (filesModificades > 0) {
						System.out.println("S'ha actualitzat el salari de " + filesModificades + " empleats.");
					} else {
						System.out.println("No s'ha modificat cap salari (potser el departament no té empleats).");
					}
				} else {
					System.out.println("Error: El departament amb codi " + modS + " no existeix.");
				}
				break;
			case 8:
				System.out.println("Introdueix el codi de l'empleat per modificar la comissió:");
				int modC = Integer.parseInt(sc.nextLine());
				System.out.println("Introdueix la nova comissió:");
				double comissio = Double.parseDouble(sc.nextLine());
				Empleat e = new Empleat(modC);
				int files = gbd.modificarComissio(e, (int) comissio);
				if (files > 0) {
					System.out.println("Comissió actualitzada correctament per a l'empleat " + modC + ".");
				} else {
					System.out.println("No s'ha trobat cap empleat amb el codi " + modC + " al sistema.");
				}
				break;
			case 0:
				continuar = false;
				break;
			default:
				System.out.println("Innexistent.");
				break;
			}
		}
	}
}