package BibliotecaACL;

import java.util.Set;

public interface GestorFitxers {

	public Set<Element> llegir(String nomFitxer) throws Exception;

	public void desa(String nomFitxer, Set<Element> element);
}
