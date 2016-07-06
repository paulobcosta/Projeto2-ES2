/**
 * 
 */
package projeto2;

import projeto2.dao.ContaDAO;
import projeto2.dao.SenhaDAO;
import projeto2.entidades.conta.Conta;
import projeto2.entidades.seguranca.Senha;
import projeto2.paineis.PainelLogin;
import projeto2.paineis.PainelOperacao;
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
		
		ContaDAO dao = new ContaDAO();
		Conta c = dao.buscaContaPorId(new Long(1));
		
		PainelLogin pL = new PainelLogin(s, c);
		pL.setVisible(true);
	}

}
