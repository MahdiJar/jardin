/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service;

import com.esprit.Entite.Menu;
import com.esprit.Entite.user;
import com.esprit.Utils.SingletonConnexion;

import java.sql.SQLException;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;


/**
 *
 * @author House
 */
public class ServiceMenu  {

    
    private Statement ste;
    MetierUser metierUser ;
    Connection cnx = SingletonConnexion.getCnx();
    public ServiceMenu() {
        
        
        

    }

 
    public void ajouter(Menu t) throws SQLException {
        ste = cnx.createStatement();
        String requeteInsert = "INSERT INTO `menu` (`id_menu`, `entree`, `plat`, `dessert`,`user_id`) VALUES (NULL, '" + t.getEntree() + "', '" + t.getPlat() + "', '" + t.getDessert() +"', '" + t.getUser().getId() + "');";
        ste.executeUpdate(requeteInsert);
    }
   
    
     public void editerMenu(Menu m) {
     
        try{
            PreparedStatement ps=cnx.prepareStatement("UPDATE menu SET entree ='"+m.getEntree()+"',plat ='"+m.getPlat()+"',dessert ='"+m.getDessert()+"' where id_menu="+m.getId_menu()+";" );
                   
            ps.executeUpdate();
            
        }
        catch(SQLException er)
        {
            System.err.println("probleme de requete Sql"+er.getMessage());
        }
    }
     
     public void supprimerMenu(Menu m) {
            
        try{
            PreparedStatement ps=cnx.prepareStatement("delete from `menu` where id_menu ='"+m.getId_menu()+"' ;" );
                   
            ps.executeUpdate();
            
        }
        catch(SQLException er)
        {
            System.err.println("probleme de requete Sql"+er.getMessage());
        }
    }
    
     
    public List<Menu> getAllMenu(user u) {
         
        ArrayList<Menu> list=new ArrayList<>();
        try{
            PreparedStatement ps=cnx.prepareStatement("select * from menu where user_id="+u.getId()+" ;");
            ResultSet res=ps.executeQuery();
            while (res.next())
            {
            int id_user = res.getInt("id_user");
            user user = metierUser.findById(id_user);
            int id=res.getInt("id_menu");
            String entree=res.getString("entree");
            String plat=res.getString("plat");
            String dessert=res.getString("dessert");
                
           
             list.add(new Menu(id,entree,plat,dessert,user));
             
            }
        }
             catch(SQLException er)
        {
            System.err.println("probleme de requete Sql"+er.getMessage());
        }
        return list;
    }

     /*public List<Menu> readAll() throws SQLException {
        List<Menu> arr = new ArrayList<>();
        
        user u = new user(0, "role", "nom", "prenom", "mail", 0, "mdp", "adresse", "emploi");
        ste = cnx.createStatement();
        ResultSet rs = ste.executeQuery("select * from menu");
        

        while (rs.next()) {
            user user = metierUser.findById(id_user);
            int id = rs.getInt("id_menu");
            String entree = rs.getString("entree");
            String plat = rs.getString("plat");
            String dessert = rs.getString("dessert");
            Menu m = new Menu(id, entree, plat, dessert, user);
            arr.add(m);
        }
        return arr;
    }
    /*public List readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    
     
 }