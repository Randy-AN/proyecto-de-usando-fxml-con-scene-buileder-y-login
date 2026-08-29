package org.randychurunel.system.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.randychurunel.system.service.UserSirvice;
import org.randychurunel.system.service.UserStatus;
import org.randychurunel.system.utils.ViewFactory;
import org.randychurunel.system.utils.Validacion;
import org.randychurunel.system.utils.AlertInformation;

public class RegistroController implements Initializable {

    @FXML
    private TextField txtUser;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtLastName;
    @FXML
    private TextField txtEmail;
    @FXML
    private PasswordField pwdPass;
    @FXML
    private PasswordField pwdConfirmPass;
    @FXML
    private Button btnCancel;
    @FXML
    private Button btnCreateUser;
    private Validacion validate = new Validacion();
    private AlertInformation AlertInfo = new AlertInformation();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

   
    
    @FXML
    public void onCancelRegistro(MouseEvent event) {
        ViewFactory viewFacto = new ViewFactory();
        viewFacto.viewLogin();
    }

    @FXML
    public void onRegister(MouseEvent event) {
        String email = txtEmail.getText().trim();
        boolean validEmail = validate.ValidateEmail(email);
        if (validEmail == false) {
            AlertInfo.viewAlert("ERROR", "E", "E", "Ingrcorrecto");
            return;
        }
        String user, name, lastName, password, confirmPassword;
        user = txtUser.getText().trim();
        name = txtName.getText().trim();
        lastName = txtLastName.getText().trim();
        password = pwdPass.getText().trim();
        confirmPassword = pwdConfirmPass.getText().trim();
        if (validate.validateTextEmpty(user) == true
                || validate.validateTextEmpty(name) == true
                || validate.validateTextEmpty(lastName) == true
                || validate.validateTextEmpty(email) == true
                || validate.validateTextEmpty(password) == true
                || validate.validateTextEmpty(confirmPassword) == true) {

            AlertInfo.viewAlert("ERROR",
                    "ERROR DE CAMPO",
                    "ERROR CAMPOS VACIOS",
                    "NO LLENASTE TODOS LOS CAMPOS");
            return;
        }
        String msgField = "";
        if (validate.validateTextLenght(user, 77) == false) {
            msgField = "El campo usuario excedio los caracteres permitidos";
        }
        if (validate.validateTextLenght(name, 77) == false) {
            msgField = "El campo usuario excedio los caracteres permitidos";
        }
        if (validate.validateTextLenght(lastName, 77) == false) {
            msgField = "El campo usuario excedio los caracteres permitidos";
        }
        if (validate.validateTextLenght(email, 77) == false) {
            msgField = "El campo usuario excedio los caracteres permitidos";
        }
        if (validate.validateTextLenght(password, 77) == false) {
            msgField = "El campo usuario excedio los caracteres permitidos";
        }
        if (validate.validateTextLenght(confirmPassword, 77) == false) {
            msgField = "El campo usuario excedio los caracteres permitidos";
        }

        if (msgField.isEmpty() == false) {
            AlertInfo.viewAlert("ERROR",
                    "ERROR DE CAMPO",
                    "ERROR excedio el limite de caracteres permitidos",
                    msgField);
            return;
        }

        if (validate.validatePass(password, confirmPassword) == false) {
            AlertInfo.viewAlert("ERROR", "ERROR DE CONTRASEÑA",
                    "ERROR AL CONFIRMAR CONTRASEÑA",
                    "LAS CONTRASEÑAS NO COINCIDEN");
            return;
        }

        
        
        
        UserSirvice userService = new UserSirvice();
UserStatus status = userService.createUser(user, name, lastName, email, password);
if (status == UserStatus.USER_CREATE) {
    AlertInfo.viewAlert("Éxito", "Usuario registrado", "Registro exitoso", "El usuario se creó correctamente");
    ViewFactory viewFacto = new ViewFactory();
    viewFacto.viewLogin();
}
    }

}
