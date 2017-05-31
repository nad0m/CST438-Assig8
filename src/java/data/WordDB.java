
package data;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
        
/**
 *
 * @author huy
 */

public class WordDB {
   
    public static Word selectWord(Integer id) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM Word u " +
                "WHERE u.id = :id";
        TypedQuery<Word> q = em.createQuery(qString, Word.class);
        q.setParameter("id", id);
        try {
            Word word = q.getSingleResult();
            return word;
        }catch (NoResultException e){
            return null;
        }finally {
            em.close();
        }
    }
}
