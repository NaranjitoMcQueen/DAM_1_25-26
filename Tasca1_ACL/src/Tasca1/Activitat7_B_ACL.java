package Tasca1;

import java.util.Scanner;

public class Activitat7_B_ACL {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num, cercar;

			System.out.println("Introdueix el nombre a cercar: ");
			cercar = sc.nextInt();
			System.out.println("Introdueix els nombres: ");
			num = sc.nextInt();

			while (num != 0 && num != cercar) {
				num = sc.nextInt();
			}
			if (num == cercar) {
				System.out.println("El nombre si es troba en la serie");
			} else
				System.out.println("El nombre no es troba a la serie");
			sc.close();		
	}
}
