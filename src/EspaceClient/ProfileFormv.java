/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EspaceClient;

import Entites.FosUser;
import Gui.ReparationsForm;
import com.codename1.components.FloatingActionButton;
import com.codename1.components.ImageViewer;
import com.codename1.components.MultiButton;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.gui.HomeForm;
import com.mycompany.myapp.gui.HomeFormClient;
import utils.SessionUser;

/**
 *
 * @author root
 */
public class ProfileFormv extends SideMenuBaseForm {
    FosUser u;
     private Resources theme;
    public ProfileFormv(Resources res) {
        super(BoxLayout.y());
        Toolbar tb = getToolbar();
        tb.setTitleCentered(false);
  

//        System.out.println(SessionUser.getUser().getId());
        Button menuButton = new Button("");
        menuButton.setUIID("Title");
        FontImage.setMaterialIcon(menuButton, FontImage.MATERIAL_AC_UNIT);
        menuButton.addActionListener(e -> getToolbar().openSideMenu());
        
        
       
        

        Container titleCmp = BoxLayout.encloseY(
                        FlowLayout.encloseIn(menuButton),
                 new Label("VELO.TN", "CenterTitle")
                        
                       
                );
        
        
       
        tb.setTitleComponent(titleCmp);
                     
      Button velos = new Button("Achat de vélos ");
        
         velos.addActionListener(e ->  new HomeFormClient(theme).show());
        
         Button Ventevelos = new Button("vente de velos");
        
         Ventevelos.addActionListener(e -> new HomeForm().show());
        setupSideMenu(res);
        add(velos);
        add(Ventevelos);
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
    protected void showLocationsForm(Resources res) {
        new LocationFormV(res).show(); 
     }
     @Override
    protected void showEventForm(Resources res) {
        new EventForm(res).show();
    }
        @Override
    protected void showReparationsForm(Resources res) {
     
        new ReparationsForm(res).show();
    }}


