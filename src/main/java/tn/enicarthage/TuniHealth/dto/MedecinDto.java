package tn.enicarthage.TuniHealth.dto;

import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MedecinDto {

	private String medName;
    private String medFirstName;
    private String medLastName;
    private String medPassword;
	private Date date_naiss;
    private CalendrierSemaineDto Calendrier_Semaine;
    @JsonIgnore
    private Set<ConsultationDto> Consultations;
    

}
