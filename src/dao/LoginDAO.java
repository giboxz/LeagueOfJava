package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Login;

public class LoginDAO {
	private Connection connection;

	public LoginDAO(Connection connection) {
		this.connection = connection;
	}

	public void cadastrar(Login login) {
		try {
			String sql = "INSERT INTO LOGIN (LOGIN, NOME, CPF, SENHA)" + " VALUES (?, ?, ?, ?)";

			try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

				pstm.setString(1, login.getLogin());
				pstm.setString(2, login.getNome());
				pstm.setString(3, login.getCpf());
				pstm.setString(4, login.getSenha());

				pstm.execute();

				try (ResultSet rst = pstm.getGeneratedKeys()) {
					while (rst.next()) {
						login.setId(rst.getInt(1));
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public boolean verifica(String login, String senha) {
		boolean statusLogin = false;
		try {
			List<Login> logins = new ArrayList<Login>();

			try (PreparedStatement pstm = connection.prepareStatement(
					"SELECT ID, LOGIN, NOME, CPF, SENHA FROM LOGIN WHERE LOGIN = ? AND SENHA = ?",
					Statement.RETURN_GENERATED_KEYS)) {
				pstm.setString(1, login);
				pstm.setString(2, senha);

				pstm.execute();

				transformarResultSetEmLogin(logins, pstm);
			}
			if(!logins.isEmpty()) {
				statusLogin = true;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return statusLogin;
	}
	
	private void transformarResultSetEmLogin(List<Login> logins, PreparedStatement pstm) throws SQLException {
		try (ResultSet rst = pstm.getResultSet()) {
			while (rst.next()) {
				Login login = new Login(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5));
				
				logins.add(login);
			}
		}
	}
}
