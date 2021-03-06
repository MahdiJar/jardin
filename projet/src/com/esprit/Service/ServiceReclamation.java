/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service;

import com.esprit.Utils.SingletonConnexion;
import com.esprit.Entite.Reclamation;
import com.esprit.Entite.user;
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
public class ServiceReclamation {
    private MetierUser metierUser;
     public void Reclamer(Reclamation r) {
          Connection cnx=SingletonConnexion.getCnx();
        try{
            PreparedStatement ps=cnx.prepareStatement("INSERT INTO reclamer (`id_staff`, `id_parent`, `id_reclamation` ,`statut`,`date`,`description`)"
                    + "VALUES ('"+r.getStaff().getId()+"','"+r.getParent().getId()+"','"+r.getId_reclamation()+"','"+r.getStatut()+"','"+r.getDate()+"','"+r.getDescription()+"'  ) ;" ) ;
            ps.executeUpdate();
            
        }
        catch(SQLException er)
        {
            System.err.println("probleme de requete Sql"+er.getMessage());
        }
    }
    public void editerReclamation(int id,String statut) {
     Connection cnx=SingletonConnexion.getCnx();
        try{
            PreparedStatement ps=cnx.prepareStatement("UPDATE reclamer SET statut ='"+statut+"' where id_reclamation="+id+";" );
                   
            ps.executeUpdate();
            
        }
        catch(SQLException er)
        {
            System.err.println("probleme de requete Sql"+er.getMessage());
        }
    }
    
    public void supprimerReclamation(Reclamation r) {
            Connection cnx=SingletonConnexion.getCnx();
        try{
            PreparedStatement ps=cnx.prepareStatement("delete from reclamer where id_reclamation='"+r.getId_reclamation()+"' ;" );
                   
            ps.executeUpdate();
            
        }
        catch(SQLException er)
        {
            System.err.println("probleme de requete Sql"+er.getMessage());
        }
    }
    
    public List<Reclamation> getAllReclamation() {
         Connection cnx =SingletonConnexion.getCnx();
         List<Reclamation> list=new ArrayList<>();
        try{
            PreparedStatement ps=cnx.prepareStatement("select * from reclamer ;");
            ResultSet res=ps.executeQuery();
            while (res.next())
            {
            int id=res.getInt("id_reclamation");
            int id_Parent=res.getInt("id_parent");
            int id_Staff=res.getInt("id_staff");
            user staff = metierUser.findById(id_Staff);
            user parent = metierUser.findById(id_Parent);
            String statut=res.getString("statut");
            String description=res.getString("description");
            String date=res.getString("date");
           
           
             list.add(new Reclamation(staff,parent,id,statut,date,description));
             
            }
        }
             catch(SQLException er)
        {
            System.err.println("probleme de requete Sql"+er.getMessage());
        }
        return list;
    }
    
    public Reclamation getReclamation(int idrec) {
        Connection cnx =SingletonConnexion.getCnx();
         Reclamation rec=null;
        try{
            PreparedStatement ps=cnx.prepareStatement("select * from reclamation where id_reclamation='"+idrec+"' ;");
            ResultSet res=ps.executeQuery();
            while (res.next())
            {
            int id=res.getInt("id_reclamation");
            int id_parent=res.getInt("id_parent");
            int id_staff=res.getInt("id_staff");
            user staff = metierUser.findById(id_staff);
            user parent = metierUser.findById(id_parent);
            String statut=res.getString("statut");
            String description=res.getString("description");
            String date=res.getString("date");
           
           
             
             rec = new Reclamation(staff,parent,id,statut,date,description);
             
            }
        }
             catch(SQLException er)
        {
            System.err.println("probleme de requete Sql"+er.getMessage());
        }
        return rec;
    }
}
