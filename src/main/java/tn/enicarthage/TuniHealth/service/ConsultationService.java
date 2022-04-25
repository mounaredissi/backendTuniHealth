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
	SimpleDateFormat format_day=new SimpleDateFormat("day")  ;	

	public int registerNewConsultation(Consultation consultation) throws ParseException {
		int retour=0;
		int t=0 ;
		  Consultation C = new Consultation();
		  int day=consultation.getDate().getDay();
		  System.out.println("dayyyyyyyyyyyyyyy    "+day);
		  String d =format_date.format(consultation.getDate());
		  System.out.println("daaaaaaaaaaaate    "+d);
		  int h =consultation.getH();
		  System.out.println("hhhhhhhhhhhhhhhhhh    "+h);
		  List<Consultation> dates =(consRepo.findAllConsultationsBydatess(d));
		  System.out.println("dddddddddddddd "+dates.size());
		  for (int i=0 ; i<dates.size();i++)
		  {
			  if (dates.get(i).getH()==h) 
				  {t=1;
				  return 3;
			  		}
			  }		 
			 if (t==0){
				 if (day >=1 && day<=6) {
					 if(h>=8 && h<=15) {
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
	      retour=1;}
					 else {System.out.println("ce medecin travail de 08:00 à 16:00");
					 retour=4;
						 }
					 }
				 else  {System.out.println("ce medecin ne travail pas dimanche ");
				 retour=2;}				 
	    } else { System.out.println("ce medecin a une autre consultation pour cette date");
	    retour=3;}
			 return retour ; 
		  
		  }

  
}