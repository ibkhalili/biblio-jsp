
package ma.ensak.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import ma.ensak.beans.Livre;

public interface ILivreDao {

	List<Livre> Lister() throws SQLException;
	void ajouter(Livre l) throws SQLException;
	void modifier(Livre l) throws SQLException;
	void supprimer(Number numero) throws SQLException;
	public Livre getLivreById(Number numero) throws SQLException;
	void extraire(String directoryPath) throws SQLException, IOException;

}
