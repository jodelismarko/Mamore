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
 * Linha generated by hbm2java
 */
@Entity
@Table(name = "linha"
        , catalog = "mamore"
)
public class Linha implements java.io.Serializable {


    private Integer id;
    private int numero;
    private String situacaoVivoGestao;
    private int lmite;
    private String pacoteDados;
    private Set<Disponibilizacao> disponibilizacaos = new HashSet<Disponibilizacao>(0);
    private Set<AssociacaoLinhaChip> associacaoLinhaChips = new HashSet<AssociacaoLinhaChip>(0);

    public Linha() {
    }


    public Linha(int numero, int lmite) {
        this.numero = numero;
        this.lmite = lmite;
    }

    public Linha(int numero, String situacaoVivoGestao, int lmite, String pacoteDados, Set<Disponibilizacao> disponibilizacaos, Set<AssociacaoLinhaChip> associacaoLinhaChips) {
        this.numero = numero;
        this.situacaoVivoGestao = situacaoVivoGestao;
        this.lmite = lmite;
        this.pacoteDados = pacoteDados;
        this.disponibilizacaos = disponibilizacaos;
        this.associacaoLinhaChips = associacaoLinhaChips;
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


    @Column(name = "numero", nullable = false)
    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }


    @Column(name = "situacao_vivo_gestao", length = 8)
    public String getSituacaoVivoGestao() {
        return this.situacaoVivoGestao;
    }

    public void setSituacaoVivoGestao(String situacaoVivoGestao) {
        this.situacaoVivoGestao = situacaoVivoGestao;
    }


    @Column(name = "lmite", nullable = false)
    public int getLmite() {
        return this.lmite;
    }

    public void setLmite(int lmite) {
        this.lmite = lmite;
    }


    @Column(name = "pacote_dados", length = 3)
    public String getPacoteDados() {
        return this.pacoteDados;
    }

    public void setPacoteDados(String pacoteDados) {
        this.pacoteDados = pacoteDados;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "linha")
    public Set<Disponibilizacao> getDisponibilizacaos() {
        return this.disponibilizacaos;
    }

    public void setDisponibilizacaos(Set<Disponibilizacao> disponibilizacaos) {
        this.disponibilizacaos = disponibilizacaos;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "linha")
    public Set<AssociacaoLinhaChip> getAssociacaoLinhaChips() {
        return this.associacaoLinhaChips;
    }

    public void setAssociacaoLinhaChips(Set<AssociacaoLinhaChip> associacaoLinhaChips) {
        this.associacaoLinhaChips = associacaoLinhaChips;
    }


}


