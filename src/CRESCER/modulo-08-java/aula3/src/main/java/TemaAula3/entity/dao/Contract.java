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
@Table(name = "CONTRACT")
public class Contract implements Serializable{
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_CONTRACT")
    @SequenceGenerator(name = "SEQ_CONTRACT", sequenceName = "SEQ_CONTRACT", allocationSize = 1) 
    @Basic(optional = false)
    @Column(name = "ID_CONCTRACT")
    private Long idContract;
    
    @Basic(optional = false)
    @Column(name = "DS_DESCRIPTION")
    private String dsDescription;
    
    @Basic(optional = false)
    @Column(name = "DS_STATE")
    private String dsState;
    
    @Basic(optional = false)
    @Column(name = "DS_WEBSITE")
    private String dsWebsite;
    
    @Basic(optional = false)
    @Column(name = "NM_CONTRACT")
    private String nmContract;
    
    @ManyToOne(cascade = ALL)
    private Client ClientDao;    

    public Long getIdContract() {
        return idContract;
    }

    public void setIdContract(Long idContract) {
        this.idContract = idContract;
    }

    public String getDsDescription() {
        return dsDescription;
    }

    public void setDsDescription(String dsDescription) {
        this.dsDescription = dsDescription;
    }

    public String getDsState() {
        return dsState;
    }

    public void setDsState(String dsState) {
        this.dsState = dsState;
    }

    public String getDsWebsite() {
        return dsWebsite;
    }

    public void setDsWebsite(String dsWebsite) {
        this.dsWebsite = dsWebsite;
    }

    public String getNmContract() {
        return nmContract;
    }

    public void setNmContract(String nmContract) {
        this.nmContract = nmContract;
    }

    public Client getClientDao() {
        return ClientDao;
    }

    public void setClientDao(Client ClientDao) {
        this.ClientDao = ClientDao;
    }
            
   
}
