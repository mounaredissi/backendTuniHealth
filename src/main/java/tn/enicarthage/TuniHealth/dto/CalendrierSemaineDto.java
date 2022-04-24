package tn.enicarthage.TuniHealth.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;
import tn.enicarthage.TuniHealth.entity.CalendrierSemaine;
@Data
@Builder
public class CalendrierSemaineDto {
	
	 private long id;
	 private int Duree_Cons;
	 @JsonIgnore
	 private Set<CalendrierJourDto> jours_cal;

	  public static CalendrierSemaineDto fromEntity(CalendrierSemaine CalendSem) {
		    if (CalendSem == null) {
		      return null;
		    }
		    return CalendrierSemaineDto.builder()
		        .id(CalendSem.getId())
		        .Duree_Cons(CalendSem.getDuree_Cons())	
		        .build();
		  }
	  public static CalendrierSemaine toEntity(CalendrierSemaineDto dto) {
		    if (dto == null) {
		      return null;
		    }
		    CalendrierSemaine CalendrierSemaine = new CalendrierSemaine();
		    CalendrierSemaine.setId(dto.getId());
		    CalendrierSemaine.setDuree_Cons(dto.getDuree_Cons());
		    return CalendrierSemaine;
		  }

}
