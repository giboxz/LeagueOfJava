package modelo;

public class Login {
	private Integer id;
	private String login;
	private String nome;
	private String cpf;
	private String senha;
	
	public Login(String login, String nome, String cpf, String senha) {
		super();
		this.login = login;
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
	}
	
	public Login(Integer id, String login, String nome, String cpf, String senha) {
		this.id = id;
		this.login = login;
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
