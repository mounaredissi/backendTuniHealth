package tn.enicarthage.TuniHealth.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.enicarthage.TuniHealth.entity.CalendrierSemaine;
@Repository
public interface CalendrierSemaineRepo extends JpaRepository<CalendrierSemaine, Long>{

}
