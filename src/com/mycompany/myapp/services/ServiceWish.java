/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.services;

import com.codename1.db.Cursor;
import com.codename1.db.Database;
import com.codename1.db.Row;
import com.mycompany.myapp.entities.Wish;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author user
 */
public class ServiceWish {
    
     public static ServiceWish instance=null;
   
     Database db;
     
    public ServiceWish() {
        try {
            
            db = Database.openOrCreate("PIMOBILE.db");
            db.execute("create table IF NOT EXISTS wish (id INTEGER PRIMARY KEY AUTOINCREMENT,id_prod INTEGER,id_user INTEGER,nom_prod Text,photo Text );");

        } catch (IOException ex) {
            System.out.println("Probleme de BAse!!");
            ex.printStackTrace();
        }
    }
        
     public static ServiceWish getInstance() {
        if (instance == null) {
            instance = new ServiceWish();
        }
        return instance;
    }
    
  
    
     public void addToWish(int id_prod , int id_user ,String nom_prod ,String photo) throws IOException  {
      
         
             db.execute("insert into wish (id_prod,id_user,nom_prod,photo) values ('"+id_prod+"','"+id_user+"','"+nom_prod+"','"+photo+"');");
             
//          //
       
        
  }
     
     
     public ArrayList<Wish> getAllwish() {
       ArrayList<Wish> wishs = new ArrayList<>();
        try {
          

            Cursor c = db.executeQuery("select * from wish");
          while (c.next()) {
               Row r = c.getRow();
                int id = r.getInteger(0);
                int id_prod = r.getInteger(1);
                int id_user = r.getInteger(2);
                String name = r.getString(3);
                String photo = r.getString(4);
               // double num = r.getDouble(2);
               Wish wish = new Wish( id_prod, id_user,name,photo);
               wishs.add(wish);
           }
          c.close();

       } catch (IOException ex) {
          
       }
       return wishs;
   }
   
}
