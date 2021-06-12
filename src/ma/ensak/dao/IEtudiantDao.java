package ma.ensak.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import ma.ensak.beans.Etudiant;

public interface IEtudiantDao {

	List<Etudiant> Lister() throws SQLException;
	void ajouter(Etudiant e) throws SQLException;
	void modifier(Etudiant e) throws SQLException;
	void supprimer(String cin) throws SQLException;
	Etudiant getEtudiantById(String cin) throws SQLException;
	void extraire(String directoryPath) throws SQLException, IOException;

}
