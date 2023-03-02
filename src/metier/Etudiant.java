package metier;

import java.io.Serializable;

public class Etudiant implements Serializable {
	private String numEt;
	private String nomEt;
	private String prenomEt;
	private String dateNaiss;
	private String lieuNaiss;
	private String email;
	private String sexe;
	private String numTel;
	private String semestre;
	
	public String getNumEt() {
		return numEt;
	}
	public Etudiant() {
		super();
	}
	public Etudiant(String i, String nomEt, String prenomEt, String dateNaiss, String lieuNaiss, String email,
			String sexe, String numTel, String semestre) {
		super();
		this.numEt = i;
		this.nomEt = nomEt;
		this.prenomEt = prenomEt;
		this.dateNaiss = dateNaiss;
		this.lieuNaiss = lieuNaiss;
		this.email = email;
		this.sexe = sexe;
		this.numTel = numTel;
		this.semestre = semestre;
		
	}
	public void setNumEt(String numEt) {
		this.numEt = numEt;
	}
	public String getNomEt() {
		return nomEt;
	}
	public void setNomEt(String nomEt) {
		this.nomEt = nomEt;
	}
	public String getPrenomEt() {
		return prenomEt;
	}
	public void setPrenomEt(String prenomEt) {
		this.prenomEt = prenomEt;
	}
	public String getDateNaiss() {
		return dateNaiss;
	}
	public void setDateNaiss(String dateNaiss) {
		this.dateNaiss = dateNaiss;
	}
	public String getLieuNaiss() {
		return lieuNaiss;
	}
	public void setLieuNaiss(String lieuNaiss) {
		this.lieuNaiss = lieuNaiss;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public String getNumTel() {
		return numTel;
	}
	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}
	public String getSemestre() {
		return semestre;
	}
	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
	@Override
	public String toString() {
		return "Etudiant [numEt=" + numEt + ", nomEt=" + nomEt + ", prenomEt=" + prenomEt + ", dateNaiss=" + dateNaiss
				+ ", lieuNaiss=" + lieuNaiss + ", email=" + email + ", sexe=" + sexe + ", numTel=" + numTel
				+ ", semestre=" + semestre + "]";
	}
	
	

}
