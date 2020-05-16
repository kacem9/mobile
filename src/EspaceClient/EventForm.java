/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EspaceClient;

import Evenement.AjoutEventForm;
import Evenement.ListEventForm;
import Gui.ReparationsForm;
import com.codename1.ui.BrowserWindow;

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
 * @author root
 */
public class EventForm extends SideMenuBaseForm{
     private static final int[] COLORS = {0xf8e478, 0x60e6ce, 0x878aee};
    private static final String[] LABELS = {"Design", "Coding", "Learning"};

    public EventForm(Resources res) {
        super(BoxLayout.y());
        
        Toolbar tb = getToolbar();
        tb.setTitleCentered(false);
       

        Button menuButton = new Button("");
        menuButton.setUIID("Title");
        FontImage.setMaterialIcon(menuButton, FontImage.MATERIAL_MENU);
        menuButton.addActionListener(e -> getToolbar().openSideMenu());

        Container titleCmp = BoxLayout.encloseY(
                        FlowLayout.encloseIn(menuButton),
                new Label("Evenements", "CenterTitle")
                        
                       
                );

        tb.setTitleComponent(titleCmp);

        FontImage arrowDown = FontImage.createMaterial(FontImage.MATERIAL_KEYBOARD_ARROW_DOWN, "Label", 3);

        setupSideMenu(res);
         Label lOption = new Label("Choisir option : ");
        
         Button Affevent = new Button("Afficher Evenement(s)");
       
        FontImage.setMaterialIcon(Affevent, FontImage.MATERIAL_VIEW_LIST);
    
        Affevent.getStyle().setBorder(Border.createDashedBorder(CENTER, CENTER));
         
        Affevent.setUIID("SkipButton");
         Container southLayout = BoxLayout.encloseY(
                       
                     lOption,   Affevent
                );
        add(BorderLayout.south(
                southLayout
        ));
        Affevent.addActionListener((evt) -> {
         try {
                new ListEventFormClient(this).show();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        Container espace=new Container(BoxLayout.x());
         Label lab1 = new Label("                     ");
         espace.add(lab1);
         add(espace);
         Container espace1=new Container(BoxLayout.x());
         Label lab2 = new Label("                     ");
         espace1.add(lab2);
         add(espace1);
         Container espace2=new Container(BoxLayout.x());
         Label lab3 = new Label("                     ");
         
         espace1.add(lab3);
         add(espace2);

        Container co=new Container(BoxLayout.x());
         Label contact=new Label("Contact us :");
         co.add(contact);
         add(co);
         Container c=new Container(BoxLayout.x());
          Label MailIcon = new Label("velo@esprit.tn");
       FontImage.setMaterialIcon(MailIcon, FontImage.MATERIAL_MAIL, 3);
       c.add(MailIcon);
        Container c1=new Container(BoxLayout.x());
         Label TelIcon = new Label("58491039");
       FontImage.setMaterialIcon(TelIcon, FontImage.MATERIAL_SMARTPHONE, 3);
       c1.add(TelIcon);
       Container c2=new Container(BoxLayout.x());
       Label MapIcon = new Label("Z.I.ChotranaII B.P.160 Pôle Technologique ");
       FontImage.setMaterialIcon(MapIcon, FontImage.MATERIAL_PLACE, 3);
       c2.add(MapIcon);
       Container c3=new Container(BoxLayout.x());
       Label a=new Label("El Ghazela - Ariana 2083");
       Button b=new Button("View Map");
       
       b.addActionListener(e->{
        BrowserWindow win = new BrowserWindow("https://www.google.com/maps/place/ESPRIT/@36.8992777,10.1874516,17z/data=!3m1!4b1!4m5!3m4!1s0x12e2cb75abef9f39:0xb7b85ec579f3acb!8m2!3d36.8992777!4d10.1896403");
            win.addCloseListener(evt->{
                System.out.println("Browser was closed");
            });
            win.addLoadListener(evt->{
                System.out.println("Loaded page "+evt.getSource());
            });
                 win.setTitle("Esprit");
                 win.show();
        });
            
               c3.addAll(a,b);
       addAll(c,c1,c2,c3); 
        Container co2=new Container(BoxLayout.x());
       
       //icones
      
        Label CopyrightIcon = new Label("2020 All rights reserved |");
       FontImage.setMaterialIcon(CopyrightIcon, FontImage.MATERIAL_COPYRIGHT, 3);
       add(CopyrightIcon);
       Container c5=new Container(BoxLayout.x());
       Label m=new Label("This Website is made with");
       Label loveIcon = new Label("by DEFENDERS");
       FontImage.setMaterialIcon(loveIcon, FontImage.MATERIAL_FAVORITE, 3);
       c5.addAll(m,loveIcon);
       add(c5);
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
        new LocationFormV(res).show();
    }
          @Override
    protected void showReparationsForm(Resources res) {
     
        new ReparationsForm(res).show();
    }}


