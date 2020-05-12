/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import Entites.rendezvous;
import Entites.Fos_User;
import Entites.Reparateur;
import Services.ListReparateurService;
import com.codename1.components.ImageViewer;
import com.codename1.components.ToastBar;
import com.codename1.l10n.ParseException;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
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
;

/**
 *
 * @author HP
 */
public class ListRepairesForm extends Form{
    private void initStarRankStyle(Style s, Image star) {
    s.setBackgroundType(Style.BACKGROUND_IMAGE_TILE_BOTH);
    s.setBorder(Border.createEmpty());
    s.setBgImage(star); 
   s.setBgTransparency(0);
     }

    public ListRepairesForm(Form previous)throws ParseException {
    super(BoxLayout.y());
        
    Toolbar tb = getToolbar();
    tb.setTitleCentered(false);
      
    Container titleCmp = BoxLayout.encloseY(
                        
                new Label("List Repaires", "CenterTitle") 
                );
    tb.setTitleComponent(titleCmp);
     FontImage arrowDown = FontImage.createMaterial(FontImage.MATERIAL_KEYBOARD_ARROW_DOWN, "Label", 3);
              EncodedImage enc ;
     
 Reparateur work=new Reparateur();
 rendezvous p=new rendezvous();
 ListReparateurService ws = new ListReparateurService();       
 ArrayList<Reparateur> rep = ws.getFos_user();
 {for (int i = 0; i < rep.size(); i++) {
Container c2 = new Container(BoxLayout.x()); 
Container c1 = new Container(BoxLayout.x());
Container c3 = new Container(BoxLayout.y());   
final Reparateur fos = rep.get(i);
int y=rep.get(i).getId();
Label ll = new Label("Repaire n°"+i+":");
c2.add(ll);
add(c2);         
Image placeholder = Image.createImage(this.getWidth() / 3 - 4, this.getWidth() / 3 - 4, 0xbfc9d2);
EncodedImage encImage = EncodedImage.createFromImage(placeholder, false);
ImageViewer img1 = new ImageViewer(URLImage.createToStorage(encImage, "file" + rep.get(i).getPhoto(),
                    "http://localhost/Velo/web/uploads/admin/" + rep.get(i).getPhoto()));
Button b = new Button("Make an appointement");
 Button btnAnnuler = new Button("Reset");

FontImage.setMaterialIcon(b, FontImage.MATERIAL_ADD_COMMENT);
            Label l2 = new Label("Name: " + rep.get(i).getNom());
            Label l3 = new Label("Last name: " + rep.get(i).getPrenom());
            c1.add(img1);
            c1.add(c3);
            c3.add(l2);
            c3.add(l3);
            c3.add(b);
            
     
     
            
    b.addActionListener(new ActionListener() {
    Form f1 = new Form("Make an appointement",new FlowLayout());
    
        
              Label lOption = new Label("Make an appointement : ");
              TextField typepannet = new TextField();
              
        
             ComboBox typepanne = new ComboBox("DIRECTION ET ROUES","FREINS","SUSPENSION");
              //TextField typepanne=new TextField("","typepanne");
              TextField message=new TextField("","Message");
              Button btnConf = new Button("Ajouter");
               
                
               @Override
               public void actionPerformed(ActionEvent evt) {
               
    
               
               btnConf.addActionListener((evt1) -> {
             getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
               rendezvous p=new rendezvous( typepannet.getText() ,message.getText());
               ws.ajoutRendezvous(p,y);
               ToastBar.showInfoMessage("Votre rendezvous  est ajouté avec succés");
              
             //add(typepannet);add(typepanne);add(messaget);add(message);
             
            });
                
              f1.add(lOption);
              f1.add(message);
              f1.add(typepanne);
              
              f1.add(typepannet);
              f1.add(btnConf);
              f1.show();
            Toolbar tb2= f1.getToolbar();
       tb2.addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, (ActionListener) (ActionEvent evt1) -> {
                   try {
                       //previous.showBack();
                       ListRepairesForm  v= new ListRepairesForm(previous);
                       v.show();
                   } catch (ParseException ex) {
                      
                   }
                
        });
               }
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
