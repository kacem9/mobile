/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entites.FosUser;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.messaging.Message;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Display;
import com.codename1.ui.events.ActionListener;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import utils.Statics;

/**
 *
 * @author bhk
 */
public class ServiceUser {

    private ConnectionRequest request;
    private ConnectionRequest req;
    private boolean responseResult;
    public ArrayList<FosUser> tasks;
    public ArrayList<FosUser> velos;
    public ArrayList<FosUser> type;
    public boolean resultOK;
    public static ServiceUser instance = null;

    public ServiceUser() {
        req = utils.DataSource.getInstance().getRequest();
    }

    public static ServiceUser getInstance() {
        if (instance == null) {
            instance = new ServiceUser();
        }
        return instance;
    }

    public boolean adduser(FosUser u) {
        String url = "http://localhost/Velo/web/app_dev.php/api/users/new?&Username="+ u.getUsername() +"&Email="+ u.getEmail() +"&Password="+ u.getPassword() +"&roles="+ u.getRoles() +"&Cin="+u.getCin()+"&Nom="+ u.getNom() +"&Prenom="+ u.getPrenom()+"&Sexe="+ u.getSexe()+"&Date_naissance="+ u.getDate_naissance()+"&Num_tel="+u.getNum_tel()+
         "&Adresse="+ u.getAdresse() +"&Poste="+u.getPoste() +"&Civilite=" + u.getCivilite() +"&Pays="+u.getPays()+"&Ville="+u.getVille()+"&Code_postal="+ u.getCode_postal()+"&photo="+u.getPhoto();
               
       
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

    /*
    public boolean deleterec(int id) {
        String url = Statics.BASE_URL + "/removeRec?id=" +id;

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
    
    public boolean updaterec(int id, String msg) {
        String url = Statics.BASE_URL + "/updateRec?id=" +id+ "&message=" +msg;

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
    }*/
    public ArrayList<FosUser> getAllTasks() throws ParseException {
        String url = Statics.BASE_URL + "/users/alluser";

        request.setUrl(url);
        request.setPost(false);
        request.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {

                try {
                    velos = (ArrayList<FosUser>) parseTasks(new String(request.getResponseData()));
                } catch (ParseException ex) {
                    System.out.println("erre");
                }

                request.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(request);

        return velos;
    }

  
   
    
    public ArrayList<FosUser> parseTasks(String jsonText) throws ParseException {
        try {
            velos = new ArrayList<>();

            JSONParser jp = new JSONParser();
            Map<String, Object> tasksListJson = jp.parseJSON(new CharArrayReader(jsonText.toCharArray()));

//   Map<String, Object> events = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");
            for (Map<String, Object> obj : list) {
                SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy ");
                int id = (int) Float.parseFloat(obj.get("id").toString());
                String Sexe = obj.get("Sexe").toString();
                String Prenom = obj.get("Prenom").toString();
                String roles = obj.get("roles").toString();
//                 String Date_naissance = obj.get("Date_naissance").toString();
                String photo = obj.get("photo").toString();
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

                System.out.println(photo);
//   Date datePublication     =new Date((long) Integer.parseInt(sdf.format(obj.get("datePublication").toString())));

                //System.out.println(Date_naissance);
                // String datePublication	 = obj.get("datePublication").toString();
                //  String date_circulation	 = obj.get("date_circulation").toString();
                //  Date date = format.parse(datePublication);
                // Date datePublication = (Date) format.parse(obj.get("datePublication").toString());
                velos.add(new FosUser(id, Prenom, photo, roles, Sexe));
            }

        } catch (IOException ex) {
        }

        return velos;
    }

    /*public ArrayList<typeReclamation> parseType(String jsonText) {
        try {
            type = new ArrayList<>();

            JSONParser jp = new JSONParser();
            Map<String, Object> tasksListJson = jp.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");
            for (Map<String, Object> obj : list) {
                int id = (int)Float.parseFloat(obj.get("id").toString());
                String titre = obj.get("titre").toString();
                
                type.add(new typeReclamation(id, titre));
            }

        } catch (IOException ex) {
        }

        return type;
    }*/
    public void sendEmail() {
        Message m = new Message("Bonjour Monsieur,\n Pouvez vous me répondre.\n Merci. ");
//        m.getAttachments().put(textAttachmentUri, "text/plain");
//        m.getAttachments().put(imageAttachmentUri, "image/png");
        Display.getInstance().sendMessage(new String[]{"nejibalazzem@gmail.com"}, "Réclamation", m);
    }

    /*public void Notification(){
        LocalNotification n = new LocalNotification();
        n.setId("demo-notification");
        n.setAlertBody("It's time to take a break and look at me");
        n.setAlertTitle("Break Time!");
        n.setAlertSound("/notification_sound_beep-01a.mp3");
            // alert sound file name must begin with notification_sound

        Display.getInstance().scheduleLocalNotification(
                n,
                System.currentTimeMillis() + 10 * 1000, // fire date/time
                LocalNotification.REPEAT_MINUTE  // Whether to repeat and what frequency
        );
    }*/
    public void localNotificationReceived(String notificationId) {

    }
}
