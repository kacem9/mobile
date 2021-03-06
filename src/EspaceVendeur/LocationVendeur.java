/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EspaceVendeur;

import Evenement.AjoutEventForm;
import Evenement.ListEventForm;
import Gui.EventForm;
import Gui.LocationForm;
import Gui.ReclamationsForm;
import Gui.ReparationsForm;
import Gui.SideMenuBaseForm;
import Gui.VelosForm;
import EspaceVendeur.ListVelos;
import com.codename1.ui.Button;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.util.Resources;

/**
 *
 * @author HP
 */
public class LocationVendeur extends SideMenuBaseFormVendeur{
     private static final int[] COLORS = {0xf8e478, 0x60e6ce, 0x878aee};
    private static final String[] LABELS = {"Design", "Coding", "Learning"};

    public LocationVendeur(Resources res) {
        
        
         super(BoxLayout.y());
        
        Toolbar tb = getToolbar();
        tb.setTitleCentered(false);
       

        Button menuButton = new Button("");
        menuButton.setUIID("Title");
        FontImage.setMaterialIcon(menuButton, FontImage.MATERIAL_MENU);
        menuButton.addActionListener(e -> getToolbar().openSideMenu());

        Container titleCmp = BoxLayout.encloseY(
                        FlowLayout.encloseIn(menuButton),
                new Label("Bikes", "CenterTitle")
                        
                       
                );

        tb.setTitleComponent(titleCmp);

        FontImage arrowDown = FontImage.createMaterial(FontImage.MATERIAL_KEYBOARD_ARROW_DOWN, "Label", 3);

        setupSideMenuBaseFormVendeur(res);
         Label lOption = new Label("Choisir option : ");
         Button Ajoutevent = new Button("Add Bike(s)");
         Button Affevent = new Button("List of  Bikes(s)");
          FontImage.setMaterialIcon(Ajoutevent, FontImage.MATERIAL_ADD_COMMENT);
        FontImage.setMaterialIcon(Affevent, FontImage.MATERIAL_VIEW_LIST);
        Ajoutevent.getStyle().setBorder(Border.createDashedBorder(CENTER,CENTER ));
        Affevent.getStyle().setBorder(Border.createDashedBorder(CENTER, CENTER));
         Ajoutevent.setUIID("SkipButton");
        Affevent.setUIID("SkipButton");
         Container southLayout = BoxLayout.encloseY(
                       
                     lOption,   Affevent,Ajoutevent
                );
        add(BorderLayout.south(
                southLayout
        ));
        Affevent.addActionListener((evt) -> {
         try {
                new ListVelos(this).show();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        Ajoutevent.addActionListener((evt) -> {
            new AddVeloL(this).show();
        });
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