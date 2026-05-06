package JBDC_ACL;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Departament implements Comparable<Departament> {
	private int codi_dept;
	private String nom;
	private String ciutat;
	private Set<Empleat> empleats = new HashSet<>();

	public Departament(int codi_dept, String nom, String ciutat) {
		this.codi_dept = codi_dept;
		this.nom = nom;
		this.ciutat = ciutat;
	}

	public Departament(int codi_dept, String nom, String ciutat, Set<Empleat> empleats) {
		this.codi_dept = codi_dept;
		this.nom = nom;
		this.ciutat = ciutat;
		this.empleats = empleats;
	}

	public int getCodi_dept() {
		return codi_dept;
	}

	public void setCodi_dept(int codi_dept) {
		this.codi_dept = codi_dept;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCiutat() {
		return ciutat;
	}

	public void setCiutat(String ciutat) {
		this.ciutat = ciutat;
	}

	public Set<Empleat> getEmpleats() {
		return empleats;
	}

	public void setEmpleats(Set<Empleat> empleats) {
		this.empleats = empleats;
	}

	public void afegirEmpleat(Empleat e) {
		empleats.add(e);
	}

	@Override
	public String toString() {
		return "\nCodi: " + codi_dept + " Nom: " + nom + " Ciutat: " + ciutat + "\n	Empleats: " + empleats;
	}

	public String printDepts() {
		return "Codi: " + codi_dept + " Nom: " + nom + " Ciutat: " + ciutat;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codi_dept);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Departament other = (Departament) obj;
		return codi_dept == other.codi_dept;
	}

	@Override
	public int compareTo(Departament o) {
		return Integer.compare(this.codi_dept, o.codi_dept);
	}

}
