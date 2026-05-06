package cineExamen;

import java.time.LocalDate;
import java.time.LocalTime;

public class TestMain {
	public static void main(String[] args) {

		// ── Create Cinema ──────────────────────────────────────────────
		Cinema cinema = new Cinema("Cines Diagonal", "Avinguda Diagonal, 208, Barcelona");
		System.out.println(cinema);

		// ── CUSTOMERS ───────────────────────────────────────────────────
		// Registre de clients
		System.out.println("=== REGISTER CUSTOMERS ===");
		Client cl1 = new Client("Ana García", "612345678");
		Client cl2 = new Client("Pere Mas", "934567890");
		
		// Client invalidClient = new Client("Nobody", "123"); // telèfon invàlid → no
		// es crea
		
		System.out.println(cinema.registerClient(cl1)); // true
		System.out.println(cinema.registerClient(cl2)); // true
		System.out.println(cinema.registerClient(cl1)); // false (duplicat)

		System.out.println("\n=== SHOW CUSTOMERS ===");
		// Mostrar tots els clients registrats
		cinema.showClients();
		
		// ── MOVIES ──────────────────────────────────────────────────────
		// Registre de pel·lícules
		System.out.println("\n=== REGISTER MOVIES ===");
		ChildrenMovie m1 = new ChildrenMovie("El Rey León", "Animación", 88, 0, true, true);
		ChildrenMovie m2 = new ChildrenMovie("Shrek", "Animación/Comedia", 90, 0, true, true);
		Movie3D m3 = new Movie3D("Avatar", "Ciencia Ficción", 162, 12, true, 3.50);
		Movie3D m4 = new Movie3D("El Señor de los Anillos", "Fantasía", 178, 12, true, 3.00);
		// Movie invalidMovie = new Movie("Bad", "Horror", -10, 0); // durada invàlida →
		// no es crea
		
		System.out.println(cinema.registerMovie(m1)); // true
		System.out.println(cinema.registerMovie(m2)); // true
		System.out.println(cinema.registerMovie(m3)); // true
		System.out.println(cinema.registerMovie(m4)); // true
		System.out.println(cinema.registerMovie(m1)); // true (admet duplicats)

		System.out.println("\n=== SHOW MOVIES ===");
		// Mostrar totes les pel·lícules
		cinema.showMovies();
		
		// ── SESSIONS ────────────────────────────────────────────────────
		// Registre de sessions
		System.out.println("\n=== REGISTER SESSIONS ===");
		Session session1 = new Session(LocalDate.of(2026, 6, 15), LocalTime.of(17, 30), m1, 1, 2);
		Session session2 = new Session(LocalDate.of(2026, 6, 15), LocalTime.of(20, 0), m3, 2, 3);
		Session session3 = new Session(LocalDate.of(2026, 6, 20), LocalTime.of(18, 0), m2, 1, 1);
		// Session invalidSession = new Session(LocalDate.of(2026, 7, 1),
		// LocalTime.of(10, 0), m4, 3, 0); // aforament 0 → invàlida
/*
		System.out.println(cinema.registerSession(session1)); // true
		System.out.println(cinema.registerSession(session2)); // true
		System.out.println(cinema.registerSession(session3)); // true
/*
		System.out.println("\n=== SHOW SESSIONS ===");
		// Mostrar sessions ordenades per data i hora
		cinema.showSessions();

		// ── SELL TICKETS ───────────────────────────────────────────────
		// Venda d'entrades
		System.out.println("\n=== SELL TICKETS ===");
		int codeS1 = session1.getCode();
		int codeS2 = session2.getCode();
		int codeS3 = session3.getCode();

		System.out.println(cinema.sellTicket(codeS1, cl1)); // true
		System.out.println(cinema.sellTicket(codeS1, cl1)); // false (mateix client, mateixa sessió)
		System.out.println(cinema.sellTicket(codeS1, cl2)); // true → aforament complet → estat COMPLETED
		System.out.println(cinema.sellTicket(codeS1, cl2)); // false (sessió COMPLETED)

		// session3 té aforament 1
		System.out.println(cinema.sellTicket(codeS3, cl1)); // true → COMPLETED automàticament
		System.out.println(session3.getStatus());

		// ── CHANGE SESSION STATUS ───────────────────────────────────────
		// Canvi d'estat de sessió
		System.out.println("\n=== CHANGE SESSION STATUS ===");
		System.out.println(cinema.changeSessionStatus(codeS2, COMPLETA)); // true
		System.out.println(cinema.changeSessionStatus(codeS2, CANCEL_LADA)); // true
		System.out.println(cinema.changeSessionStatus(9999, COMPLETA)); // false (no existeix)

		// Intentar canviar estat d'una sessió amb data passada
		Session pastSession = new Session(LocalDate.of(2020, 1, 1), LocalTime.of(10, 0), m1, 4, 50);
		cinema.registerSession(pastSession);
		// System.out.println(cinema.changeSessionStatus(pastSession.getCode(),
		// SessionStatus.CANCEL_LADA)); // false (data passada)

		// ── FINAL SESSION STATUS ───────────────────────────────────────
		// Mostrar estat final de les sessions
		System.out.println("\n=== FINAL SESSION STATUS ===");
		cinema.showSessions();

		// ── MODIFY SESSION ─────────────────────────────────────────────
		// Modificació de data i hora de sessió
		System.out.println("\n=== MODIFY SESSION ===");
		System.out.println(cinema.modifySession(session1.getCode(), LocalDate.of(2026, 8, 20), LocalTime.of(10, 0))); // true
		System.out.println(cinema.modifySession(session1.getCode(), LocalDate.of(2020, 1, 1), LocalTime.of(10, 0))); // false
																														// (data
																														// passada)
		System.out.println(cinema.modifySession(9999, LocalDate.of(2026, 8, 20), LocalTime.of(10, 0))); // false (no
																										// existeix)
		System.out.println(cinema.modifySession(session2.getCode(), LocalDate.of(2026, 9, 1), LocalTime.of(10, 0))); // false
																														// (cancel·lada)
*/
		// ── DELETE CLIENT ─────────────────────────────────────────────
		// Eliminem un client
		cinema.removeClient(cl1.getPhone());
		cinema.showClients();
	}
}
