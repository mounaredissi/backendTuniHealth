package tn.enicarthage.TuniHealth.controller;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.enicarthage.TuniHealth.dao.ConsultationRepo;
import tn.enicarthage.TuniHealth.entity.Consultation;
import tn.enicarthage.TuniHealth.service.ConsultationService;
@RestController
public class ConsultationController {
	   @Autowired
	    private ConsultationService ConsultationService;
	   @Autowired
	   private ConsultationRepo consrep;

    @PostMapping({"/registerNewConsultation"})
    public Consultation registerNewConsultation(@RequestBody Consultation Consultation) throws ParseException  {
        return ConsultationService.registerNewConsultation(Consultation);
    }
  @GetMapping({"/findPatientsByIdMed/{id}"})
  public ResponseEntity<List<Consultation>> findPatientsByIdMed(@PathVariable String id) {
      return new ResponseEntity<List<Consultation>>(consrep.findAllPatientsByIdMed(id), HttpStatus.OK);
  }
  @GetMapping({"/findAllConsultationsBydate/{id}"})
  public ResponseEntity<List<Consultation>> findAllConsultationsBydate(@PathVariable String id) {
      return new ResponseEntity<List<Consultation>>(consrep.findAllConsultationsBydatess(id), HttpStatus.OK);
  }
  @DeleteMapping("/deleteCons/{id}")
  public ResponseEntity<HttpStatus> deleteConsultation(@PathVariable("id") long id) {
      try {
    	  consrep.deleteById(id);
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      } catch (Exception e) {
          return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
  }
  }