package TascaEmail;

import java.util.Scanner;

public class TascaCorreu {

	public static int comprovacio(String mail) {

		if (mail.indexOf("@") >= 0) {
			String[] comprovacioB = mail.toLowerCase().split("@");
			if (comprovacioB[0].length() >= 2) {
				if (comprovacioB[1].indexOf(".") >= 0) {
					String[] comprovacioC = mail.split("\\.");
					if (comprovacioC[1].length() >= 2) {
						return 1;
					} else {
						return -4;
					}
				} else {
					return -3;
				}
			} else {
				return -2;
			}
		} else {
			return -1;
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Introdueix el teu correu electrònic:");
		String mail = sc.nextLine();
		
		int comprovar = comprovacio(mail);
		
		if (comprovar == 1) {
			String[] av = mail.split("@");
			System.out.println("Adreça vàlida\nNom d’usuari: " + av[0] +  "\nDomini: " + av[1]);
		} else if (comprovar == -1) {
			System.out.println("Adreça invàlida: La teva adreça ha de comptar amb el símbol '@'.");
		} else if (comprovar == -2) {
			System.out.println("Adreça invàlida: El nom d’usuari ha de tenir com a mínim 2 caràcters.");
		} else if (comprovar == -3) {
			System.out.println("Adreça invàlida: La teva adreça ha de comptar amb el símbol '.'.");
		} else if (comprovar == -4) {
			System.out.println("Adreça invàlida: El teu servidor de correu ha de tenir com a mínim 2 caràcters. ");
		}
		sc.close();
	}

}
