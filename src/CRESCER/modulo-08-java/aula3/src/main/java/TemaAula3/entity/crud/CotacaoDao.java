/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TemaAula3.entity.crud;

import TemaAula3.entity.dao.Cotacao;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Eduardo
 */
public class CotacaoDao implements IDao<Cotacao> {

    final EntityManager entityManager;

    public CotacaoDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void insert(Cotacao cotacao) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(cotacao);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Cotacao cotacao) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(cotacao);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void update(Cotacao cotacao) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(cotacao);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }        
    }

    @Override
    public List<Cotacao> listar() {
        return entityManager.createQuery("select c from COTACAO c").getResultList();
    }

}
