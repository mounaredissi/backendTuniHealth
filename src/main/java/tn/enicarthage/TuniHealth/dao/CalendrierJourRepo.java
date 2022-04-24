package tn.enicarthage.TuniHealth.dao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.enicarthage.TuniHealth.entity.CalendrierJour;
@Repository
public interface CalendrierJourRepo extends CrudRepository<CalendrierJour, Long>{

}
