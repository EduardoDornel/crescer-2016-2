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
@Table(name = "COTACAO")
public class Cotacao implements Serializable{
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_COTACAO")
    @SequenceGenerator(name = "SEQ_COTACAO", sequenceName = "SEQ_COTACAO", allocationSize = 1) 
    @Basic(optional = false)
    @Column(name = "ID_COTACAO")
    private Long idCotacao;
    
    @Basic(optional = false)
    @Column(name = "DS_COTACAO_DOLLAR_AUSTRALIANO")
    private Long dsCotacaoDolarAustraliano;

    @Basic(optional = false)
    @Column(name = "DS_COTACAO_DOLLAR_CANADENSE")
    private Long dsCotacaoDolarCanadense;

    @Basic(optional = false)
    @Column(name = "DS_COTACAO_EURO")
    private Long dsCotacaoEuro;   
    
    @Basic(optional = false)
    @Column(name = "DS_COTACAO_FRANCO_SUICO")
    private Long dsCotacaoFrancoSuico;
    
    @Basic(optional = false)
    @Column(name = "DS_COTACAO_LIBRA")
    private Long dsCotacaoLibra;  
    
    @Basic(optional = false)
    @Column(name = "DS_COTACAO_REAL")
    private Long dsCotacaoReal;

    @Basic(optional = false)
    @Column(name = "DS_COTACAO_YEN")
    private Long dsCotacaoYen;

    @Basic(optional = false)
    @Column(name = "DS_COTACAO_YUAN")
    private Long dsCotacaoYuan;

    @Basic(optional = false)
    @Column(name = "DS_COTACAO")
    private Long dsCotacao;    
}
