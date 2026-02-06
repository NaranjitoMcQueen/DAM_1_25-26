package HashMap;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	
        boolean sortir = false;
        Scanner sc = new Scanner(System.in);
        Diccionari diccionari = new Diccionari();

		diccionari.afegir("Acollida",
				"Rebuda d'una persona en el si de la societat en la qual s'estableix amb vocació de romandre-hi.");
		diccionari.afegir("Bull", "Embotit elaborat farcint budell ample");
		diccionari.afegir("Cotxe", "Vehicle per movilitat personal o amb acompanyament");
		diccionari.afegir("Dinosaure", "Grup heterogeni de sauròpsids");
		diccionari.afegir("Estocolm", "Capital del Regne de Suècia ");
		diccionari.afegir("Funcionalitat", "Aventatge");

		while (sortir == false) {
			System.out.println("Quina operació vols fer?");
			System.out.println("1 - Afegir una paraula i definició al diccionari:");
			System.out.println("2 - Eliminar una paraula:");
			System.out.println("3 - Consultar la definició d'una paraula:");
			System.out.println("4 - Llistar totes les paraules i definicions: ");
			System.out.println("5 - Consultar paraules totals:");
			int seleccio = sc.nextInt();
			sc.nextLine();

			switch (seleccio) {
			case 1:
				System.out.println("Introdueix la paraula:");
				String paraula = sc.nextLine();
				System.out.println("Introdueix la definició:");
				String definicio = sc.nextLine();
				diccionari.afegir(paraula, definicio);
				System.out.println("Paraula afegida.");
				break;
			case 2:
				System.out.println("Introdueix la paraula a eliminar:");
				paraula = sc.nextLine();
				String eliminat = diccionari.eliminar(paraula);
				if (eliminat != null) {
					System.out.println("La paraula " + eliminat + " s'ha eliminar correctament.");
				} else System.out.println("No existeix la paraula.");
				break;
			case 3:
				System.out.println("Introdueix la paraula a cercar la definició:");
				paraula = sc.nextLine();
				String cercar = diccionari.cercar(paraula);
				if (cercar != null) {
				System.out.println(diccionari.cercar(paraula));
				} else System.out.println("No existeix la paraula.");
				break;
			case 4:
				System.out.println(diccionari.llistar() + "\n");
				break;
			case 5:
				System.out.println(diccionari.tamany());
				break;
			default:

			}
		}
		sc.close();
	}
}
