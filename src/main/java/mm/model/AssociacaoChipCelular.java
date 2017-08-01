package mm.model;
// Generated 31/07/2017 19:00:58 by Hibernate Tools 5.2.0.Final


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * AssociacaoChipCelular generated by hbm2java
 */
@Entity
@Table(name="associacao_chip_celular"
    ,catalog="mamore"
)
public class AssociacaoChipCelular  implements java.io.Serializable {


     private Integer id;
     private Celular celular;
     private Chip chip;

    public AssociacaoChipCelular() {
    }

    public AssociacaoChipCelular(Celular celular, Chip chip) {
       this.celular = celular;
       this.chip = chip;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="celular_id", nullable=false)
    public Celular getCelular() {
        return this.celular;
    }
    
    public void setCelular(Celular celular) {
        this.celular = celular;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="chip_id", nullable=false)
    public Chip getChip() {
        return this.chip;
    }
    
    public void setChip(Chip chip) {
        this.chip = chip;
    }




}


