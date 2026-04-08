package FitxersACL;

import java.util.Set;

public interface InterficieGestorFitxer {
	public Set<Vehicle> llegir(String nomFitxer) throws Exception;

	public void desa(String nomFitxer, Set<Vehicle> vehicles);
}
