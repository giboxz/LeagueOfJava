package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Classe;

public class ClasseDAO {

	private Connection connection;

	public ClasseDAO(Connection connection) {
		this.connection = connection;
	}

	public List<Classe> listar() {
		try {
			List<Classe> classes = new ArrayList<>();
			String sql = "SELECT ID, NOME FROM CLASSE";

			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				pstm.execute();

				try (ResultSet rst = pstm.getResultSet()) {
					while (rst.next()) {
						Classe classe = new Classe(rst.getInt(1), rst.getString(2));

						classes.add(classe);
					}
				}
			}
			return classes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
