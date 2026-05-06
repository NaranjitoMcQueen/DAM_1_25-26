package cineExamen;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Cinema {

	private String name;
	private String address;
	private Set<Client> clients = new TreeSet<>();
	private List<Movie> movies = new ArrayList<>();
	private Set<Session> sessions = new TreeSet<>();

	public Cinema(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}

	public Cinema(String name, String address, Set<Client> clients, List<Movie> movies, Set<Session> sessions) {
		super();
		this.name = name;
		this.address = address;
		this.clients = clients;
		this.movies = movies;
		this.sessions = sessions;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Client cercarClient(Client client) {
		for (Client c : clients) {
			if (c.getPhone().equals(client)) {
				return null;
			}
		}
		return client;
	}

	public boolean registerClient(Client client) {
		if (cercarClient(client) == null) {
			return false;
		}
		return clients.add(client);
	}

	public void showClients() {
		String LlistaClient = "";
		for (Client c : clients) {
			if (c instanceof Client) {
				LlistaClient = clients.toString();
			}
		}
		System.out.println("Llista:\n" + LlistaClient);
	}

	public boolean removeClient(String phone) {
		Object client = cercarClient(phone);
		if (client == null) {
			return false;
		}
		return clients.remove(phone);
	}

	private Object cercarClient(String phone) {
		for (Client p : clients) {
			if (p.getPhone().equals(phone)) {
				return null;
			}
		}
		return phone;
	}

	public Movie cercarMovie(Movie movie) {
		for (Movie m : movies) {
			if (m.getTitle().equals(movie)) {
				return null;
			}
		}
		return movie;
	}

	public boolean registerMovie(Movie movie) {
		if (cercarMovie(movie) == null) {
			return false;
		}
		return movies.add(movie);
	}

	public void showMovies() {
		String llistaMovies = "";
		for (Movie m : movies) {
			if (m instanceof Movie) {
				llistaMovies = movies.toString();
			}
		}
		System.out.println("Llista:\n" + llistaMovies);
		// amb només un return llistaMovies ja es troba correcte.
	}

	/*
	 * public boolean registerSession(Session session) { if (cercarSession(session)
	 * == null) { return false; } return sessions.add(session); }
	 * 
	 * public Session cercarSession(Session session) { for (Session s : sessions) {
	 * if (s.getCode().equals(session)) { return null; } } return session; }
	 */

}
