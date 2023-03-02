package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class GestionEtudiant implements IGestionEtudiant {

	@Override
	public void addEtudiant(Etudiant e) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into Etudiants(numEt,nomEt,prenomEt,DateNaissance,LieuxNaissance"
					+ ",Email,NumTel,Sexe,semestre) values(?,?,?,?,?,?,?,?,?)");
			ps.setString(1, e.getNumEt());
			ps.setString(2, e.getNomEt());
			ps.setString(3, e.getPrenomEt());
			ps.setString(4, e.getDateNaiss());
			ps.setString(5, e.getLieuNaiss());
			ps.setString(6, e.getEmail());
			ps.setString(7, e.getNumTel());
			ps.setString(8, e.getSexe());
			ps.setString(9, e.getSemestre());
		
			ps.executeUpdate();
			ps.close();
			
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	@Override
	public void deleteEtudiant(String numEt) {
	Connection conn = SingletonConnection.getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement("delete from Etudiants where NumEt=?");
			
			ps.setString(1,numEt);
			
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		

	}

	@Override
	public void updateEtudiant(Etudiant e) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("update Etudiants set "
					+ "nomEt=? ,prenomEt=?,DateNaissance=?,LieuxNaissance=?,Email=?,"
					+ "NumTel=?,Sexe=?,semestre=? where numEt=?");
		
			ps.setString(1, e.getNomEt());
			ps.setString(2, e.getPrenomEt());
			ps.setString(3, e.getDateNaiss());
			ps.setString(4, e.getLieuNaiss());
			ps.setString(5, e.getEmail());
			ps.setString(6, e.getNumTel());
			ps.setString(7, e.getSexe());
			ps.setString(8, e.getSemestre());
			ps.setString(9, e.getNumEt());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
		
		

	}

	@Override
	public Etudiant getEtudiant(String numEt) {
		Connection conn = SingletonConnection.getConnection();
		Etudiant e = null;
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * from Etudiants WHERE numEt=? ;");
			ps.setString(1, numEt);
			ResultSet rs = ps.executeQuery();
			
			
			if(rs.next()) {
				e= new Etudiant();
				e.setNumEt(rs.getString("numEt"));
				e.setNomEt(rs.getString("nomEt"));
				e.setPrenomEt(rs.getString("prenomEt"));
				e.setDateNaiss(rs.getString("DateNaissance"));
				e.setLieuNaiss(rs.getString("LieuxNaissance"));
				e.setEmail(rs.getString("Email"));
				e.setNumTel(rs.getString("NumTel"));
				e.setSexe(rs.getString("Sexe"));
				e.setSemestre(rs.getString("Semestre"));
			
			
			
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(e==null)throw new RuntimeException("Etudiant "+numEt+" inexistant");
		
	return e;	
	}

	@Override
	public List<Etudiant> listEtudiants() {
		List<Etudiant> etudiants = new ArrayList<Etudiant>();
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * from Etudiants ;");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Etudiant e = new Etudiant();
				e.setNumEt(rs.getString("numEt"));
				e.setNomEt(rs.getString("nomEt"));
				e.setPrenomEt(rs.getString("prenomEt"));
				e.setDateNaiss(rs.getString("DateNaissance"));
				e.setLieuNaiss(rs.getString("LieuxNaissance"));
				e.setEmail(rs.getString("Email"));
				e.setNumTel(rs.getString("NumTel"));
				e.setSexe(rs.getString("Sexe"));
				e.setSemestre(rs.getString("Semestre"));
				etudiants.add(e);
				
			
			
			
			}
			ps.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return etudiants;
	}

	@Override
	public List<Etudiant> EtudiantsParMC(String mc) {
		List<Etudiant> etudiants = new ArrayList<Etudiant>();
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * from Etudiants where nomEt like ?;");
			ps.setString(1,"%"+ mc+"%");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Etudiant e = new Etudiant();
				e.setNumEt(rs.getString("numEt"));
				e.setNomEt(rs.getString("nomEt"));
				e.setPrenomEt(rs.getString("prenomEt"));
				e.setDateNaiss(rs.getString("DateNaissance"));
				e.setLieuNaiss(rs.getString("LieuxNaissance"));
				e.setEmail(rs.getString("Email"));
				e.setNumTel(rs.getString("NumTel"));
				e.setSexe(rs.getString("Sexe"));
				e.setSemestre(rs.getString("Semestre"));
				etudiants.add(e);
				
			}
			ps.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch(NullPointerException e2) {
			e2.printStackTrace();
			
		}
		
		return etudiants;
		
	}

}
