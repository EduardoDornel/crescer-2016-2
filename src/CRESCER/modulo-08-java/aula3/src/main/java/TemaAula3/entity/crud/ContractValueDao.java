/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TemaAula3.entity.crud;

import TemaAula3.entity.dao.ContractValue;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Eduardo
 */
public class ContractValueDao implements IDao<ContractValue>{
    final EntityManager entityManager;

    public ContractValueDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    @Override
    public void insert(ContractValue contract) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(contract);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }    }

    @Override
    public void delete(ContractValue contract) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(contract);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }   
    }

    @Override
    public void update(ContractValue contract) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(contract);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }     }

    @Override
    public List<ContractValue> listar() {
        return entityManager.createQuery("select c from CONTRACT_VALUE c").getResultList();
    }
    
}
