package Tasca1;

import java.util.Scanner;

public class Activitat5_A_ACL {

		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			float num;
			int par;
			
			System.out.println("Introdueix els nombres: ");
			num = sc.nextInt();
			par = 0;
			
			while (num != 0) {
				if (num % 2 == 0) {
					par ++;
				}
				num = sc.nextFloat();
			}
			System.out.println("Els numeros pars hi son es: " + par);
			sc.close();
		}
	}
