package modelo;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Proposta {

	public static final int ACEITA = 0;
	public static final int RECUSADA = 1;
	
	@Column(precision = 14, scale = 2)
	private BigDecimal valor;
	
	@Column
	private Integer status;
	
	@OneToOne
	private Proposta contraProposta;
	
	@ManyToOne
	private Imovel imovel;
	
	@ManyToOne
	private Cliente comprador;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;
	
	@ManyToOne
	private Funcionario funcionario;
	
}
