/**
 * 
 */
package projeto2.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import projeto2.dao.generico.DAOGenerico;
import projeto2.entidades.conta.Conta;

/**
 * @author paulo
 *
 */
public class ContaDAO extends DAOGenerico<Conta> {

	public Conta buscaContaPorId(Long id) {
		EntityManager em = getEntityManager();
		Conta conta = new Conta();
		try {
			Query q = em.createNamedQuery("Conta.buscaPorId");
			q.setParameter("id", id);
			conta = (Conta)q.getSingleResult();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			em.close();
		}
		return conta;
	}
}
