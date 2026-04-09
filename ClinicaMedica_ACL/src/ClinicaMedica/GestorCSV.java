package ClinicaMedica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Set;
import java.util.TreeSet;

public class GestorCSV implements GestorFitxers {

	@Override
	public Set<Pacient> llegir(String nomFitxer) throws Exception {
		File fitxer = new File(nomFitxer);
		Set<Pacient> pacient = new TreeSet<>();

		try (BufferedReader br = new BufferedReader(new FileReader(nomFitxer))) {
			String linia;
			while ((linia = br.readLine()) != null) {
				Pacient p = toPacient(linia);
				if (p != null) {
					pacient.add(p);
				}
			}
			return pacient;
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public void desa(String nomFitxer, Set<Pacient> pacient) {
		try (PrintWriter pw = new PrintWriter(new FileWriter(nomFitxer))) {
			for (Pacient p : pacient) {
				// ENUNCIAT: Utilitzar mètode que converteix vehicle a String
				pw.println(toCSV(p));
			}
		} catch (IOException e) {
			System.out.println("Error en desar: " + e.getMessage());
		}
	}

	public String toCSV(Pacient p) {
		return p.toString();
	}

	public Pacient toPacient(String linia) throws Exception {
		// SPLIT per delimitador: El ";" separa els camps del fitxer CSV/Text
		String[] info = linia.trim().split(";");

		// NETEJA DE DADES: Trim de cada element de l'array per evitar errors de parsing
		for (int i = 0; i < info.length; i++) {
			info[i] = info[i].trim();
		}

		if (!"Pacient".equals(info[0])) {
			return null;
		}

		String nom = info[1];
		String dni = info[2];
		LocalDate dataNaix = LocalDate.parse(info[3]);
		String telefon = info[4];

		if ("Pacient".equals(info[0])) {
			String codi = info[5];
			String historial = info[6];
			int totalPacients = Integer.parseInt(info[7]);

			Pacient pct = new Pacient(nom, dni, dataNaix, telefon, codi, historial);
			return pct;
		} else {
			return null;
		}
	}

}
