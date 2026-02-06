package HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		boolean sortir = false;
		Scanner sc = new Scanner(System.in);

		Map<String, String> diccionari = new HashMap<String, String>();

		diccionari.put("Acollida",
				"Rebuda d'una persona en el si de la societat en la qual s'estableix amb vocació de romandre-hi.");
		diccionari.put("Bull", "Embotit elaborat farcint budell ample");
		diccionari.put("Cotxe", "Vehicle per movilitat personal o amb acompanyament");
		diccionari.put("Dinosaure", "Grup heterogeni de sauròpsids");
		diccionari.put("Estocolm", "Capital del Regne de Suècia ");
		diccionari.put("Funcionalitat", "Aventatge");

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

				diccionari.put(paraula, definicio);
				System.out.println("Paraula afegida.");
				break;
			case 2:
				System.out.println("Introdueix la paraula a eliminar:");
				paraula = sc.nextLine();
				String eliminar = diccionari.remove(paraula);
				if (eliminar != null) {
					System.out.println("La paraula " + paraula + " s'ha eliminar correctament.");
				} else System.out.println("No existeix la paraula.");
				break;
			case 3:
				System.out.println("Introdueix la paraula a cercar la definició:");
				paraula = sc.nextLine();
				String cercar = diccionari.get(paraula);
				if (cercar != null) {
				System.out.println(diccionari.get(paraula));
				} else System.out.println("No existeix la paraula.");
				break;
			case 4:
				System.out.println(diccionari);
				break;
			case 5:
				System.out.println(diccionari.size());
				break;
			default:

			}
		}
		
	}
}
