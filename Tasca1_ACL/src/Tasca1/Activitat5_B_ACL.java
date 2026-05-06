package Tasca1;

import java.util.Scanner;

public class Activitat5_B_ACL {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		float num;
		boolean par;
		
		System.out.println("Introdueix els nombres: ");
		num = sc.nextInt();
		par = false;
		
		while (num != 0) {
			if (num % 2 == 0) {
				par = true;
			}
			num = sc.nextFloat();
		}
		if (par == false) {
		System.out.println("No hi ha cap par"); }
		else {
			System.out.println("Hi ha un par");
		sc.close();
		}
	}
}
