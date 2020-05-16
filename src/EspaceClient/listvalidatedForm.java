/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EspaceClient;

import Entites.Reparateur;
import Entites.rendezvous;
import Entites.validrendezvous;
import Services.ListReparateurService;
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
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import java.util.ArrayList;
import utils.SessionUser;


/**
 *
 * @author HP
 */
public class listvalidatedForm  extends Form {
    
    private void initStarRankStyle(Style s, Image star) {
    s.setBackgroundType(Style.BACKGROUND_IMAGE_TILE_BOTH);
    s.setBorder(Border.createEmpty());
    s.setBgImage(star); 
   s.setBgTransparency(0);
     }

    public listvalidatedForm(Form previous) throws ParseException{
         super(BoxLayout.y());
        
    Toolbar tb = getToolbar();
    tb.setTitleCentered(false);
      
    Container titleCmp = BoxLayout.encloseY(
                        
                new Label("List appointement validated", "CenterTitle") 
                );
    tb.setTitleComponent(titleCmp);
     FontImage arrowDown = FontImage.createMaterial(FontImage.MATERIAL_KEYBOARD_ARROW_DOWN, "Label", 3);
              EncodedImage enc ;
     
 Reparateur work=new Reparateur();
 rendezvous p=new rendezvous();
ListReparateurService ws = new ListReparateurService(); 
ArrayList<validrendezvous> ren = ws.getValidRendezvous();
 {for (int i = 0; i < ren.size(); i++) {
          int test=ren.get(i).getUser();
     System.out.println("hedha l user"+test);
if(SessionUser.getUser().getId()==test){ 
Container c2 = new Container(BoxLayout.x()); 
Container c1 = new Container(BoxLayout.x());
Container c3 = new Container(BoxLayout.y());   
final validrendezvous r = ren.get(i);
int y=ren.get(i).getReference();
//Label ll = new Label("Appointement validated n°"+i+":");
//c2.add(ll);
add(c2);         
Button b1 = new Button("Delete Rdv");
 FontImage.setMaterialIcon(b1, FontImage.MATERIAL_DELETE);
            Label l2 = new Label("Date: " + ren.get(i).getDateheure());
            Label l3 = new Label("Prix: " + ren.get(i).getPrix());
            Label l4 = new Label("Promo: " + ren.get(i).getPromo());
            Label l5 = new Label("Message: " + ren.get(i).getMessage());
            
            c1.add(c3);
            c3.add(l2);
            c3.add(l3);
            c3.add(l4);
            c3.add(l5);
            c3.add(b1);
            //c3.add(lOption);

    b1.addActionListener((evt) -> {
          if (Dialog.show("Delete", "Êtes vous sûr de supprimer ce rendezvous validé ??", "Oui", "Non")) {
              try {
                  ws. DeleteRdvValide(p,y);
                  c3.remove();
                  c1.remove();
                  c2.remove();
                  listvalidatedForm  v= new  listvalidatedForm(previous);
                  v.show();
              } catch (ParseException ex) {
                
              }
          }
     });
  
    
    
add(c1);
 } 
else {

 Label lOption = new Label("you haven't any appointment valid ! ");

}
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
    

