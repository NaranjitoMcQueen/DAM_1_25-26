package gimnas;

import java.util.TreeSet;

public class ActivitatGimnas {

	private String nom;
	private Entrenador entrenador;
	private int capacitatMaxima;
	private int edatMinima;
	private TreeSet<Client> clients = new TreeSet<>();

	public ActivitatGimnas(String nom, Entrenador entrenador, int capacitatMaxima, int edatMinima) {
		super();
		this.nom = nom;
		this.entrenador = entrenador;
		if (capacitatMaxima <= 0) {
			throw new IllegalStateException("Cal com a minim una persona inscrita");
		}
		this.capacitatMaxima = capacitatMaxima;
		if (edatMinima < 0) {
			throw new IllegalStateException("S'ha de ser major o igual a 0 anys");
		}
		this.edatMinima = edatMinima;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Entrenador getEntrenador() {
		return entrenador;
	}

	public void setEntrenador(Entrenador entrenador) {
		this.entrenador = entrenador;
	}

	public int getCapacitatMaxima() {
		return capacitatMaxima;
	}

	public void setCapacitatMaxima(int capacitatMaxima) {
		this.capacitatMaxima = capacitatMaxima;
	}

	public int getEdatMinima() {
		return edatMinima;
	}

	public void setEdatMinima(int edatMinima) {
		this.edatMinima = edatMinima;
	}

	public TreeSet<Client> getClients() {
		return clients;
	}

	public void setClients(TreeSet<Client> clients) {
		this.clients = clients;
	}

	public void mostrarClients() {
		String LlistaClients = "";
		for (Client c : clients) {
			if (c instanceof Client) {
				LlistaClients = clients.toString();
			}
		}
		System.out.println("Llista:\n" + LlistaClients);
	}

	public boolean inscriureClient(Client c) {
		return clients.add(c);
	}

	@Override
	public String toString() {
		return "ActivitatGimnas [nom=" + nom + ", entrenador=" + entrenador + ", capacitatMaxima=" + capacitatMaxima
				+ ", edatMinima=" + edatMinima + "]";
	}

}
