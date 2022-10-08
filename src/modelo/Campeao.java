package modelo;

public class Campeao {
	private Integer id;
	private Integer vida;
	private Integer ataque;
	private Integer defesa;
	private String nome;
	private Integer rotaId;
	private Integer classeId;

	public Campeao(Integer vida, Integer ataque, Integer defesa, String nome, Integer rotaId, Integer classeId) {
		super();
		this.vida = vida;
		this.ataque = ataque;
		this.defesa = defesa;
		this.nome = nome;
		this.rotaId = rotaId;
		this.classeId = classeId;
	}

	public Campeao(Integer id, Integer vida, Integer ataque, Integer defesa, String nome, Integer rotaId,
			Integer classeId) {
		this.id = id;
		this.vida = vida;
		this.ataque = ataque;
		this.defesa = defesa;
		this.nome = nome;
		this.rotaId = rotaId;
		this.classeId = classeId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getVida() {
		return vida;
	}

	public void setVida(Integer vida) {
		this.vida = vida;
	}

	public Integer getAtaque() {
		return ataque;
	}

	public void setAtaque(Integer ataque) {
		this.ataque = ataque;
	}

	public Integer getDefesa() {
		return defesa;
	}

	public void setDefesa(Integer defesa) {
		this.defesa = defesa;
	}

	public String getNome() {
		return nome;
	}

	public Integer getRotaId() {
		return rotaId;
	}

	public void setRotaId(Integer rotaId) {
		this.rotaId = rotaId;
	}

	public Integer getClasseId() {
		return classeId;
	}

	public void setClasseId(Integer classeId) {
		this.classeId = classeId;
	}

	@Override
	public String toString() {
		return String.format("Status do Campeão %s: \n  Vida: %d\n Ataque: %d\n Defesa: %d\n Id: %d", this.nome, this.vida,
				this.ataque, this.defesa, this.id);
	}

}