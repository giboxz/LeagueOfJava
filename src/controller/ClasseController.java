package controller;

import java.sql.Connection;
import java.util.List;

import dao.ClasseDAO;
import factory.ConnectionFactory;
import modelo.Classe;

public class ClasseController {
	
	private ClasseDAO classeDAO;
	
	public ClasseController() {
		Connection conneciton = new ConnectionFactory().recuperarConexao();
		this.classeDAO = new ClasseDAO(conneciton);
	}
	
	public List<Classe> listar() {
		return this.classeDAO.listar();
	}
}
