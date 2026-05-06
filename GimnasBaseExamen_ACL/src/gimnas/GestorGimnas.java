package gimnas;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class GestorGimnas {

	private String nom;
	private String adreca;
	private TreeSet<Client> clients = new TreeSet<>();
	private HashSet<Entrenador> entrenadors = new HashSet<>();
	private List<ActivitatGimnas> activitats = new ArrayList<>();

	public GestorGimnas() {

	}

	public GestorGimnas(String nom, String adreca) {
		super();
		this.nom = nom;
		this.adreca = adreca;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdreca() {
		return adreca;
	}

	public void setAdreca(String adreca) {
		this.adreca = adreca;
	}

	public TreeSet<Client> getClients() {
		return clients;
	}

	public void setClients(TreeSet<Client> clients) {
		this.clients = clients;
	}

	public boolean registrarClient(Client client) {
		return clients.add(client);
	}

	public void mostrarClients() {
		boolean clientsPositiu = false;
		int tClients = 0;

		for (Client c : clients) {
			System.out.println(c);
			clientsPositiu = true;
		}

		if (!clientsPositiu) {
			System.out.println("No hi ha cap client");
		}
	}

	public Client buscarClient(String dni) {
		for (Client c : clients) {
			if (c.getDni().equals(dni)) {
				System.out.println(c);
			}
		}
		return null;
	}

	public HashSet<Entrenador> getEntrenadors() {
		return entrenadors;
	}

	public void setEntrenadors(HashSet<Entrenador> entrenadors) {
		this.entrenadors = entrenadors;
	}

	public boolean registrarEntrenador(Entrenador entrenador) {
		return entrenadors.add(entrenador);
	}

	public List<ActivitatGimnas> getActivitats() {
		return activitats;
	}

	public void setActivitats(List<ActivitatGimnas> activitats) {
		this.activitats = activitats;
	}

	public boolean registrarActivitat(ActivitatGimnas activitat) {
		return activitats.add(activitat);
	}

	public boolean inscriureClientEnActivitat(String dni, ActivitatGimnas act) {
		if (dni == null || act == null) {
			return false;
		}
		return false;
	}

	@Override
	public String toString() {
		return "GestorGimnas [nom=" + nom + ", adreca=" + adreca + ", clients=" + clients + ", entrenadors="
				+ entrenadors + ", activitats=" + activitats + "]";
	}

	public void eliminarAllClients() {
		TreeSet<Client> clientsElim = new TreeSet<>();

		for (Client c : clients) {
			if (c.getDni().equals(clients)) {
				clientsElim.add(c);
				clients.removeAll(clientsElim);
			}
		}
	}

}
