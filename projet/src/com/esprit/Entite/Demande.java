/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Entite;

/**
 *
 * @author hamza
 */
public class Demande {
    

private int ID_demande ;

private String nom_demande ;

private final Statut  statut ;

private String reponse ; 

private String  description ;

private user user;

   

    public Demande(int ID_demande, String nom_demande, Statut statut, String reponse, String description, user user) {
        this.ID_demande = ID_demande;
        this.nom_demande = nom_demande;
        this.statut = statut;
        this.reponse = reponse;
        this.description = description;
        this.user = user;
    }

    public Demande() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Statut getStatut() {
        return statut;
    }

    public int getID_demande() {
        return ID_demande;
    }

    public void setID_demande(int ID_demande) {
        this.ID_demande = ID_demande;
    }

    public String getNom_demande() {
        return nom_demande;
    }

    public void setNom_demande(String nom_demande) {
        this.nom_demande = nom_demande;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public user getUser() {
        return user;
    }

    public void setUser(user user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "demande{" + "ID_demande=" + ID_demande + ", nom_demande=" + nom_demande + ", statut=" + statut + ", reponse=" + reponse + ", description=" + description + ", user=" + user + '}';
    }
    

}
