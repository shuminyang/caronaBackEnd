package br.com.caronaparatodos.entidades;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "info_usuario")
@XmlRootElement
public class InfoUsuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_info_usuario")
    private Integer idInfoUsuario;

    @Basic(optional = false)
    @NotNull
    @Column(name = "nome")
    private String nome;

    @Basic(optional = false)
    @NotNull
    @Column(name = "cpf")
    private String cpf;

    @Basic(optional = false)
    @NotNull
    @Column(name = "endereco")
    private String endereco;

    @Basic(optional = false)
    @NotNull
    @Column(name = "email")
    private String email;

    @Basic(optional = false)
    @NotNull
    @Column(name = "data_nascimento")
    private Date dataNascimento;

    @Basic(optional = false)
    @NotNull
    @Column(name = "data_inclusao")
    private Date dataInclusao;

    @Basic(optional = true)
    @Column(name = "data_alteracao")
    private Date dataAlteracao;


    public Integer getIdInfoUsuario() {
        return idInfoUsuario;
    }

    public void setIdInfoUsuario(Integer idInfoUsuario) {
        this.idInfoUsuario = idInfoUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public Date getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(Date dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }
}
