package modelo;

public class Cliente {

	private String nome;
	
	private String cpf;
	
	private String rg;
	
	private String nacionalidade;
	
	private String endereco;
	
	private String estadoCivil;
	
	private String telefone;
	
	private String email;
	
	public Cliente(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}