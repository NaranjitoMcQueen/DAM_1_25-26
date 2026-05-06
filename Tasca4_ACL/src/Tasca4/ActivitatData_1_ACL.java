package Tasca4;

import java.util.Scanner;

public class ActivitatData_1_ACL {

	public static boolean calendari(int dia, int mes, int any) {
		Scanner sc = new Scanner(System.in);

		boolean resultat = true;

		int[] vd; // Vector per el Dia

		if (any % 4 == 0 && any % 100 != 0 || any % 400 == 0) {
			vd = new int[] { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }; // Any de traspàs
		} else {
			vd = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }; // Any normal
		}

		int diaMax = vd[0]; // Marquem dia maxim
		int i = 0;

		if (mes >= 1 && mes < 13) {
			while (i != mes) {
				diaMax = vd[i];
				i++;
			}
			if (dia > diaMax || dia <= 0) {
				resultat = false;
			}
		} else {
			resultat = false;
		}
		return resultat;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Donam el dia:"); // Demanem els inputs per comprobar-ho
		int dia = sc.nextInt();
		System.out.println("Donam el mes:");
		int mes = sc.nextInt();
		System.out.println("Donam l'any:");
		int any = sc.nextInt();

		boolean resultat = calendari(dia, mes, any);
		if (resultat == false) {
			System.out.println("Revisa la data, dona error");
		} else {
			System.out.println("La data " + dia + "/" + mes + "/" + any);
		}

	}
}
