/**
 * 
 */
package projeto2.entidades.conta;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import projeto2.dao.base.EntidadeBase;
import projeto2.transacoes.Transacao;

/**
 * @author paulo
 *
 */
@Entity
@SequenceGenerator(name = "CNT_SEQ", sequenceName = "CONTA_SEQ", initialValue = 1, allocationSize = 1)
@Table(name = "contas")
@NamedQuery(name ="Conta.buscaPorId",query="SELECT c FROM Conta c WHERE c.id = :id")
public class Conta implements EntidadeBase {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CNT_SEQ")
	private Long id;
	// @JoinColumn(name = "transacoes",nullable=true)
	@JoinTable(name = "conta_transacoes", joinColumns = {
			@JoinColumn(name = "conta_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "transacao_id", referencedColumnName = "id") })
	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private ArrayList<Transacao> transacoes;
	// @Column(name="saldo",nullable=false)
	// private Double saldo;
	@Column(name = "valor_em_conta", nullable = false)
	private Double valorEmConta;

	public Conta() {
		this.transacoes = new ArrayList<>();
		// this.saldo = new Double(0);
		this.valorEmConta = new Double(0);
	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	/**
	 * @return the transacoes
	 */
	public ArrayList<Transacao> getTransacoes() {
		return transacoes;
	}

	/**
	 * @param transacoes
	 *            the transacoes to set
	 */
	public void setTransacoes(ArrayList<Transacao> transacoes) {
		this.transacoes = transacoes;
	}

	public void debitaValor(double valor, String descricao) {
		Transacao t = new Transacao(-valor, descricao);

		this.transacoes.add(t);
		this.valorEmConta = this.valorEmConta + t.getValor();
		// this.saldo += t.getValor();
	}

	public void creditaValor(double valor) {
		Transacao t = new Transacao(valor, "valor_creditado");
		this.transacoes.add(t);
		this.valorEmConta = this.valorEmConta + t.getValor();
		// this.saldo = this.saldo + t.getValor();
	}

	/**
	 * @return the valorEmConta
	 */
	public Double getValorEmConta() {
		return valorEmConta;
	}

	/**
	 * @param valorEmConta
	 *            the valorEmConta to set
	 */
	public void setValorEmConta(Double valorEmConta) {
		this.valorEmConta = valorEmConta;
	}

}
