package modelo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Imovel {

	public static final int ALUGAR = 0;
	public static final int VENDER = 1;
	
	private String endereco;
	
	private String cep;
	
	private BigDecimal valor;
	
	private Double metragem;
	
	private List<Comodo> comodos = new ArrayList<Comodo>();
	
	private Funcionario angariador;
	
	private Chave chave;
	
	private Placa placa;
	
	private TipoImovel tipo;
	
	private Cliente proprietario;

	public Cliente getProprietario() {
		return proprietario;
	}

	public void setProprietario(Cliente proprietario) {
		this.proprietario = proprietario;
	}

}
