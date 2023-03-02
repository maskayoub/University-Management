package metier;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GestionInscription {
	
	
	public void ajouterInscription(Inscription i) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into	Inscriptions(numEt,codeFil,dateInscription,semestre,groupe"
					+ ") values(?,?,?,?,?)");
			ps.setString(1, i.getNumEt());
			ps.setString(2, i.getCodeFil());
			ps.setString(3, i.getDateInscription());
			ps.setString(4, i.getSemestre());
			ps.setString(5, i.getGroupe());
			ps.executeUpdate();
			ps.close();
			
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}		
	}
	
	public Inscription getInscription(String numEt) {
		Connection conn = SingletonConnection.getConnection();
		Inscription i = null;
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * from Inscriptions WHERE numEt=? ;");
			ps.setString(1, numEt);
			ResultSet rs = ps.executeQuery();
			
			
			if(rs.next()) {
				i= new Inscription();
				i.setNumEt(rs.getString("numEt"));
				i.setCodeFil(rs.getString("codeFil"));
				i.setDateInscription(rs.getString("dateInscription"));
				i.setSemestre(rs.getString("semestre"));
				i.setGroupe(rs.getString("groupe"));
				


			
			
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(i==null)throw new RuntimeException("Inscription "+ numEt +" inexistante");
		
	return i;	
		
	}
	
	public List<Inscription> listInscription(){
		List<Inscription> inscriptions = new ArrayList<Inscription>();
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * from Inscriptions ;");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Inscription i = new Inscription();
				i.setIdInscription(Integer.parseInt(rs.getString("idInscription")));
				i.setNumEt(rs.getString("numEt"));
				i.setCodeFil(rs.getString("codeFil"));
				i.setDateInscription(rs.getString("dateInscription"));
				i.setSemestre(rs.getString("semestre"));
				i.setGroupe(rs.getString("groupe"));
				inscriptions.add(i);
				
			
			
			
			}
			ps.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return inscriptions;
		
	}
	
	
	

}
