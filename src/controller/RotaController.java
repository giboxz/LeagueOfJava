package controller;

import java.sql.Connection;
import java.util.List;

import dao.RotaDAO;
import factory.ConnectionFactory;
import modelo.Rota;

public class RotaController {
	
	private RotaDAO rotaDAO;
	
	public RotaController() {
		Connection connection = new ConnectionFactory().recuperarConexao();
		this.rotaDAO = new RotaDAO(connection);
	}
	
	public List<Rota> listar() {
		return this.rotaDAO.listar();
	}
}
