package JBDC_ACL;

import java.sql.Date;
import java.util.Objects;

public class Empleat implements Comparable<Empleat> {
	private int codi_emp;
	private String cognom;
	private String ofici;
	private Date data_alta;
	private double salari;
	private double comissio;
	private Departament dept;

	public Empleat(int codi_emp, String cognom, String ofici, Date data_alta, double salari, double comissio,
			Departament dept) {
		this.codi_emp = codi_emp;
		this.cognom = cognom;
		this.ofici = ofici;
		this.data_alta = data_alta;
		this.salari = salari;
		this.comissio = comissio;
		this.dept = dept;
	}

	public Empleat(int codi_emp) {
		this.codi_emp = codi_emp;
	}

	public int getCodi_emp() {
		return codi_emp;
	}

	public void setCodi_emp(int codi_emp) {
		this.codi_emp = codi_emp;
	}

	public String getCognom() {
		return cognom;
	}

	public void setCognom(String cognom) {
		this.cognom = cognom;
	}

	public String getOfici() {
		return ofici;
	}

	public void setOfici(String ofici) {
		this.ofici = ofici;
	}

	public Date getData_alta() {
		return data_alta;
	}

	public void setData_alta(Date data_alta) {
		this.data_alta = data_alta;
	}

	public double getSalari() {
		return salari;
	}

	public void setSalari(double salari) {
		this.salari = salari;
	}

	public double getComissio() {
		return comissio;
	}

	public void setComissio(double comissio) {
		this.comissio = comissio;
	}

	public Departament getDept() {
		return dept;
	}

	public void setDept(Departament dept) {
		this.dept = dept;
	}

	@Override
	public int compareTo(Empleat o) {
		return Integer.compare(this.codi_emp, o.codi_emp);
	}

	@Override
	public int hashCode() {
		return Objects.hash(codi_emp);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleat other = (Empleat) obj;
		return codi_emp == other.codi_emp;
	}

	@Override
	public String toString() {
		return "\nCodi: " + codi_emp + " Cognom: " + cognom + " Ofici: " + ofici + " Data d'alta: " + data_alta
				+ " Salari: " + salari + " Comissió: " + comissio + " N.DPT: " + dept.getCodi_dept();
	}

}
