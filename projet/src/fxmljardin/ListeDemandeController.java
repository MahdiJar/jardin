/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmljardin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author hamza
 */
public class ListeDemandeController implements Initializable {

    @FXML
    private ListView<?> lstDemande;
    @FXML
    private ImageView imghome;
    @FXML
    private ImageView imgreturn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        imghome.setImage(new Image("/resources/images/home.png"));
        imgreturn.setImage(new Image("/resources/images/return.png"));
    }    

    @FXML
    private void gohome(MouseEvent event) {
           try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("Acceuil.fxml"));
            Parent root = loader.load();
            AcceuilController dc=loader.getController();
            imghome.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ListeDemandeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void retour(MouseEvent event) {
         try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("Demande.fxml"));
            Parent root = loader.load();
            DemandeController dc=loader.getController();
            imghome.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ListeDemandeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
