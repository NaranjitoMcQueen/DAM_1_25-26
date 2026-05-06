package BibliotecaACL;

import java.io.*;
import java.util.*;

public class GestorCSV implements GestorFitxers {
	@Override
	public Set<Element> llegir(String nomFitxer) throws Exception {
		Set<Element> llista = new TreeSet<>();
		try (BufferedReader br = new BufferedReader(new FileReader(nomFitxer))) {
			String linia;
			while ((linia = br.readLine()) != null) {
				if (linia.trim().startsWith("#") || linia.trim().isEmpty())
					continue;
				try {
					Element e = toElement(linia);
					if (e != null)
						llista.add(e);
				} catch (Exception ex) {
					// Si una línia del CSV falla, la ignorem i seguim
					System.err.println("Error en línia CSV: " + ex.getMessage());
				}
			}
		}
		return llista;
	}

	public Element toElement(String linia) throws InvalidCodiException {
		String[] info = linia.split(";");
		for (int i = 0; i < info.length; i++)
			info[i] = info[i].trim();

		String codi = info[0];
		String titol = info[1];
		int any = Integer.parseInt(info[2]);
		String tipus = info[3].toLowerCase();

		if (tipus.equals("llibre")) {
			return new Llibre(codi, titol, any, Integer.parseInt(info[4]), info[5], info[6]);
		} else if (tipus.equals("pelicula")) {
			return new Pelicula(codi, titol, any, Integer.parseInt(info[4]), info[5]);
		}
		return null;
	}

	@Override
	public void desa(String nomFitxer, Set<Element> element) {
		try (PrintWriter pw = new PrintWriter(new FileWriter(nomFitxer))) {
			for (Element e : element) {
				if (e instanceof Llibre) {
					Llibre l = (Llibre) e;
					pw.println(l.getCodi() + ";" + l.getTitol() + ";" + l.getAny_publicacio() + ";llibre;"
							+ l.getNum_pagines() + ";" + l.getAutor() + ";" + l.getEditorial());
				} else if (e instanceof Pelicula) {
					Pelicula p = (Pelicula) e;
					pw.println(p.getCodi() + ";" + p.getTitol() + ";" + p.getAny_publicacio() + ";pelicula;"
							+ p.getDuracio() + ";" + p.getClassificacio());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}