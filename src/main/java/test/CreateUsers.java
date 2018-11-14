
package test;

import entity.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CreateUsers {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpapu");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        User u = new User("test1", "1234");
        em.persist(u);
        em.getTransaction().commit();
        
        
        
    }
}
