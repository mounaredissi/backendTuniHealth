package tn.enicarthage.TuniHealth.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.enicarthage.TuniHealth.entity.Medecin;
@Repository
public interface MedecinRepo extends JpaRepository<Medecin, String>{
	List<Medecin> findByMedSpecialite( String spec);

}
