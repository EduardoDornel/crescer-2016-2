/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula5tema;

/**
 *
 * @author Eduardo
 */
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "ELENCO")
public class Elenco implements Serializable{
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_ELENCO")
    @SequenceGenerator(name = "SEQ_ELENCO", sequenceName = "SEQ_ELENCO", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_ELENCO")
    private Long idElenco; 
    
    @Basic(optional = false)
    @Column(name = "NOME_ELENCO")
    private String nomeElenco;
    
    @OneToMany   
    private List<Ator> atores;

    public List<Ator> getAtores() {
        return atores;
    }

    public void setAtores(List<Ator> atores) {
        this.atores = atores;
    }
    
    public Long getIdElenco() {
        return idElenco;
    }

    public void setIdElenco(Long idElenco) {
        this.idElenco = idElenco;
    }

    public String getNomeElenco() {
        return nomeElenco;
    }

    public void setNomeElenco(String nomeElenco) {
        this.nomeElenco = nomeElenco;
    }

}
