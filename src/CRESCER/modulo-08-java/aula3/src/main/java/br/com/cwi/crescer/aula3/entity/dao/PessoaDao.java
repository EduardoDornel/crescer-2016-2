/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula3.entity.dao;

import br.com.cwi.crescer.aula3.entity.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Session;

/**
 *
 * @author eduardo.ribas
 */
public class PessoaDao implements IDao<Pessoa, Long> {

    EntityManager entityManager;
    final EntityManagerFactory entityManagerFactory;

    public PessoaDao() {
        entityManagerFactory = Persistence.createEntityManagerFactory("CRESCER");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public void insert(Pessoa t) {
        if (entityManager.isOpen()) {
            entityManager.getTransaction().begin();
            try {
                final Pessoa pessoa = t;
                if (pessoa.getIdPessoa() == null) {
                    entityManager.persist(pessoa);
                } else {
                    entityManager.merge(pessoa);
                }
                entityManager.getTransaction().commit();
            } catch (Exception e) {
                entityManager.getTransaction().rollback();
            }
        }
    }

    @Override
    public void delete(Pessoa t) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(t);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    public Pessoa find(Long id) {
        Pessoa pessoa = entityManager.find(Pessoa.class, id);
        if (pessoa != null) {
            return entityManager.find(Pessoa.class, id);
        } else {
            return null;
        }
    }

    @Override
    public List<Pessoa> findAll() {
        return entityManager.createQuery("select p from pessoa p").getResultList();
    }
}
