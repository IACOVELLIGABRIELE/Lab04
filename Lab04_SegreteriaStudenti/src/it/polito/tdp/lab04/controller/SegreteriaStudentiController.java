/**
 * Sample Skeleton for 'SegreteriaStudenti.fxml' Controller Class
 */

package it.polito.tdp.lab04.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SegreteriaStudentiController {
	
	private Model model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="comboBox"
    private ChoiceBox<Corso> choiceBox; // Value injected by FXMLLoader

    @FXML // fx:id="btnIscrittiCorso"
    private Button btnIscrittiCorso; // Value injected by FXMLLoader

    @FXML // fx:id="txtMatricola"
    private TextField txtMatricola; // Value injected by FXMLLoader

    @FXML // fx:id="btnVerde"
    private Button btnVerde; // Value injected by FXMLLoader

    @FXML // fx:id="txtNome"
    private TextField txtNome; // Value injected by FXMLLoader

    @FXML // fx:id="txtCognome"
    private TextField txtCognome; // Value injected by FXMLLoader

    @FXML // fx:id="btnCercaCorsi"
    private Button btnCercaCorsi; // Value injected by FXMLLoader

    @FXML // fx:id="btnIscrivi"
    private Button btnIscrivi; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML // fx:id="btnReset"
    private Button btnReset; // Value injected by FXMLLoader

    @FXML
    void CercaNomeCognomeDataMatricola(ActionEvent event) {
    	
    	txtNome.clear();
    	txtCognome.clear();
    	
    	if(txtMatricola.getText().compareTo("") == 0) {
    		txtResult.appendText("Nessuna matricola selezionata \n");
    	}
    	
    	String a = model.dataMatricolaNomeCognome(Integer.parseInt(txtMatricola.getText()));
    	int i = 0;
    	String[] vet = new String[2];
    	
    	for(String b : a.split(" ")) {
    		vet[i] = b;
    		i++;
    	}
    	
    	txtNome.appendText(vet[0]);
    	txtCognome.appendText(vet[1]);
    	

    }

    @FXML
    void IscrittiCorso(ActionEvent event) {//btnIscrittiCorso
    	
    	if(choiceBox.getValue()== null) {
    		txtResult.appendText("Nessun corso selezionato \n");
    	}
    	
    	txtResult.appendText(model.studentiIscrittiACorso(choiceBox.getValue()).toString());

    }

    @FXML
    void carcaCorsi(ActionEvent event) {
    	
    	if(txtMatricola.getText().compareTo("") == 0) {
    		txtResult.appendText("Nessuna matricola selezionata \n");
    	}
    	
    	Studente s = model.cercaStudenteDataMatricola(Integer.parseInt(txtMatricola.getText()));
    	txtResult.appendText(model.corsiACuiIscrittoStudente(s));
    	

    }

    @FXML
    void iscrivi(ActionEvent event) {
    	
    	

    }

    @FXML
    void reset(ActionEvent event) {
    	txtResult.clear();
    	txtMatricola.clear();
    	txtNome.clear();
    	txtCognome.clear();
    	

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	assert choiceBox != null : "fx:id=\"choiceBox\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnIscrittiCorso != null : "fx:id=\"btnIscrittiCorso\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnVerde != null : "fx:id=\"btnVerde\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnCercaCorsi != null : "fx:id=\"btnCercaCorsi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnIscrivi != null : "fx:id=\"btnIscrivi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";

    }
    
    public void setModel(Model model) {
    	this.model = model;
 
    	choiceBox.getItems().addAll(model.corsi());
    }
}
