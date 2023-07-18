package db;
//ESSA É A CLASSE DE CONEXAO COM A BASE DE DADOS!!!
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PgSQLConnection {
	private static final String url ="jdbc:postgresql://localhost:5432/java_crud";
	private static final String user= "postgres";
	private static final String password = "postdba";	
	
	//AQUI CRIO A CHAMADA PARA CONEXAO COM O DB
	public static Connection createConnection() { 
		
		try {
			Class.forName("org.postgresql.Driver"); //chamada do driver do postgresql
			System.out.println("Driver found!!!");
			
		} catch(ClassNotFoundException e) {
			
			System.out.println("Driver Not found."+e.getMessage());
			
		}
		try { //aqui eu tento fazer a conexao com o db
			Connection connection = DriverManager.getConnection(url, user, password);
			System.out.println("Connected to data base!!!");
			return connection;
			
		} catch(SQLException e) {
			System.out.println("Not connectde to databse "+e.getMessage());
			return null;
		}
		
	}
}
