package modelo;

import java.math.BigDecimal;

public class Proposta {

	public static final int ACEITA = 0;
	public static final int RECUSADA = 1;
	
	private BigDecimal valor;
	
	private int status;
	
	private Proposta contraProposta;
	
	private Imovel imovel;
	
	private Cliente comprador;
	
}
