package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Rota;

public class RotaDAO {

	private Connection connection;

	public RotaDAO(Connection connection) {
		this.connection = connection;
	}

	public List<Rota> listar() {
		try {
			List<Rota> classes = new ArrayList<>();
			String sql = "SELECT ID, NOME FROM ROTA";

			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				pstm.execute();

				try (ResultSet rst = pstm.getResultSet()) {
					while (rst.next()) {
						Rota rota = new Rota(rst.getInt(1), rst.getString(2));

						classes.add(rota);
					}
				}
			}
			return classes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
