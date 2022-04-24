package tn.enicarthage.TuniHealth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.enicarthage.TuniHealth.dao.MedecinRepo;
import tn.enicarthage.TuniHealth.entity.Medecin;
import tn.enicarthage.TuniHealth.service.MedecinService;
@RestController
public class MedecinController {
	@Autowired 	MedecinRepo medRepo;
	 @Autowired
	    private MedecinService medService;
	 @PostMapping({"/registerNewMedecin"})
	    public Medecin save(@RequestBody Medecin med) {
	        return medService.save(med);
	    }
	 @GetMapping({"/getMedecin"})
	 public ResponseEntity<List<Medecin>> retirerAllMed( ){
		 List<Medecin> medecins = medService.retirerAllMed();
	        return new ResponseEntity<>(medecins, HttpStatus.OK);
	 }
	 @GetMapping({"/FindByMedName/{medName}"})
	    public ResponseEntity<Medecin> getMedecin(@PathVariable String medName) {
	        return new ResponseEntity<>(medService.FindByMedName(medName), HttpStatus.OK);
	    }
	 @GetMapping({"/FindBySpecialite/{Specialite}"})
	    public ResponseEntity<List<Medecin>> getMedecinbyspec(@PathVariable  String Specialite) {
	        return new ResponseEntity<List<Medecin>>(medService.FindBySpecialite(Specialite), 
	        		HttpStatus.OK);
	    }
	 
}
