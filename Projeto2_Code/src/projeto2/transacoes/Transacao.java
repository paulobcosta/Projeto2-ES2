/**
 * 
 */
package projeto2.transacoes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import projeto2.dao.base.EntidadeBase;

/**
 * @author paulo
 *
 */
@Entity
@Table(name="transacoes")
@SequenceGenerator(name="TRANS_SEQ", sequenceName="TRANSACAO_SEQ",
initialValue=1, allocationSize=1)
public class Transacao implements EntidadeBase {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, 
    generator = "TRANS_SEQ")
	private Long id;
	@Column(name = "v")
	private Double valor;
	private String descricao;
	/**
	 * @return the valorAbsoluto
	 */
	public Double getValor() {
		return valor;
	}
	/**
	 * @param valorAbsoluto the valorAbsoluto to set
	 */
	public void setValor(Double valor) {
		this.valor = valor;
	}
	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}
	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return this.id;
	}
	
	
}
