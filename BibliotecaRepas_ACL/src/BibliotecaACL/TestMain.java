package BibliotecaACL;

import java.time.LocalDate;

public class TestMain {

	public static void main(String[] args) throws InvalidCodiException {

		Biblioteca b = new Biblioteca();

		// Crear socios
		Soci s1 = new Soci(1, "Juan Pérez", LocalDate.of(1996, 5, 10));
		Soci s2 = new Soci(2, "Ana López", LocalDate.of(2001, 8, 20));

		b.afegirSoci(s1);
		b.afegirSoci(s2);

		// Crear elements
		Llibre l1 = new Llibre("LAA0001", "El Quijote", 1605, 863, "Cervantes", "Anaya");
		Llibre l2 = new Llibre("LBB0002", "1984", 1949, 300, "George Orwell", "Debolsillo");
		Llibre l3 = new Llibre("LAC0003", "Cien años de soledad", 1967, 417, "Gabriel García Márquez", "Sudamericana");
		Pelicula p1 = new Pelicula("PCC0001", "Inception", 2010, 148, "PG-13");

		// Crear elements amb dades no vàlides
		Llibre l4 = new Llibre("SAA0001", "El Quijote", 1605, 863, "Cervantes", // Codi incorrecte
				"Anaya");
		Llibre l5 = new Llibre("LAA0003", "El Quijote", 1101, 863, "Cervantes", // Any incorrecte
				"Anaya");
		Llibre l6 = new Llibre("LAA0003", "El Quijote", 1605, -3, "Cervantes", // Nombre de pàgines incorrecte
				"Anaya");
		Pelicula p2 = new Pelicula("PCC0002", "Inception", 2010, 0, "PG-13"); // Durada invàlida

		System.out.println(b.afegirElement(l1));
		System.out.println(b.afegirElement(l2));
		System.out.println(b.afegirElement(p1));

		System.out.println(b.afegirElement(l1)); // Afegir repetit

		l3.setDisponible(false);
		// Mostrar elements disponibles
		System.out.println("=== ELEMENTS DISPONIBLES ===");
		b.mostrarDisponibles();

		Pelicula p3 = new Pelicula("PAB0002", "The Matrix", 1999, 136, "R");
		Pelicula p4 = new Pelicula("PAC0003", "Interstellar", 2014, 169, "PG-13");
		b.afegirElement(p3);
		b.afegirElement(p4);

		// Prestar elements
		System.out.println("\n=== PRÉSTECS ===");
		System.out.println(b.prestarElement("LAA0001", s1));
		System.out.println(b.prestarElement("PCC0001", s1));

		// Intentar superar límit de préstecs
		System.out.println(b.prestarElement("LBB0002", s1));
		System.out.println(b.prestarElement("PAB0002", s1));
		System.out.println(b.prestarElement("PAC0003", s1));

		// Intentar prestar un llibre ja prestat o no disponible
		System.out.println(b.prestarElement("LAA0001", s2)); // Ja prestat
		System.out.println(b.prestarElement("LAC0003", s2)); // No disponible

		// Mostrar elements d'un soci
		System.out.println("\n=== ELEMENTS DE JUAN ===");
		b.mostrarPrestecsSoci(1);

		// Buscar per títol
		System.out.println("\n=== CERCA ===");
		Element encontrado = b.buscarPerTitol("1984");
		System.out.println(encontrado);

		// Retornar element
		System.out.println("\n=== DEVOLUCIÓ ===");
		System.out.println(b.tornarElement("LAA0001"));
		System.out.println(b.tornarElement("LAC0003")); // No disponible

		// Comprovant penalització
		l2.setDataPrestec(LocalDate.of(2026, 3, 26));
		Soci s = l2.getSoci();
		System.out.println(b.tornarElement(l2.getCodi()));
		System.out.println(s.getPuntsPenalitzacio());

		// Eliminar element
		System.out.println("\n=== ELIMINAR ===");
		System.out.println(b.eliminarElement("LAA0001"));
		System.out.println(b.eliminarElement("PCC0001")); // Prestat
		System.out.println(b.eliminarElement("LBB0009")); // No existeix

		// Guardar en XML

		// Llegir XML

		// Exportar a CSV

		// Importar CSV
	}
}
