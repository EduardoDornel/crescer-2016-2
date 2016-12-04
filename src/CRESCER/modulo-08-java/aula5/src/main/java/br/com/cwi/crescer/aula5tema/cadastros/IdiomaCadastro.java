/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula5tema.cadastros;

import br.com.cwi.crescer.aula5tema.Genero;
import br.com.cwi.crescer.aula5tema.GeneroBean;
import br.com.cwi.crescer.aula5tema.Idioma;
import br.com.cwi.crescer.aula5tema.IdiomaBean;
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
public class IdiomaCadastro {

    @EJB
    private IdiomaBean idiomaBean;

    private Idioma idioma;
    private List<Idioma> idiomas;

    @PostConstruct
    public void init() {
        this.idioma = new Idioma();
        this.idiomas = idiomaBean.findAll();
        this.idiomas.sort((a, b) -> a.getIdIdioma().compareTo(b.getIdIdioma()));
    }

    public void adicionar() {
        idiomaBean.insert(idioma);
        this.init();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Teste", "teste"));
    }

    public IdiomaBean getIdiomaBean() {
        return idiomaBean;
    }

    public void setIdiomaBean(IdiomaBean idiomaBean) {
        this.idiomaBean = idiomaBean;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public List<Idioma> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<Idioma> idiomas) {
        this.idiomas = idiomas;
    }
    
    
}
