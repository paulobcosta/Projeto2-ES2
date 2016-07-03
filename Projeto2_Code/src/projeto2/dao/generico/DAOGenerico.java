package projeto2.dao.generico;
import projeto2.dao.base.EntidadeBase;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class DAOGenerico <BASE extends EntidadeBase >{
	
	public EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Projeto2_Code");
        EntityManager em = emf.createEntityManager();
        return em;
    }
    public void persist(BASE objeto) {
        
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try {
            if(objeto.getId() == null) {
                em.persist(objeto);
            }
            else {
                if(!em.contains(objeto)) {
                    if(em.find(objeto.getClass(), objeto.getId()) == null) {
                        throw new Exception("Erro ao atualizar!");
                    }
                }
                em.merge(objeto);
            }
            
            em.getTransaction().commit();
        } catch (Exception e) {
        	System.out.println("Erro: " + e.getMessage());
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    public void delete(Class<BASE> clazz, Long id) throws Exception {
        EntityManager em = getEntityManager();
        BASE objeto = em.find(clazz, id);
        try {
            if(objeto == null) {
                throw new Exception("Erro na delecao! Objeto nao encontrado");
            }
            em.getTransaction().begin();
            em.remove(objeto);
            em.getTransaction().commit();
        }
        finally{
            em.close();
        }
    }
    
    public BASE searchById(Class<BASE> clazz, Long id) {
        EntityManager em = getEntityManager();
        BASE objeto = null;
        try {
            objeto = em.find(clazz, id);
        } catch(Exception e) {
        	System.out.println("Erro: " + e.getMessage());
        	e.printStackTrace();
        }
        finally {
            em.close();
        }
        return objeto;
    }
	
}
