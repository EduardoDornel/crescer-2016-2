/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula5tema.cadastros;

import br.com.cwi.crescer.aula5tema.Ator;
import br.com.cwi.crescer.aula5tema.AtorBean;
import br.com.cwi.crescer.aula5tema.Classificacao;
import br.com.cwi.crescer.aula5tema.ClassificacaoBean;
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
public class ClassificacaoCadastro {

    @EJB
    private ClassificacaoBean classificacaoBean;

    private Classificacao classificacao;
    private List<Classificacao> classificacoes;

    @PostConstruct
    public void init() {
        this.classificacao = new Classificacao();
        this.classificacoes = classificacaoBean.findAll();
        this.classificacoes.sort((a, b) -> a.getIdClassificacao().compareTo(b.getIdClassificacao()));
    }

    public ClassificacaoBean getClassificacaoBean() {
        return classificacaoBean;
    }

    public void setClassificacaoBean(ClassificacaoBean classificacaoBean) {
        this.classificacaoBean = classificacaoBean;
    }

    public Classificacao getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(Classificacao classificacao) {
        this.classificacao = classificacao;
    }

    public List<Classificacao> getClassificacoes() {
        return classificacoes;
    }

    public void setClassificacoes(List<Classificacao> classificacoes) {
        this.classificacoes = classificacoes;
    }



    public void adicionar() {
        classificacaoBean.insert(classificacao);
        this.init();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Teste", "teste"));
    }
}
