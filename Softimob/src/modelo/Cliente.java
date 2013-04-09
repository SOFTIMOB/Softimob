package modelo;

import java.util.List;

public class Cliente implements Pessoa{

	private String nome;
	
	private String cpf;
	
	private String rg;
	
	private String nacionalidade;
	
	private String endereco;
	
	private String estadoCivil;
	
	private String telefone;
	
	private String email;
	
	private String filiacao;
	
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
