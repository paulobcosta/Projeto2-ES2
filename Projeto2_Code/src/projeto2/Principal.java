/**
 * 
 */
package projeto2;

import projeto2.dao.ContaDAO;
import projeto2.dao.SenhaDAO;
import projeto2.entidades.conta.Conta;
import projeto2.entidades.seguranca.Senha;
import projeto2.transacoes.Transacao;

/**
 * @author paulo
 *
 */
public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Senha s = new Senha("123");
		SenhaDAO sd = new SenhaDAO();
		sd.persist(s);
		Conta c = new Conta();
		ContaDAO cd = new ContaDAO();
		Transacao t = new Transacao();
		cd.persist(c);
		c.creditaValor(3000.00);
		c.debitaValor(1400, "compra de bicicleta");
		cd.persist(c);
	}

}
