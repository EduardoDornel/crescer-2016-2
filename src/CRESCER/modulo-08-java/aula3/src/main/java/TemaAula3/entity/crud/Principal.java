/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TemaAula3.entity.crud;

import TemaAula3.entity.dao.Client;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Eduardo
 */
public class Principal {
    public static void main(String[] args) {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ORACLE XE LOCAL");
        final EntityManager em = emf.createEntityManager();

        final ClientDao clientCrud = new ClientDao(em);
        
        /*final ClientDao client = new ClientDao();
        
        client.setDsEmail("email");
        client.setDsPassword("pass");
        client.setDsPreferredCoin("yen");
        client.setDsState("sta");
        client.setDsUserName("cda");
        client.setNmClient("ed");
        client.setTpPermission("no");
        
        clientCrud.insert(client);
        */
        
        clientCrud.listar().forEach(c -> System.out.println(c.getNmClient()));

        em.close();
        emf.close();
    }
}
