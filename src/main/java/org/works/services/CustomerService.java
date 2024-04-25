package org.works.services;

import jakarta.persistence.EntityManager;
import org.works.entities.Customer;
import org.works.utils.EntityManagerUtil;

import java.util.List;

public class CustomerService {

    EntityManager em = EntityManagerUtil.getEntityManager();

    public void customerSave(Customer customer) {
        em.getTransaction().begin();
        em.persist(customer);
        em.getTransaction().commit();
        //em.close();
    }

    public List<Customer> customerAll() {
        List<Customer> ls = em.createQuery("from Customer ", Customer.class).getResultList();
        return ls;
    }

    public void deleteCustomer(Long cid) {
        Customer c = singleCustomer(cid);
        em.getTransaction().begin();
        em.remove(c);
        em.getTransaction().commit();
        //em.close();
    }

    public Customer singleCustomer( Long cid ) {
        Customer c = em.createQuery("from Customer c where c.cid = ?1", Customer.class)
                .setParameter(1, cid).getSingleResult();
        return c;
    }

    public void customerUpdate( Customer customer ) {
        em.getTransaction().begin();
        em.merge(customer);
        em.getTransaction().commit();
    }

}
