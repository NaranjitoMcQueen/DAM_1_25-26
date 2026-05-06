package BibliotecaACL;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Biblioteca {
	private TreeSet<Element> elements = new TreeSet<>();
	private HashSet<Soci> socis = new HashSet<>();

	public void afegirSoci(Soci s) {
		socis.add(s);
	}

	public boolean afegirElement(Element e) {
		return elements.add(e);
	}

	public boolean prestarElement(String codi, Soci s) {
		Element e = buscarPerCodi(codi);
		if (e == null || e.isPrestat())
			return false;

		long numPrestecs = elements.stream().filter(el -> s.equals(el.getSoci())).count();
		if (numPrestecs >= 4)
			return false;

		e.setPrestat(true);
		e.setSoci(s);
		e.setDataPrestec(LocalDate.now());
		return true;
	}

	public boolean tornarElement(String codi) {
		Element e = buscarPerCodi(codi);
		if (e == null || !e.isPrestat())
			return false;

		// Calcular penalització
		long dies = ChronoUnit.DAYS.between(e.getDataPrestec(), LocalDate.now());
		long limit = (e instanceof Pelicula) ? 7 : 14;
		if (dies > limit) {
			e.getSoci().setPuntsPenalitzacio(e.getSoci().getPuntsPenalitzacio() + (int) (dies - limit));
		}

		e.setPrestat(false);
		e.setSoci(null);
		return true;
	}

	public void mostrarDisponibles() {
		for (Element e : elements) { // elements és el TreeSet<Element>
			if (e.isDisponible() && !e.isPrestat()) {
				System.out.println(e);
			}
		}
	}

	public Element buscarPerCodi(String codi) {
		return elements.stream().filter(e -> e.getCodi().equals(codi)).findFirst().orElse(null);
	}

	public Element buscarPerTitol(String titol) {
		return elements.stream().filter(e -> e.getTitol().equalsIgnoreCase(titol)).findFirst().orElse(null);
	}

	public void mostrarPrestecsSoci(int codiSoci) {
		elements.stream().filter(e -> e.getSoci() != null && e.getSoci().getCodi() == codiSoci)
				.forEach(System.out::println);
	}
}