package br.com.caronaparatodos.entidades;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@Table(name = "usuario")
@XmlRootElement
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "login")
    private String login;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "senha")
    private String senha;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_info_usuario")
    private InfoUsuario infoUsuario;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public InfoUsuario getInfoUsuario() {
        return infoUsuario;
    }

    public void setInfoUsuario(InfoUsuario infoUsuario) {
        this.infoUsuario = infoUsuario;
    }
}
