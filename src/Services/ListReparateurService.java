
package Services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.events.ActionListener;
import Entites.Reparateur;
import Entites.rendezvous;
import Entites.validrendezvous;
import com.codename1.components.ToastBar;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author HP
 */
public class ListReparateurService {
    
    public ArrayList<Reparateur> reparateurs;
    public ArrayList<rendezvous> rendezvous;
    public ArrayList<validrendezvous> validrendezvous;
    public static ListReparateurService instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    public ListReparateurService() {
      req = new ConnectionRequest();
    }
      public static ListReparateurService getInstance() {
        if (instance == null) {
            instance = new ListReparateurService();
        }
        return instance;
    }
         /* public ArrayList<fos_user> getAllReparateurs() {

        ConnectionRequest con = new ConnectionRequest();
      
        con.setUrl("http://localhost/Velo/web/app_dev.php/api/reparateurs/Reparateurs");
        con.setPost(false);

        ArrayList<fos_user> rep = new ArrayList<>();
        con.addResponseListener((e) -> {
            ListReparateurService ws = new ListReparateurService();
            String jsonj = new String(con.getResponseData());
             

            try {

                JSONParser jp = new JSONParser();

                Map<String, Object> reparateur = jp.parseJSON(new CharArrayReader(jsonj.toCharArray()));
                System.out.println(reparateur);

                java.util.List<Map<String, Object>> list = (java.util.List<Map<String, Object>>) reparateur.get("root");
                SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy ");  
               //SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd hh:mm");
     
                for (Map<String, Object> obj : list) {
                    fos_user w = new fos_user(
                            (int) Float.parseFloat(obj.get("id").toString()),
                            obj.get("username").toString(),
                            obj.get("usernameCanonical").toString(),
                            obj.get("email").toString(),
                            obj.get("emailCanonical").toString(),
                            (Boolean) Boolean.parseBoolean(obj.get("enabled").toString()),
                            obj.get("salt").toString(),
                            obj.get("password").toString(),
                            new Date((long) Float.parseFloat(obj.get("last_login").toString())),
                            obj.get("confirmation_token").toString(),
                            new Date((long) Float.parseFloat(obj.get("password_requested_at").toString())),
                             obj.get("roles").toString(),
                            obj.get("Cin").toString(),
                            obj.get("nom").toString(),
                            obj.get("Prenom").toString(),
                            obj.get("Sexe").toString(),
                            new Date((long) Float.parseFloat(obj.get("Date_naissance").toString())),
                            obj.get("numTel").toString(),
                             obj.get("Adresse").toString(),
                             obj.get("Poste").toString(),
                             obj.get("Civilite").toString(),
                             obj.get("Pays").toString(),
                             obj.get("Ville").toString(),
                              obj.get("codePostal").toString(),
                             obj.get("photo").toString()
                           
                           
                    );
                    
                    rep.add(w);

                }

            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        });
        //System.out.println(rep);
       
        NetworkManager.getInstance().addToQueueAndWait(con);
        return rep;

    }*/
           public ArrayList<Reparateur> parseFos_user(String jsonText){
        try {
            reparateurs=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                Reparateur t = new Reparateur();
                float id = Float.parseFloat(obj.get("id").toString());
                t.setId((int)id);
                t.setNom(obj.get("nom").toString());
                t.setPrenom(obj.get("Prenom").toString());
                t.setPhoto(obj.get("photo").toString());
                reparateurs.add(t);
                System.err.println("re"+reparateurs);
            }
            
            
        } catch (IOException ex) {
            
        }
        return reparateurs;
    }
    
    public ArrayList<Reparateur> getFos_user(){
        //String url = Statics.BASE_URL;
        req.setUrl("http://localhost/Velo/web/app_dev.php/api/reparateurs/Reparateurs");
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                reparateurs = parseFos_user(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return reparateurs;
    }
       public void ajoutRendezvous(rendezvous rep ,Integer user,String nom,String Prenom,String Email,String Adresse ,String Num_tel,Integer fos) {

        try {

            ConnectionRequest connReq = new ConnectionRequest();
            connReq.setPost(true);
            connReq.setContentType("application/json");
            //rendezvous rep =new rendezvous();
            connReq.setUrl("http://localhost/Velo/web/app_dev.php/api/reparateurs/MakeRdv?"
                    + "nom="+nom+"&prenom="+Prenom
                    + "&email="+Email+"&message="+rep.getMessage()
                    + "&typepanne="+rep.getTypepanne()+"&adresse="+Adresse+"&numtel="+Num_tel+"&user="+user+"&fos="+fos);
            connReq.addResponseListener((e) -> {
                String str = new String(connReq.getResponseData());
                System.out.println(str);
            });
            NetworkManager.getInstance().addToQueueAndWait(connReq);
        } catch (Exception err) {
            System.err.println(err.getMessage());
        }
    }
       
            public ArrayList<rendezvous> parseRendezvous(String jsonText){
        try {
            rendezvous=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> rendezvousListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)rendezvousListJson.get("root");
            for(Map<String,Object> obj : list){
                rendezvous t = new rendezvous();

                float Cin = Float.parseFloat(obj.get("Cin").toString());
               int numtel = (int)Float.parseFloat(obj.get("numtel").toString());
               int user=(int) Float.parseFloat(obj.get("user").toString());
                t.setCin((int)Cin);
                t.setNom(obj.get("nom").toString());
                t.setPrenom(obj.get("prenom").toString());
                t.setEmail(obj.get("email").toString());
                t.setAdresse(obj.get("adresse").toString());
                t.setMessage(obj.get("message").toString());
                t.setTypepanne(obj.get("typepanne").toString());
                t.setNumtel((int)numtel);
                t.setUser((int)user);
                rendezvous.add(t);
                System.err.println("re"+rendezvous);
            }
            
            
        } catch (IOException ex) {
            
        }
        return rendezvous;
    }
    
    public ArrayList<rendezvous> getRendezvous(){
        //String url = Statics.BASE_URL;
        req.setUrl("http://localhost/Velo/web/app_dev.php/api/reparateurs/ListRdv");
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                rendezvous = parseRendezvous(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return rendezvous;
    }
    
    public void modWork(rendezvous r,Integer Cin,String nom,String Prenom,String Email,String Adresse ,String Num_tel,Integer user) {
        try {
            ConnectionRequest connReq = new ConnectionRequest();
            connReq.setPost(true);
            connReq.setContentType("application/json");
            connReq.setUrl("http://localhost/Velo/web/app_dev.php/api/reparateurs/ModifiRdv?Cin="+Cin+
                     "&nom="+nom+"&prenom="+Prenom+"&email="+Email+"&message="+r.getMessage()
                    + "&typepanne="+r.getTypepanne()+"&adresse="+Adresse+"&numtel="+Num_tel+"&user="+user);

            connReq.addResponseListener((e) -> {
                String str = new String(connReq.getResponseData());
                System.out.println(str);
            });
            NetworkManager.getInstance().addToQueueAndWait(connReq);
        } catch (Exception err) {
            System.err.println(err.getMessage());
        }
    }
        public void Delete(rendezvous r,Integer Cin) {
        try {

            ConnectionRequest connReq = new ConnectionRequest();
            connReq.setUrl("http://localhost/Velo/web/app_dev.php/api/reparateurs/DeleteRdv?Cin="+Cin
            );

            connReq.addResponseListener((e) -> {
                String str = new String(connReq.getResponseData());
                System.out.println(str);
            });
            NetworkManager.getInstance().addToQueueAndWait(connReq);
        } catch (Exception err) {
            System.err.println(err.getMessage());
        }
    }
        
        
        
            public ArrayList<rendezvous> parseMaRendezvous(String jsonText){
        try {
            rendezvous=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> rendezvousListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)rendezvousListJson.get("root");
            for(Map<String,Object> obj : list){
                rendezvous t = new rendezvous();
                float Cin = Float.parseFloat(obj.get("Cin").toString());
               int numtel = (int)Float.parseFloat(obj.get("numtel").toString());
              int user=(int) Float.parseFloat(obj.get("user").toString());
               int fos = (int)Float.parseFloat(obj.get("fos").toString());
                t.setCin((int)Cin);
                t.setNom(obj.get("nom").toString());
                t.setPrenom(obj.get("prenom").toString());
                t.setEmail(obj.get("email").toString());
                t.setAdresse(obj.get("adresse").toString());
                t.setMessage(obj.get("message").toString());
                t.setTypepanne(obj.get("typepanne").toString());
                t.setNumtel((int)numtel);
                t.setUser((int)user);
                t.setFos((int)fos);
                rendezvous.add(t);
                System.err.println("re"+rendezvous);
            }
            
            
        } catch (IOException ex) {
            
        }
        return rendezvous;
    }
    
    public ArrayList<rendezvous> getMaRendezvous(){
        //String url = Statics.BASE_URL;
        req.setUrl("http://localhost/Velo/web/app_dev.php/api/reparateurs/MaListRdv");
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                rendezvous = parseRendezvous(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return rendezvous;
    }        
        
           public void DeleteMaRdv(rendezvous r,Integer Cin) {
        try {

            ConnectionRequest connReq = new ConnectionRequest();
            connReq.setUrl("http://localhost/Velo/web/app_dev.php/api/reparateurs/DeleteMaRdv?Cin="+Cin
            );

            connReq.addResponseListener((e) -> {
                String str = new String(connReq.getResponseData());
                System.out.println(str);
            });
            NetworkManager.getInstance().addToQueueAndWait(connReq);
        } catch (Exception err) {
            System.err.println(err.getMessage());
        }
    }     
      public void validsrendezvous(validrendezvous v ,Integer user_cc,Integer user,String emailR ) {

        try {

            ConnectionRequest connReq = new ConnectionRequest();
            connReq.setPost(true);
            connReq.setContentType("application/json");
            //rendezvous rep =new rendezvous();
            connReq.setUrl("http://localhost/Velo/web/app_dev.php/api/reparateurs/validsrendezvous?dateheure="+v.getDateheure()
                    + "&prix="+v.getPrix()+"&promo="+v.getPromo()+"&etat="+v.getEtat()+"&message="+v.getMessage()+"&emailR="+emailR+"&user="+user+"&user_cc="+user_cc);
            connReq.addResponseListener((e) -> {
                String str = new String(connReq.getResponseData());
                System.out.println(str);
            });
            NetworkManager.getInstance().addToQueueAndWait(connReq);
        } catch (Exception err) {
            System.err.println(err.getMessage());
        }
    }
          public ArrayList<validrendezvous> parseValidRendezvous(String jsonText){
        try {
            validrendezvous=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> validrendezvousListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)validrendezvousListJson.get("root");
            for(Map<String,Object> obj : list){
                validrendezvous t = new validrendezvous();
                float reference = Float.parseFloat(obj.get("reference").toString());
                int user=(int) Float.parseFloat(obj.get("user").toString());
                t.setReference((int)reference);
                t.setDateheure(obj.get("dateheure").toString());
                t.setPrix(obj.get("prix").toString());
                t.setPromo(obj.get("promo").toString());
                t.setEtat(obj.get("etat").toString());
                t.setMessage(obj.get("message").toString());
                 t.setUser((int)user);
                validrendezvous.add(t);
                System.err.println("re"+validrendezvous);
            }
            
            
        } catch (IOException ex) {
            
        }
        return validrendezvous;
    }
    
    public ArrayList<validrendezvous> getValidRendezvous(){
        //String url = Statics.BASE_URL;
        req.setUrl("http://localhost/Velo/web/app_dev.php/api/reparateurs/RendezVousValide");
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                validrendezvous = parseValidRendezvous(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return validrendezvous;
    }
            public void DeleteRdvValide(rendezvous r,Integer reference) {
        try {

            ConnectionRequest connReq = new ConnectionRequest();
            connReq.setUrl("/http://localhost/Velo/web/app_dev.php/api/reparateurs/DeleteRdvValide?reference="+reference
            );

            connReq.addResponseListener((e) -> {
                String str = new String(connReq.getResponseData());
                System.out.println(str);
            });
            NetworkManager.getInstance().addToQueueAndWait(connReq);
        } catch (Exception err) {
            System.err.println(err.getMessage());
        }
    }
       
}





