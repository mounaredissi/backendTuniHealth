package tn.enicarthage.TuniHealth.entity;

import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Medecin {
	
	@Id
    @Column(name = "Medecin_username")
	 private String medName;
    @Column(name = "Medecin_firstName")
    private String medFirstName;    
    @Column(name = "Medecin_Last_name")
    private String medLastName;
    @Column(name = "Medecin_user_Password")
    private String medPassword;
	 @Column(name = "Medecin_spécialité")
	    private String medSpecialite;
	 @Column(name = "Medecin_sexe")
	    private String sexe;
	@JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "medecin")
    private Set<Consultation> Consultations;
	@JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "medecin")
    @OrderBy("id")
    private Set<CalendrierJour> jours_cal;

	public Medecin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Medecin(String medName, String medFirstName, String medLastName, String medPassword, String medSpecialite,
			String sexe, Set<Consultation> consultations, Set<CalendrierJour> jours_cal) {
		super();
		this.medName = medName;
		this.medFirstName = medFirstName;
		this.medLastName = medLastName;
		this.medPassword = medPassword;
		this.medSpecialite = medSpecialite;
		this.sexe = sexe;
		Consultations = consultations;
		this.jours_cal = jours_cal;
	}





    
	
}
