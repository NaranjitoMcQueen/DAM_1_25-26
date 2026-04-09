package ClinicaMedica;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

public class GestorXML implements GestorFitxers {

	@Override
	public Set<Pacient> llegir(String nomFitxer) throws Exception {
		File fitxer = new File(nomFitxer);
		Set<Pacient> p = new TreeSet<>();

		try (XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(fitxer)))) {
			p = (Set<Pacient>) decoder.readObject();
			decoder.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
		return p;
	}

	@Override
	public void desa(String nomFitxer, Set<Pacient> pacient) {
		try (XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(nomFitxer)))) {
			encoder.writeObject(pacient);
		} catch (FileNotFoundException e) {
			System.out.println("No s'ha trobat el fitxer: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error en escriure XML: " + e.getMessage());
		}
	}

}
