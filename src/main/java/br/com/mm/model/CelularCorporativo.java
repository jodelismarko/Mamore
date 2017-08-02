package br.com.mm.model;
// Generated 31/07/2017 19:00:58 by Hibernate Tools 5.2.0.Final


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * CelularCorporativo generated by hbm2java
 */
@Entity
@Table(name = "celular_corporativo"
        , catalog = "mamore"
)
public class CelularCorporativo implements java.io.Serializable {


    private Integer id;
    private Celular celular;
    private Fabricante fabricante;
    private Modelo modelo;
    private String imei;

    public CelularCorporativo() {
    }


    public CelularCorporativo(Celular celular, Fabricante fabricante, Modelo modelo) {
        this.celular = celular;
        this.fabricante = fabricante;
        this.modelo = modelo;
    }

    public CelularCorporativo(Celular celular, Fabricante fabricante, Modelo modelo, String imei) {
        this.celular = celular;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.imei = imei;
    }

    @GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "celular"))
    @Id
    @GeneratedValue(generator = "generator")


    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    public Celular getCelular() {
        return this.celular;
    }

    public void setCelular(Celular celular) {
        this.celular = celular;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fabricante_id", nullable = false)
    public Fabricante getFabricante() {
        return this.fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "modelo_id", nullable = false)
    public Modelo getModelo() {
        return this.modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }


    @Column(name = "imei", length = 15)
    public String getImei() {
        return this.imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }


}

