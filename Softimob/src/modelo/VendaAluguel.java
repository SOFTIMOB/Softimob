package modelo;

import java.math.BigDecimal;
import java.util.Date;

public class VendaAluguel {

	public static final int VENDA = 0;
	public static final int ALUGUEL = 1;
	
	private Contrato contrato;
	
	private Imovel imovel;
	
	private Cliente comprador;
	
	private BigDecimal valor;
	
	private Date dataAssinaturaContrato;
	
	private Funcionario vendedor;
	
}
