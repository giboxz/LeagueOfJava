package modelo;

import java.util.ArrayList;
import java.util.List;

public class Classe {
	private Integer id;
	private String nome;
	private List<Campeao> campeoes = new ArrayList<Campeao>();

	public Classe(Integer id, String nome) {
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
