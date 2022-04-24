package tn.enicarthage.TuniHealth.service;

import org.springframework.stereotype.Service;

import tn.enicarthage.TuniHealth.dao.CalendrierSemaineRepo;
import tn.enicarthage.TuniHealth.entity.CalendrierSemaine;

@Service
public class CalendrierSemaineService {
	private CalendrierSemaineRepo calendrier_semaine_repo;


   // @Override
  /*  public CalendrierSemaine createDefault() {
        CalendrierSemaine CalendrierSemaine = this.calendrier_semaine_repo.saveAndFlush(new CalendrierSemaine ());

        for (Jour Jour : Jour.values()) {
            CalendrierJour calendrier_jour= new CalendrierJour ();
            calendrier_jour.setJour(Jour);
            calendrier_jour.setTemps_debut(Time.valueOf("00:00:00"));
            calendrier_jour.setTemps_fin(Time.valueOf("00:00:00"));
            calendrier_jour.setSemaines_cal(CalendrierSemaine);

            this.calendrier_jour_service.create(calendrier_jour);
        }

        return CalendrierSemaine;
    }
    */
    public CalendrierSemaine save(CalendrierSemaine c) {
    	return calendrier_semaine_repo.save(c);
    }
    
}
