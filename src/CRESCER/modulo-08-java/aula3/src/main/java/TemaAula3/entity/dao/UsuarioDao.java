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
@Table(
    name = "USUARIO",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "DS_USER_NAME")
    }
)
public class UsuarioDao implements Serializable{
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_USUARIO")
    @SequenceGenerator(name = "SEQ_USUARIO", sequenceName = "SEQ_USUARIO", allocationSize = 1) 
    @Basic(optional = false)
    @Column(name = "ID_USUARIO")
    private Long idUsuario;
    
    @Basic(optional = false)
    @Column(name = "DS_EMAIL")
    private String dsEmail;
    
    @Basic(optional = false)
    @Column(name = "DS_SENHA")
    private String dsSenha;
    
    @Basic(optional = false)
    @Column(name = "DS_SITUACAO")
    private String dsSituacao;
    
    @Basic(optional = false)
    @Column(name = "DS_USER_NAME")
    private String dsUserName;
    
    @Basic(optional = false)
    @Column(name = "NM_USUARIO")
    private String nmUsuario;
    
    @Basic(optional = false)
    @Column(name = "TP_PERMISSAO")
    private String tpPermissao;

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getDsEmail() {
        return dsEmail;
    }

    public void setDsEmail(String dsEmail) {
        this.dsEmail = dsEmail;
    }

    public String getDsSenha() {
        return dsSenha;
    }

    public void setDsSenha(String dsSenha) {
        this.dsSenha = dsSenha;
    }

    public String getDsSituacao() {
        return dsSituacao;
    }

    public void setDsSituacao(String dsSituacao) {
        this.dsSituacao = dsSituacao;
    }

    public String getDsUserName() {
        return dsUserName;
    }

    public void setDsUserName(String dsUserName) {
        this.dsUserName = dsUserName;
    }

    public String getNmUsuario() {
        return nmUsuario;
    }

    public void setNmUsuario(String nmUsuario) {
        this.nmUsuario = nmUsuario;
    }

    public String getTpPermissao() {
        return tpPermissao;
    }

    public void setTpPermissao(String tpPermissao) {
        this.tpPermissao = tpPermissao;
    }
    
    
}
