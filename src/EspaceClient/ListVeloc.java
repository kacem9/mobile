/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EspaceClient;

import Entites.Panier;
import Entites.Velo;
import EspaceVendeur.UpdateVelo;
import Services.PanierServices;
import Services.ServiceVelos;
import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.components.ToastBar;
import com.codename1.l10n.ParseException;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
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
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import java.util.ArrayList;
import utils.SessionUser;

/**
 *
 * @author HP
 */
public class ListVeloc extends Form {
    
      Image  img;
    
      private void initStarRankStyle(Style s, Image star) {
    s.setBackgroundType(Style.BACKGROUND_IMAGE_TILE_BOTH);
    s.setBorder(Border.createEmpty());
    s.setBgImage(star); 
   s.setBgTransparency(0);
     }
    public ListVeloc(Form previous)throws ParseException {
        super(BoxLayout.y());
        
        Toolbar tb = getToolbar();
        tb.setTitleCentered(false);
      
        Container titleCmp = BoxLayout.encloseY(
                        
                new Label("Liste des velos", "CenterTitle")
                        
                       
                );
        
        
       
        tb.setTitleComponent(titleCmp);
   FontImage arrowDown = FontImage.createMaterial(FontImage.MATERIAL_AC_UNIT, "Label", 3);
              EncodedImage enc ;
       ServiceVelos se = new ServiceVelos();
       ArrayList<Velo> lis = se.getAllVelos();
       { for(int i = 0; i<lis.size(); i++) {
             Container c2 = new Container(BoxLayout.x()); 
            Container c1 = new Container(BoxLayout.x());
            Container c3 = new Container(BoxLayout.y());
          //  Button btnsupp = new Button("Delete card");
    Label ll = new Label("Velo n°"+i+":");
    c2.add(ll);
                   add(c2);
            ImageViewer iv = new ImageViewer();
            System.out.println(lis.get(i).getPhoto());
            Image placeholder = Image.createImage(this.getWidth() / 3 - 3, this.getWidth() / 3- 3, 0xbfc9d2);
            EncodedImage encImage = EncodedImage.createFromImage(placeholder, false);
           //  img = Image.createImage(FileSystemStorage.getInstance().openInputStream(path))
            ImageViewer img1 = new ImageViewer(URLImage.createToStorage(encImage, "file" + lis.get(i).getPhoto(),
            "http://127.0.0.1/Velo/web/images/"+lis.get(i).getPhoto()));
            
            //http://127.0.0.1/symfony/Velo/web/images/
            Button addcard = new Button("Add to card ");
           
            FontImage.setMaterialIcon(addcard, FontImage.MATERIAL_UPLOAD_FILE);
            Label l2 = new Label("Description: " + lis.get(i).getDescription());
            Label l3 = new Label("Date circulation: " + lis.get(i).getDate_circulation());
            Label l4 = new Label("Localisation: " + lis.get(i).getLocalitsation_velo());
            Label l5 = new Label("Quantity: " + lis.get(i).getQuantity());
             String des = lis.get(i).getDescription();
              String date = lis.get(i).getDate_circulation();
                     String image = lis.get(i).getPhoto();
                    
               String localisation = lis.get(i).getLocalitsation_velo();
                String quantity = String.valueOf(lis.get(i).getQuantity());
               
                   System.out.println(quantity);
                   String price_location =String.valueOf( lis.get(i).getPrice_location());
            c1.add(img1);
            c1.add(c3);
                   System.out.println(SessionUser.getUser().getId());
            c3.add(new SpanLabel("Price:" + lis.get(i).getPrice_location()));
            c3.add(l2);
            c3.add(l3);
            c3.add(l4);
            c3.add(l5);
TextField   txtQte = new TextField();
            txtQte.setHint("Quantité");
            TextField tf = new TextField();
             
            c3.add(txtQte);
            c3.add(addcard);
           // c3.add(btnsupp);
          
            
            int id = lis.get(i).getId();
         
            addcard.addActionListener((evt) -> {

                    PanierServices ps = new PanierServices();
                    Panier p = new Panier();
                    System.out.println("idp " + id);
                    p.setId(id);
                  p.setIdu(SessionUser.getUser().getId());
                    p.setQte(txtQte.getText());
                    System.out.println(txtQte.getText());
                    p.setProdImg(image);
                    p.setLibelle(des);
                    p.setPrix(Double.valueOf(price_location));
                    p.setPrixTot(Double.valueOf(price_location) * Integer.valueOf(txtQte.getText()));
                    System.out.println("p " + p.toString());
                   // ps.addPanier(p, SessionUser.getUser().getId());
                   ps.addPanier(p,SessionUser.getUser().getId());
                    AfficherPanier afp = new AfficherPanier();
         
           

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
