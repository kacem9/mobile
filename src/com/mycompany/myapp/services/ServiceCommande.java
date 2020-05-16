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
import com.mycompany.myapp.entities.Commande;

import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;
import java.util.Map;

/**
 *
 * @author bhk
 */
public class ServiceCommande {

    public ArrayList<Commande> commandes;
    
    public static ServiceCommande instance=null;
    public boolean resultOK;
    private ConnectionRequest req;
    private Commande t;
    private String cmd;

    private ServiceCommande() {
         req = new ConnectionRequest();
    }

    public static ServiceCommande getInstance() {
        if (instance == null) {
            instance = new ServiceCommande();
        }
        return instance;
    }

       //localhost/VeloSymfonyIntegre/Velo/web/app_dev.php/api/LigneDeCommande/new?prixTotal=100&adresse2=ttttttttttttt&adresse=hhhhhhhhhhhh&ville=tunis&codePostal=20&numTel=5520520&dateLivraison=2020-05-06&quantite=51
    
    
    public boolean addCommande(Commande t) {
        String url = Statics.BASE_URL + "/LigneDeCommande/new"+"?prixTotal=" + t.getPrixTotal()+ "&adresse2=" +t.getAdresse2()+ "&adresse=" +t.getAdresse()+ "&ville=" +t.getVille()+ "&codePostal=" +t.getCodePostal()+ "&numTel=" +t.getNumTel()+ "&quantite=" +t.getQuantite();
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

    
     public boolean deleteCommande(int id) {
         
        String url = Statics.BASE_URL + "/suprimerCommande/"+id;
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
    
    
     
    public ArrayList<Commande> parseCommandes(String jsonText){
        try {
            commandes=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
       
            for(Map<String,Object> obj : list){
              
                      Commande t = new Commande();
                float id = Float.parseFloat(obj.get("id").toString());
                t.setId((int)id);
               
              //  t.setDateLivraison((obj.get("datelivraison").toString()));
                t.setPrixTotal(Float.parseFloat(obj.get("prixTotal").toString()));
                t.setAdresse2(obj.get("adresse2").toString());
                t.setAdresse(obj.get("adresse").toString());
                t.setVille(obj.get("ville").toString());
                t.setCodePostal(obj.get("codePostal").toString());
                t.setNumTel(((int)Float.parseFloat(obj.get("numTel").toString())));
                t.setQuantite(((int)Float.parseFloat(obj.get("quantite").toString())));
                      
                            
                  
              
                
                commandes.add(t);
                }
              
                
          
            
        } catch (IOException ex) {
            
        }
        System.out.println(commandes.get(0).getId());
        return commandes;
    }
    
    public ArrayList<Commande> getAllCommandes(){
        String url = Statics.BASE_URL+"/LigneDeCommande/all";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                
                commandes = parseCommandes(new String(req.getResponseData()));
               
                 
               
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return commandes;
    }
    
    
   
}
