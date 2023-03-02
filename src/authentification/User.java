package authentification;

public class User {
	private String email;
	private String mdp;
	private String statut;
	
	
	

	public String getStatut() {
		return statut;
	}


	public void setStatut(String statut) {
		this.statut = statut;
	}


	public User() {}
	
	
	public User(String email, String mdp) {
		super();
		this.email = email;
		this.mdp = mdp;
	}

	


	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
}
