/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EspaceClient;

import Evenement.*;
import Entites.Event;
import Entites.Fos_User;
import Entites.Participation;
import Services.ServiceParticipation;
import Services.ServicesEvent;
import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.components.ToastBar;
import com.codename1.l10n.ParseException;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import java.util.ArrayList;
import static jdk.nashorn.internal.runtime.Debug.id;
import utils.SessionUser;

/**
 *
 * @author root
 */
public class ListEventFormClient extends Form{
    Participation p = new Participation();
     Fos_User u=new Fos_User();
     private void initStarRankStyle(Style s, Image star) {
    s.setBackgroundType(Style.BACKGROUND_IMAGE_TILE_BOTH);
    s.setBorder(Border.createEmpty());
    s.setBgImage(star); 
   s.setBgTransparency(0);
     }
    public ListEventFormClient(Form previous)throws ParseException {
        super(BoxLayout.y());
        
        Toolbar tb = getToolbar();
        tb.setTitleCentered(false);
      
        Container titleCmp = BoxLayout.encloseY(
                        
                new Label("Liste des evenements", "CenterTitle")
                        
                       
                );
        
        
       
        tb.setTitleComponent(titleCmp);
  
        
        FontImage arrowDown = FontImage.createMaterial(FontImage.MATERIAL_KEYBOARD_ARROW_DOWN, "Label", 3);
              EncodedImage enc ;
       ServicesEvent se = new ServicesEvent();
       ArrayList<Event> lis = se.getAllEvents();
       { for(int i = 0; i<lis.size(); i++) {
           
           
             Container c2 = new Container(BoxLayout.x()); 
            Container c1 = new Container(BoxLayout.x());
            Container c3 = new Container(BoxLayout.y());
            
         
            
            Button btParticiper = new Button("Participer");
            Button btannuler = new Button("Annuler");
         
             if(SessionUser.getUser().getId() != p.getId_user()){
                   btParticiper.setEnabled(true);
                   btannuler.setEnabled(false);  
                }
                else{
                    btParticiper.setEnabled(false);  
                    btannuler.setEnabled(true); 
                }
            
            
            
            
    Label ll = new Label("Event n°"+i+":");
    c2.add(ll);
                   add(c2);
            ImageViewer iv = new ImageViewer();
            System.out.println(lis.get(i).getPhoto());
            Image placeholder = Image.createImage(this.getWidth() / 3 - 3, this.getWidth() / 3- 3, 0xbfc9d2);
            EncodedImage encImage = EncodedImage.createFromImage(placeholder, false);
            ImageViewer img1 = new ImageViewer(URLImage.createToStorage(encImage, "file" + lis.get(i).getPhoto(),
            "http://127.0.0.1/"+ lis.get(i).getPhoto()));
            //http://127.0.0.1/symfony/Velo/web/images/
            
            FontImage.setMaterialIcon(btParticiper, FontImage.MATERIAL_KEYBOARD_ARROW_RIGHT);
            FontImage.setMaterialIcon(btannuler, FontImage.MATERIAL_CLEAR);
            Label l2 = new Label("Nom: " + lis.get(i).getNom());
            Label l3 = new Label("Date Event: " + lis.get(i).getDate_event());
            Label l4 = new Label("Lieu Event: " + lis.get(i).getLieu_event());
            Label l5 = new Label("Nbr participant: " + lis.get(i).getNbr_participant());
            c1.add(img1);
            c1.add(c3);
            c3.add(new SpanLabel("Description:" + lis.get(i).getDescription()));
            c3.add(new SpanLabel("Prix:" + lis.get(i).getPrix()));
            c3.add(l2);
            c3.add(l3);
            c3.add(l4);
            c3.add(l5);

           
            c3.add(btParticiper);
            c3.add(btannuler);
            TextField tf = new TextField();
           
            ServiceParticipation sp = new ServiceParticipation();
            
            ArrayList<Participation> list = sp.getAllParticipation();
            for(int j = 0; j<list.size(); j++) {
                int id_participation=list.get(j).getId_participation();
                System.out.println(id_participation);
                TextField tfidparticipation = new TextField(list.get(j).getId_participation());
                TextField tfidUser = new TextField(1);
                TextField tfevent = new TextField(list.get(j).getEvent());
                
               
                 
            btannuler.addActionListener((evt) -> {
                
                  
                 if(sp.AnnulerParticipation(id_participation))
                 {
                    
                      ToastBar.showInfoMessage("vous avez annuler votre participation");
                      btannuler.setEnabled(false);  

                 }else{
                    ToastBar.showErrorMessage("Erreur");
                }
            });
            
            btParticiper.addActionListener((evt) -> {
                
                    try {
                        int idu=SessionUser.getUser().getId();
                        if(sp.Participer(id_participation,idu, p))
                        {
                          
                            Dialog.show("Success","Connection accepted",new Command("OK"));
                        }else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (Exception e) {
                        Dialog.show("ERROR", "server error", new Command("OK"));
                    }
   
        });
            }
            add(c1);
           
        
       }
       

        }
       getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
    
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
    
 
}

