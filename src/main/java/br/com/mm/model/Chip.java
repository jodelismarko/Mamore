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
 * Chip generated by hbm2java
 */
@Entity
@Table(name = "chip"
        , catalog = "mamore"
)
public class Chip implements java.io.Serializable {


    private Integer id;
    private String cod;
    private Set<AssociacaoLinhaChip> associacaoLinhaChips = new HashSet<AssociacaoLinhaChip>(0);
    private Set<AssociacaoChipCelular> associacaoChipCelulars = new HashSet<AssociacaoChipCelular>(0);

    public Chip() {
    }

    public Chip(String cod, Set<AssociacaoLinhaChip> associacaoLinhaChips, Set<AssociacaoChipCelular> associacaoChipCelulars) {
        this.cod = cod;
        this.associacaoLinhaChips = associacaoLinhaChips;
        this.associacaoChipCelulars = associacaoChipCelulars;
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


    @Column(name = "cod", length = 20)
    public String getCod() {
        return this.cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "chip")
    public Set<AssociacaoLinhaChip> getAssociacaoLinhaChips() {
        return this.associacaoLinhaChips;
    }

    public void setAssociacaoLinhaChips(Set<AssociacaoLinhaChip> associacaoLinhaChips) {
        this.associacaoLinhaChips = associacaoLinhaChips;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "chip")
    public Set<AssociacaoChipCelular> getAssociacaoChipCelulars() {
        return this.associacaoChipCelulars;
    }

    public void setAssociacaoChipCelulars(Set<AssociacaoChipCelular> associacaoChipCelulars) {
        this.associacaoChipCelulars = associacaoChipCelulars;
    }


}


