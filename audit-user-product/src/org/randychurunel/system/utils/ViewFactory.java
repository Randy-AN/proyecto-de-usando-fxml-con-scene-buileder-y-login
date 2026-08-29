package org.randychurunel.system.utils;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import java.net.URL;

import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import java.io.UncheckedIOException;
import javax.swing.JOptionPane;
import org.randychurunel.system.ClasePrincipal;
import org.randychurunel.system.utils.SceneManager;
public class ViewFactory {
    private final String PATH_VIEWS="/org/randychurunel/system/view/";
    
    public Scene loadFileFXML(String nameFile, int width, int height) throws IOException{
        String pathOfFile = PATH_VIEWS + nameFile;
        try {
            //Llamar al FXMLLoader
            FXMLLoader loadFXML = new FXMLLoader();
            //Obtener la URL del archivo, viene de la clase main
            URL urlFile = ClasePrincipal.class.getResource(pathOfFile);
            loadFXML.setBuilderFactory(new JavaFXBuilderFactory() );
            loadFXML.setLocation(urlFile);
            
            return new Scene( loadFXML.load(), width, height  );
            
        } catch (NullPointerException e) {
    JOptionPane.showMessageDialog(null,"Error load scene: Ruta incorrecta o archivo no encontrado.");
    e.printStackTrace(); 
}
        return null;
    }
            
 public void loadScene(String nameFile){
        Scene scene = null;
        try {
            switch (nameFile) {
                case "login" -> scene = loadFileFXML("LoginView.fxml",400,500);
                case "register" -> {
                    SceneManager.getInstanciaSceneManager()
                            .getStagePrincipal().setTitle("REGISTRO DE USUARIO");
                    SceneManager.getInstanciaSceneManager()
                            .getStagePrincipal().setResizable(false);
                    scene = loadFileFXML("RegisterView.fxml",350,400);
                }
                default      -> scene = loadFileFXML("LoginView.fxml",0,0); 
            }
            SceneManager.getInstanciaSceneManager().changeScene(scene);
        } catch (Exception e) { 
           JOptionPane.showMessageDialog(null,"Error load scene: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public void viewRegister(){
        loadScene("register");
    }
    
    public void viewLogin(){
        loadScene("login");
    }
    
    
} 
    
    
