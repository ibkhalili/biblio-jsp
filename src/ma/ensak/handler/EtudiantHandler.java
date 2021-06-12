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
	private static String INSERT = "/etudiant/newEtudiant.jsp";
	private static String Edit = "/etudiant/editEtudiant.jsp";
	private static String EtudiantList = "/etudiant/listEtudiant.jsp";
	private EtudiantDao dao;

	public EtudiantHandler() {
		super();
		dao = new EtudiantDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String redirect="";
		String action = request.getParameter("action");
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
			} else if (action.equalsIgnoreCase("editform")){        	
				redirect = Edit;            
			} else if (action.equalsIgnoreCase("extraire")) {
				if (request.getParameter("extraire") != null) {
					System.out.println("le path: " + request.getParameter("extraire"));
					dao.extraire(request.getParameter("extraire"));
				}
				redirect = EtudiantList;
				
			} else if (action.equalsIgnoreCase("edit")){
				Etudiant etudiant = new Etudiant();
				etudiant.setCin(request.getParameter("cin"));
				etudiant.setNom(request.getParameter("nom"));
				etudiant.setPrenom(request.getParameter("prenom"));
				etudiant.setFiliere(request.getParameter("filiere"));
				dao.modifier(etudiant);
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
