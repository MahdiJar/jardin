/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmljardin;

import com.esprit.Entite.Menu;
import com.esprit.Entite.user;
import com.esprit.Service.ServiceMenu;
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
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class SupprimerMenuController implements Initializable {

    @FXML
    private TextField txtidSupp;
    
    @FXML
    private Button btnsupp;
    @FXML
    private ImageView imgback;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    

    
@FXML
    private void supprimerMenu(ActionEvent event) {
      try {
            user u=new user(1, "admin", "mahdi", "jarraya", "jie@ef.com", 0, "*****", "zed", "eee");
            Menu m= new Menu();
            ServiceMenu mn = new ServiceMenu();
            int id;
            id = Integer.parseInt(txtidSupp.getText());
            m.setId_menu(id);
            mn.supprimerMenu(m);           
        }catch (Exception ex) {
            System.out.println(ex.getMessage());
}}

    @FXML
    private void back(MouseEvent event) {
    try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("AcceuilC.fxml"));
            Parent root = loader.load();
            AcceuilCController dc=loader.getController();
            imgback.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(SupprimerMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }
    

        
    
    
    
    