/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Evenement;

import Entites.Event;
import Services.ServicesEvent;
import com.codename1.components.ImageViewer;
import com.codename1.components.ShareButton;
import com.codename1.components.SpanLabel;
import com.codename1.components.ToastBar;
import com.codename1.l10n.ParseException;
import com.codename1.location.Geofence;
import com.codename1.location.Location;
import com.codename1.location.LocationManager;
import com.codename1.notifications.LocalNotification;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import java.util.ArrayList;
import static jdk.nashorn.internal.runtime.Debug.id;


/**
 *
 * @author root
 */
public class ListEventForm extends Form{
     private void initStarRankStyle(Style s, Image star) {
    s.setBackgroundType(Style.BACKGROUND_IMAGE_TILE_BOTH);
    s.setBorder(Border.createEmpty());
    s.setBgImage(star); 
   s.setBgTransparency(0);
     }
    public ListEventForm(Form previous)throws ParseException {
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
            Button btnsupp = new Button("Supprimer");
    Label ll = new Label("Event n°"+i+":");
    c2.add(ll);
                   add(c2);
            ImageViewer iv = new ImageViewer();
            System.out.println(lis.get(i).getPhoto());
            Image placeholder = Image.createImage(this.getWidth() / 3 - 3, this.getWidth() / 3- 3, 0xbfc9d2);
            EncodedImage encImage = EncodedImage.createFromImage(placeholder, false);
            ImageViewer img1 = new ImageViewer(URLImage.createToStorage(encImage, "file" + lis.get(i).getPhoto(),
            "http://127.0.0.1/"+ lis.get(i).getPhoto()));
            //http://127.0.0.1/symfony/Velo/web/
            ShareButton share = new ShareButton();
                    
                    
                    // share.getAllStyles().setBgColor(0x009FFD);
                    FontImage.setMaterialIcon(share, FontImage.MATERIAL_SHARE);
                    share.setText("Share");
                    share.setTextToShare(lis.get(i).getDescription());
            Button btnmodif = new Button("Modifier");
            FontImage.setMaterialIcon(btnsupp, FontImage.MATERIAL_DELETE);
            FontImage.setMaterialIcon(btnmodif, FontImage.MATERIAL_UPLOAD_FILE);
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

           
            c3.add(btnmodif);
            c3.add(btnsupp);
            c3.add(share);
            TextField tf = new TextField();
           int id = lis.get(i).getId();
           System.out.println(id);
           String Nom = lis.get(i).getNom();
           String Description = lis.get(i).getDescription();
           String Lieu_event = lis.get(i).getLieu_event();
           Double Prix = lis.get(i).getPrix();
           int Nbr_participant=lis.get(i).getNbr_participant();
          
            btnsupp.addActionListener((evt) -> {
                
                   
                 if(new ServicesEvent().SupprimerEvent(id))
                 {
                    
                      ToastBar.showInfoMessage("Votre evenement est supprimée avec succés");
                    c2.remove();
                    c1.remove();
                    c3.remove();
                    img1.remove();
                    btnsupp.remove();
                    btnmodif.remove();
                    this.refreshTheme();
                 }else{
                    ToastBar.showErrorMessage("Erreur de suppression");
                }
            });

          
            btnmodif.addActionListener((evt) -> {
                new ModifierEventForm(this,id, Nom, Description, Lieu_event,Prix,Nbr_participant).show();
            });

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

