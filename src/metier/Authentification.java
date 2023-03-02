package metier;

public class Authentification {
	
	private String email;
	private String mdp;
	
	public Authentification() {}
	public Authentification(String email, String mdp) {
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
