/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.location.Geofence;
import com.codename1.location.Location;
import com.codename1.location.LocationManager;
import com.codename1.notifications.LocalNotification;
import com.codename1.push.PushAction;
import com.codename1.ui.Button;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.utils.BackgroundLocationDemo;
import com.mycompany.myapp.utils.GeofenceListenerImpl;

/**
 *
 * @author bhk
 */
public class HomeFormClient extends SideMenuBaseForm{
SideMenuBaseForm current;
    public HomeFormClient(Resources res) {
       
        current=this;
        
          //super(BoxLayout.y());
        
        Toolbar tb = getToolbar();
        tb.setTitleCentered(false);
       

        Button menuButton = new Button("");
        menuButton.setUIID("Title");
        FontImage.setMaterialIcon(menuButton, FontImage.MATERIAL_MENU);
        menuButton.addActionListener(e -> getToolbar().openSideMenu());
        
        
       
        

        Container titleCmp = BoxLayout.encloseY(
                        FlowLayout.encloseIn(menuButton),
                new Label(" Home Velos", "CenterTitle")
                        
                       
                );
        
        
       
        tb.setTitleComponent(titleCmp);
                        
      
        
        FontImage arrowDown = FontImage.createMaterial(FontImage.MATERIAL_KEYBOARD_ARROW_DOWN, "Label", 3);
        
        
        current.setupSideMenu(res);
        
        current.add(new Label("Choose an option"));
        current.setLayout(BoxLayout.y());
        
        ////////////////////////////////////
        
       // setTitle("Home");
       
        
        
       // Button btnAddTask = new Button("Add Task");
         Button btnAddCmd = new Button("Add  commande");
        Button btnPanier = new Button("Panier");
         Button btnListvelos = new Button("List Velos");
         Button btnWishList = new Button("wishlist");
          Button btnProdList = new Button("list produits");
          
           
          FontImage.setMaterialIcon(btnAddCmd, FontImage.MATERIAL_ADD_COMMENT);
        FontImage.setMaterialIcon(btnPanier, FontImage.MATERIAL_SHOPPING_CART);
         FontImage.setMaterialIcon(btnListvelos, FontImage.MATERIAL_DIRECTIONS_BIKE);
          FontImage.setMaterialIcon(btnWishList, FontImage.MATERIAL_EMOJI_EMOTIONS);
           FontImage.setMaterialIcon(btnProdList, FontImage.MATERIAL_SPORTS_MOTORSPORTS);
        btnAddCmd.getUnselectedStyle().setBgTransparency(255);
        btnWishList.getUnselectedStyle().setBgTransparency(255);
        btnProdList.getUnselectedStyle().setBgTransparency(255);
         btnPanier.getUnselectedStyle().setBgTransparency(255);
         btnListvelos.getUnselectedStyle().setBgTransparency(255);
        btnAddCmd.getStyle().setMargin(50, 50, 70, 70);
        btnWishList.getStyle().setMargin(50, 50, 70, 70);
        btnProdList.getStyle().setMargin(50, 50, 70, 70);
        btnPanier.getStyle().setMargin(50, 50, 70, 70);
        btnListvelos.getStyle().setMargin(50, 50, 70, 70);
       // btnAddCmd.getStyle().setBorder(Border.createDashedBorder(CENTER,CENTER ));
       // btnPanier.getStyle().setBorder(Border.createDashedBorder(CENTER, CENTER));
        
        
         btnAddCmd.addActionListener(e->new AddCommandeForm(current).show());
        btnPanier.addActionListener((e)-> { LocalNotification n = new LocalNotification();
        n.setId("notification");
        n.setAlertBody("Your command is not passed yet");
        n.setAlertTitle("Continue your purchase !!");
        //n.setAlertSound("/notification_sound_bells.mp3"); //file name must begin with notification_sound


        Display.getInstance().scheduleLocalNotification(
                n,
                System.currentTimeMillis() + 10 * 1000, // fire date/time
                LocalNotification.REPEAT_MINUTE  // Whether to repeat and what frequency
        ); 
        new PanierClient(current).show();
        });
        btnWishList .addActionListener(e-> new ListVelosWishClient(current).show());
         btnListvelos .addActionListener(e-> new ListVelosFormClient(current).show());
         // btnAddVelos .addActionListener(e-> new AddVeloForm(current).show());
         btnProdList.addActionListener(e-> new ListProduitsFormClient(current).show());
        current.addAll(btnAddCmd,btnListvelos,btnWishList,btnPanier,btnProdList);
        
       // Form home = new Form("Home");
       // Form listCommande = new ListCommandesForm(current);
        Form ajoutCommande = new AddCommandeForm(current);
        Form listVelos=new ListVelosFormClient(current);
        Form listwish=new ListVelosWishClient(current);
        Form listproduits=new ListProduitsFormClient(current);
        //Form addVelo=new AddVeloForm(current);
        
//        f1.getToolbar().addCommandToLeftBar("back", FontImage.createMaterial(FontImage.MATERIAL_HOME, new Style()), (evt) -> {
//            this.showBack();
//        });
//        
//        f2.getToolbar().addCommandToLeftBar("back", FontImage.createMaterial(FontImage.MATERIAL_HOME, new Style()), (evt) -> {
//            this.showBack();
//        });
        
        ajoutCommande.getToolbar().addCommandToOverflowMenu("say hello", FontImage.createMaterial(FontImage.MATERIAL_ARROW_DROP_UP, new Style()), (evt) -> {
            System.out.println("Hello all");
        });
       
        
        listVelos.getToolbar().addCommandToOverflowMenu("say goodbye", FontImage.createMaterial(FontImage.MATERIAL_BORDER_HORIZONTAL, new Style()), (evt) -> {
            System.out.println("Goodbye");
        });
        
        
        //right home side menu 
        current.getToolbar().addCommandToRightBar("", FontImage.createMaterial(FontImage.MATERIAL_SHOPPING_CART, new Style()), (evt) -> {
          
      });
       
        
        
        current.getToolbar().addCommandToOverflowMenu("account :", null, (evt) -> {
            
            
            
           // listVelos.show();
        });
        
       
      //  this.show();
    }

    @Override
    protected void showEventForm(Resources res) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void showLocationsForm(Resources res) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void showHomeFormClient(Resources res) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void showReclamationsForm(Resources res) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void showReparationsForm(Resources res) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
