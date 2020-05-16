/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entites.Event;
import Entites.Panier;
import Entites.Participation;
import com.codename1.db.Cursor;
import com.codename1.db.Database;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import utils.SessionUser;

/**
 *
 * @author root
 */
public class ParticiperService {
     Database db;
    boolean created;
    
    public void createDB() {
        created = Database.exists("participation");
        try {
            db = Database.openOrCreate("participation");
            if (created == false) {
                db.execute("create table `participation` ( id_participation integer , id_user Integer , event Integer)");
            }
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        System.out.println("créer");

    }
    
    public ArrayList<Participation> getParticiper() {
        createDB();
        ConnectionRequest con = new ConnectionRequest();

        ArrayList<Participation> mapPart = new ArrayList<>();
        con.addResponseListener((e) -> {
            ParticiperService ps = new ParticiperService();
            String jsonRes = new String(con.getResponseData());
            try {
                JSONParser j = new JSONParser();

                Map<String, Object> participe = j.parseJSON(new CharArrayReader(jsonRes.toCharArray()));

                List<Map<String, Object>> list = (List<Map<String, Object>>) participe.get("root");

                for (Map<String, Object> obj : list) {
                    /*  Panier p = new Panier();
                     System.out.println("img"+obj.get("prodImg"));
                     p.setProdImg(obj.get("prodImg").toString());
                     p.setLibelle(obj.get("libelle").toString());*/
                    // p.setQte(obj.get("qte").toString());
                    //  p.setPrixTot((Double)obj.get("prixTot"));

                    //  mapPanier.add(p);
                }

            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        });

        NetworkManager.getInstance().addToQueue(con);

        return mapPart;
    }
    
    public Boolean checkParticipation(Integer id_user, Integer event) {
         createDB();
        Boolean b = false;

        try {
            System.out.println("aaaaaaaaaaaaaaaaaaa");
            Cursor cs = db.executeQuery("select * from participation where id_user=" + id_user + " and event=" + event);
            if (cs.next()) {
                b = true;
            }

        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        System.out.println("b " + b);

        return b;   
    }
    
    public void Participer(Event ev) {
        try {
                db.execute("insert into `participation` (id_user,event) values('" + SessionUser.getUser().getId() + "','" + ev.getId()  + ")");
                System.out.println("jawou behy");
            } catch (IOException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
            System.out.println("cv");
    }

}
