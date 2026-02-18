package ExpRegulars;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		String dni = "12345678A";
		if (validarDNI(dni))
			System.out.println("DNI correcte: " + dni);
		else
			System.out.println("DNI incorrecte.");

		String mail = "arnau@gmail.cat";
		if (validarMail(mail))
			System.out.println("Mail correcte: " + mail);
		else
			System.out.println("Mail incorrecte.");

		String cadena = "APROEIS4L";
		if (validarCadena(cadena))
			System.out.println("Cadena correcte: " + cadena);
		else
			System.out.println("Cadena incorrecte.");

		String telefon = "612345678";
		if (validarTelefon(telefon))
			System.out.println("Telèfon correcte: " + telefon);
		else
			System.out.println("Telèfon incorrecte.");

		String clau = "12v#75A8";
		if (validarClau(clau))
			System.out.println("Contrasenya correcte");
		else
			System.out.println("Contrasenya no segura.");

		String matricula = "B-3456-AN";
		if (validarMatricula(matricula))
			System.out.println("Matricula correcte: " + matricula);
		else
			System.out.println("Matricula incorrecte.");
	}

	public static boolean validarDNI(String dni) {
		String esquemaDNI = ("[0-9]{8}[A-Z]{1}");
		Pattern patroDNI = Pattern.compile(esquemaDNI);
		Matcher emparelladorDNI = patroDNI.matcher(dni);
		return emparelladorDNI.find();
	}

	public static boolean validarMail(String mail) {
		String esquemaEmail = "^[A-Z a-z 0-9 \\- \\_ \\.]+(@(?=.*\\.[a-z]{2,3}$))";
		Pattern patroMail = Pattern.compile(esquemaEmail);
		Matcher emparelladorMail = patroMail.matcher(mail);
		return emparelladorMail.find();
	}

	public static boolean validarCadena(String cadena) {
		String esquemaCadena = "^[A-Z a-z 0-9]+$";
		Pattern patroCadena = Pattern.compile(esquemaCadena);
		Matcher emparelladorCadena = patroCadena.matcher(cadena);
		if (emparelladorCadena.find())
			return true;
		return false;
	}

	public static boolean validarTelefon(String telefon) {
		String esquemaTlf1 = "\\+34\\s+\\d{9}";
		String esquemaTlf2 = "\\d{3}\\s+\\d{2}\\s+\\d{2}\\s+\\d{2}";
		String esquemaTlf3 = "\\d{9}";
		if (Pattern.matches(esquemaTlf1, telefon) || Pattern.matches(esquemaTlf2, telefon)
				|| Pattern.matches(esquemaTlf3, telefon))
			return true;
		return false;
	}

	public static boolean validarClau(String clau) {
		String esquemaClau = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%&]).{8,}$";
		Pattern patroClau = Pattern.compile(esquemaClau);
		Matcher emparelladorClau = patroClau.matcher(clau);
		return emparelladorClau.find();
	}

	private static final List<String> CODIGOS_PROVINCIALES = Arrays.asList("A", "AB", "AL", "AV", "B", "BA", "BI", "BU",
			"C", "CA", "CC", "CS", "CR", "CO", "CU", "GE", "GR", "GU", "H", "HU", "J", "L", "LE", "LO", "LU", "M", "MA",
			"MU", "O", "OR", "P", "NA", "PM", "PO", "S", "SA", "SS", "SG", "SE", "SO", "T", "TE", "GC", "TF", "TO", "V",
			"VA", "VI", "Z", "ZA", "CE", "ML", "GI", "OU", "IB");

	public static boolean validarMatricula(String matricula) {
		// Format: B-3456-AN o HU-1234-X
		String esquemaMatr = "^([A-Z]{1,2})-\\d{4}-[A-Z]{1,2}$";

		// Format: 7890-MXZ
		String esquemaMatr2 = "^\\d{4}-[BCDFGHJKLMNPRSTVWXYZ]{3}$";

		if (matricula.matches(esquemaMatr2)) {
			return true;
		}

		if (matricula.matches(esquemaMatr)) {
			String provincia = matricula.split("-")[0];
			return CODIGOS_PROVINCIALES.contains(provincia);
		}

		return false;

	}

}
