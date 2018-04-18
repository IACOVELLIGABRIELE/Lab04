package it.polito.tdp.lab04.model;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;
import javafx.collections.FXCollections;

public class Model {
	
	CorsoDAO c = new CorsoDAO();
	StudenteDAO s = new StudenteDAO();
	
	public List<Corso> corsi(){
		return c.getTuttiICorsi();
		
	}
	
	public List<Studente> studenti(){
		return s.getTuttiIStudenti();
	}
	
	public Studente cercaStudenteDataMatricola(int matricola) {
		for(Studente a : s.getTuttiIStudenti()) {
			if(a.getMatricola() == matricola)
				return a;
		}
		return null;
	}
	
	public String dataMatricolaNomeCognome(int matricola) {
		    return s.nomeCognomeDataMatricola(matricola);
	}
	
	public String studentiIscrittiACorso(Corso corso){
		String result = "";
		
		for(Studente s1 : c.getStudentiIscrittiAlCorso(corso)) {
			result += s1.getMatricola() + " " + s1.getCognome() + " " + s1.getNome() + " " + s1.getCds() + "\n";
		}
		return result;
	}
	
	public String corsiACuiIscrittoStudente(Studente studente){
		/*String result = "";
		
		for(Corso c1 : s.corsiDatoUnoStudente(studente)) {
			result += c1.getCodins() + " " + c1.getCrediti() + " " + c1.getNome() + " " + c1.getPd() + "\n";
		}*/
		return s.corsiDatoUnoStudente(studente);
	}
	
	public boolean studenteIscrittoCorso(Studente studente, Corso corso) {
		return c.studenteIscrittoACorso(studente, corso);
	}
	
	
	
	
	
	/*TreeMap<Integer,Studente> mappaStudenti = new TreeMap<Integer,Studente>();
	TreeMap<String,Corso> mappaCorsi = new TreeMap<String, Corso>();
	TreeMap<Integer,String> mappaIscrizioni = new TreeMap<Integer,String>();
	
	public void aggiungiStudenti(List<Studente> lista) {
		
		StudenteDAO dao = new StudenteDAO();
		for(Studente s : dao.getTuttiIStudenti()) {
			mappaStudenti.put(s.getMatricola(), s);
		}
	}
	
   public void aggiungiCorsii(List<Corso> lista) {
		
		CorsoDAO dao = new CorsoDAO();
		for(Corso s : dao.getTuttiICorsi()) {
			mappaCorsi.put(s.getCodins(), s);
		}
	}
   
   public List<Studente> studentiIscrittiACorso(String nomeCorso){
	return null;
	   
	   
   }*/
	

}
