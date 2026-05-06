package cineExamen;

import java.util.regex.Pattern;

public class Client implements Comparable<Client> {

	private String name;
	private String phone;

	public Client(String name, String phone) throws IllegalArgumentException {
		super();
		this.name = name;
		if (phone != null && valTelefon(phone)) {
			this.phone = phone;
		} else
			throw new IllegalArgumentException("El telèfon no és correcte o no cumpleix els requisits");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public static boolean valTelefon(String phone) {
		if (phone == null) {
			return true;
		}
		String esquemaTlf1 = "^6\\d{8}";
		String esquemaTlf2 = "^9\\d{8}";
		if (Pattern.matches(esquemaTlf1, phone) || Pattern.matches(esquemaTlf2, phone)) {
			return true;
		}
		return false;
	}

	/*
	 * Patró corregit: String regex = "^[69]{1}[0-9]{8}" return
	 * Pattern.matches(regex, phone); No cal, però si poses ^, seria lògic posar $
	 * al final "^[69]\\d{8}$" El {1} no fa falta.
	 */

	@Override
	public String toString() {
		return "Client [name=" + name + ", phone=" + phone + "]";
	}

	@Override
	public int compareTo(Client altre) {
		return this.phone.compareTo(altre.phone);
	}

}
