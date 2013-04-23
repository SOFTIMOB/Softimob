package modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class Vistoria {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message="Informe a data da vistoria.")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date data;
	
	@NotNull(message = "Selecione o funcionário responsável pela vistoria.")
	@ManyToOne(optional=false)
	private Funcionario funcionario;
	
	private Byte arquivo;
	
	@NotNull(message = "Selecione o último inquilino do imóvel.")
	@ManyToOne(optional=false)
	private Cliente inquilino;
	
	@NotNull(message = "Selecione o imóvel referente a vistoria.")
	@ManyToOne(optional=false)
	private Imovel imovel;
	
	@Column
	private String observacoes;
	
}
