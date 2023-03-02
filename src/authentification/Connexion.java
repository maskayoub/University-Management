package authentification;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import metier.SingletonConnection;


public class Connexion {
	 private static final String CHAMP_EMAIL  = "email";
	    private static final String CHAMP_PASS   = "motdepasse";

	    private String  resultat;
	    private Map<String, String> erreurs = new HashMap<String, String>();

	    public String getResultat() {
	        return resultat;
	    }

	    public Map<String, String> getErreurs() {
	        return erreurs;
	    }

	    public User connecterUtilisateur( HttpServletRequest request ) {
	        /* Récupération des champs du formulaire */
	        String email = getValeurChamp( request, CHAMP_EMAIL );
	        String motDePasse = getValeurChamp( request, CHAMP_PASS );

	        User user = new User();

	        /* Validation du champ email. */
	        try {
	            validationEmail( email );
	        } catch ( Exception e ) {
	            setErreur( CHAMP_EMAIL, e.getMessage() );
	        }
	        user.setEmail( email );

	        /* Validation du champ mot de passe. */
	        try {
	            validationMotDePasse( motDePasse );
	        } catch ( Exception e ) {
	            setErreur( CHAMP_PASS, e.getMessage() );
	        }
	        user.setMdp( motDePasse );
	        
	        //Comparation de l email et mdp avec ceux dans la bd
			Connection conn = SingletonConnection.getConnection();
	        try {
	        	PreparedStatement ps = conn.prepareStatement("SELECT * from Authentification where email="+email+"&& mdp="+motDePasse);
	        }catch(Exception e) {
	        	
	        }

	        /* Initialisation du résultat global de la validation. */
	        if ( erreurs.isEmpty() ) {
	            resultat = "Succès de la connexion.";
	        } else {
	            resultat = "Échec de la connexion.";
	        }

	        return user;
	    }

	   
	     // Valide l'adresse email saisie.
	     
	    private void validationEmail( String email ) throws Exception {
	        if ( email != null && !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
	            throw new Exception( "Merci de saisir une adresse mail valide." );
	        }
	    }

	  
	     // Valide le mot de passe saisi.
	     
	    private void validationMotDePasse( String motDePasse ) throws Exception {
	        if ( motDePasse != null ) {
	            if ( motDePasse.length() < 3 ) {
	                throw new Exception( "Le mot de passe doit contenir au moins 3 caractères." );
	            }
	        } else {
	            throw new Exception( "Merci de saisir votre mot de passe." );
	        }
	    }

	   
	    // Ajoute un message correspondant au champ spécifié à la map des erreurs.
	     
	    public void setErreur( String champ, String message ) {
	        erreurs.put( champ, message );
	    }

	    
	      //Méthode utilitaire qui retourne null si un champ est vide, et son contenu sinon.
	    
	     
	    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
	        String valeur = request.getParameter( nomChamp );
	        if ( valeur == null || valeur.trim().length() == 0 ) {
	            return null;
	        } else {
	            return valeur;
	        }
	    }
	    
	    public List<User> listeUtilisateurs(HttpServletRequest request){
	    	List<User> l  = new ArrayList<User>();
	    	Connection conn = SingletonConnection.getConnection();
	    	try {
	    		PreparedStatement ps = conn.prepareStatement("select * from user");
	    		ResultSet rs = ps.executeQuery();
	    		while(rs.next()) {
	    			User u = new User();
	    			u.setEmail(rs.getString("email"));
	    			u.setMdp(rs.getString("mdp"));
	    			u.setStatut(rs.getString("statut"));
	    			l.add(u);
	    		}
	    		ps.close();
	    	}catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch(NullPointerException e2) {
				e2.printStackTrace();
				
			}
	    	
			
	    	
	    	
	    	return l; }
	

}
