package ClinicaMedica;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

public class Cita implements Comparable<Cita> {

	private Pacient pacient;
	private Doctor doctor;
	private LocalDate data;
	private LocalTime hora;
	private Estat estat;

	public Cita(Pacient pacient, Doctor doctor, LocalDate data, LocalTime hora) throws IllegalArgumentException {
		super();
		if (comprovarData(data, hora)) {
			if (valEdatCita(pacient, doctor.getEspecialitat())) {
				this.pacient = pacient;
				this.doctor = doctor;
				this.data = data;
				this.hora = hora;
				this.estat = Estat.Pendent;
			} else {
				throw new IllegalArgumentException("El pacient no té l'edat permesa per a aquesta especialitat.");
			}
		} else {
			throw new IllegalArgumentException("La data de la cita ha de ser futura.");
		}
	}

	public Pacient getPacient() {
		return pacient;
	}

	public void setPacient(Pacient pacient) {
		this.pacient = pacient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public static boolean comprovarData(LocalDate data, LocalTime hora) {
		LocalDateTime ara = LocalDateTime.now();
		LocalDateTime fechaHoraCita = LocalDateTime.of(data, hora);
		return fechaHoraCita.isAfter(ara);
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public Estat getEstat() {
		return estat;
	}

	public void setEstat(Estat estat) {
		this.estat = estat;
	}

	public void confirmarCita() {
		this.estat = Estat.Realitzada;
	}

	public void cancellarCita() throws IllegalStateException {
		if (this.estat != Estat.Pendent) {
			throw new IllegalStateException("Només es poden cancel·lar cites pendents.");
		} else if (this.estat != Estat.Realitzada) {
			throw new IllegalStateException("No es pot cancel·lar una cita ja realitzada");
		}
		this.estat = Estat.Cancellada;
	}

	public static boolean valEdatCita(Pacient p, Especialitat e) {
		LocalDate naix = p.getDnaix();
		int naixAny = naix.getYear();
		int naixDia = naix.getDayOfYear();
		LocalDate avui = LocalDate.now();

		int edat = avui.getYear() - naixAny;
		if (naixDia < avui.getDayOfYear()) {
			edat--;
		}

		int edatEspMin = e.getEdatmin();
		int edatEspMax = e.getEdatmax();

		if (edat >= edatEspMin && edat <= edatEspMax) {
			return true;
		}
		return false;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cita other = (Cita) obj;
		return Objects.equals(data, other.data) && Objects.equals(doctor, other.doctor)
				&& Objects.equals(hora, other.hora) && Objects.equals(pacient, other.pacient);
	}

	@Override
	public String toString() {
		return "Cita [pacient=" + pacient.getNom() + ", doctor=" + doctor.getNom() + ", data=" + data + ", hora=" + hora
				+ ", estat=" + estat + "]";
	}

	@Override
	public int compareTo(Cita o) {
		int compData = this.data.compareTo(o.getData());
		if (compData != 0)
			return compData;
		return this.hora.compareTo(o.getHora());
	}

}
