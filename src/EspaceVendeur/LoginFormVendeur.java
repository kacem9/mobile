/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EspaceVendeur;

import Gui.EventForm;
import Gui.LocationForm;
import Gui.SideMenuBaseForm;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;

/**
 *
 * @author HP
 */
public class LoginFormVendeur extends SideMenuBaseFormVendeur
{
    public LoginFormVendeur(Resources res) {
         super(BoxLayout.y());
        Toolbar tb = getToolbar();
        tb.setTitleCentered(false);
       

        Button menuButton = new Button("");
        menuButton.setUIID("Title");
        FontImage.setMaterialIcon(menuButton, FontImage.MATERIAL_MENU);
        menuButton.addActionListener(e -> getToolbar().openSideMenu());
        
        
       
        

        Container titleCmp = BoxLayout.encloseY(
                        FlowLayout.encloseIn(menuButton),
                 new Label("VELO.TN", "CenterTitle")
                        
                       
                );
        
        
       
        tb.setTitleComponent(titleCmp);
                     
      
        
        
        
        
        setupSideMenuBaseFormVendeur(res);
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
           new LocationVendeur(res).show();
    }
    
}


   

