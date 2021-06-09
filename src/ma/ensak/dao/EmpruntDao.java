package ma.ensak.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ma.ensak.beans.Emprunt;
import ma.ensak.beans.Livre;

public class EmpruntDao implements IEmpruntDao {

	static Connection con = ConnexionDB.getConnection();	

	@Override
	public List<Emprunt> Lister() throws SQLException {
		// TODO Auto-generated method stub
		String query = "select * from emprunt";
		PreparedStatement ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		List<Emprunt> ls = new ArrayList<Emprunt>();

		while (rs.next()) {
			Emprunt emp = new Emprunt();
			emp.setNumero_livre(rs.getInt("numero_livre"));
			emp.setCin_etudiant(rs.getString("cin_etudiant"));
			emp.setDate(rs.getDate("date"));
			emp.setRemis_le(rs.getDate("remis_le"));
			ls.add(emp);
		}
		return ls;
	}

	@Override
	public void ajouter(Emprunt emp) throws SQLException {
		// TODO Auto-generated method stub
		String query = "insert into emprunt(numero_livre, cin_etudiant, date) VALUES (?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(query);

		List<Emprunt> list = getEmpruntByCin(emp.getCin_etudiant());
		int nbrOfBooks = 0;
		for (int i=0; i < list.size(); i++) {
			if (list.get(i).getRemis_le() == null)
				nbrOfBooks++;
		}
		if (nbrOfBooks < 3) {
			LivreDao livreDao = new LivreDao();			
			Livre updatedLivre = livreDao.getLivreById(emp.getNumero_livre());
			// check if stock has enough books
			if (updatedLivre.getStock().intValue() > 0) {
				ps.setInt(1, emp.getNumero_livre().intValue());
				ps.setString(2, emp.getCin_etudiant());
				ps.setDate(3, new Date(emp.getDate().getTime()));
				ps.executeUpdate();
				updatedLivre.setStock(updatedLivre.getStock().intValue() - 1);
				livreDao.modifier(updatedLivre);
			}
		}
		// rs = select * from emprunt where cin_etudiant=emp.getCin_etudiant()
		// int nbrOfBooks = 0;
		// loop through rs {
		// 		if (rs.getDate("remis_le") == NULL) 
		//			nbrOfBooks++;
		// }
		// if (nbrOfBooks < 3) {
		//		continue and create emprunt;
		//		decrease stock;
		// }

	}

	@Override
	public void modifier(Emprunt emp) throws SQLException {
		// TODO Auto-generated method stub
		String query = "update emprunt set numero_livre=?, cin_etudiant=?, date=?, remis_le=? where numero=?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, emp.getNumero_livre().intValue());
		ps.setString(2, emp.getCin_etudiant());
		ps.setDate(3, new Date(emp.getDate().getTime()));
		ps.setDate(4, new Date(emp.getRemis_le().getTime()));
		ps.setInt(5,emp.getNumero().intValue());
		ps.executeUpdate(); 
	}

	@Override
	public void supprimer(Number numero) throws SQLException {
		// TODO Auto-generated method stub
		LivreDao livreDao = new LivreDao();

		Emprunt emprunt = getEmpruntById(numero);

		Livre updatedLivre = livreDao.getLivreById(emprunt.getNumero_livre());

		updatedLivre.setStock(updatedLivre.getStock().intValue() + 1);

		livreDao.modifier(updatedLivre);

		// usual process:
		// String query = "delete from emprunt where numero=?";
		// PreparedStatement ps = con.prepareStatement(query);
		// ps.setInt(1, numero.intValue());
		// ps.executeUpdate();
	}

	@Override
	public Emprunt getEmpruntById(Number numero) throws SQLException {
		Emprunt emp = new Emprunt();
		String query = "SELECT * FROM emprunt WHERE numero=?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, numero.intValue());
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			emp.setNumero(rs.getInt("numero"));
			emp.setNumero_livre(rs.getInt("numero_livre"));
			emp.setCin_etudiant(rs.getString("cin_etudiant"));
			emp.setDate(rs.getDate("date"));
			emp.setRemis_le(rs.getDate("remis_le"));
		}	

		return emp;
	}

	public List<Emprunt> getEmpruntByCin(String cin) throws SQLException {
		String query = "SELECT * FROM emprunt WHERE cin_etudiant=?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, cin);
		ResultSet rs = ps.executeQuery();
		List<Emprunt> ls = new ArrayList<Emprunt>();

		if (rs.next()) {
			Emprunt emp = new Emprunt();
			emp.setNumero(rs.getInt("numero"));
			emp.setNumero_livre(rs.getInt("numero_livre"));
			emp.setCin_etudiant(rs.getString("cin_etudiant"));
			emp.setDate(rs.getDate("date"));
			emp.setRemis_le(rs.getDate("remis_le"));
			ls.add(emp);
		}	

		return ls;
	}

}
