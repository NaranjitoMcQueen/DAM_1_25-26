package Tasca1;

import java.util.Scanner;

public class Activitat4_ACL {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num, major;
		
		System.out.println("Introdueix els nombres: ");
		num = sc.nextInt();
		major = 0;
		
		while (num != 0) {
			num = sc.nextInt(); //Segueix llegint 
			if (num > major) {
				major = num;
			}
		}
		System.out.println("El més gran hi es: " + major);
		sc.close();
	}
	
}