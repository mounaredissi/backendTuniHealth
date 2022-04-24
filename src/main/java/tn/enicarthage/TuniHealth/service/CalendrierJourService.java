package tn.enicarthage.TuniHealth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.enicarthage.TuniHealth.dao.CalendrierJourRepo;
import tn.enicarthage.TuniHealth.entity.CalendrierJour;

@Service
public class CalendrierJourService {

    @Autowired
    private CalendrierJourRepo CalJourDao;
    public  CalendrierJour registerNewCalendrierJour(CalendrierJour CalendrierJour) {
        CalendrierJour.setId(CalendrierJour.getId());
        CalendrierJour.setJour(CalendrierJour.getJour());
        CalendrierJour.setId(CalendrierJour.getId());
	    CalendrierJour.setTemps_debut(CalendrierJour.getTemps_debut());
	    CalendrierJour.setTemps_fin(CalendrierJour.getTemps_fin()); 
	    CalendrierJour.setMedecin(CalendrierJour.getMedecin());
        return CalJourDao.save(CalendrierJour);
    }

}
