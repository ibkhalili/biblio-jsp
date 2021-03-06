package ma.ensak.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ma.ensak.beans.Emprunt;
import ma.ensak.beans.Etudiant;

public class EtudiantDao implements IEtudiantDao {

	static Connection con = ConnexionDB.getConnection();
	
	@Override
	public List<Etudiant> Lister() throws SQLException {
		// TODO Auto-generated method stub
		String query = "select * from etudiant";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<Etudiant> ls = new ArrayList<Etudiant>();
  
        while (rs.next()) {
        	Etudiant e = new Etudiant();
            e.setCin(rs.getString("cin"));
            e.setNom(rs.getString("nom"));
            e.setPrenom(rs.getString("prenom"));
            e.setFiliere(rs.getString("filiere"));
            ls.add(e);
        }
        return ls;
	}

	@Override
	public void ajouter(Etudiant e) throws SQLException {
		// TODO Auto-generated method stub
		String query = "insert into etudiant(cin, nom, prenom, filiere) VALUES (?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, e.getCin());
		ps.setString(2, e.getNom());
		ps.setString(3, e.getPrenom());
		ps.setString(4, e.getFiliere());
		ps.executeUpdate(); // maybe we want to check the return value
	}
	
	@Override
	public void extraire(String directoryPath) throws SQLException, IOException {
		// TODO Auto-generated method stub
		File file = new File(directoryPath);

		if (file.isDirectory()) {
			PrintWriter writer = new PrintWriter(new FileWriter(directoryPath + "/etudiant.csv", false));

			writer.println("nom, prenom, filiere, cin");

			List<Etudiant> etudiants = Lister();
			for (Etudiant etudiant : etudiants) {
				writer.println(etudiant.toString());
			}

			writer.close();

			System.out.println("Etudiant table extracted successfully !");
		}
		else {
			throw new FileNotFoundException("Directory doesn't exist!!");
		}

	}

	@Override
	public void modifier(Etudiant e) throws SQLException {
		// TODO Auto-generated method stub
		String query = "update etudiant set nom=?, prenom=?, filiere=? where cin=?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, e.getNom());
		ps.setString(2, e.getPrenom());
		ps.setString(3, e.getFiliere());
		ps.setString(4, e.getCin());
		ps.executeUpdate();
	}

	@Override
	public void supprimer(String cin) throws SQLException {
		// TODO Auto-generated method stub
		String query = "delete from etudiant where cin=?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, cin);
		ps.executeUpdate();
	}
	
	@Override
	public Etudiant getEtudiantById(String cin) throws SQLException {
		Etudiant etudiant = new Etudiant();
		String query = "SELECT * FROM etudiant WHERE cin=?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, cin);
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			etudiant.setCin(rs.getString("cin"));
			etudiant.setNom(rs.getString("nom"));
			etudiant.setPrenom(rs.getString("prenom"));
			etudiant.setFiliere(rs.getString("filiere"));
		}	

		return etudiant;
	}

}
