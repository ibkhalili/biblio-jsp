package ma.ensak.handler;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.ensak.beans.Etudiant;
import ma.ensak.dao.EtudiantDao;

public class EtudiantHandler extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String INSERT = "/Etudiant.jsp";
	private static String Edit = "/editEtudiant.jsp";
	private static String EtudiantList = "/listEtudiant.jsp";
	private EtudiantDao dao;

	public EtudiantHandler() {
		super();
		dao = new EtudiantDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String redirect="";
		String action = request.getParameter("action");
		System.out.println("action: " + action);
		try {
			if(action.equalsIgnoreCase("insert"))
			{
				Etudiant Etudiant = new Etudiant();
				Etudiant.setNom(request.getParameter("nom"));
				Etudiant.setPrenom(request.getParameter("prenom"));
				Etudiant.setFiliere(request.getParameter("filiere"));
				Etudiant.setCin(request.getParameter("cin"));
				dao.ajouter(Etudiant);
				redirect = EtudiantList;
				request.setAttribute("Etudiants", dao.Lister());    
				System.out.println("Etudiant Added Successfully");
			}
			else if (action.equalsIgnoreCase("delete")){
				String cin = request.getParameter("cin");
				dao.supprimer(cin);
				redirect = EtudiantList;
				request.setAttribute("Etudiants", dao.Lister());
				System.out.println("Etudiant Deleted Successfully");
			}else if (action.equalsIgnoreCase("editform")){        	
				redirect = Edit;            
			} else if (action.equalsIgnoreCase("edit")){
				
				//String numeroStr = request.getParameter("numero");
				//System.out.println("numeroStr: " + numeroStr);
				Etudiant etudiant = new Etudiant();
				// etudiant.setNumero(Integer.parseInt(numeroStr));
				// !!
				etudiant.setNom(request.getParameter("Nom"));
				etudiant.setPrenom(request.getParameter("Prenom"));
				etudiant.setFiliere(request.getParameter("filiere"));
				dao.modifier(etudiant);
				System.out.println("etudiant: " + etudiant);
				request.setAttribute("etudiant", etudiant);
				redirect = EtudiantList;
				System.out.println("Etudiant updated Successfully");
			} else if (action.equalsIgnoreCase("listEtudiant")){
				redirect = EtudiantList;
				request.setAttribute("Etudiants", dao.Lister());
			} else {
				redirect = INSERT;
			}
		} catch (Exception e) {
			System.err.print(e);
		}
		RequestDispatcher rd = request.getRequestDispatcher(redirect);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}