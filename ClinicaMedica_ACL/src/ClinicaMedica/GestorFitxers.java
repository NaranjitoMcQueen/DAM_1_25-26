package ClinicaMedica;

import java.util.Set;

public interface GestorFitxers {

	public Set<Pacient> llegir(String nomFitxer) throws Exception;

	public void desa(String nomFitxer, Set<Pacient> pacient);
}
