/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmljardin;
import com.esprit.Entite.Demande;
import com.esprit.Entite.Statut;
import com.esprit.Entite.user;
import com.esprit.Service.*;
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
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author hamza
 */
public class DemandeController implements Initializable {

    @FXML
    private TextArea txtDescriptionDemande;
    @FXML
    private Button btnDemander;
    @FXML
    private Button btnAnnuler;
    @FXML
    private Button btnConsulter;
    @FXML
    private TextField txtNomdemande;
    @FXML
    private ImageView imghome;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        imghome.setImage(new Image("/resources/images/home.png"));
    }

    public TextArea getTxtDescriptionDemande() {
        return txtDescriptionDemande;
    }

    public TextField getTxtNomdemande() {
        return txtNomdemande;
    }
    
    

    @FXML
    private void gohome(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Acceuil.fxml"));
            Parent root = loader.load();
            AcceuilController dc = loader.getController();
            imghome.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(DemandeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void consultation(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ListeDemande.fxml"));
            Parent root = loader.load();
            ListeDemandeController dc = loader.getController();
            imghome.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(DemandeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void confirmerDemande(ActionEvent event)  {
        Demande d =new Demande();
        ServiceDemande  serviceDemande =new ServiceDemande();
        user u=new user(1, "Parent","mehdi", "hiii", "mmmm@mail" ,21365897 ,"mmmm" ,"mdmdmdm", null );
        MetierUser metierUser=new MetierUser();
        d.setDescription(getTxtDescriptionDemande().toString());
        d.setNom_demande(getTxtNomdemande().toString());
        d.setID_demande(3);
        d.setReponse(null);
        try {
            d.setUser(metierUser.findById(u.getId()));
        } catch (SQLException ex) {
            Logger.getLogger(DemandeController.class.getName()).log(Level.SEVERE, null, ex);
        }   
        serviceDemande.ajouterDemande(d);
        
        
    }

    @FXML
    private void annuler(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Acceuil.fxml"));
            Parent root = loader.load();
            AcceuilController dc = loader.getController();
            imghome.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(DemandeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
