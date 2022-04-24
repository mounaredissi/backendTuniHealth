package tn.enicarthage.TuniHealth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.enicarthage.TuniHealth.entity.CalendrierJour;
import tn.enicarthage.TuniHealth.service.CalendrierJourService;
@RestController
public class CalendrierJourController {
	   @Autowired
	    private CalendrierJourService CalendrierJourService;

    @PostMapping({"/registerNewCalendrierJour"})
    public CalendrierJour registerNewCalendrierJour(@RequestBody CalendrierJour CalendrierJour) {
        return CalendrierJourService.registerNewCalendrierJour(CalendrierJour);
    }

}
