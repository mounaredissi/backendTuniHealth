package tn.enicarthage.TuniHealth.entity;

import java.io.Serializable;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name = "calendrier_jour")
public class CalendrierJour implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(value = EnumType.STRING)
    private Jour jour;

    private Time temps_debut;

    private Time temps_fin;

    @ManyToOne
    @JoinColumn(name = "medecin_id")
    private Medecin medecin;

	public CalendrierJour() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CalendrierJour(long id, Jour jour, Time temps_debut, Time temps_fin, Medecin medecin) {
		super();
		this.id = id;
		this.jour = jour;
		this.temps_debut = temps_debut;
		this.temps_fin = temps_fin;
		this.medecin = medecin;
	}

    
    }