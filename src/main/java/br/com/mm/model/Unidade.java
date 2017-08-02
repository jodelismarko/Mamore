package br.com.mm.model;
// Generated 31/07/2017 19:00:58 by Hibernate Tools 5.2.0.Final


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Unidade generated by hbm2java
 */
@Entity
@Table(name = "unidade"
        , catalog = "mamore"
)
public class Unidade implements java.io.Serializable {


    private Integer id;
    private String sigla;
    private String descricao;
    private Set<Servidor> servidors = new HashSet<Servidor>(0);

    public Unidade() {
    }


    public Unidade(String sigla, String descricao) {
        this.sigla = sigla;
        this.descricao = descricao;
    }

    public Unidade(String sigla, String descricao, Set<Servidor> servidors) {
        this.sigla = sigla;
        this.descricao = descricao;
        this.servidors = servidors;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)


    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @Column(name = "sigla", nullable = false, length = 7)
    public String getSigla() {
        return this.sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }


    @Column(name = "descricao", nullable = false, length = 50)
    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "unidade")
    public Set<Servidor> getServidors() {
        return this.servidors;
    }

    public void setServidors(Set<Servidor> servidors) {
        this.servidors = servidors;
    }


}

