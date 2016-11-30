/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TemaAula3.entity.crud;

import TemaAula3.entity.dao.Contract;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Eduardo
 */
public class ContractDao implements IDao<Contract>{
    final EntityManager entityManager;

    public ContractDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    @Override
    public void insert(Contract contract) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(contract);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }    
    }

    @Override
    public void delete(Contract contract) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(contract);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }   
    }

    @Override
    public void update(Contract contract) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(contract);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }     
    }

    @Override
    public List<Contract> listar() {
        return entityManager.createQuery("select c from CONTRACT c").getResultList();
    }
    
}
