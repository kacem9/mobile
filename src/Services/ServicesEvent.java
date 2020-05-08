/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entites.Event;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import utils.Statics;

/**
 *
 * @author root
 */
public class ServicesEvent {
    private ConnectionRequest request;
   public static ServicesEvent instance=null;
    private boolean responseResult;
    public ArrayList<Event> events;
    
    public ServicesEvent() {
         request = new ConnectionRequest();
    }

    public static ServicesEvent getInstance() {
        if (instance == null) {
            instance = new ServicesEvent();
        }
        return instance;
    }
    
    public ArrayList<Event> getAllEvents() throws ParseException {
        String url = Statics.BASE_URL +"/event/afficher";

        request.setUrl(url);
        request.setPost(false);
        request.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
          
                try {
                    events = parseEvents(new String(request.getResponseData()));
                } catch (ParseException ex) {
                    System.out.println("erreur de l'affichage !!!!!!!!!!!!!!!!!!!!!"); 
               }
              
                request.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(request);

        return events;
    }
    
    public ArrayList<Event> parseEvents(String jsonText) throws ParseException{
        try {
            events = new ArrayList<>();

            JSONParser jp = new JSONParser();
            Map<String, Object> eventsListJson = jp.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) eventsListJson.get("root");
            for (Map<String, Object> obj : list) {
                 SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy ");
                int id = (int)Float.parseFloat(obj.get("id").toString()); 
                int etat = (int)Float.parseFloat(obj.get("etat").toString());
                String Nom = obj.get("nom").toString();
                String Description = obj.get("description").toString();
                 String Date_event = obj.get("dateEvent").toString();
                 String Lieu_event = obj.get("lieuEvent").toString();
                 int Nbr_participant = (int)Float.parseFloat(obj.get("nbrParticipant").toString());
                 double Prix = (double)Float.parseFloat(obj.get("prix").toString());
                  String Photo=obj.get("photo").toString();
                  
                  SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
               //  System.out.println(id);      
                System.out.println(Photo);  
                System.out.println(Date_event);


                events.add(new Event(Nom, Date_event, Description, Lieu_event, Photo, Prix, Nbr_participant, etat));
            }

        } catch (IOException ex) {
        }

        return events;
    }
    
    public boolean SupprimerEvent(int id) {
        String url = Statics.BASE_URL +"/event/supp/"+ id;
       
        request.setUrl(url);
        request.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                responseResult = request.getResponseCode() == 200; // Code HTTP 200 OK
                request.removeResponseListener(this);
         System.out.println(responseResult);
           
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(request);
         
        return responseResult;
    }
    
    public boolean AjouterEvent(Event ev) {
        String url = Statics.BASE_URL + "/event/ajouter?Nom=" + ev.getNom()
                + "&Description=" + ev.getDescription()
                + "&DateEvent=" + ev.getDate_event()
                + "&Photo=" + ev.getPhoto()
                + "&LieuEvent=" +ev.getLieu_event()
                + "&Prix=" + ev.getPrix()
                + "&NbrParticipant=" + ev.getNbr_participant();
              //  + "&Categories_id=" + ev.getCategories_id();

        request.setUrl(url);
        request.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                responseResult = request.getResponseCode() == 200; // Code HTTP 200 OK
                request.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(request);
        return responseResult;
    }
    
    public void ModifierEvent(Event ev) {
        String url = Statics.BASE_URL + "/event/modifier/" + ev.getId()
                + "?Nom=" + ev.getNom()
                + "&Description=" + ev.getDescription()
                + "&DateEvent=" + ev.getDate_event()
                + "&Photo=" + ev.getPhoto()
                + "&LieuEvent=" +ev.getLieu_event()
                + "&Prix=" + ev.getPrix()
                + "&NbrParticipant=" + ev.getNbr_participant();
              //  + "&Categories_id=" + ev.getCategories_id();

        request.setUrl(url);
        request.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                responseResult = request.getResponseCode() == 200; // Code HTTP 200 OK
                request.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(request);

    }
}
