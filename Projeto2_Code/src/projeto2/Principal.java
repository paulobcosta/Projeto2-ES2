/**
 * 
 */
package projeto2;

import projeto2.dao.SenhaDAO;
import projeto2.entidades.seguranca.Senha;

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
	}

}
