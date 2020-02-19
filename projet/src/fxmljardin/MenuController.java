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
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class MenuController implements Initializable {
    @FXML
    private TextField txtNomEntree;
    @FXML
    private TextField txtNomPlat;
    @FXML
    private TextField txtNomDessert;
    @FXML
    private Button btnAdd;
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
    private void ajouter(ActionEvent event) {
      try {
          user u=new user(1, "admin", "mahdi", "jarraya", "jie@ef.com", 0, "*****", "zed", "eee");
            String entree = txtNomEntree.getText();
            String plat = txtNomPlat.getText();
            String dessert = txtNomDessert.getText();
            ServiceMenu mn = new ServiceMenu();
            Menu m = new Menu(entree,plat,dessert,u);
            mn.ajouter(m);           
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
    }

    @FXML
    private void back(MouseEvent event) {
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("AcceuilC.fxml"));
            Parent root = loader.load();
            AcceuilCController dc=loader.getController();
            imgback.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}



    

    
