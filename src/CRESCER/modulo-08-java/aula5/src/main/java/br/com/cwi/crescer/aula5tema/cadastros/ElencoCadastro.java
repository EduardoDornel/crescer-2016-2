/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula5tema.cadastros;

import br.com.cwi.crescer.aula5tema.Classificacao;
import br.com.cwi.crescer.aula5tema.ClassificacaoBean;
import br.com.cwi.crescer.aula5tema.Elenco;
import br.com.cwi.crescer.aula5tema.ElencoBean;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author eduardo.ribas
 */
@ManagedBean
@ViewScoped
public class ElencoCadastro {

    @EJB
    private ElencoBean elencoBean;

    private Elenco elenco;
    private List<Elenco> elencos;

    @PostConstruct
    public void init() {
        this.elenco = new Elenco();
        this.elencos = elencoBean.findAll();
        this.elencos.sort((a, b) -> a.getIdElenco().compareTo(b.getIdElenco()));
    }

    public ElencoBean getElencoBean() {
        return elencoBean;
    }

    public void setElencoBean(ElencoBean elencoBean) {
        this.elencoBean = elencoBean;
    }

    public Elenco getElenco() {
        return elenco;
    }

    public void setElenco(Elenco elenco) {
        this.elenco = elenco;
    }

    public List<Elenco> getElencos() {
        return elencos;
    }

    public void setElencos(List<Elenco> elencos) {
        this.elencos = elencos;
    }

    

    public void adicionar() {
        elencoBean.insert(elenco);
        this.init();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Teste", "teste"));
    }
}
