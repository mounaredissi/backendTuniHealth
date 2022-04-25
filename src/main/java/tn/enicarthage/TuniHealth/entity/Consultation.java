package tn.enicarthage.TuniHealth.entity;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Consultations")
public class Consultation implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	private int h ;
    private Date date ;
    private LocalTime T_debut;
    private LocalTime T_fin ;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "medecin_id")
    private 	Medecin medecin;

    private String description;

    public Consultation () {}

    public void setTDebut(int h ) {
    	if (h==8 || h==9)
    	this.T_debut=this.T_debut.parse("0"+h+":00");
    	else
    		this.T_debut=this.T_debut.parse(h+":00");
    		
    }
    public void setTFin(int h ) {
    	if (h==8)
    	this.T_fin=this.T_fin.parse("0"+h+":00");
    	else
        	this.T_fin=this.T_fin.parse(h+":00");

    }
    



}