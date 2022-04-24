package tn.enicarthage.TuniHealth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.enicarthage.TuniHealth.entity.Consultation;
import tn.enicarthage.TuniHealth.entity.Medecin;
import tn.enicarthage.TuniHealth.entity.Patient;
import tn.enicarthage.TuniHealth.service.PatientService;
@RestController
public class PatientController {
	 @Autowired
	    private PatientService patService;
	 @PostMapping({"/registerNewPatient"})
	    public Patient save(@RequestBody Patient pat) {
	        return patService.save(pat);
	    }
	  @GetMapping({"/findPatientsByMed/{id}"})
	  public ResponseEntity<List<Patient>> retirerAllPatByMed(@PathVariable String id) {
	      return new ResponseEntity<List<Patient>>(patService.retirerAllPatByMed(id), HttpStatus.OK);
	      }
}
