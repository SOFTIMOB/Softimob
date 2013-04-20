package modelo;

import java.math.BigDecimal;
import java.sql.Date;

public class Proposta {

	public static final int ACEITA = 0;
	public static final int RECUSADA = 1;
	
	private BigDecimal valor;
	
	private int status;
	
	private Proposta contraProposta;
	
	private Imovel imovel;
	
	private Cliente comprador;
	
	private Date data;
	
	private Funcionario funcionario;
	
}
