package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import authentification.*;


/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String att_user="utilisateur";
	public static final String att_conn="conn";
	public static final String att_session_user="sessionUtilisateur";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		boolean p = true;
		List<User> users;
		UtilisateurModel um = new UtilisateurModel();
		Connexion connexion = new Connexion();
		User user = connexion.connecterUtilisateur(request);		
		if(session.getAttribute(att_session_user)==null) {
		p = false;
			
		request.setAttribute("usermodel", um);
		users = connexion.listeUtilisateurs(request);
		boolean t = false;
		for(User u:users) {
			System.out.println(user.getEmail());
			System.out.println(user.getMdp());
			if(user!=null) {
			if((user.getEmail().equals(u.getEmail()))&&(user.getMdp().equals(u.getMdp())))
				t = true;
			}
		}
		
		if(t==false)
			connexion.setErreur("user", "connection failed");
		
		if(connexion.getErreurs().isEmpty()) {
			session.setAttribute(att_session_user, user);
			response.sendRedirect("index.jsp");
		}
		else {
			session.setAttribute(att_session_user, null);
			response.sendRedirect("home2.jsp");
		}
		request.setAttribute(att_conn, connexion);
		request.setAttribute(att_user, user);
		
		}
			
	
		
	}

}
