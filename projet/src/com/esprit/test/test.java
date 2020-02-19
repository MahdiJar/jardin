package com.esprit.test;


import com.esprit.Service.ServiceDemande;
import com.esprit.Service.ServiceReclamation;
import com.esprit.Entite.Demande;
import com.esprit.Entite.Menu;
import com.esprit.Entite.Reclamation;

import com.esprit.Entite.Statut;
import com.esprit.Entite.user;
import com.esprit.Service.ServiceMenu;
import com.esprit.Service.ServiceUser;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hamza
 */
public class test {
    public static void main(String[] args) {
     
        ServiceMenu mn = new ServiceMenu();
        
        user u = new user(0, "role", "nom", "prenom", "mail", 0, "mdp", "adresse", "emploi");
        
        Menu m1 = new Menu("fakoussa", "gar3aya", "tamtam");
        Menu m2 = new Menu("soupe", "spaghetti", "fruit");
        Menu m4 = new Menu("oeuf", "poulet", "glace");
        Menu m3= new Menu("entree", "plat", "dessert");
        //try {
        

           //mn.ajouter(m1);
           //mn.ajouter(m4);
           m1.setId_menu(5);
           
           //Modifier
           //mn.editerMenu(5 ,"nem", "nom", "tam");<
           mn.getAllMenu(u);
           System.out.println(mn.getAllMenu(u));
           //List<Menu> list = mn.readAll();
           //System.out.println(list);
           System.out.println(m1.getId_menu());
           mn.supprimerMenu(m1);
           //List<Menu> list1 = mn.readAll();
           //System.out.println(list1);
        //} catch (SQLException ex) {
            //System.out.println(ex);
        }
    }
    