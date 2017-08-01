package mm.model;
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
 * CargoEfetivo generated by hbm2java
 */
@Entity
@Table(name="cargo_efetivo"
    ,catalog="mamore"
)
public class CargoEfetivo  implements java.io.Serializable {


     private Integer id;
     private String descricao;
     private Set<Efetivo> efetivos = new HashSet<Efetivo>(0);

    public CargoEfetivo() {
    }

	
    public CargoEfetivo(String descricao) {
        this.descricao = descricao;
    }
    public CargoEfetivo(String descricao, Set<Efetivo> efetivos) {
       this.descricao = descricao;
       this.efetivos = efetivos;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="descricao", nullable=false, length=30)
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="cargoEfetivo")
    public Set<Efetivo> getEfetivos() {
        return this.efetivos;
    }
    
    public void setEfetivos(Set<Efetivo> efetivos) {
        this.efetivos = efetivos;
    }




}


