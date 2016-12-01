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
    
    @OneToMany (cascade = ALL)
    private List<Ator> listaDeAtores;

    public Long getIdElenco() {
        return idElenco;
    }

    public void setIdElenco(Long idElenco) {
        this.idElenco = idElenco;
    }

    public List<Ator> getListaDeAtores() {
        return listaDeAtores;
    }

    public void setListaDeAtores(List<Ator> listaDeAtores) {
        this.listaDeAtores = listaDeAtores;
    }
    
    
}
