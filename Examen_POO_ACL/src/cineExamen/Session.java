package cineExamen;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class Session {

	private int code;
	private LocalDate date;
	private LocalTime time;
	private Movie movie;
	private int room;
	private int maximumCapacity;
	private Set<String> sessionClients = new HashSet<>();
	private SessionStatus status;

	public Session(LocalDate date, LocalTime time, Movie movie, int room, int maximumCapacity) {
		super();
		this.date = date;
		this.time = time;
		this.movie = movie;
		this.room = room;
		if (valMaxCapacitat(maximumCapacity)) {
			this.maximumCapacity = maximumCapacity;
		} else
			throw new IllegalArgumentException("La capacitat màxima no es trobe correctament establerta.");
	}

	public Session(int code, LocalDate date, LocalTime time, Movie movie, int room, int maximumCapacity,
			Set<String> sessionClients, SessionStatus status) {
		super();
		this.code = code;
		this.date = date;
		this.time = time;
		this.movie = movie;
		this.room = room;
		this.maximumCapacity = maximumCapacity;
		this.sessionClients = sessionClients;
		this.status = status;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	/*
	 * private LocalDate validarData(LocalDate date) throws IllegalArgumentException
	 * { if (date == null) { throw new
	 * IllegalArgumentException("La data es obligatoria"); } try { DateTimeFormatter
	 * formatter = DateTimeFormatter.ofPattern("yyyy, MM, dd"); LocalDate d =
	 * LocalDate.parse(date, formatter); if (d.isBefore(LocalDate.now())) { throw
	 * new IllegalArgumentException("La data no pot ser pasada."); } return d; }
	 * catch (DateTimeParseException e) { throw new
	 * IllegalArgumentException("Format de data incorrecte. Fes servir yyyy, MM, dd."
	 * ); } }
	 */

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public int getRoom() {
		return room;
	}

	public void setRoom(int room) {
		this.room = room;
	}

	public int getMaximumCapacity() {
		return maximumCapacity;
	}

	public void setMaximumCapacity(int maximumCapacity) {
		this.maximumCapacity = maximumCapacity;
	}

	public static boolean valMaxCapacitat(int maximumCapacity) {
		if (maximumCapacity <= 0) {
			return false;
		}
		return true;
	}

	/*
	 * public boolean equals(Session s) { return this.code.equals(s).getCode()); }
	 */

}
