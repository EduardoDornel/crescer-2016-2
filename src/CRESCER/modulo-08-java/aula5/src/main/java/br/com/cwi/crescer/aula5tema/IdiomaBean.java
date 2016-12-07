/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula5tema;

import br.com.cwi.crescer.aula5tema.cadastros.AbstractDao;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Eduardo
 */
@Stateless
public class IdiomaBean extends AbstractDao<Idioma, Long> {
    @PersistenceContext(unitName = "crescer")
    private EntityManager entityManager;

    public IdiomaBean() {
        super(Idioma.class);
    }
    
    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    @Override
    public List<Idioma> findAll() {
        return this.getEntityManager().createQuery("select i from Idioma i").getResultList();
    }

    @Override
    public void insert(Idioma idioma) {
        this.getEntityManager().merge(idioma);
    }
}