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
import com.mycompany.myapp.entities.Comment;
import com.mycompany.myapp.entities.RateAvg;


import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;
import java.util.Map;

/**
 *
 * @author bhk
 */
public class ServiceAvgRate {

    public ArrayList<RateAvg> Counts;
    
    public static ServiceAvgRate instance=null;
    public boolean resultOK;
    private ConnectionRequest req;
    private Comment t;
    private String cmd;

    private ServiceAvgRate() {
         req = new ConnectionRequest();
        
    }

    public static ServiceAvgRate getInstance() {
        if (instance == null) {
            instance = new ServiceAvgRate();
        }
        return instance;
    }

       //localhost/VeloSymfonyIntegre/Velo/web/app_dev.php/api/LigneDeCommande/new?prixTotal=100&adresse2=ttttttttttttt&adresse=hhhhhhhhhhhh&ville=tunis&codePostal=20&numTel=5520520&dateLivraison=2020-05-06&quantite=51
    
    
//    public boolean addComment(int id_user,int id_prod, String comment,String DatePublication,String Rate) {
//       String url = "http://localhost/connChermiti/connect.php?id_user="+id_user+"&comment="+comment+"&datePublication="+DatePublication+"&Rate="+Rate+"&id_Prod="+id_prod+"";
//       req.setUrl(url);
//    req.addResponseListener(new ActionListener<NetworkEvent>() {
//           @Override
//         public void actionPerformed(NetworkEvent evt) {
//             resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
//              req.removeResponseListener(this);
//          }
//      });
//      NetworkManager.getInstance().addToQueueAndWait(req);
//       return resultOK;
//   }

    
//     public boolean deleteComment(int id) {
//         
//        String url = Statics.BASE_URL + "/suprimerCommande/"+id;
//        req.setUrl(url);
//      req.addResponseListener(new ActionListener<NetworkEvent>() {
//           @Override
//         public void actionPerformed(NetworkEvent evt) {
//             resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
//              req.removeResponseListener(this);
//          }
//      });
//      NetworkManager.getInstance().addToQueueAndWait(req);
//       return resultOK;
//   }
    
    
     
    public ArrayList<RateAvg> parseRate(String jsonText){
        try {
            Counts=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            
       
            for(Map<String,Object> obj : list){
             
                     // Comment t = new Comment();
                     RateAvg t = new RateAvg();   
         //t.setPhoto(obj.get("photo").toString());
                float value = Float.parseFloat(obj.get("id").toString());
                t.setId((int)value);
                
                t.setAvgRate(Float.parseFloat(obj.get("avrage rate").toString()));
                t.setNbComment((int)Float.parseFloat(obj.get("avrage rate").toString()));
                
                
               
              //  t.setDateLivraison((obj.get("datelivraison").toString()));
//                t.setPrixTotal(Float.parseFloat(obj.get("prixTotal").toString()));
//                t.setAdresse2(obj.get("adresse2").toString());
//                t.setAdresse(obj.get("adresse").toString());
//                t.setVille(obj.get("ville").toString());
//                t.setCodePostal(obj.get("codePostal").toString());
//                t.setNumTel(((int)Float.parseFloat(obj.get("numTel").toString())));
//                t.setQuantite(((int)Float.parseFloat(obj.get("quantite").toString())));
//      
                Counts.add(t);
                }
            
            
            
              
                
          
            
        } catch (IOException ex) {
            
        }
       // System.out.println(Counts.get(0).getValue()));
       // System.out.println("Sports Bike  :"+Counts.get(0).getValue()+"velos");
        return Counts;
    }
    
    public ArrayList<RateAvg> findProd(int id){
        String url ="http://localhost/connChermiti/connectAVG.php?id_Prod="+id;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                
                Counts = parseRate(new String(req.getResponseData()));
               
                 
               
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return Counts;
    }
    
    
   
}
