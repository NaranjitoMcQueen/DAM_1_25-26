package gimnas;

public class TestMain {

	public static void main(String[] args) throws Exception {

		String nomFitxer;

		GestorGimnas g = new GestorGimnas("FITNESS", "Sant Boi");

		// Crear clients
		Client c1 = new Client("12345678Z", "Ana", "Garcia Rodriguez", "600111111", "10/05/2005",
				TipusMembresia.BASICA);
		g.registrarClient(c1);
		Client c2 = new Client("87654321X", "Luis", "Perez Solana", "600222222", "20/03/1998", TipusMembresia.PREMIUM);
		g.registrarClient(c2);
		Client c3 = new Client("11223344B", "Carlos", "Ruiz Solis", "15/08/1995", TipusMembresia.VIP);
		g.registrarClient(c3);
		Client c4 = new Client("22334455N", "Nuria", "Martinez Lopez", "600222222", "23/11/2018",
				TipusMembresia.BASICA);
		g.registrarClient(c4);
		g.mostrarClients();

		// Crear entrenadors
		Entrenador e1;
		e1 = new Entrenador("33445566J", "Maria", "Estivill Baute", "600999999", "01/02/1980", "Fitness");
		g.registrarEntrenador(e1);
		Entrenador e2 = new Entrenador("44556677P", "Laura", "Sanchez Perez", "600888888", "15/06/1985", "Yoga");
		g.registrarEntrenador(e2);
		Entrenador e3 = new Entrenador("55667788D", "Miguel", "Torres Gomez", "600777777", "22/09/1990", "Crossfit");
		g.registrarEntrenador(e3);

		// Crear classes o activitats
		ActivitatGimnas act1 = new ActivitatGimnas("Spinning", e1, 2, 18);
		g.registrarActivitat(act1);
		ActivitatGimnas act2 = new ActivitatGimnas("Yoga", e2, 6, 15);
		g.registrarActivitat(act2);
		ActivitatGimnas act3 = new ActivitatGimnas("Crossfit", e3, 3, 12);
		g.registrarActivitat(act3);

		// ActivitatGimnas act4 = new ActivitatGimnas("Crossfit", e3, 3, -1);
		// ActivitatGimnas act5 = new ActivitatGimnas("Crossfit", e3, 0, 18);

		// Inscriure clients
		System.out.println(g.inscriureClientEnActivitat("12345678Z", act1));
		System.out.println(g.inscriureClientEnActivitat("87654321X", act1));

		// Provar capacitat plena
		System.out.println(g.inscriureClientEnActivitat("11223344B", act1));

		// Provar client menor d'edat
		System.out.println(g.inscriureClientEnActivitat("22334455N", act1));

		// Provar límit membresia
		System.out.println(g.inscriureClientEnActivitat("12345678Z", act2));
		System.out.println(g.inscriureClientEnActivitat("12345678Z", act3));

		// Mostrar clients inscrits en act1
		System.out.println("\nClients inscritos en act1:");
		act1.mostrarClients();

		// Provar client duplicat
		System.out.println(g.inscriureClientEnActivitat("12345678Z", act1));

		System.out.println(g.inscriureClientEnActivitat("11223344B", act2));
		System.out.println(g.inscriureClientEnActivitat("66778899S", act2));

		// Guardar Clients
		GestorFitxerXML gXML = new GestorFitxerXML();
		gXML.desa("clients.xml", g.getClients());

		// Eliminar Clients
		g.eliminarAllClients(); // nom_llist_clients.clear();
		System.out.println("\nClients esborrats");

		g.mostrarClients();

		// Carregar Clients
		GestorFitxerCSV gCSV = new GestorFitxerCSV();
		gCSV.llegir("clients.txt");

		g.mostrarClients();

	}

}