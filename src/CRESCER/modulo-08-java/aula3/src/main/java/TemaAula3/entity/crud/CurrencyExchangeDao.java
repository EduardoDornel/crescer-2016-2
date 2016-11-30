/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TemaAula3.entity.crud;

import TemaAula3.entity.dao.CurrencyExchange;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Eduardo
 */
public class CurrencyExchangeDao implements IDao<CurrencyExchange>{

    final EntityManager entityManager;

    public CurrencyExchangeDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public void insert(CurrencyExchange ce) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(ce);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }    }

    @Override
    public void delete(CurrencyExchange ce) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(ce);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }    }

    @Override
    public void update(CurrencyExchange ce) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(ce);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }            }

    @Override
    public List<CurrencyExchange> listar() {
        return entityManager.createQuery("select c from CURRENCY_EXCHANGE c").getResultList();
    }
    
}
