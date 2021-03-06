/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula5tema;

import java.io.Serializable;
import javax.persistence.*;
import static javax.persistence.GenerationType.SEQUENCE;

/**
 *
 * @author eduardo.ribas
 */
@Entity
@Table(name = "ATOR")
public class Ator implements Serializable {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_ATOR")
    @SequenceGenerator(name = "SEQ_ATOR", sequenceName = "SEQ_ATOR", allocationSize = 1) 
    @Basic(optional = false)
    @Column(name = "ID_ATOR")
    private Long idAtor;    
    
    @Basic(optional = false)
    @Column(name = "NOME_ATOR")
    private String nomeAtor; 
    
    @ManyToOne
    @Basic(optional = false)
    @Column(name = "ID_ELENCO")
    private long idElenco;

    public long getIdElenco() {
        return idElenco;
    }

    public void setIdElenco(long idElenco) {
        this.idElenco = idElenco;
    }

    public Long getIdAtor() {
        return idAtor;
    }

    public void setIdAtor(Long idAtor) {
        this.idAtor = idAtor;
    }

    public String getNomeAtor() {
        return nomeAtor;
    }

    public void setNomeAtor(String nomeAtor) {
        this.nomeAtor = nomeAtor;
    }
    
    
}
