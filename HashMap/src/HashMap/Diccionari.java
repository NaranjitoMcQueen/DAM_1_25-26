package HashMap;

import java.util.HashMap;
import java.util.Map;

public class Diccionari {
	public Map<String, String> dades;

	// Inicialitzar
	public Diccionari() {
		this.dades = new HashMap<>();
	}

	// Afegri
	public void afegir(String paraula, String definicio) {
		dades.put(paraula, definicio);
	}

	// Eliminar
	public String eliminar(String paraula) {
		String remove = dades.remove(paraula);
		if (remove != null) {
			return remove;
		}
		return null;
	}

	// Mostrar tamany
	public int tamany() {
		return dades.size();
	}

	// Cercar paraula
	public String cercar(String paraula) {
		return dades.get(paraula);
	}

	// Mostrar hashmap
	public String llistar() {
		String info = "";
		for (String paraula : dades.keySet()) {
			info = info + "\nParaula: " + paraula + " - Definició: " + dades.get(paraula);
		}
		return info;
	}

	// Info
	@Override
	public String toString() {
		return "\nParaula i definició: " + dades;
	}

}