/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;


import Entites.Event;
import Entites.Participation;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import utils.SessionUser;
import utils.Statics;

/**
 *
 * @author root
 */
public class ServiceParticipation {
     private ConnectionRequest request;
   public static ServiceParticipation ins=null;
    private boolean responseResult;
    public ArrayList<Participation> parts;
    
    public ServiceParticipation() {
         request = new ConnectionRequest();
    }

    public static ServiceParticipation getInstance() {
        if (ins == null) {
            ins = new ServiceParticipation();
        }
        return ins;
    }
    
        public ArrayList<Participation> parseParticipations(String jsonText) throws ParseException{
        try {
            parts = new ArrayList<>();

            JSONParser jp = new JSONParser();
            Map<String, Object> partsListJson = jp.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) partsListJson.get("root");
            for (Map<String, Object> obj : list) {
                 
                int id_participation = (int)Float.parseFloat(obj.get("idParticipation").toString()); 
//                int id_user = (int)Float.parseFloat(obj.get("user").toString());
          //      int event = (int)Float.parseFloat(obj.get("event").toString());
                
                System.out.println(id_participation);  
           //     System.out.println(event);
           //     System.out.println(id_user);

                parts.add(new Participation(id_participation));
            }

        } catch (IOException ex) {
        }

        return parts;
    }
        
        public boolean AnnulerParticipation(int id_participation) {
         String url = Statics.BASE_URL2 +"/event/annuler/" + id_participation;
       
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
        
    public ArrayList<Participation> getAllParticipation() throws ParseException {
        String url = Statics.BASE_URL2 +"/event/afficherpar";

        request.setUrl(url);
        request.setPost(false);
        request.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
          
                try {
                    parts = parseParticipations(new String(request.getResponseData()));
                } catch (ParseException ex) {
                    System.out.println("erreur de l'affichage !!!!!!!!!!!!!!!!!!!!!"); 
               }
              
                request.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(request);

        return parts;
    }
    
    public boolean Participer(int id_participation,Participation p) {
        String url = Statics.BASE_URL2 + "/event/participer/" + id_participation
                + "&event=" + p.getEvent()
                + "&id_user=" + SessionUser.getUser().getId();
         

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
    
}
