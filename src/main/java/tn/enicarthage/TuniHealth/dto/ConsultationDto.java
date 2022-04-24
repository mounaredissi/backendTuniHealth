package tn.enicarthage.TuniHealth.dto;

import java.util.Date;

import lombok.Builder;
import lombok.Data;
import tn.enicarthage.TuniHealth.entity.Consultation;
import tn.enicarthage.TuniHealth.entity.Medecin;
import tn.enicarthage.TuniHealth.entity.Patient;

@Data
@Builder
public class ConsultationDto {

    private long id;
    private Date date;
    private Patient patient;
    private Medecin medecin;
    private String description;

  public static ConsultationDto fromEntity(tn.enicarthage.TuniHealth.entity.Consultation Consultation) {
    if (Consultation == null) {
      return null;
    }
    return ConsultationDto.builder()
        .id(Consultation.getId())
        .date(Consultation.getDate())
      //  .patient(PatientDto.fromEntity(Consultation.getPatient()))
      // .medecin(MedecinDto.fromEntity(Consultation.getMedecin()))
        .description(Consultation.getDescription())
        .build();

  }

  public static Consultation toEntity(ConsultationDto dto) {
    if (dto == null) {
      return null;
    }
    Consultation Consultation = new Consultation();
    Consultation.setId(dto.getId());
    Consultation.setDate(dto.getDate());
   // Consultation.setPatient(PatientDto.toEntity(dto.getPatient()));
   // Consultation.setPatient(MedecinDto.toEntity(dto.getMedecin()));
    Consultation.setDescription(dto.getDescription());

    return Consultation;
  }

}