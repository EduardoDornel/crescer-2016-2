/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula5.mbean;

import br.com.cwi.crescer.aula5.bean.AtorBean;
import br.com.cwi.crescer.aula5.bean.UserBean;
import br.com.cwi.crescer.aula5.dao.AtorDao;
import br.com.cwi.crescer.aula5.dao.UserDao;
import br.com.cwi.crescer.aula5.entity.Ator;
import br.com.cwi.crescer.aula5.entity.Usuario;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Eduardo
 */
@ManagedBean
@ViewScoped
public class UsuarioMBean extends AbstractMBean<Usuario, Long, UserDao, UserBean> {

    @EJB
    private UserBean usuarioBean;

    @PostConstruct
    public void init() {
        this.limpar();
    }

    @Override
    public UserBean getBean() {
        return usuarioBean;
    }

    @Override
    public void limpar() {
        this.setEntity(new Usuario());
        this.setList(this.getBean().findAll());
    }
}
