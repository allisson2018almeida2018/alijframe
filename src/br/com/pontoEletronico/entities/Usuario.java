/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pontoEletronico.entities;

import br.com.pontoEletronico.intefaces.Bean;
import java.io.Serializable;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.eclipse.persistence.annotations.Index;
import org.eclipse.persistence.annotations.Indexes;

/**
 *
 * @author Tiago
 */
@Entity
@Access(AccessType.PROPERTY)
@Table(name = "CAD_USUARIOS")
@Indexes(value = {
    @Index(name = "idx_login", columnNames = {"login"})
})
@NamedQueries(value = {
    @NamedQuery(name = "usuario.findAll", query = "SELECT user FROM Usuario AS user"),
    @NamedQuery(name = "usuario.findByLogin", query = "SELECT user FROM Usuario AS user WHERE user.login = :paramLogin")
})
@SequenceGenerator(name = "user_seq", sequenceName = "user_seq", initialValue = 1, allocationSize = 1)
public class Usuario implements Serializable, Bean<Usuario> {

    private static final long serialVersionUID = 5907257879879194399L;

    private Long id;
    private String nome;
    private String login;
    private String senha;

    public Usuario() {
    }

    public Usuario(Long id, String nome, String login, String senha) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "NOME", length = 255, nullable = false)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(name = "LOGIN", length = 20, nullable = false)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Column(name = "SENHA", length = 10, nullable = false)
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public void clear() {
        this.id = null;
        this.nome = null;
        this.login = null;
        this.senha = null;
    }

    @Override
    public void copiar(Usuario object) {
        if (object != null) {
            this.id = object.getId();
            this.nome = object.getNome();
            this.login = object.getLogin();
            this.senha = object.getSenha();
        }
    }

    @Override
    public Usuario clonar() {
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNome(nome);
        usuario.setLogin(login);
        usuario.setSenha(senha);
        return usuario;
    }

}
