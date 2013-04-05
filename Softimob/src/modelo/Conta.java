package modelo;

import java.math.BigDecimal;
import java.util.Date;

public class Conta {

	public static int PAGAR = 0;
	public static int RECEBER = 1;
	
	private BigDecimal valor;
	
	private TipoConta tipo;
	
	private Date dataVencimento;
	
}
