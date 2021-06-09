
package ma.ensak.handler;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.ensak.beans.Emprunt;
import ma.ensak.dao.EmpruntDao;

public class EmpruntHandler extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String INSERT = "/Emprunt.jsp";
	private static String Edit = "/editEmprunt.jsp";
	private static String EmpruntList = "/listEmprunt.jsp";
	private EmpruntDao dao;

	public EmpruntHandler() {
		super();
		dao = new EmpruntDao();
	}

	@SuppressWarnings("deprecation")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String redirect="";
		String action = request.getParameter("action");
		System.out.println("action: " + action);
		try {
			if(action.equalsIgnoreCase("insert"))
			{
				Emprunt emp = new Emprunt();
				emp.setNumero(Integer.parseInt(request.getParameter("numero")));
				emp.setNumero_livre(Integer.parseInt(request.getParameter("numero_livre")));
				emp.setCin_etudiant(request.getParameter("cin_etudiant"));
				emp.setDate(new Date(request.getParameter("date")));
				emp.setRemis_le(new Date(request.getParameter("remis_le")));
				dao.ajouter(emp);
				redirect = EmpruntList;
				request.setAttribute("emprunts", dao.Lister());    
				System.out.println("Emprunt Added Successfully");
			}
			/*
			else if (action.equalsIgnoreCase("delete")){
				String numero = request.getParameter("numero");
				dao.supprimer(Integer.parseInt(numero));
				redirect = EmpruntList;
				request.setAttribute("emprunts", dao.Lister());
				System.out.println(" Deleted Successfully");
				*/
			}else if (action.equalsIgnoreCase("editform")){        	
				redirect = Edit;            
			} else if (action.equalsIgnoreCase("edit")){
				
				String numeroStr = request.getParameter("numero");
				System.out.println("numeroStr: " + numeroStr);
				Emprunt emp = new Emprunt();
				emp.setNumero(Integer.parseInt(numeroStr));
				emp.setNumero_livre(request.getParameter("numero"));
				emp.setNumero_edition(request.getParameter("numero_edition"));
				livre.setDate_apparition(new Date(request.getParameter("date_apparition")));
				livre.setStock(Integer.parseInt(request.getParameter("stock")));
				dao.modifier(livre);
				System.out.println("livre: " + livre);
				request.setAttribute("livre", livre);
				redirect = LivreList;
				System.out.println("Livre updated Successfully");
			} else if (action.equalsIgnoreCase("listLivre")){
				redirect = LivreList;
				request.setAttribute("livres", dao.Lister());
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
