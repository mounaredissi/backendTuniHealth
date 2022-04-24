package tn.enicarthage.TuniHealth.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.enicarthage.TuniHealth.entity.Patient;
@Repository
public interface PatientRepo extends JpaRepository<Patient, String>{

}
