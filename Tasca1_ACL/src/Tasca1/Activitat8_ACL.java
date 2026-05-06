package Tasca1;

import java.util.Scanner;

public class Activitat8_ACL {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num, serie;

			System.out.println("Introdueix els nombres: ");
			num = sc.nextInt();
			serie = num;
			while (num != 0 && serie <= num) {
				serie = num;
				num = sc.nextInt();
			}
			if (num != 0)
				System.out.println("La serie no es creixent");
			else
				System.out.println("La serie si es creixent");
			sc.close();		
	}
}
