package web;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import metier.Etudiant;
import metier.GestionEtudiant;
import metier.IGestionEtudiant;
import authentification.*;
import metier.Inscription;
import metier.GestionInscription;

public class ControleurServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IGestionEtudiant metier;
	private GestionInscription imetier;
	private Connexion connexion;
	public static final String att_user="utilisateur";
	public static final String att_conn="conn";
	public static final String att_session_user="sessionUtilisateur";
	public static final String vue="/connexion.jsp";
       
	@Override
	public void init() {
		metier= new GestionEtudiant();
		imetier = new GestionInscription();
		connexion = new Connexion();
		
		
	}
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
		/*HttpSession session = request.getSession();
		boolean p = true;
		List<User> users;
		UtilisateurModel um = new UtilisateurModel();
		Connexion connexion = new Connexion();
		User user = connexion.connecterUtilisateur(request);
		
		String action = request.getServletPath();
		
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
		if(p==true)
			doPost(request,response);
		if(action != null) {
			if(action .equals("/logout.php")) {
				System.out.println("logout");
				session.removeAttribute(att_session_user);
				System.out.println("true");
				session.invalidate();
				System.out.println("truue");
				response.sendRedirect("home2.jsp");
				System.out.println("truuue");
			}
		}*/
	}
	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		HttpSession session = request.getSession();
		String url ="";
		String list="help.jsp";
		String edit="etudiant.jsp";
		
		String action = request.getServletPath();
		String a = request.getParameter("action");
		List<Etudiant> etudiants;
		List<Inscription> inscriptions;
		EtudiantModel model = new EtudiantModel();
		InscriptionModel imodel = new InscriptionModel();
		request.setAttribute("model", model);
		etudiants = metier.listEtudiants();
		model.setEtudiants(etudiants);
		System.out.println("etudiants");
		if(action!=null) {
			if(session.getAttribute("sessionUtilisateur")==null)
				{response.sendRedirect("home2.jsp");}
				System.out.println("a");
			
				System.out.println("list");
				
				
				

				if(etudiants == null)
				System.out.println("liste vide");
				model.setEtudiants(etudiants);
				url=list;
			
								
			
			
				if(action.equals("/chercher.php")) {
			
				System.out.println(1);
				model.setMotCle(request.getParameter("motCle"));
				System.out.println(2);
				
				etudiants = metier.EtudiantsParMC(model.getMotCle());
				System.out.println(3);
				model.setEtudiants(etudiants);
				url=list;
				
			}
			
				else if(action.equals("/view.php")) {
					String numEt = request.getParameter("numEt");
					
					imodel.setI(imetier.getInscription(numEt));
					
					
				}
			
		
			
			else if(action.equals("/ajout.php")/* || action.equals("edit")*/) {
				
				Etudiant e = new Etudiant();
				Inscription i =new Inscription();
				String numEt = request.getParameter("numEt");
				String semestre = request.getParameter("semestre");
					
				
					
					e.setNumEt(numEt);
					e.setNomEt(request.getParameter("nomEt"));
					e.setPrenomEt(request.getParameter("prenomEt"));
					e.setDateNaiss(request.getParameter("dateNaiss"));
					e.setLieuNaiss(request.getParameter("lieuNaiss"));
					e.setSexe(request.getParameter("sexe"));
					e.setEmail(request.getParameter("email"));
					e.setNumTel(request.getParameter("numTel"));
					e.setSemestre(semestre);
					model.setEtudiant(e);
					metier.addEtudiant(model.getEtudiant());
					model.setEtudiants(metier.listEtudiants());
					
					i.setNumEt(numEt);
					i.setCodeFil(request.getParameter("codeFil"));
					i.setDateInscription(request.getParameter("dateInscription"));
					i.setSemestre(semestre);
					i.setGroupe(request.getParameter("groupe"));
					imodel.setI(i);
					imetier.ajouterInscription(imodel.getI());
					imodel.setInscriptions(imetier.listInscription());
					url=list;
					
				
				}
			else if(a!=null) {
				if(a.equals("delete")) {
					System.out.println("delete");
					
					String ref =request.getParameter("cne");
				
					Etudiant e =new Etudiant();
					e = metier.getEtudiant(ref);
					model.setEtudiant(e);
					
					
					
					
					metier.deleteEtudiant(model.getEtudiant().getNumEt());
					model.setEtudiants(metier.listEtudiants()); 
					url=list;
				}
			
				else if(a.equals("edit")) {
					
			
				request.setAttribute("model", request.getParameter("cne"));
				url=edit;
				}
				else if(a.equalsIgnoreCase("update")) {
					
					Etudiant e = new Etudiant();
				String numEt = request.getParameter("numEt");
				e.setNumEt(numEt);
				String nomEt = request.getParameter("nomEt");
				e.setNomEt(nomEt);
				String prenomEt = request.getParameter("prenomEt");
				e.setPrenomEt(prenomEt);
				String dateNaiss = request.getParameter("dateNaiss");
				e.setDateNaiss(dateNaiss);
				String lieuNaiss = request.getParameter("lieuNaiss");
				e.setLieuNaiss(lieuNaiss);
				String sexe = request.getParameter("sexe");
				e.setSexe(sexe);
				String email = request.getParameter("email");
				e.setEmail(email);
				String numTel = request.getParameter("numTel");
				e.setNumTel(numTel);
				String semestre = request.getParameter("semestre");
				e.setSemestre(semestre);
				model.setEtudiant(e);
				metier.updateEtudiant(model.getEtudiant());
				model.setEtudiants(metier.listEtudiants());
				url=list;
			
			}
			}
			
			}
		
		request.getRequestDispatcher(url).forward(request, response);

		}
	
}
