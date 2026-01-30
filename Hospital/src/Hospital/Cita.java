package Hospital;

import java.time.LocalDate;
import java.time.LocalTime;

public class Cita {

	private Pacient pacient;
	private Doctor doctor;
	private LocalDate data;
	private LocalTime hora;
	private estatCita estat;

	// CONSTRUCTOR
	public Cita(Pacient pacient, Doctor doctor, LocalDate data, LocalTime hora, estatCita estat) {
		super();
		this.pacient = pacient;
		this.doctor = doctor;
		LocalDate datacita = LocalDate.now();
		this.data = datacita.plusDays(5);
		LocalTime horacita = LocalTime.now();
		this.hora = horacita.plusHours(15);
		this.estat = estatCita.PENDING;
	}

	// PERSONA
	public Pacient getPacient() {
		return pacient;
	}

	public void setPacient(Pacient pacient) {
		this.pacient = pacient;
	}

	/*
	 * public boolean comprobacioEdat(int edat) { if (edat < edatMinima) return
	 * false; return true; }
	 */

	// DOCTOR
	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	// DATA
	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	// HORA
	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	// ESTAT
	public estatCita getEstat() {
		return estat;
	}

	public void setEstat(estatCita estat) {
		this.estat = estat;
	}

	// ESTAT CITA
	public int confirmarCita() {
		if (estat == estatCita.CANCELED || estat == estatCita.COMPLETED) {
			return -1;
		}
		estat = estatCita.COMPLETED;
		return 0;
	}

	public int cancellarCita() {
		if (estat == estatCita.COMPLETED) {
			return -1;
		}
		estat = estatCita.CANCELED;
		return 0;
	}

	public enum estatCita {
		COMPLETED, CANCELED, PENDING;
	}

	// INFO
	@Override
	public String toString() {
		return "Cita [pacient=" + pacient + ", doctor=" + doctor + ", data=" + data + ", hora=" + hora + ", estat="
				+ estat + "]";
	}
}