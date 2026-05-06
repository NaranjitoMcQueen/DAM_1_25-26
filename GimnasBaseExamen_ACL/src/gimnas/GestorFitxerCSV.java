package gimnas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;
import java.util.TreeSet;

public class GestorFitxerCSV implements GestorFitxers {

	@Override
	public Set<Client> llegir(String nomFitxer) throws Exception {
		Set<Client> llista = new TreeSet<>();
		try (BufferedReader br = new BufferedReader(new FileReader(nomFitxer))) {
			String linia;
			while ((linia = br.readLine()) != null) {
				if (linia.trim().startsWith("#") || linia.trim().isEmpty())
					continue;
				try {
					Client c = toClient(linia);
					if (c != null)
						llista.add(c);
				} catch (Exception ex) {
					System.err.println("Error en línia CSV: " + ex.getMessage());
				}
			}
		}
		return llista;
	}

	@Override
	public void desa(String nomFitxer, Set<Client> clients) {
		try (PrintWriter pw = new PrintWriter(new FileWriter(nomFitxer))) {
			for (Client c : clients) {
				pw.println("Client," + c.getDni() + "," + c.getNom() + "," + c.getCognoms() + "," + c.getTelefon() + ","
						+ c.getDataNaixement() + "," + c.getMembresia());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Client toClient(String linia) throws InvalidDniException {
		String[] info = linia.split(",");
		for (int i = 0; i < info.length; i++)
			info[i] = info[i].trim();

		String dni = info[1];
		String nom = info[2];
		String cognoms = info[3];
		String telefon = info[4];
		String dataNaixement = info[5];
		TipusMembresia membresia = TipusMembresia.valueOf(info[6]);

		if ("Client".equals(info[0])) {
			Client c = new Client(dni, nom, cognoms, telefon, dataNaixement, membresia);
			return c;
		} else {
			return null;
		}
	}

}
