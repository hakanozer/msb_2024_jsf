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
        em.close();
    }

    public List<Customer> customerAll() {
        List<Customer> ls = em.createQuery("from Customer ", Customer.class).getResultList();
        return ls;
    }

}
