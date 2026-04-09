package ClinicaMedica;

import java.util.HashSet;
import java.util.TreeSet;

public class Hospital {

	// TreeSet sense repetit i ordenat
	// HashSet sense repetit pero desordenat

	private String nom;
	private String adreça;
	private HashSet<Pacient> pacients = new HashSet<>();
	private HashSet<Doctor> doctors = new HashSet<>();
	private HashSet<Especialitat> especialitats = new HashSet<>();
	private TreeSet<Cita> cites = new TreeSet<>();

	public Hospital(String nom, String adreça, HashSet<Pacient> pacients, HashSet<Doctor> doctors,
			HashSet<Especialitat> especialitats, TreeSet<Cita> cites) {
		super();
		this.nom = nom;
		this.adreça = adreça;
		this.pacients = pacients;
		this.doctors = doctors;
		this.especialitats = especialitats;
		this.cites = cites;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdreça() {
		return adreça;
	}

	public void setAdreça(String adreça) {
		this.adreça = adreça;
	}

	// Pacients
	public HashSet<Pacient> getPacients() {
		return pacients;
	}

	public void setPacients(HashSet<Pacient> pacients) {
		this.pacients = pacients;
	}

	public boolean registrarPacient(Pacient p) {
		return pacients.add(p);
	}

	// PREGUNTAR TEACHER
	public void dadesPacients() {
		for (Pacient p : pacients) {
			System.out.println(p);
		}
	}

	public int totalPacients() {
		return pacients.size();
	}

	// Docs
	public HashSet<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(HashSet<Doctor> doctors) {
		this.doctors = doctors;
	}

	public boolean registrarDoctor(Doctor d) {
		return doctors.add(d);
	}

	public void dadesDoctors() {
		for (Doctor d : doctors) {
			System.out.println(d);
		}
	}

	// Especialitats
	public HashSet<Especialitat> getEspecialitats() {
		return especialitats;
	}

	public void setEspecialitats(HashSet<Especialitat> especialitats) {
		this.especialitats = especialitats;
	}

	public boolean registrarEspecialitat(Especialitat e) {
		return especialitats.add(e);
	}

	public void dadesEspecialitats() {
		for (Especialitat e : especialitats) {
			System.out.println(e);
		}
	}

	// Cites
	public TreeSet<Cita> getCites() {
		return cites;
	}

	public void setCites(TreeSet<Cita> cites) {
		this.cites = cites;
	}

	public boolean registrarCites(Cita c) {
		return cites.add(c);
	}

	@Override
	public String toString() {
		return "Hospital [nom=" + nom + ", adreça=" + adreça + ", pacients=" + pacients + ", doctors=" + doctors
				+ ", especialitats=" + especialitats + ", cites=" + cites + "]";
	}

	/*
	 * • Eliminar pacient (s’han d’esborrar també les seves cites futures) •
	 * Cancel·lar una cita prèviament agendada • Canviar l’estat d’una cita •
	 * Mostrar cites per dia
	 */

}
