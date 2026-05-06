package gimnas;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Set;

public class GestorFitxerXML implements GestorFitxers {

	@Override
	public Set<Client> llegir(String nomFitxer) throws Exception {
		try (XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(nomFitxer)))) {
			return (Set<Client>) decoder.readObject();
		}
	}

	@Override
	public void desa(String nomFitxer, Set<Client> clients) {
		try (XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(nomFitxer)))) {
			encoder.writeObject(clients);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
