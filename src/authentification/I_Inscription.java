package authentification;

public interface I_Inscription {
	public void validationEmail(String email) throws Exception;
	public void validationMdp(String mdp,String confirmation)throws Exception;
	public void validationNom(String nom)throws Exception;


}
