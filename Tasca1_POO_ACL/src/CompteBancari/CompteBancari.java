package CompteBancari;

public class CompteBancari {

	public static void main(String[] args) {

		Compte[] comptes = new Compte[2];
		Client[] clients = new Client[2];
		TargetaDebit[] targetaDeb = new TargetaDebit[2];
		TargetaCredit[] targetaCred = new TargetaCredit[2];

		clients[0] = new Client("50511866W", "Arnau", "Carrer Putellas", 764960715, "18/10/2000");
		clients[1] = new Client("54772876D", "Emma", "Carrer Cubarsí", 653604859, "29/08/2002");
		
		comptes[0] = new Compte("ES6101823456420456323532", 500, 100, clients[0], "09/12/2025");
		comptes[1] = new Compte("ES6121003456420456323545", 300, 100, clients[1], "09/01/2026");
		
		targetaDeb[0] = new TargetaDebit ("0001", comptes[0], 500.0);
		targetaDeb[1] = new TargetaDebit ("0002", comptes[1], 500.0);
		
		targetaCred[0] = new TargetaCredit ("0001", comptes[0], 500.0, 777.0, 777.0);
		targetaCred[1] = new TargetaCredit ("0002", comptes[1], 500.0, 1000, 1000);

		// TEST
		comptes[0].ingressar(500);
		comptes[0].retirar(600);
		comptes[0].transferir(comptes[1], 50);
		
		// Get DNI TEST
		System.out.println(clients[1].getDni());
		System.out.println(comptes[1].getDniTitular());
		System.out.println(clients[0].getEdat());

		// INFO
		for (int i = 0; i < comptes.length; i++) {
			System.out.println("---- COMPTE " + (i + 1) + " ----");
			System.out.println(comptes[i].getInfo());
			System.out.println("BANC: " + comptes[i].getNomBanc());
		}
		System.out.println("\nInterès anual: " + Compte.getInteresAnual());
		System.out.println("Total comptes creats: " + Compte.getTotalComptes());
		
		// TEST PAGAMENTS TARGETES
		// DEBIT
		System.out.println("\nTargeta Debit TEST:\n" + comptes[0].getSaldo() + "\nSaldo restant:");
		targetaDeb[0].pagament(150);
		System.out.println(comptes[0].getSaldo());
		// CREDIT
		System.out.println("\nTargeta Credit TEST:\n" + targetaCred[0].getCredit() + "\nNou Credit restant: ");
		targetaCred[0].pagament(277);
		System.out.println(targetaCred[0].getCredit());
	}
	// ES6112343456420456323532, 50511866W, Arnau
	// ES6112343456420456323545, 54772876D, Emma
}