package controller;

import java.sql.Connection;

import dao.LoginDAO;
import factory.ConnectionFactory;
import modelo.Login;

public class LoginController {
	private LoginDAO loginDAO;
	
	public LoginController() {
		Connection connection = new ConnectionFactory().recuperarConexao();
		this.loginDAO = new LoginDAO(connection);
	}
	
	public void cadastrar(Login login) {
		this.loginDAO.cadastrar(login);
	}
	
	public boolean verifica(String login, String senha) {
		return this.loginDAO.verifica(login, senha);
	}
}
