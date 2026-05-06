package TascaString;

import java.util.Scanner;

public class TascaString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean sortir = false;
		boolean resultat;
		String s1 = " ", s2 = " ";
		
		while (sortir == false) {
			System.out.println("Quina operació vols fer?");
			System.out.println("1 - Utilitzar-hi equals:");
			System.out.println("2 - Utilitzar-hi equalsIgnoreCase:");
			System.out.println("3 - Utilitzar-hi compareTo:");
			System.out.println("4 - Utilitzar-hi charAt:");
			System.out.println("5 - Utilitzar-hi int length:");
			System.out.println("6 - Utilitzar-hi String substring:");
			System.out.println("7 - Utilitzar-hi int indexOf:");
			System.out.println("8 - Utilitzar-hi String toUpperCase:");
			System.out.println("9 - Utilitzar-hi String toLowerCase:");
			System.out.println("10 - Utilitzar-hi String[] split:");
			System.out.println("11 - Finalitza.");
			int cas = sc.nextInt();
			sc.nextLine();
			
			switch (cas) {
			case 1:
				System.out.println("Introdueix la primera paraula:");
				s1 = sc.nextLine();
				System.out.println("Introdueix la segona paraula:");
				s2 = sc.nextLine();
				
				resultat = s1.equals(s2);
				
				if(resultat == true) {
					System.out.println("El resultat es correcte.");
				} else System.out.println("No hi coincideix, torna a probar-ho.");
				break;
				
			case 2:
				System.out.println("Introdueix la primera paraula:");
				s1 = sc.nextLine();
				System.out.println("Introdueix la segona praula:");
				s2 = sc.nextLine();
				
				resultat = s1.equalsIgnoreCase(s2);
				
				if(resultat == true) {
					System.out.println("El resultat es correcte.");
				} else System.out.println("No hi coincideix, torna a probar-ho.");
				break;
				
			case 3:
				System.out.println("Introdueix la primera paraula:");
				s1 = sc.nextLine();
				System.out.println("Introdueix la segona paraula:");
				s2 = sc.nextLine();
				
				int resultatComparar = s1.compareTo(s2);
				
				if(resultatComparar == 0) {
					System.out.println("Les paraules són exactament igual.");
				} else if (resultatComparar <= 0) {
					System.out.println("La primera paraula es major alfabèticament.");
				} else if (resultatComparar >= 0) {
					System.out.println("La primera paraula es menor alfabèticament.");
				}
				break;
			case 4:
				System.out.println("Introdueix la paraula:");
				s1 = sc.nextLine();
				System.out.println("Quina posició vols cercar-hi de la paraula:");
				
				int posicio = sc.nextInt();
				
				if(posicio > s1.length()) {
					System.out.println("La posició que vols cercar es massa gran.");
				} else System.out.println("La posició " + posicio + " compta amb la lletra " + s1.charAt(posicio - 1));
				break;
			case 5:
				System.out.println("Introdueix la frase que vols contar els nombres:");
				s1 = sc.nextLine();
				System.out.println("La teva frase compté: " + s1.length() + " nombres.");
				break;
			case 6:
				System.out.println("Introdueix una cadena:");
				s1 = sc.nextLine();
				System.out.println("Introdueix la posició on vols començar: ");
				int pos1 = sc.nextInt();
				System.out.println("Introdueix la segona posició: ");
				int pos2 = sc.nextInt();
				
				String subserie = s1.substring(pos1, pos2);
				System.out.println("Dona aquest resultat: " + subserie);
				break;
			case 7:
				System.out.println("Introdueix una cadena de nombres: ");
				s1 = sc.nextLine();
				System.out.println("Introdueix el nombre a cercar: ");
				s2 = sc.nextLine();
				
				int res = s1.indexOf(s2);
				if (res == -1) {
					System.out.println("No es troba la paraula");
				} else System.out.println("Es troba a la posició: " + res);
				break;
			case 8:
				System.out.println("Introdueix una paraula:");
				s1 = sc.nextLine();
				
				String resmaj = s1.toUpperCase();
				System.out.println("Aquí tens el teu resultat: " + resmaj);
				break;
			case 9:
				System.out.println("Introdueix una paraula:");
				s1 = sc.nextLine();
				
				String resmin = s1.toLowerCase();
				System.out.println("Aquí tens el teu resultat: " + resmin);
				break;
			case 10:
				/*Fer-ho amb data ex: 22/febrer/2025*/
				System.out.println("Introdueix la teva data en aquest format (XX/X/XXXX):");
				s1 = sc.nextLine();
				
				String[] data = s1.split("/");
				for (int i=0; i < data.length; i++) {
					System.out.println(data[i]);
				}
				break;
			case 11:
				sortir = true;
				break;
			}
		}
	}
}