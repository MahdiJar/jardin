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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class AfficherMenuController implements Initializable {

    @FXML
    private TableView<Menu> listeMenu;
    @FXML
    private TableColumn<Menu, Integer> id_menu;
    @FXML
    private TableColumn<Menu, String> cln_entree;
    @FXML
    private TableColumn<Menu, String> cln_plat;
    @FXML
    private TableColumn<Menu, String> cln_dessert;
    List list = new ArrayList();
    Menu e;
    ServiceMenu ser = new ServiceMenu();
    @FXML
    private ImageView imgback;
    
    user u = new user(1,"mehdi","nom","prenom","mail",0,"mdp","adresse","emploi");

    
    public void views() throws SQLException {
    
        list = ser.getAllMenu(u);
        ObservableList<Menu> l = FXCollections.observableArrayList(list);
        id_menu.setCellValueFactory(new PropertyValueFactory<>("id_menu"));
        cln_entree.setCellValueFactory(new PropertyValueFactory<>("entree"));
        cln_plat.setCellValueFactory(new PropertyValueFactory<>("plat"));
        cln_dessert.setCellValueFactory(new PropertyValueFactory<>("dessert"));
        System.out.println(l);
        listeMenu.setItems(l);

    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
           views();
        
        } catch (SQLException ex) {
            Logger.getLogger(AfficherMenuController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AfficherMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }
