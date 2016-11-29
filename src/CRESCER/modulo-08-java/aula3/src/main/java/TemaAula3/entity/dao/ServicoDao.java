/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TemaAula3.entity.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.SEQUENCE;
/**
 *
 * @author Eduardo
 */
@Entity
@Table(name = "SERVICO")
public class ServicoDao implements Serializable{
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_SERVICO")
    @SequenceGenerator(name = "SEQ_SERVICO", sequenceName = "SEQ_SERVICO", allocationSize = 1) 
    @Basic(optional = false)
    @Column(name = "ID_SERVICO")
    private Long idServico;    
    
    @Basic(optional = false)
    @Column(name = "DS_DESCRICAO")
    private String dsDescricao;

    @Basic(optional = false)
    @Column(name = "DS_PERIODICIDADE")
    private String dsPeriodicidade;

    @Basic(optional = false)
    @Column(name = "DS_SIMBOLO_MOEDA")
    private String dsSimboloMoeda;

    @Basic(optional = false)
    @Column(name = "DS_SITUACAO")
    private String dsSituacao;

    @Basic(optional = false)
    @Column(name = "DS_WEBSITE")
    private String dsWebsite;
    
    @Basic(optional = false)
    @Column(name = "NM_SERVICO")
    private String nmServico;

    @Basic(optional = false)
    @Column(name = "VL_MENSAL_USD")
    private Long vlMensalUsd;

    @Basic(optional = false)
    @Column(name = "VL_TOTAL_SERVICO")
    private Long vlTotalServico;    
    
    @ManyToOne(cascade = ALL)
    private UsuarioDao usuarioDao;

    public Long getIdServico() {
        return idServico;
    }

    public void setIdServico(Long idServico) {
        this.idServico = idServico;
    }

    public String getDsDescricao() {
        return dsDescricao;
    }

    public void setDsDescricao(String dsDescricao) {
        this.dsDescricao = dsDescricao;
    }

    public String getDsPeriodicidade() {
        return dsPeriodicidade;
    }

    public void setDsPeriodicidade(String dsPeriodicidade) {
        this.dsPeriodicidade = dsPeriodicidade;
    }

    public String getDsSimboloMoeda() {
        return dsSimboloMoeda;
    }

    public void setDsSimboloMoeda(String dsSimboloMoeda) {
        this.dsSimboloMoeda = dsSimboloMoeda;
    }

    public String getDsSituacao() {
        return dsSituacao;
    }

    public void setDsSituacao(String dsSituacao) {
        this.dsSituacao = dsSituacao;
    }

    public String getDsWebsite() {
        return dsWebsite;
    }

    public void setDsWebsite(String dsWebsite) {
        this.dsWebsite = dsWebsite;
    }

    public String getNmServico() {
        return nmServico;
    }

    public void setNmServico(String nmServico) {
        this.nmServico = nmServico;
    }

    public Long getVlMensalUsd() {
        return vlMensalUsd;
    }

    public void setVlMensalUsd(Long vlMensalUsd) {
        this.vlMensalUsd = vlMensalUsd;
    }

    public Long getVlTotalServico() {
        return vlTotalServico;
    }

    public void setVlTotalServico(Long vlTotalServico) {
        this.vlTotalServico = vlTotalServico;
    }

    public UsuarioDao getUsuarioDao() {
        return usuarioDao;
    }

    public void setUsuarioDao(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }
    
    
}
