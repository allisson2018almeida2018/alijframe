/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pontoEletronico.entities;

import br.com.pontoEletronico.intefaces.Bean;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Tiago
 */
@Entity
@Access(AccessType.PROPERTY)
@Table(name = "CAD_FUNCIONARIOS")
@SequenceGenerator(name = "func_seq", sequenceName = "seq_func", initialValue = 1, allocationSize = 1)
public class Funcionario implements Serializable, Bean<Funcionario> {

    private static final long serialVersionUID = -7136837973113115416L;

    private Long matricula;
    private String nome;
    private String cpf;
    private BigDecimal salario;
    private String senha;

    public Funcionario() {
    }

    public Funcionario(Long matricula, String nome, String cpf, BigDecimal salario, String senha) {
        this.matricula = matricula;
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
        this.senha = senha;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "func_seq")
    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    @Column(name = "NOME", length = 255, nullable = false)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(name = "CPF", length = 11, nullable = false)
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Column(name = "SALARIO", length = 10, nullable = false)
    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    @Column(name = "SENHA", length = 15, nullable = false)
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public void clear() {
        this.matricula = null;
        this.nome = null;
        this.cpf = null;
        this.salario = null;
        this.senha = null;
    }

    @Override
    public void copiar(Funcionario object) {
        if (object != null) {
            this.matricula = object.getMatricula();
            this.nome = object.getNome();
            this.cpf = object.getCpf();
            this.salario = object.getSalario();
            this.senha = object.getSenha();
        }
    }

    @Override
    public Funcionario clonar() {
        Funcionario funcionario = new Funcionario();
        funcionario.setMatricula(matricula);
        funcionario.setNome(nome);
        funcionario.setCpf(cpf);
        funcionario.setSalario(salario);
        funcionario.setSenha(senha);
        return funcionario;
    }

}
