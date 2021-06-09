package ma.ensak.view;

import java.sql.SQLException;
import java.util.Date;

import ma.ensak.beans.Emprunt;
import ma.ensak.beans.Etudiant;
import ma.ensak.beans.Livre;
import ma.ensak.dao.EmpruntDao;
import ma.ensak.dao.EtudiantDao;
import ma.ensak.dao.LivreDao;

public class Menu {

	public static void main(String[] args) {
		try {
			menu1();
			menu2();
			menu3();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	static public void menu1() throws SQLException {
		System.out.println("test etudiant");
		Etudiant e = new Etudiant();
		e.setCin("PB244544");
		e.setFiliere("GI");
		e.setNom("El Khalili");
		e.setPrenom("Ibrahim");
		EtudiantDao eDao = new EtudiantDao();
		eDao.modifier(e);
	}
	@SuppressWarnings("deprecation")
	static public void menu2() throws SQLException {
		System.out.println("test livre");
		Livre l = new Livre();
		l.setDate_apparition(new Date("14/02/1078"));
		l.setNumero_edition("n3");
		l.setStock(10);
		l.setTitre("Struture Java");
		l.setNumero(1);
		LivreDao lDao = new LivreDao();
		lDao.modifier(l);
		
	}
	static public void menu3() throws SQLException {
		System.out.println("test Emprunt");
		Emprunt emp = new Emprunt();
		emp.setCin_etudiant("PB244544");
		emp.setDate(new Date());
		emp.setNumero_livre(1);
		emp.setRemis_le(new Date());
		emp.setNumero(4);
		EmpruntDao eDao = new EmpruntDao();
		eDao.modifier(emp);
	}

}
