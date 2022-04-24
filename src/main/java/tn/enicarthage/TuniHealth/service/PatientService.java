package tn.enicarthage.TuniHealth.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import tn.enicarthage.TuniHealth.controller.ConsultationController;
import tn.enicarthage.TuniHealth.dao.ConsultationRepo;
import tn.enicarthage.TuniHealth.dao.PatientRepo;
import tn.enicarthage.TuniHealth.dao.RoleDao;
import tn.enicarthage.TuniHealth.dao.UserDao;
import tn.enicarthage.TuniHealth.entity.Consultation;
import tn.enicarthage.TuniHealth.entity.Medecin;
import tn.enicarthage.TuniHealth.entity.Patient;
import tn.enicarthage.TuniHealth.entity.Role;
import tn.enicarthage.TuniHealth.entity.User;
 
@Service
public class PatientService {
	@Autowired 	ConsultationRepo cons;
	@Autowired 	PatientRepo patRepo;
	@Autowired 	UserDao userDao;
	@Autowired 	RoleDao roleDao;
	@Autowired UserService userserv;
	@Autowired
    private PasswordEncoder passwordEncoder;
	  public Patient save(Patient patient) {
		  System.out.println("the pass"+patient.getPatPassword());
		  System.out.println("the pass"+patient.getPatFirstName());
		  User user = new User();
		  Role role = roleDao.findById("Patient").get();
	        Set<Role> userRoles = new HashSet<>();
	        userRoles.add(role);
	        user.setUserName(patient.getPatName());
	        user.setUserFirstName(patient.getPatFirstName());
	        user.setUserLastName(patient.getPatLastName());
	        user.setRole(userRoles);
	        user.setUserPassword(getEncodedPasswordPat(patient.getPatPassword()));
	        userDao.save(user);
	        return patRepo.save(patient);
	                             
	    }
	  public String getEncodedPasswordPat(String password) {
	        return passwordEncoder.encode(password);
	    }
	  public  List<Patient> retirerAllPatByMed(@PathVariable(value = "medId") String medId){
		  List<Consultation> l= cons.findAllPatientsByIdMed(medId);
		  List<Patient> pat= new ArrayList<>();
		
		  for(int i=0 ; i<l.size() ; i++) {
			  pat.add(l.get(i).getPatient());
		  }
		  return pat ;
	  }
}
