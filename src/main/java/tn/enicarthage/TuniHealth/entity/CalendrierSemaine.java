package tn.enicarthage.TuniHealth.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter

@Entity
@Table(name = "Calendrier_Semaine")
public class CalendrierSemaine implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int Duree_Cons;


    public CalendrierSemaine () {
        }
}