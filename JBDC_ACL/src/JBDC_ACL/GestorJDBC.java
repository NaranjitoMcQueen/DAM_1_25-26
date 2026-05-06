package JBDC_ACL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class GestorJDBC {
	private static Connection connexio = GestorConnexions.obtenirConnexio();

	public int afegirDepartament(Departament d) throws SQLException {
		String sql = "INSERT INTO DEPARTAMENTS VALUES(?,?,?)";
		PreparedStatement sentencia = connexio.prepareStatement(sql);
		sentencia.setInt(1, d.getCodi_dept());
		sentencia.setString(2, d.getNom());
		sentencia.setString(3, d.getCiutat());
		int files = sentencia.executeUpdate();
		return files;
	}

	public int afegirEmpleat(Empleat e) throws SQLException {
		String sql = "INSERT INTO EMPLEATS VALUES(?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement sentencia = connexio.prepareStatement(sql);
		sentencia.setInt(1, e.getCodi_emp());
		sentencia.setString(2, e.getCognom());
		sentencia.setString(3, e.getOfici());
		sentencia.setDate(4, new java.sql.Date(e.getData_alta().getTime()));
		sentencia.setDouble(5, e.getSalari());
		sentencia.setDouble(6, e.getComissio());
		sentencia.setInt(7, e.getDept().getCodi_dept());
		int files = sentencia.executeUpdate();
		return files;
	}

	public HashSet<Departament> getDepartaments(boolean ambEmpleats) throws SQLException {
		HashSet<Departament> llistaDpts = new HashSet<>();
		String sqlD = "SELECT * FROM DEPARTAMENTS";
		String sqlE = "SELECT * FROM EMPLEATS WHERE CODI_DEPT = ?";
		try (Statement sentencia = connexio.createStatement(); ResultSet resultatD = sentencia.executeQuery(sqlD)) {
			try (PreparedStatement sentenciaE = connexio.prepareStatement(sqlE)) {
				while (resultatD.next()) {
					int codi = resultatD.getInt(1);
					String nom = resultatD.getString(2);
					String ciutat = resultatD.getString(3);
					Set<Empleat> empleats = new HashSet<>();
					Departament d = new Departament(codi, nom, ciutat, empleats);
					llistaDpts.add(d);
					if (ambEmpleats) {
						sentenciaE.setInt(1, codi);
						try (ResultSet resultatE = sentenciaE.executeQuery()) {
							while (resultatE.next()) {
								try {
									Empleat e = new Empleat(resultatE.getInt(1), resultatE.getString(2),
											resultatE.getString(3), resultatE.getDate(4), resultatE.getDouble(5),
											resultatE.getDouble(6), d);
									d.afegirEmpleat(e);
								} catch (Exception ex) {
									System.err.println("Error creant l'objecte Empleat: " + ex.getMessage());
									ex.printStackTrace();
								}
							}
							System.out.println(d.toString());
						}
					} else {
						System.out.println(d.printDepts());
					}
				}
			}
		}
		return llistaDpts;
	}

	/*
	 * public HashSet<Empleat> getEmpleat(Departament d) throws SQLException {
	 * HashSet<Empleat> llistaEmps = new HashSet<>(); String sql =
	 * "SELECT * FROM EMPLEATS WHERE CODI_DEPT = ?"; try (Statement sentencia =
	 * connexio.createStatement(); ResultSet resultatD =
	 * sentencia.executeQuery(sql)) {
	 * 
	 * } return llistaEmps; }
	 */

	public Departament cercarDepartament(int codiD) throws SQLException {
		String sql = "SELECT * FROM DEPARTAMENTS WHERE CODI_DEPT = ?";
		try (PreparedStatement sentencia = connexio.prepareStatement(sql)) {
			sentencia.setInt(1, codiD);
			try (ResultSet resultat = sentencia.executeQuery()) {
				if (resultat.next()) {
					return new Departament(resultat.getInt("codi_dept"), resultat.getString("nom"),
							resultat.getString("ciutat"));
				}
			}
		}
		return null;
	}

	public int esborrarEmpleat(int codiEmp) throws SQLException {
		String sql = "DELETE FROM EMPLEATS WHERE CODI_EMP = ?";
		try (PreparedStatement sentencia = connexio.prepareStatement(sql)) {
			sentencia.setInt(1, codiEmp);
			return sentencia.executeUpdate();
		}
	}

	public int esborrarDepartament(Departament d, boolean cascade) throws SQLException {
		if (d == null || d.getCodi_dept() <= 0) {
			return 0;
		}
		int numfiles = 0;
		if (cascade) {
			String sqlEmpleats = "DELETE FROM EMPLEATS WHERE CODI_DEPT = ?";
			PreparedStatement sentenciaE = connexio.prepareStatement(sqlEmpleats);
			sentenciaE.setInt(1, d.getCodi_dept());
			sentenciaE.executeUpdate();
			sentenciaE.close();
		} else {
			return 0;
		}
		String sqlDept = "DELETE FROM DEPARTAMENTS WHERE CODI_DEPT = ?";
		PreparedStatement sentenciaD = connexio.prepareStatement(sqlDept);
		sentenciaD.setInt(1, d.getCodi_dept());
		return numfiles = sentenciaD.executeUpdate();
	}

	public int modificarSalari(Departament d, int percentatge) {
		double factor = 1 + (percentatge / 100.0);
		String sqlMS = "UPDATE EMPLEATS SET SALARI = SALARI * ? WHERE CODI_DEPT = ?";
		int files = 0;
		try (PreparedStatement sentenciaS = connexio.prepareStatement(sqlMS)) {
			sentenciaS.setDouble(1, factor);
			sentenciaS.setInt(2, d.getCodi_dept());
			files = sentenciaS.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error en actualitzar el salari: " + e.getMessage());
		}
		return files;
	}

	public int modificarComissio(Empleat e, int comissio) {
		int files = 0;
		String sqlMC = "UPDATE EMPLEATS SET COMISSIO = ? WHERE CODI_EMP = ?";
		try (PreparedStatement sentenciaC = connexio.prepareStatement(sqlMC)) {
			sentenciaC.setDouble(1, comissio);
			sentenciaC.setInt(2, e.getCodi_emp());
			files = sentenciaC.executeUpdate();
		} catch (SQLException a) {
			System.out.println("Error en actualitzar el salari: " + a.getMessage());
		}
		return files;
	}
}
