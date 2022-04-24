package tn.enicarthage.TuniHealth.dto;

import java.sql.Time;

import lombok.Builder;
import lombok.Data;
import tn.enicarthage.TuniHealth.entity.CalendrierJour;
import tn.enicarthage.TuniHealth.entity.Jour;

@Data
@Builder
public class CalendrierJourDto {
	  private long id;
	  private Jour jour;
	  private Time temps_debut;
	  private Time temps_fin;
	  private CalendrierSemaineDto semaines_cal;

	  public static CalendrierJourDto fromEntity(CalendrierJour CalendJour) {
		    if (CalendJour == null) {
		      return null;
		    }
		    return CalendrierJourDto.builder()
		        .id(CalendJour.getId())
		        .jour(CalendJour.getJour())
		        .temps_debut(CalendJour.getTemps_debut())
		        .temps_fin(CalendJour.getTemps_fin())
		        //.semaines_cal(CalendrierSemaineDto.fromEntity(CalendJour.getSemaines_cal()))
		        .build();
		  }
	  public static CalendrierJour toEntity(CalendrierJourDto dto) {
		    if (dto == null) {
		      return null;
		    }
		    CalendrierJour CalendrierJour = new CalendrierJour();
		    CalendrierJour.setId(dto.getId());
		    CalendrierJour.setJour(dto.getJour());
		    CalendrierJour.setTemps_debut(dto.getTemps_debut());
		    CalendrierJour.setTemps_fin(dto.getTemps_fin()); 
		   // CalendrierJour.setSemaines_cal(CalendrierSemaineDto.toEntity(dto.getSemaines_cal()));
		    return CalendrierJour;
		  }
}
