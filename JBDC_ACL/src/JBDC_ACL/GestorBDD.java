package JBDC_ACL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GestorBDD {
	private Connection connexio;

	public GestorBDD(Connection connexio) {
		this.connexio = connexio;
	}

	public void infoDPT() throws SQLException {
		Statement sentencia = connexio.createStatement();
		String sql = "SELECT * FROM DEPARTAMENTS";
		ResultSet resultat = sentencia.executeQuery(sql);
		while (resultat.next()) {
			System.out.println("C.Departament: " + resultat.getInt(1) + " Nom: " + resultat.getString(2) + " Ciutat: "
					+ resultat.getString(3));
		}
	}

	public void infoEMP() throws SQLException {
		Statement sentencia = connexio.createStatement();
		String sql = "SELECT D.NOM, E.CODI_EMP, E.COGNOM, E.COMISSIO, E.DATA_ALTA, E.OFICI, E.SALARI "
				+ "FROM EMPLEATS E " + "JOIN DEPARTAMENTS D ON E.CODI_DEPT = D.CODI_DEPT " + "ORDER BY D.NOM";
		ResultSet resultat = sentencia.executeQuery(sql);
		while (resultat.next()) {
			System.out.println("Nom Departament: " + resultat.getString(1) + " C.Empleat: " + resultat.getInt(2)
					+ " Cognom: " + resultat.getString(3) + " Comissió: " + resultat.getFloat(4) + " Data alta: "
					+ resultat.getDate(5) + " Ofici: " + resultat.getString(6) + " Salari: " + resultat.getFloat(7));
		}
	}

	public void InfoEMP_Punt4() throws SQLException {
		Statement sentencia = connexio.createStatement();
		String sql = "SELECT D.NOM, E.CODI_EMP, E.COGNOM, E.OFICI, E.SALARI, E.COMISSIO " + "FROM EMPLEATS E "
				+ "JOIN DEPARTAMENTS D ON E.CODI_DEPT = D.CODI_DEPT " + "ORDER BY D.NOM";
		ResultSet resultat = sentencia.executeQuery(sql);
		while (resultat.next()) {
			System.out.println("Nom Departament: " + resultat.getString(1) + " C.Empleat: " + resultat.getInt(2)
					+ " Cognom: " + resultat.getString(3) + " Ofici: " + resultat.getString(4) + " Salari: "
					+ resultat.getFloat(5) + " Comissió: " + resultat.getFloat(6));
		}
	}

	public void consultaEMPParam(int CodiParam) throws SQLException {
		String sql = "SELECT CODI_EMP, COGNOM FROM EMPLEATS WHERE CODI_DEPT = ?";
		PreparedStatement sentenciaPreparada = connexio.prepareStatement(sql);
		sentenciaPreparada.setInt(1, CodiParam);
		System.out.println("EMPLEATS DEL DEPARTAMENT " + CodiParam);
		ResultSet resultat = sentenciaPreparada.executeQuery();
		while (resultat.next()) {
			System.out.println("Codi empleat: " + resultat.getInt(1) + " Cognom: " + resultat.getString(2));
		}
	}

	public void afegirDepartament(int codiD, String nomD, String ciutatD) throws SQLException {
		Statement sentencia = connexio.createStatement();
		String sql = "INSERT INTO DEPARTAMENTS VALUES (" + codiD + ",'" + nomD + "','" + ciutatD + "')";
		int numfiles = sentencia.executeUpdate(sql);
		if (numfiles > 0) {
			System.out.println("Files afegides: " + numfiles);
		} else
			System.out.println("No s'ha afegit res.");
	}

	public void esborrarEmpleat(int codiE) throws SQLException {
		Statement sentencia = connexio.createStatement();
		String sql = "DELETE FROM EMPLEATS WHERE CODI_EMP = " + codiE;
		int numfiles = sentencia.executeUpdate(sql);
		System.out.println("Empleats esborrats: " + numfiles);
	}
}
