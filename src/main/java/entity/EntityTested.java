package entity;

import dbFacade.CustomerFacade;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityTested {

    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        CustomerFacade.getBookFacade(emf);
        CustomerFacade cf = new CustomerFacade();
      
        cf.addCustomer("Bjørn", "Bjørnsen");
        System.out.println("By id: " + cf.findCustomerById(1));
        System.out.println("By lastName: " + cf.findCustomerByLastName("Olsen"));
        System.out.println("Number of customers: " + cf.getNumberOfCustomers() + cf.getAllCustomers().size());
        System.out.println("All customers: " + cf.getAllCustomers());
        em.close();
        emf.close();
    }
    
}
