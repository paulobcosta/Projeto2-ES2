/**
 * 
 */
package projeto2.entidades.seguranca;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import projeto2.dao.base.EntidadeBase;
import javax.persistence.TableGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import static javax.persistence.GenerationType.AUTO;

import javax.persistence.Column;

/**
 * @author paulo
 *
 */
@Entity
@Table(name = "senhas")
@SequenceGenerator(name="PASS_SEQ", sequenceName="SENHA_SEQ",
initialValue=1, allocationSize=1)
public class Senha implements EntidadeBase {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, 
    generator = "PASS_SEQ")
	private Long id;
	
	@Column(name = "valor", nullable = false)
	private String valor;
	public Senha() {
		
	}
	
	public Senha(String senha) {
		this.valor = senha;
	}
	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * @return the senha
	 */
	public String getValor() {
		return valor;
	}
	/**
	 * @param senha the senha to set
	 */
	public void setValor(String senha) {
		this.valor = senha;
	}

}
