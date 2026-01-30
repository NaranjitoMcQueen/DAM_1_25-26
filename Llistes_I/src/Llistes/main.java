package Llistes;

import java.util.ArrayList;
import java.util.LinkedList;

public class main {

	public static void main(String[] args) {
		// Tasca llistes I
		// Llista String 
			String[] medicina = new String[10];
			int pos = 0;
			medicina[pos] = "Paracetamol";
			pos++;
			medicina[pos] = "Amoxicilna";
			pos++;
			// Mostrar String
			for (int i = 0; i < pos; i++) {
				System.out.println(medicina[i]);
			}
			// Afegir String
			medicina[pos] = "Ibuprofeno";
			pos++;
			// Esborrar String (per posició i per valor)
			medicina[pos] = null; // No obligatori
			pos--;; // Elimina un contador per no arrivar al final
			// Mostra mida String
			System.out.println("\nMida llista String: " + pos + "\n");
			
		// Llista LinkedList
			LinkedList<String> equipMedic = new LinkedList<>();
			equipMedic.add("Estetoscopi");
			equipMedic.add("Guants");
			// Mostrar LinkedList
			System.out.println("LinkedList: " + equipMedic);
			// Afegir LinkedList
			equipMedic.add("Termòmetre");
			equipMedic.add("Pulsioxímetre");
			// Esborrar LinkedList (per posició i per valor)
			equipMedic.remove(1);
			equipMedic.remove("Estetoscopi");
			// Mostra mida LinkedList
			System.out.println("\nMida LinkedList: " + equipMedic.size());
			
		// Llista ArrayList
			ArrayList<String> emergencies = new ArrayList<>();
			emergencies.add("Paramèdic");
			emergencies.add("TCAI");
			// Mostrar ArrayList
			System.out.println("\nLlista ArrayList: " + emergencies);
			// Afegir ArrayList
			emergencies.add("Infermer");
			emergencies.add("TES");
			// Esborrar ArrayList (per posició i per valor)
			emergencies.remove(1);
			emergencies.remove("Infermer");
			System.out.println("\nLlista ArrayList: " + emergencies);
			// Mostra mida ArrayList
			System.out.println("\nMida ArrayList: " + emergencies.size());
	}

}