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
public class Reclamation {

    private user Staff;
    private user parent;
    private int id_reclamation;
    private String statut;
    private String description;
    private String date;

    public Reclamation(user Staff, user parent, int id_reclamation, String statut, String description, String date) {
        this.Staff = Staff;
        this.parent = parent;
        this.id_reclamation = id_reclamation;
        this.statut = statut;
        this.description = description;
        this.date = date;
    }

    public Reclamation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public user getStaff() {
        return Staff;
    }

    public void setStaff(user Staff) {
        this.Staff = Staff;
    }

    public user getParent() {
        return parent;
    }

    public void setParent(user parent) {
        this.parent = parent;
    }



    public int getId_reclamation() {
        return id_reclamation;
    }

    public void setId_reclamation(int id_reclamation) {
        this.id_reclamation = id_reclamation;
    }

    @Override
    public String toString() {
        return "Reclamer{" + "Staff=" + Staff + ", parent=" + parent + ", id_reclamation=" + id_reclamation + ", statut=" + statut + ", description=" + description + ", date=" + date + '}';
    }

}
