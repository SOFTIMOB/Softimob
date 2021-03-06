package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class TipoImovel implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public TipoImovel() {
	}
	
	public TipoImovel(String descricao) {
		this.descricao = descricao;
	}

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "A descrição do tipo de imóvel não pode ser vazio.")
	@Column(nullable = false, unique = true)
	private String descricao;

	@OneToMany
	private List<TipoImovelTipoComodo> tipoComodos = new ArrayList<TipoImovelTipoComodo>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<TipoImovelTipoComodo> getTipoComodos() {
		return tipoComodos;
	}

	public void setTipoComodos(List<TipoImovelTipoComodo> tipoComodos) {
		this.tipoComodos = tipoComodos;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoImovel other = (TipoImovel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
