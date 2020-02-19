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
public class ModifierMenuController implements Initializable {

    @FXML
    private TextField txtidMod;
    @FXML
    private TextField txtidEntree;
    @FXML
    private TextField txtidPlat;
    @FXML
    private TextField txtidDessert;
    @FXML
    private Button btnMod;
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
    private void editerMenu(ActionEvent event) {
        try {
            user u = new user(1, "admin", "mahdi", "jarraya", "jie@ef.com", 0, "*****", "zed", "eee");
            Menu m = new Menu();
            ServiceMenu mn = new ServiceMenu();
            int id;
            id = Integer.parseInt(txtidMod.getText());
            m.setId_menu(id);
            
            String entree = txtidEntree.getText();
            String plat = txtidPlat.getText();
            String dessert = txtidDessert.getText();
            
            m.setEntree(entree);
            m.setPlat(plat);
            m.setDessert(dessert);
    
            mn.editerMenu(m);           
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
            Logger.getLogger(ModifierMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }
