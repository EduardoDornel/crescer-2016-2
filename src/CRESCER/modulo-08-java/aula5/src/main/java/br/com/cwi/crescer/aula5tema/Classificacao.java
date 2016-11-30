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
@Table(name = "CLASSIFICACAO")
public class Classificacao implements Serializable{
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_CLASSIFICACAO")
    @SequenceGenerator(name = "SEQ_CLASSIFICACAO", sequenceName = "SEQ_CLASSIFICACAO", allocationSize = 1) 
    @Basic(optional = false)
    @Column(name = "ID_CLASSIFICACAO")
    private Long idClassificacao;
    
    @Basic(optional = false)
    @Column(name = "DESCRICAO_CLASSIFICACAO")
    private String descricaoClassificacao;
    
    @Basic(optional = true)
    @Column(name = "IDADE_CLASSIFICACAO")
    private String idadeClassificacao;   
}
