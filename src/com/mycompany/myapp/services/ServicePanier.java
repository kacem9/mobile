/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.services;

import com.codename1.db.Cursor;
import com.codename1.db.Database;
import com.codename1.db.Row;
import com.mycompany.myapp.entities.Panier;
import com.mycompany.myapp.entities.Wish;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author user
 */
public class ServicePanier {
    
     public static ServicePanier instance=null;
   
     Database db;
     
    public ServicePanier() {
        try {
            
            db = Database.openOrCreate("PIMOBILE.db");
            db.execute("create table IF NOT EXISTS Panier (id INTEGER PRIMARY KEY AUTOINCREMENT,id_prod INTEGER,id_user INTEGER,quantite INTEGER,nom_prod Text,photo Text,prix INTEGER );");

        } catch (IOException ex) {
            System.out.println("Probleme de BAse!!");
            ex.printStackTrace();
        }
    }
        
     public static ServicePanier getInstance() {
        if (instance == null) {
            instance = new ServicePanier();
        }
        return instance;
    }
    
  
    
     public void addToPanier(int id_prod , int id_user ,int quantite,String nom_prod ,String photo, int prix) throws IOException  {
      
         
             db.execute("insert into Panier (id_prod,id_user,quantite,nom_prod,photo,prix) values ('"+id_prod+"','"+id_user+"','"+quantite+"','"+nom_prod+"','"+photo+"','"+prix+"');");
             
//          //
       
        
  }
     
     
     public ArrayList<Panier> getAllPanier() {
       ArrayList<Panier> wishs = new ArrayList<>();
        try {
          

            Cursor c = db.executeQuery("select * from Panier");
          while (c.next()) {
               Row r = c.getRow();
                int id = r.getInteger(0);
                int id_prod = r.getInteger(1);
               
                int id_user = r.getInteger(2);
                 int quantite=r.getInteger(3);
                String name = r.getString(4);
                String photo = r.getString(5);
                int prix=r.getInteger(6);
                
               // double num = r.getDouble(2);
               Panier wish = new Panier( id_prod,id_user,quantite,name,photo,prix);
               wishs.add(wish);
           }
          c.close();

       } catch (IOException ex) {
          
       }
       return wishs;
   }
   
}
