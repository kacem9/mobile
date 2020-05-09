/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entities.Produit;



import com.mycompany.myapp.utils.Statics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author bhk
 */
public class ServiceProduit {

    public ArrayList<Produit> produits;
    
    public static ServiceProduit instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    private ServiceProduit() {
         req = new ConnectionRequest();
    }

    public static ServiceProduit getInstance() {
        if (instance == null) {
            instance = new ServiceProduit();
        }
        return instance;
    }

   /* public boolean addTask(Commande t) {
        String url = Statics.BASE_URL + "/tasks/" + t.getName() + "/" + t.getStatus();
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }*/

    public ArrayList<Produit> parseProduit(String jsonText){
        try {
            produits=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                Produit t = new Produit();
                
                float id = Float.parseFloat(obj.get("id").toString());
                t.setId((int)id);
               //t.setUser_id(((int)Float.parseFloat(obj.get("id").toString())));
                t.setModel(obj.get("model").toString());
              //  if(((int)Float.parseFloat(obj.get("etatLocation").toString()))==0){
                    
                  
                t.setType(obj.get("type").toString());
                t.setPrice(obj.get("price").toString());
                t.setQuantity(obj.get("quantity").toString());
                t.setPhoto(obj.get("photo").toString());
               
                
               // t.setUserid(currentUser.getId().toString());
                //t.setPrice(((int)Float.parseFloat(obj.get("price").toString()))); 
                
                
                
               
                
              // System.out.println("hhhhhhhhhhhhhhhhhhhhh");
                        
              
                
                produits.add(t);
            }
            
            
        } catch (IOException ex) {
            
        }
        return produits;
    }
    
    public ArrayList<Produit> getAllProduits(){
        String url = Statics.BASE_URL+"/produits/all";
       // String url = Statics.BASE_URL+"/prod/all";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                produits = parseProduit(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return produits;
    }
    
    //supprimer un vélo
    
     public boolean deleteVelo(int id) {
         
        String url = Statics.BASE_URL + "/Velo/"+id;
        req.setUrl(url);
      req.addResponseListener(new ActionListener<NetworkEvent>() {
           @Override
         public void actionPerformed(NetworkEvent evt) {
             resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
              req.removeResponseListener(this);
          }
      });
      NetworkManager.getInstance().addToQueueAndWait(req);
       return resultOK;
   }
}
