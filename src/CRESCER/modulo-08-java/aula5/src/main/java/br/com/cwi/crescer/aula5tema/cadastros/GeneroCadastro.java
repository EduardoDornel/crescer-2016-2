/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula5tema.cadastros;

import br.com.cwi.crescer.aula5tema.Classificacao;
import br.com.cwi.crescer.aula5tema.ClassificacaoBean;
import br.com.cwi.crescer.aula5tema.Genero;
import br.com.cwi.crescer.aula5tema.GeneroBean;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Eduardo
 */
@ManagedBean
@ViewScoped
public class GeneroCadastro {

    @EJB
    private GeneroBean generoBean;

    private Genero genero;
    private List<Genero> generos;

    @PostConstruct
    public void init() {
        this.genero = new Genero();
        this.generos = generoBean.findAll();
        this.generos.sort((a, b) -> a.getIdGenero().compareTo(b.getIdGenero()));
    }

    public void adicionar() {
        generoBean.insert(genero);
        this.init();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Teste", "teste"));
    }

    public GeneroBean getGeneroBean() {
        return generoBean;
    }

    public void setGeneroBean(GeneroBean generoBean) {
        this.generoBean = generoBean;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(List<Genero> generos) {
        this.generos = generos;
    }
    
    
}
