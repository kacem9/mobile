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
import com.mycompany.myapp.entities.Count;

import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;
import java.util.Map;

/**
 *
 * @author bhk
 */
public class ServiceStatistique {

    public ArrayList<Count> Counts;
    
    public static ServiceStatistique instance=null;
    public boolean resultOK;
    private ConnectionRequest req;
    private Commande t;
    private String cmd;

    private ServiceStatistique() {
         req = new ConnectionRequest();
    }

    public static ServiceStatistique getInstance() {
        if (instance == null) {
            instance = new ServiceStatistique();
        }
        return instance;
    }

       //localhost/VeloSymfonyIntegre/Velo/web/app_dev.php/api/LigneDeCommande/new?prixTotal=100&adresse2=ttttttttttttt&adresse=hhhhhhhhhhhh&ville=tunis&codePostal=20&numTel=5520520&dateLivraison=2020-05-06&quantite=51
    
    
//    public boolean addCommande(Commande t) {
//        String url = Statics.BASE_URL + "/LigneDeCommande/new"+"?prixTotal=" + t.getPrixTotal()+ "&adresse2=" +t.getAdresse2()+ "&adresse=" +t.getAdresse()+ "&ville=" +t.getVille()+ "&codePostal=" +t.getCodePostal()+ "&numTel=" +t.getNumTel()+ "&quantite=" +t.getQuantite();
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

    
//     public boolean deleteCommande(int id) {
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
    
    
     
    public ArrayList<Count> parseCommandes(String jsonText){
        try {
            Counts=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("Sports Bike");
        List<Map<String,Object>> list1 = (List<Map<String,Object>>)tasksListJson.get("Cyclocross Bike");
         List<Map<String,Object>> list2 = (List<Map<String,Object>>)tasksListJson.get("Road Bike");
          List<Map<String,Object>> list3 = (List<Map<String,Object>>)tasksListJson.get("Kids Bikes");
          List<Map<String,Object>> list4 = (List<Map<String,Object>>)tasksListJson.get("Mountain Bikes");
            for(Map<String,Object> obj : list){
              
                      Count t = new Count();
                float value = Float.parseFloat(obj.get("count(nom)").toString());
                t.setValue((int)value);
               
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
            
             for(Map<String,Object> obj : list1){
              
                      Count t1 = new Count();
                float value = Float.parseFloat(obj.get("count(nom)").toString());
                t1.setValue((int)value);
               
              //  t.setDateLivraison((obj.get("datelivraison").toString()));
//                t.setPrixTotal(Float.parseFloat(obj.get("prixTotal").toString()));
//                t.setAdresse2(obj.get("adresse2").toString());
//                t.setAdresse(obj.get("adresse").toString());
//                t.setVille(obj.get("ville").toString());
//                t.setCodePostal(obj.get("codePostal").toString());
//                t.setNumTel(((int)Float.parseFloat(obj.get("numTel").toString())));
//                t.setQuantite(((int)Float.parseFloat(obj.get("quantite").toString())));
//      
                Counts.add(t1);
                }
              for(Map<String,Object> obj : list2){
              
                      Count t2 = new Count();
                float value = Float.parseFloat(obj.get("count(nom)").toString());
                t2.setValue((int)value);
               
              //  t.setDateLivraison((obj.get("datelivraison").toString()));
//                t.setPrixTotal(Float.parseFloat(obj.get("prixTotal").toString()));
//                t.setAdresse2(obj.get("adresse2").toString());
//                t.setAdresse(obj.get("adresse").toString());
//                t.setVille(obj.get("ville").toString());
//                t.setCodePostal(obj.get("codePostal").toString());
//                t.setNumTel(((int)Float.parseFloat(obj.get("numTel").toString())));
//                t.setQuantite(((int)Float.parseFloat(obj.get("quantite").toString())));
//      
                Counts.add(t2);
                }
              for(Map<String,Object> obj : list3){
              
                      Count t3 = new Count();
                float value = Float.parseFloat(obj.get("count(nom)").toString());
                t3.setValue((int)value);
               
              //  t.setDateLivraison((obj.get("datelivraison").toString()));
//                t.setPrixTotal(Float.parseFloat(obj.get("prixTotal").toString()));
//                t.setAdresse2(obj.get("adresse2").toString());
//                t.setAdresse(obj.get("adresse").toString());
//                t.setVille(obj.get("ville").toString());
//                t.setCodePostal(obj.get("codePostal").toString());
//                t.setNumTel(((int)Float.parseFloat(obj.get("numTel").toString())));
//                t.setQuantite(((int)Float.parseFloat(obj.get("quantite").toString())));
//      
                Counts.add(t3);
                }
              for(Map<String,Object> obj : list4){
              
                      Count t4 = new Count();
                float value = Float.parseFloat(obj.get("count(nom)").toString());
                t4.setValue((int)value);
               
              //  t.setDateLivraison((obj.get("datelivraison").toString()));
//                t.setPrixTotal(Float.parseFloat(obj.get("prixTotal").toString()));
//                t.setAdresse2(obj.get("adresse2").toString());
//                t.setAdresse(obj.get("adresse").toString());
//                t.setVille(obj.get("ville").toString());
//                t.setCodePostal(obj.get("codePostal").toString());
//                t.setNumTel(((int)Float.parseFloat(obj.get("numTel").toString())));
//                t.setQuantite(((int)Float.parseFloat(obj.get("quantite").toString())));
//      
                Counts.add(t4);
                }
            
              
                
          
            
        } catch (IOException ex) {
            
        }
       // System.out.println(Counts.get(0).getValue()));
        System.out.println("Sports Bike  :"+Counts.get(0).getValue()+"velos");
        return Counts;
    }
    
    public ArrayList<Count> getAllStat(){
        String url = Statics.BASE_URL+"/numbr_road_bike/count";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                
                Counts = parseCommandes(new String(req.getResponseData()));
               
                 
               
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return Counts;
    }
    
    
   
}
