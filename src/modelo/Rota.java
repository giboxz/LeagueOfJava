package modelo;

import java.util.ArrayList;
import java.util.List;

public class Rota {
	private Integer id;
	private String nome;
	private List<Campeao> campeoes = new ArrayList<Campeao>();

	public Rota(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public List<Campeao> getCampeoes() {
		return campeoes;
	}

	@Override
	public String toString() {
		return this.nome;
	}
}
