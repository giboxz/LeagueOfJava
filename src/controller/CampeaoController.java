package controller;

import java.sql.Connection;
import java.util.List;

import dao.CampeaoDAO;
import factory.ConnectionFactory;
import modelo.Campeao;

public class CampeaoController {
	private CampeaoDAO campeaoDAO;
	
	public CampeaoController() {
		Connection connection = new ConnectionFactory().recuperarConexao();
		this.campeaoDAO = new CampeaoDAO(connection);
	}
	
	public void deletar(Integer id) {
		this.campeaoDAO.deletar(id);
	}
	
	public void salvar(Campeao campeao) {
		this.campeaoDAO.salvar(campeao);
	}
	
	public List<Campeao> listar() {
		return this.campeaoDAO.listar();
	}
	
	public List<Campeao> listarEspecifico(String nome) {
		return this.campeaoDAO.listarEspecifico(nome);
	}
	
	public void alterar(Campeao campeao) {
		this.campeaoDAO.alterar(campeao);
	}
}
