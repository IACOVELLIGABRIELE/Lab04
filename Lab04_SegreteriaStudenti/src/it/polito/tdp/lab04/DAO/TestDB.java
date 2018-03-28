package it.polito.tdp.lab04.DAO;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class TestDB {

	public static void main(String[] args) {
		
		/*
		 * 	This is a main to check the DB connection
		 */
		
		CorsoDAO cdao = new CorsoDAO();
		StudenteDAO sdao = new StudenteDAO();
		Studente s1 = new Studente(170447,"VIGGIANO","CLAUDIO","CIN1T3");
		Corso c1 = new Corso("01NATPG",8,"Gestione dell'innovazione e sviluppo prodotto ICT",2);
		
		cdao.getTuttiICorsi();
		System.out.println();
		sdao.getTuttiIStudenti();
		System.out.println();
		sdao.nomeCognomeDataMatricola(168718);
		System.out.println();
		sdao.corsiDatoUnoStudente(s1);
		System.out.println();
		System.out.println();
		
		if(cdao.studenteIscrittoACorso(s1, c1))
			System.out.println("ISCRITTO" );
		else
			System.out.println("NON ISCRITTO" );
		System.out.println();
		
		
		
		for(Studente s : cdao.getStudentiIscrittiAlCorso(c1)) {
			System.out.println("matricola : " + s.getMatricola() + " cognome : " + s.getCognome() + " nome : " + s.getNome());
		}
		

	}

}
