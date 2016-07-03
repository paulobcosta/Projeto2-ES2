/**
 * 
 */
package projeto2.transacoes;

import java.awt.Window.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	@Column(name = "valor",nullable=false)
	private Double valor;
	@Column(name="descricao",nullable=false)
	private String descricao;
	@Temporal(TemporalType.DATE)
	@Column(name="data_da_transacao",nullable=false)
	private Date data;
	/**
	 * @return the valorAbsoluto
	 */
	public Transacao() {
		
	}
	
	public Transacao(double valor,String descricao) {
		this.valor = new Double(valor);
		this.descricao = descricao;
		this.data = new Date();
	}
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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	public void setData(String data) throws ParseException {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date dataFormatada = formato.parse(data);
		this.data = dataFormatada;
	}
	
	
	
}
