package modelo;

import java.math.BigDecimal;
import java.util.Date;

public class ContaPagarReceber {

	public static final char PAGAR = 'P';
	public static final char RECEBER = 'R';
	
	private BigDecimal valor;
	
	private BigDecimal valorPagoParcial;
	
	private BigDecimal valorJurosDesconto;
	
	private Date dataVencimento;
	
	private Date dataPagamento;
	
	private OrigemConta origem;
	
	private Character tipo;
	
	private MovimentacaoContabil movimentacao;

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getValorPagoParcial() {
		return valorPagoParcial;
	}

	public void setValorPagoParcial(BigDecimal valorPagoParcial) {
		this.valorPagoParcial = valorPagoParcial;
	}

	public BigDecimal getValorJurosDesconto() {
		return valorJurosDesconto;
	}

	public void setValorJurosDesconto(BigDecimal valorJurosDesconto) {
		this.valorJurosDesconto = valorJurosDesconto;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public OrigemConta getOrigem() {
		return origem;
	}

	public void setOrigem(OrigemConta origem) {
		this.origem = origem;
	}

	public Character getTipo() {
		return tipo;
	}

	public void setTipo(Character tipo) {
		this.tipo = tipo;
	}

	public MovimentacaoContabil getMovimentacao() {
		return movimentacao;
	}

	public void setMovimentacao(MovimentacaoContabil movimentacao) {
		this.movimentacao = movimentacao;
	}

	public void efetuarBaixa(MovimentacaoContabil movimentacao2) {
		
	}
	
}
