package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Studente;
import it.polito.tdp.lab04.model.Corso;

public class StudenteDAO {
	
	public List<Studente> getTuttiIStudenti() {

		final String sql = "SELECT * FROM studente";

		List<Studente> studenti = new LinkedList<Studente>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				int matricola = rs.getInt("matricola");
				String cognome = rs.getString("cognome");
				String nome = rs.getString("nome");
				String cds = rs.getString("CDS");

				System.out.println(matricola + " " + cognome + " " + nome + " " + cds);

				// Crea un nuovo JAVA Bean Studente
				// Aggiungi il nuovo oggetto Studente alla lista studenti
				
				Studente s = new Studente(matricola,cognome,nome,cds);
				studenti.add(s);
			}

			return studenti;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}
	
	public String nomeCognomeDataMatricola(int matricola) {
		//bottone spunta verde
		
		final String sql = "SELECT nome,cognome " + 
				"FROM studente " + 
				"WHERE studente.matricola = ? ";

		
		String result = "";

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, matricola);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				String cognome = rs.getString("cognome");
				String nome = rs.getString("nome");
	
				System.out.println("lo studente cercato è "+cognome + " " + nome);
				result = nome+" "+cognome;
			}

			return result;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
		
	}
	
	public String corsiDatoUnoStudente(Studente studente){
		//bottone cercaCorsi
		
		final String sql = "SELECT corso.* "+
				"FROM studente,iscrizione,corso "+
				"WHERE studente.matricola = ? "+
				"AND iscrizione.matricola = studente.matricola "+
				"AND iscrizione.codins = corso.codins ";

		String result = "";

		try {
		
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, studente.getMatricola());
  			ResultSet rs = st.executeQuery();	

			while (rs.next()) {
				
				String codins = rs.getString("codins");
				int numeroCrediti = rs.getInt("crediti");
				String nome = rs.getString("nome");
				int periodoDidattico = rs.getInt("pd");

				System.out.println(codins + " " + numeroCrediti + " " + nome + " " + periodoDidattico+" ");
				
				result += codins + " " + numeroCrediti + " " + nome + " " + periodoDidattico + "\n";
			}

			return result;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
		
		
	}
	
	

}
