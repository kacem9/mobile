/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entites.Velo;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.messaging.Message;
import com.codename1.notifications.LocalNotification;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Display;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import utils.DataSource;
import utils.Statics;

/**
 *
 * @author HP
 */
public class ServiceVelos {
  private ConnectionRequest request;

    private boolean responseResult;

        public ArrayList<Velo> velos;


    public ServiceVelos() {
        request = DataSource.getInstance().getRequest();
    }
//http://127.0.0.1/Velo/web/app_dev.php/api/newVelo?price_location=100&quantity=2&description=hhhh&localitsation_velo=h&"dateCirculation"=%222019-02-20
    public boolean addrec(Velo v,int idu) {
        String url = Statics.BASE_URL2+"/newVelo/"+idu+"?description=" +v.getDescription()+"&localitsation_velo="+v.getLocalitsation_velo()+"&photo="+v.getPhoto()+"&price_location="+v.getPrice_location()+"&quantity="+v.getQuantity()+"dateCirculation="+v.getDate_circulation();
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
    
    public boolean deleterec(int id) {
        String url = Statics.BASE_URL2+"/Deletev/"+id;

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
    
    public boolean updatev(int id,Velo v) {
        String url = Statics.BASE_URL2 +"/updatev/"+id+"?description=" +v.getDescription()+"&localitsation_velo="+v.getLocalitsation_velo()+"&photo="+v.getPhoto()+"&price_location="+v.getPrice_location()+"&quantity="+v.getQuantity()+"dateCirculation="+v.getDate_circulation();

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

    public ArrayList<Velo> getAllVelos() throws ParseException {
        String url = Statics.BASE_URL2 +"/ListVelo";

        request.setUrl(url);
        request.setPost(false);
        request.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
          
                try {
                    velos = parseTasks(new String(request.getResponseData()));
                } catch (ParseException ex) {
                    System.out.println("erre"); 
               }
              
                request.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(request);

        return velos;
    }
    

   

    public ArrayList<Velo> parseTasks(String jsonText) throws ParseException{
        try {
            velos = new ArrayList<>();

            JSONParser jp = new JSONParser();
            Map<String, Object> tasksListJson = jp.parseJSON(new CharArrayReader(jsonText.toCharArray()));

//   Map<String, Object> events = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");
            for (Map<String, Object> obj : list) {
                 SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy ");
                int id = (int)Float.parseFloat(obj.get("id").toString());
                
                                                    int price_location = (int)Float.parseFloat(obj.get("priceLocation").toString());

                  int quantity = (int)Float.parseFloat(obj.get("quantity").toString());
                System.out.println(price_location);
                String description = obj.get("description").toString();
                             //   String price_location = obj.get("priceLocation").toString();

                String localitsationVelo = obj.get("localitsationVelo").toString();
                 String datePublication = obj.get("dateCirculation").toString();
                  String photo=obj.get("photo").toString();
                  SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                       
                System.out.println(photo);
//   Date datePublication     =new Date((long) Integer.parseInt(sdf.format(obj.get("datePublication").toString())));
                        
                             System.out.println(datePublication);


           // String datePublication	 = obj.get("datePublication").toString();
                   //  String date_circulation	 = obj.get("date_circulation").toString();
                 
     //  Date date = format.parse(datePublication);
                   // Date datePublication = (Date) format.parse(obj.get("datePublication").toString());
                velos.add(new Velo(id,description,localitsationVelo,quantity,datePublication,photo,price_location));
            }

        } catch (IOException ex) {
        }

        return velos;
    }
    

    

}   

