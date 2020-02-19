/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service;

import com.esprit.Utils.SingletonConnexion;
import com.esprit.Entite.Demande;
import com.esprit.Entite.Statut;
import com.esprit.Entite.user;
import com.esprit.IService.IserviceDemande;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hamza
 */
public class ServiceDemande implements IserviceDemande{

    MetierUser metierUser = new MetierUser();
    public void ajouterDemande(Demande r) {
        Connection cnx = SingletonConnexion.getCnx();
        try {
            PreparedStatement ps = cnx.prepareStatement("INSERT INTO demande (`id_demande`, `nom_demande`, `statut`,`reponse`,`description`,`id_user`) "
                    + "VALUES ('" + r.getID_demande() + "','" + r.getNom_demande() + "','" + r.getStatut() + "','" + r.getReponse() + "','" + r.getDescription() + "','" + r.getUser().getId() + "'  ) ;");
            ps.executeUpdate();

        } catch (SQLException er) {
            System.err.println("probleme de requete Sql" + er.getMessage());
        }
    }

    public void editerDemande(int id, Statut statut, String reponse) {
        Connection cnx = SingletonConnexion.getCnx();
        try {
            PreparedStatement ps = cnx.prepareStatement("UPDATE demande SET statut ='" + statut + "', reponse='" + reponse + "' where id_demande=" + id + ";");

            ps.executeUpdate();

        } catch (SQLException er) {
            System.err.println("probleme de requete Sql" + er.getMessage());
        }
    }

    public void supprimerDemande(Demande r) {
        Connection cnx = SingletonConnexion.getCnx();
        try {
            PreparedStatement ps = cnx.prepareStatement("delete from demande where id_demande='" + r.getID_demande() + "' ;");

            ps.executeUpdate();

        } catch (SQLException er) {
            System.err.println("probleme de requete Sql" + er.getMessage());
        }
    }

    public List<Demande> getAllDemande() {
        Connection cnx = SingletonConnexion.getCnx();
        List<Demande> list = new ArrayList<>();
        try {

            PreparedStatement ps = cnx.prepareStatement("select * from demande,user where user.Id=demande.id_user ;");
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                int id = res.getInt("id_demande");
                int id_user = res.getInt("id_user");
                user user = metierUser.findById(id_user);

                Statut statut = Statut.valueOf(res.getString("statut"));
                String description = res.getString("description");
                String nom = res.getString("nom_demande");
                String reponse = res.getString("reponse");

                list.add(new Demande(id, nom, statut, reponse, description, user));

            }
        } catch (SQLException er) {
            System.err.println("probleme de requete Sql" + er.getMessage());
        }
        return list;
    }

    public Demande getDemande(int iddem) {
        Connection cnx = SingletonConnexion.getCnx();
        Demande dem = null;
        try {
            PreparedStatement ps = cnx.prepareStatement("select * from demande where id_demande='" + iddem + "' ;");
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                int id = res.getInt("id_demande");
                int iduser = res.getInt("id_user");
                user user = metierUser.findById(iduser);
                Statut statut = Statut.valueOf(res.getString("statut"));
                String description = res.getString("description");
                String nom = res.getString("nom_demande");
                String reponse = res.getString("reponse");

                dem = new Demande(id, nom, statut, reponse, description,user);

            }
        } catch (SQLException er) {
            System.err.println("probleme de requete Sql" + er.getMessage());
        }
        return dem;
    }

}
