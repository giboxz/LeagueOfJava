package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Campeao;

public class CampeaoDAO {
	private Connection connection;
	
	public CampeaoDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void salvar(Campeao campeao) {
		try {
			String sql = "INSERT INTO CAMPEAO (VIDA, ATAQUE, DEFESA, NOME, ROTAID, CLASSEID)"
					+ " VALUES (?, ?, ?, ?, ?, ?)";
			
			try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
				
				pstm.setInt(1, campeao.getVida());
				pstm.setInt(2, campeao.getAtaque());
				pstm.setInt(3, campeao.getDefesa());
				pstm.setString(4, campeao.getNome());
				pstm.setInt(5, campeao.getRotaId());
				pstm.setInt(6, campeao.getClasseId());
				
				pstm.execute();
				
				try (ResultSet rst = pstm.getGeneratedKeys()){
					while (rst.next()) {
						campeao.setId(rst.getInt(1));
					}
				}	
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Campeao> listar() {
		try {
			List<Campeao> campeoes = new ArrayList<Campeao>();
			String sql = "SELECT ID, VIDA, ATAQUE, DEFESA, NOME, ROTAID, CLASSEID FROM CAMPEAO";
			
			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				pstm.execute();
				
				transformarResultSetEmCampeao(campeoes, pstm);
			}
			return campeoes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Campeao> listarEspecifico(String nome) {
		try {
			List<Campeao> campeoes = new ArrayList<Campeao>();
			
			try (PreparedStatement pstm = connection.prepareStatement("SELECT ID, VIDA, ATAQUE, DEFESA, NOME, ROTAID, CLASSEID FROM CAMPEAO WHERE NOME LIKE ?")) {
				pstm.setString(1, "%" + nome + "%");
				pstm.execute();
				
				transformarResultSetEmCampeao(campeoes, pstm);
			}
			return campeoes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void deletar(Integer id) {
		try (PreparedStatement pstm = connection.prepareStatement("DELETE FROM CAMPEAO WHERE ID = ?")) {
			pstm.setInt(1, id);
			pstm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void alterar(Campeao campeao) {
		try (PreparedStatement pstm = connection.prepareStatement("UPDATE CAMPEAO SET VIDA = ?, ATAQUE = ?, DEFESA = ?, NOME = ? WHERE ID = ?")) {
			pstm.setInt(1, campeao.getVida());
			pstm.setInt(2, campeao.getAtaque());
			pstm.setInt(3, campeao.getDefesa());
			pstm.setString(4, campeao.getNome());
			pstm.setInt(5, campeao.getId());
			
			pstm.execute();
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
	
	private void transformarResultSetEmCampeao(List<Campeao> campeoes, PreparedStatement pstm) throws SQLException {
		try (ResultSet rst = pstm.getResultSet()) {
			while (rst.next()) {
				Campeao campeao = new Campeao(rst.getInt(1), rst.getInt(2), rst.getInt(3), rst.getInt(4), rst.getString(5), rst.getInt(6), rst.getInt(7));
				
				campeoes.add(campeao);
			}
		}
	}
}
