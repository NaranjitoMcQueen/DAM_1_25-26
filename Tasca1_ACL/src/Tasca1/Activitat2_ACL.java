package Tasca1;

import java.util.Scanner;

public class Activitat2_ACL {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1, num2, num3;
		System.out.print("Introdueix el primer nombre: ");
		num1 = sc.nextInt();
		System.out.print("Introdueix el segon nombre: ");
		num2 = sc.nextInt();
		System.out.print("Introdueix el tercer nombre: ");
		num3 = sc.nextInt();
		if ((num1 > num2) && (num1 > num3)){
				System.out.println("El més gran és: " + num1);
			}else if (num2 > num3) {
				System.out.println("El més gran és: " + num2);
			}else {
				System.out.println("El més gran és: " + num3);
			}
		sc.close();
		}
		
	}
