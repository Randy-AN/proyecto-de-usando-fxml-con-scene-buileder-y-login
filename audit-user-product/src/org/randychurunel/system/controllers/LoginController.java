package org.randychurunel.system.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.randychurunel.system.utils.ViewFactory;


public class LoginController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }
    @FXML 
    public void onRegistro(ActionEvent event){
        System.out.println("¡Sí detectó el clic!");
        ViewFactory viewFacto = new ViewFactory();
        viewFacto.viewRegister();
       
    }
    
}

