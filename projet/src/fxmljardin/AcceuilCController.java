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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class AcceuilCController implements Initializable {
     
    @FXML
    private Button btnaj;
    @FXML
    private Button btnsupp;
    @FXML
    private Button btnmod;
    @FXML
    private Button btnaff;
    @FXML
    private ImageView imghome;
    
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    @FXML
    private void ajoutermenu(ActionEvent event) {
         try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("Menu.fxml"));
            Parent root = loader.load();
            MenuController dc=loader.getController();
            btnaj.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AcceuilCController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   

    @FXML
    private void supprimerMenu(ActionEvent event) {
          try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("SupprimerMenu.fxml"));
            Parent root = loader.load();
            SupprimerMenuController dc=loader.getController();
            btnsupp.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AcceuilCController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void editerMenu(ActionEvent event) {
    try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("ModifierMenu.fxml"));
            Parent root = loader.load();
            ModifierMenuController dc=loader.getController();
            btnmod.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AcceuilCController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

   
    @FXML
    private void home(MouseEvent event) {
        
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("Acceuil.fxml"));
            Parent root = loader.load();
            AcceuilController dc=loader.getController();
            imghome.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AcceuilCController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void affichermenu(ActionEvent event) {
         try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("AfficherMenu.fxml"));
            Parent root = loader.load();
            AfficherMenuController dc=loader.getController();
            btnaff.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AcceuilCController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    }
    
        
    
 
    



    