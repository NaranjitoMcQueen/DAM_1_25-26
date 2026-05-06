package gimnas;

import java.util.Objects;

public class Client extends Persona {

	private int idClient;
	public TipusMembresia membresia;
	private int classesInscrites;
	private static int numClients = 0;

	public Client(String dni, String nom, String cognoms, String telefon, String dataNaixement,
			TipusMembresia membresia) throws InvalidDniException {
		super(dni, nom, cognoms, telefon, dataNaixement);
		if (!valTipus(membresia)) {
			throw new IllegalStateException("No hi es un tipus valid");
		}
		this.membresia = membresia;
		idClient = numClients++;
	}

	public Client(String dni, String nom, String cognoms, String dataNaixement, TipusMembresia membresia)
			throws InvalidDniException {
		super(dni, nom, cognoms, dataNaixement);
		if (!valTipus(membresia)) {
			throw new IllegalStateException("No hi es un tipus valid");
		}
		this.membresia = membresia;
		idClient = numClients++;
	}

	public Client() {
		super();
	}

	public int getIdClient() {
		return idClient;
	}

	public TipusMembresia getMembresia() {
		return membresia;
	}

	public void setMembresia(TipusMembresia membresia) {
		this.membresia = membresia;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public static boolean valTipus(TipusMembresia membresia) {
		return membresia != null;
	}

	public int getClassesInscrites() {
		return classesInscrites;
	}

	public void setClassesInscrites(int classesInscrites) {
		this.classesInscrites = classesInscrites;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idClient);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return idClient == other.idClient;
	}

	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", membresia=" + membresia + ", classesInscrites=" + classesInscrites
				+ "]";
	}

}
