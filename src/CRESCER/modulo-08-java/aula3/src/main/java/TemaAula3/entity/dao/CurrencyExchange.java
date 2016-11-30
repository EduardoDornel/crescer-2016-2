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
@Table(name = "CURRENCY_EXCHAGNGE")
public class CurrencyExchange implements Serializable{
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_CURRENCY_EXCHANGE")
    @SequenceGenerator(name = "SEQ_CURRENCY_EXCHANGE", sequenceName = "SEQ_CURRENCY_EXCHANGE", allocationSize = 1) 
    @Basic(optional = false)
    @Column(name = "ID_CURRENCY_EXCHANGE")
    private Long idContractValue;
    
    @Basic(optional = false)
    @Column(name = "DS_COIN")
    private String dsCoin;

    @Basic(optional = false)
    @Column(name = "DT_CURRENCY_EXCHANGE")
    private Long dtCurrencyExchange;
    
    @Basic(optional = false)
    @Column(name = "VL_RATE")
    private Long vlRate;

    public Long getIdContractValue() {
        return idContractValue;
    }

    public void setIdContractValue(Long idContractValue) {
        this.idContractValue = idContractValue;
    }

    public String getDsCoin() {
        return dsCoin;
    }

    public void setDsCoin(String dsCoin) {
        this.dsCoin = dsCoin;
    }

    public Long getDtCurrencyExchange() {
        return dtCurrencyExchange;
    }

    public void setDtCurrencyExchange(Long dtCurrencyExchange) {
        this.dtCurrencyExchange = dtCurrencyExchange;
    }

    public Long getVlRate() {
        return vlRate;
    }

    public void setVlRate(Long vlRate) {
        this.vlRate = vlRate;
    }
    
    
    
}
