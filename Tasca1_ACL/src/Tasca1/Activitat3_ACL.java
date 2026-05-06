package Tasca1;

import java.util.Scanner;

public class Activitat3_ACL {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		float num, sum;
		int cont;
		
		System.out.println("Introdueix els nombres: ");
		num = sc.nextInt();
		cont = 0;
		sum = num;
		
		while (num != 0) {
			num = sc.nextFloat();
			sum = sum + num;
			cont = cont + 1;
		}
		sum = sum / cont;
		System.out.println("La mitjana aritmetica es: " + sum);
		sc.close();
	}
}