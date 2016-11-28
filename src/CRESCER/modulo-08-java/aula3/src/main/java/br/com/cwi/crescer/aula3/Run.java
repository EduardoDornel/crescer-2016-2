/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula3;

import br.com.cwi.crescer.aula3.entity.Pessoa;
import br.com.cwi.crescer.aula3.entity.dao.PessoaDao;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author eduardo.ribas
 */
public class Run {

    public static void main(String[] args) {
       final EntityManagerFactory emf;
        emf = Persistence.createEntityManagerFactory("CRESCER");
        final EntityManager em;
        em = emf.createEntityManager();

        /* if (em.isOpen()) {
            em.getTransaction().begin();
            try {
                final Pessoa pessoa = new Pessoa();
                pessoa.setIdPessoa(1l);
                pessoa.setNmPessoa("Eduardo");

                em.merge(pessoa);
                em.getTransaction().commit();
            } catch (Exception e) {
                em.getTransaction().rollback();
            }
        }*/
        
        final PessoaDao pessoaDao = new PessoaDao();  
        List<Pessoa> lista = pessoaDao.findAll();
        
        em.close();
        emf.close();
            
      
    }
}
