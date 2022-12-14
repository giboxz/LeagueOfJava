package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static final String USUARIO = "seu_usuario_mysql";
	private static final String SENHA = "sua_senha_mysql";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/leagueofjava_db";
	
	public Connection recuperarConexao() {
		try {
			return DriverManager.getConnection(URL,USUARIO, SENHA);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}		
	}
}
