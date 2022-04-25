package tn.enicarthage.TuniHealth.dao;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.enicarthage.TuniHealth.entity.Consultation;
@Repository
public interface ConsultationRepo extends CrudRepository<Consultation, Long>{
	  @Query(value = " (select * from consultations c where c.medecin_id=:id)", nativeQuery = true)
	    List<Consultation> findAllPatientsByIdMed(@Param("id") String id);
	  
	  @Query(value = " (select * from consultations c where c.date=:date)", nativeQuery = true)
	    List<Consultation> findAllConsultationsBydatess(@Param("date") String date);
	  
	  @Query(value = " (select * from consultations c where c.date=:date)", nativeQuery = true)
	    List<Consultation> findAllConsultationsByToday(@Param("date") String date);
	  
}