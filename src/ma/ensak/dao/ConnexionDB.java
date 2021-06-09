package ma.ensak.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/*
 * Singleton connection class:
 * 		Singleton class is a software design pattern that
 * 		ensures there will be one single instance of that class.
 */
public class ConnexionDB {

	private static Connection con = null;
	  
    static
    {
        String url = "jdbc:mysql://127.0.01:3306/biblio?autoReconnect=true&useSSL=false";
        String user = "root";
        String password = "root";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection()
    {
        return con;
    }

}

