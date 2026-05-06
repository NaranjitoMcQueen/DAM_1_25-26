package gimnas;

import java.util.Set;

public interface GestorFitxers {

	public Set<Client> llegir(String nomFitxer) throws Exception;

	public void desa(String nomFitxer, Set<Client> clients);
}
