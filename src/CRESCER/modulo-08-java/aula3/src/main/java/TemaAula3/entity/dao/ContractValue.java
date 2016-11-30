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
@Table(name = "CONTRACT_VALUE")
public class ContractValue implements Serializable{
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_CONTRACT_VALUE")
    @SequenceGenerator(name = "SEQ_CONTRACT_VALUE", sequenceName = "SEQ_CONTRACT_VALUE", allocationSize = 1) 
    @Basic(optional = false)
    @Column(name = "ID_CONCTRACT_VALUE")
    private Long idContractValue;
    
    @Basic(optional = false)
    @Column(name = "DS_COIN")
    private String dsCoin;
    
    @Basic(optional = false)
    @Column(name = "DS_PERIODICITY")
    private String dsPeriodicity;
    
    @Basic(optional = false)
    @Column(name = "VL_AMOUNT_CONTRACT_VALUE")
    private Long vlAmountContractValue;
    
    @Basic(optional = false)
    @Column(name = "VL_MONTHLY_USD")
    private Long vlMonthlyUsd;
    
    @OneToOne
    private Contract contractDao;

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

    public String getDsPeriodicity() {
        return dsPeriodicity;
    }

    public void setDsPeriodicity(String dsPeriodicity) {
        this.dsPeriodicity = dsPeriodicity;
    }

    public Long getVlAmountContractValue() {
        return vlAmountContractValue;
    }

    public void setVlAmountContractValue(Long vlAmountContractValue) {
        this.vlAmountContractValue = vlAmountContractValue;
    }

    public Long getVlMonthlyUsd() {
        return vlMonthlyUsd;
    }

    public void setVlMonthlyUsd(Long vlMonthlyUsd) {
        this.vlMonthlyUsd = vlMonthlyUsd;
    }

    public Contract getContractDao() {
        return contractDao;
    }

    public void setContractDao(Contract contractDao) {
        this.contractDao = contractDao;
    }
    
    
}
