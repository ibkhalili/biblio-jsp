
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
	private static String INSERT = "/emprunt/newEmprunt.jsp";
	private static String Edit = "/emprunt/editEmprunt.jsp";
	private static String EmpruntList = "/emprunt/listEmprunt.jsp";
	private EmpruntDao dao;

	public EmpruntHandler() {
		super();
		dao = new EmpruntDao();
	}

	@SuppressWarnings("deprecation")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String redirect="";
		String action = request.getParameter("action");
		// System.out.println("action: " + action);
		try {
			if(action.equalsIgnoreCase("insert"))
			{
				Emprunt emp = new Emprunt();
				// emp.setNumero(Integer.parseInt(request.getParameter("numero")));
				emp.setNumero_livre(Integer.parseInt(request.getParameter("numero_livre")));
				emp.setCin_etudiant(request.getParameter("cin_etudiant"));
				emp.setDate(new Date(request.getParameter("date")));
				// emp.setRemis_le(new Date(request.getParameter("remis_le")));
				dao.ajouter(emp);
				redirect = EmpruntList;
				request.setAttribute("emprunts", dao.Lister());    
				System.out.println("Emprunt Added Successfully");
			} else if(action.equalsIgnoreCase("remis")) {
				String numeroStr = request.getParameter("numero");
				Emprunt emp = dao.getEmpruntById(Integer.parseInt(numeroStr));
				if (request.getParameter("remis_le") != null) {
					emp.setRemis_le(new Date(request.getParameter("remis_le")));
					dao.modifier(emp);
					dao.emprunter(Integer.parseInt(numeroStr));
				}
				redirect = EmpruntList;
			} else if (action.equalsIgnoreCase("editform")){        	
				redirect = Edit;            
			} else if (action.equalsIgnoreCase("edit")){

				String numeroStr = request.getParameter("numero");
				Emprunt emp = new Emprunt();
				emp.setNumero(Integer.parseInt(numeroStr));
				emp.setNumero_livre(Integer.parseInt(request.getParameter("numero")));
				emp.setDate(new Date(request.getParameter("date")));
				emp.setRemis_le(new Date(request.getParameter("remis_le")));
				emp.setCin_etudiant(request.getParameter("cin_etudiant"));
				dao.modifier(emp);
				request.setAttribute("emprunt", emp);
				redirect = EmpruntList;
				System.out.println("Emprunt updated Successfully");
			} else if (action.equalsIgnoreCase("listEmprunt")){
				redirect = EmpruntList;
				request.setAttribute("emprunts", dao.Lister());
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
