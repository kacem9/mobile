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

import com.mycompany.myapp.entities.Velo;

import com.mycompany.myapp.utils.Statics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author bhk
 */
public class ServiceVelo {

    public ArrayList<Velo> velos;
    
    public static ServiceVelo instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    private ServiceVelo() {
         req = new ConnectionRequest();
    }

    public static ServiceVelo getInstance() {
        if (instance == null) {
            instance = new ServiceVelo();
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

    public ArrayList<Velo> parseVelo(String jsonText){
        try {
            velos=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                Velo t = new Velo();
                float id = Float.parseFloat(obj.get("id").toString());
                t.setId((int)id);
               //t.setUser_id(((int)Float.parseFloat(obj.get("id").toString())));
                t.setEtat_vendu(((int)Float.parseFloat(obj.get("etatVendu").toString())));
              //  if(((int)Float.parseFloat(obj.get("etatLocation").toString()))==0){
                    
                  
                t.setEtat_location(((int)Float.parseFloat(obj.get("etatLocation").toString())));
                t.setDescription(obj.get("description").toString());
                t.setLocalitsation_velo(obj.get("localitsationVelo").toString());
                t.setPhoto(obj.get("photo").toString());
                t.setQuantity(((int)Float.parseFloat(obj.get("quantity").toString())));
                //t.setPrice(((int)Float.parseFloat(obj.get("price").toString()))); 
                
                
                
               
                
              // System.out.println("hhhhhhhhhhhhhhhhhhhhh");
                        
              
                
                velos.add(t);
            }
            
            
        } catch (IOException ex) {
            
        }
        return velos;
    }
    
    public ArrayList<Velo> getAllVelos(){
        String url = Statics.BASE_URL+"/Velos/all";
       // String url = Statics.BASE_URL+"/prod/all";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                velos = parseVelo(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return velos;
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
