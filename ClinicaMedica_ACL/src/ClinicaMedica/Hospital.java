package ClinicaMedica;

import java.time.LocalDate;
import java.time.LocalTime;
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

	public Hospital(String nom, String adreça) {
		super();
		this.nom = nom;
		this.adreça = adreça;
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

	public void dadesPacients() {
		for (Pacient p : pacients) {
			System.out.println(p);
		}
	}

	public int totalPacients() {
		return pacients.size();
	}

	public Pacient cercarPacient(String dni) {
		if (dni.isEmpty()) {
			return null;
		}
		for (Pacient p : pacients) {
			if (p.getDni().equals(dni)) {
				return p;
			}
		}
		return null;
	}

	public boolean eliminarPacient(String dni) {
		Pacient p = cercarPacient(dni);
		for (Cita c : cites) {
			if (c.getPacient().equals(p)) {
				eliminarCita(c);
			}
		}
		return false;
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

	public boolean eliminarCita(Cita c) {
		for (Cita cit : cites) {
			if (cit.equals(c)) {
				cites.remove(c);
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @param dniP Otorgem el DNI del Pacient per cercar-ho.
	 * @param data Otorgem la data de la cita per cercar-la.
	 * @param hora Otorgem l'hora de la cita per cercar-la.
	 * @return
	 * @throws IllegalStateException
	 */
	public boolean cancellarCita(String dniP, LocalDate data, LocalTime hora) throws IllegalStateException {
		for (Cita c : cites) {
			if (c.getPacient().getDni().equals(dniP) && c.getData().equals(data) && c.getHora().equals(hora)) {
				c.cancellarCita();
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @param dniD Otorgem el DNI del Doctor per cercar-ho.
	 * @param data Otorgem la data de la cita per cercar-la.
	 * @param hora Otorgem l'hora de la cita per cercar-la.
	 * @return
	 * @throws IllegalStateException
	 */
	public boolean modificarCita(String dniD, LocalDate data, LocalTime hora) throws IllegalStateException {
		if (Cita.comprovarData(data, hora) == true) {
			for (Cita c : cites) {
				if (c.getDoctor().getDni().equals(dniD) && c.getData().equals(data) && c.getHora().equals(hora)) {
					c.confirmarCita();
					return true;
				}
			}
		} else {
			throw new IllegalStateException("No es pot modificar una cita passada");
		}
		return false;
	}

	/**
	 * 
	 * @param data Otorgem la data a cercar les cites.
	 */
	public void mostrarCites(LocalDate data) {
		boolean existeixCita = false;
		int citesData = 0;

		for (Cita c : cites) {
			if (c.getData().equals(data)) {
				existeixCita = true;
				citesData++;
			}
		}

		if (!existeixCita) {
			System.out.println("No hi ha cap cita agendada per la data " + data);
		} else {
			System.out.println("Hi han aquest nombre de cites: " + citesData + " per la data: " + data);
			for (Cita c : cites) {
				if (c.getData().equals(data)) {
					String dniP = c.getPacient().getDni();
					LocalTime hCita = c.getHora();
					System.out.println("DNI Pacient: " + dniP + " - Hora: " + hCita);
				}
			}
		}
	}

	@Override
	public String toString() {
		return "Hospital [nom=" + nom + ", adreça=" + adreça + ", pacients=" + pacients + ", doctors=" + doctors
				+ ", especialitats=" + especialitats + ", cites=" + cites + "]";
	}

}
