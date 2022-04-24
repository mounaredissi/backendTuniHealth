package tn.enicarthage.TuniHealth.service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.var;
import tn.enicarthage.TuniHealth.dao.ConsultationRepo;
import tn.enicarthage.TuniHealth.entity.Consultation;

@Service
public class ConsultationService {
	@Autowired
	private ConsultationRepo consRepo;
	SimpleDateFormat format_date=new SimpleDateFormat("yyyy-MM-dd")  ;	
	 
	public Consultation registerNewConsultation(Consultation consultation) throws ParseException {
		int t=0 ;
		  Consultation C = new Consultation();
		  String d =format_date.format(consultation.getDate());
		  System.out.println("daaaaaaaaaaaate    "+d);
		  int h =consultation.getH();
		  System.out.println("hhhhhhhhhhhhhhhhhh    "+h);
		  List<Consultation> dates =(consRepo.findAllConsultationsBydatess(d));
		  System.out.println("dddddddddddddd "+dates.size());
		  for (int i=0 ; i<dates.size();i++)
		  {
			  System.out.println("hhhhhhhhhhhhhhhhhh    "+dates.get(i).getH());
			  if (dates.get(i).getH()==h) 
				  {t=1;
			  		}
			  }
		 
			 if (t==0){
				  C.setDate(format_date.parse(d));
				  C.setH(h);
		  C.setTDebut(h);
		  C.setTFin(h+1);
		  C.setId(consultation.getId());
		  C.setDate(consultation.getDate());
		  C.setPatient(consultation.getPatient());
		  C.setMedecin(consultation.getMedecin());
		  C.setDescription(consultation.getDescription());
		  consRepo.save(C);
	      return consRepo.save(C);                       
	    } 
			 return null ; 
		  
		  }

  
}