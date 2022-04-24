package tn.enicarthage.TuniHealth.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import tn.enicarthage.TuniHealth.dao.MedecinRepo;
import tn.enicarthage.TuniHealth.dao.RoleDao;
import tn.enicarthage.TuniHealth.dao.UserDao;
import tn.enicarthage.TuniHealth.entity.Medecin;
import tn.enicarthage.TuniHealth.entity.Role;
import tn.enicarthage.TuniHealth.entity.User;
 
@Service
public class MedecinService {
	@Autowired 	MedecinRepo medRepo;
	@Autowired 	UserDao userDao;
	@Autowired 	RoleDao roleDao;
	@Autowired UserService userserv;
	@Autowired
    private PasswordEncoder passwordEncoder;
	private static final Logger L = LogManager.getLogger(MedecinService.class);
	
	  public Medecin save(Medecin medecin) {
		  User user = new User();
		  Role role = roleDao.findById("Medecin").get();
	        Set<Role> userRoles = new HashSet<>();
	        userRoles.add(role);
	        user.setUserName(medecin.getMedName());
	        user.setUserFirstName(medecin.getMedFirstName());
	        user.setUserLastName(medecin.getMedLastName());
	        user.setRole(userRoles);
	        user.setUserPassword(getEncodedPasswordPat(medecin.getMedPassword()));
	        userDao.save(user);
	        return medRepo.save(medecin);
	                          
	    }
	  public String getEncodedPasswordPat(String password) {
	        return passwordEncoder.encode(password);
	    }
	  public  List<Medecin> retirerAllMed(){
	        List<Medecin> medecins = new ArrayList<>();
	        medRepo.findAll().forEach(medecins::add);
	        for (Medecin medecin: medecins) {
	        	L.info("medecin+++ :" + medecin);
	        }
		  return medecins ;
	  }
	  public Medecin FindByMedName(String medName) {
	        return medRepo.findById(medName).get();}
	  
	  public List<Medecin> FindBySpecialite(String Specialite) {
		  return medRepo.findByMedSpecialite(Specialite);}

}
 