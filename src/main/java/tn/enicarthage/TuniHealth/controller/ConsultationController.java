package tn.enicarthage.TuniHealth.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.enicarthage.TuniHealth.dao.ConsultationRepo;
import tn.enicarthage.TuniHealth.entity.Consultation;
import tn.enicarthage.TuniHealth.entity.Medecin;
import tn.enicarthage.TuniHealth.entity.Patient;
import tn.enicarthage.TuniHealth.service.ConsultationService;
@RestController
public class ConsultationController {
	   @Autowired
	    private ConsultationService ConsultationService;
	   @Autowired
	   private ConsultationRepo consrep;

    @PostMapping({"/registerNewConsultation"})
    public Consultation registerNewConsultation(@RequestBody Consultation Consultation) {
        return ConsultationService.registerNewConsultation(Consultation);
    }
  @GetMapping({"/findPatientsByIdMed/{id}"})
  public ResponseEntity<List<Consultation>> findPatientsByIdMed(@PathVariable String id) {
      return new ResponseEntity<List<Consultation>>(consrep.findAllPatientsByIdMed(id), HttpStatus.OK);
  }}
