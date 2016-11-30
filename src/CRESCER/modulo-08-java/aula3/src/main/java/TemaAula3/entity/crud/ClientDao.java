/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TemaAula3.entity.crud;

import static org.hibernate.criterion.MatchMode.ANYWHERE;

import TemaAula3.entity.dao.Client;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Eduardo
 */
public class ClientDao implements IDao<Client> {

    final EntityManager entityManager;

    public ClientDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void insert(Client client) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(client);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }
    
    @Override
    public void delete(Client client) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(client);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void update(Client client) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(client);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }    }

    @Override
    public List<Client> listar() {
        return entityManager.createQuery("select c from CLIENT c").getResultList();
    }

}
