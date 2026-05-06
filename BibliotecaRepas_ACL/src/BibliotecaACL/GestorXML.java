package BibliotecaACL;

import java.beans.*;
import java.io.*;
import java.util.*;

public class GestorXML implements GestorFitxers {
	@Override
	public void desa(String nomFitxer, Set<Element> element) {
		try (XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(nomFitxer)))) {
			encoder.writeObject(element);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Set<Element> llegir(String nomFitxer) throws Exception {
		try (XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(nomFitxer)))) {
			return (Set<Element>) decoder.readObject();
		} catch (FileNotFoundException e) {
			System.out.println("No s'ha trobat el fitxer: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error en escriure XML: " + e.getMessage());
		}
	}
}