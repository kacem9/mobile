/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import EspaceClient.ListRepairesForm;
import EspaceClient.listappointmentForm;
import EspaceClient.listvalidatedForm;
import Entites.FosUser;
import Services.Service_bcrypt;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import static com.codename1.io.Log.e;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.ParseException;
import com.codename1.ui.Button;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.util.Resources;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import utils.SessionUser;

/**
 *
 * @author root
 */
public class ReparationsForm extends SideMenuBaseForma{
     private static final String apiKey = "AIzaSyA4N1uhqDRC55eqZ3ZrJ9S_OQ3nL4vPYKg";
    final DefaultListModel<String> options = new DefaultListModel<>();
    private static final int[] COLORS = {0xf8e478, 0x60e6ce, 0x878aee};
    private static final String[] LABELS = {"Design", "Coding", "Learning"};

    public ReparationsForm(Resources res) {
        super(BoxLayout.y());
     
        Toolbar tb = getToolbar();
        tb.setTitleCentered(false);
        Button menuButton = new Button("");
        menuButton.setUIID("Title");
        FontImage.setMaterialIcon(menuButton, FontImage.MATERIAL_MENU);
        menuButton.addActionListener(e -> getToolbar().openSideMenu());
         ConnectionRequest cnx = new ConnectionRequest();
       
        
        

        Container titleCmp = BoxLayout.encloseY(
                        FlowLayout.encloseIn(menuButton),
                new Label("Reparations", "CenterTitle")
                        
                       
                );
        
        
       
        tb.setTitleComponent(titleCmp);
                        
      
        
        FontImage arrowDown = FontImage.createMaterial(FontImage.MATERIAL_KEYBOARD_ARROW_DOWN, "Label", 3);
        
        
        setupSideMenu(res);
        
        Label lOption = new Label("Choose option : ");
        Button ListRepaires = new Button("List Repaires");
        Button listappointment= new Button("List Appointment");
        Button listvalidated= new Button("List Appointment validated");
        FontImage.setMaterialIcon(ListRepaires, FontImage.MATERIAL_VIEW_LIST);
        ListRepaires.getStyle().setBorder(Border.createDashedBorder(CENTER, CENTER));
        ListRepaires.setUIID("SkipButton");
        FontImage.setMaterialIcon(listappointment, FontImage.MATERIAL_VIEW_LIST);
        listappointment.getStyle().setBorder(Border.createDashedBorder(CENTER, CENTER));
        listappointment.setUIID("SkipButton"); 
        FontImage.setMaterialIcon(listvalidated, FontImage.MATERIAL_VIEW_LIST);
        listvalidated.getStyle().setBorder(Border.createDashedBorder(CENTER, CENTER));
        listvalidated.setUIID("SkipButton");
        
                 Container southLayout = BoxLayout.encloseY(
                       
                     lOption,ListRepaires,listappointment,listvalidated
                );
        add(BorderLayout.south(
                southLayout
        ));
   
       /* ListRepaires.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                ConnectionRequest cnx = new ConnectionRequest();
                cnx.setUrl("http://localhost/Velo/web/app_dev.php/api/users/alluser");
                cnx.addResponseListener(new ActionListener<NetworkEvent>() {
                    @Override
                    public void actionPerformed(NetworkEvent evt) {
                        boolean i = false;
                        
                        for (FosUser e : getListUsers(new String(cnx.getResponseData()))) {
                            if ((e.getRoles().equals("[" + "ACHTEUR, ROLE_USER" + "]"))) {
                            System.out.println("rooooooooooooooooooooole" + e.getRoles());
                              System.out.println("rooooooooooooooooooooole" + e.getNom());
                            try {
                                //String crypted = e.getPassword();
                                
                               
                                
                                new ListRepairesForm(u,res).show();
                                
                                i = true;
                            } catch (ParseException ex) {
                               
                            }
                            } 

                        }
                      
                    }
                });
                NetworkManager.getInstance().addToQueue(cnx);
            }
        
        });*/
        
         ListRepaires.addActionListener((evt) -> {
        try {
                new ListRepairesForm(this).show();
            } catch (Exception ex) {
                ex.printStackTrace();
            }});
          
        listappointment.addActionListener((evt) -> {
         try {
                new listappointmentForm(this).show();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        listvalidated.addActionListener((evt) -> {
         try {
                new listvalidatedForm(this).show();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        }        
                
                
    
    
       public ArrayList<FosUser> getListUsers(String json) {
        ArrayList<FosUser> listUsers = new ArrayList<>();
        try {
            JSONParser j = new JSONParser();
            Map<String, Object> users = j.parseJSON(new CharArrayReader(json.toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) users.get("root");
            for (Map<String, Object> obj : list) {
                FosUser e = new FosUser();
                e.setId((int) Float.parseFloat(obj.get("id").toString()));
                e.setUsername(obj.get("username").toString());
                e.setEmail(obj.get("email").toString());
                e.setPassword(obj.get("password").toString());
                e.setRoles(obj.get("roles").toString());
                e.setNom(obj.get("nom").toString());
                e.setPrenom(obj.get("Prenom").toString());
                e.setAdresse(obj.get("Adresse").toString());

                e.setNum_tel(obj.get("numTel").toString());
                e.setSexe(obj.get("Sexe").toString());
                e.setCivilite(obj.get("Civilite").toString());
                e.setPays(obj.get("Pays").toString());
                e.setVille(obj.get("Ville").toString());
                e.setCode_postal(obj.get("codePostal").toString());
                e.setPhoto(obj.get("photo").toString());
                e.setCin(obj.get("Cin").toString());
                e.setDate_naissance(obj.get("dateNaissance").toString());
                listUsers.add(e);
                System.out.println(e.toString());

            }

        } catch (IOException ex) {

        }
        return listUsers;
    }
    
    private Image createCircleLine(int color, int height, boolean first) {
        Image img = Image.createImage(height, height, 0);
        Graphics g = img.getGraphics();
        g.setAntiAliased(true);
        g.setColor(0xcccccc);
        int y = 0;
        if(first) {
            y = height / 6 + 1;
        }
        g.drawLine(height / 2, y, height / 2, height);
        g.drawLine(height / 2 - 1, y, height / 2 - 1, height);
        g.setColor(color);
        g.fillArc(height / 2 - height / 4, height / 6, height / 2, height / 2, 0, 360);
        return img;
    }
     @Override
    protected void showEventForm(Resources res) {
        new EventForm(res).show();
    }
    @Override
    protected void showLocationsForm(Resources res) {
        new LocationForm(res).show();
    }
    
    @Override
    protected void showVelosForm(Resources res) {
        new VelosForm(res).show();
    }
    
    @Override
    protected void showReclamationsForm(Resources res) {
        new ReclamationsForm(res).show();
    }
    FosUser u =new FosUser ();
    @Override
    protected void showReparationsForm(Resources res) {
        new ReparationsForm(res).show();
    }

}


