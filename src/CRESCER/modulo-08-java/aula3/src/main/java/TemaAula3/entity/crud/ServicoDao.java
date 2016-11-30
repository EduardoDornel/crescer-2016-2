/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TemaAula3.entity.crud;

import TemaAula3.entity.dao.Servico;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Eduardo
 */
public class ServicoDao implements IDao<Servico>{
    final EntityManager entityManager;

    public ServicoDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    @Override
    public void insert(Servico servico) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(servico);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }    }

    @Override
    public void delete(Servico servico) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(servico);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }    }

    @Override
    public void update(Servico servico) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(servico);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }    
    }

    @Override
    public List<Servico> listar() {
        return entityManager.createQuery("select c from SERVICO c").getResultList();
    }
    
}
