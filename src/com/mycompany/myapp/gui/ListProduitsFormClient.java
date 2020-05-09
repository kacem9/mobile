/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.charts.util.ColorUtil;
import com.codename1.components.ImageViewer;
import com.codename1.components.ShareButton;
import com.codename1.facebook.FaceBookAccess;
import com.codename1.io.FileSystemStorage;
import com.codename1.share.FacebookShare;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.InfiniteContainer;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;

import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.ImageIO;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Comment;
import com.mycompany.myapp.entities.Produit;

import com.mycompany.myapp.entities.Velo;
import com.mycompany.myapp.entities.Wish;
import com.mycompany.myapp.services.ServiceComment;
import com.mycompany.myapp.services.ServiceProduit;

import com.mycompany.myapp.services.ServiceVelo;
import com.mycompany.myapp.services.ServiceWish;
import java.io.IOException;
import java.io.OutputStream;

import java.util.ArrayList;



/**
 *
 * @author bhk
 */
public class ListProduitsFormClient extends Form{
    private Resources theme;
  //  int nombreAleatoire = 20 + (int)(Math.random() * ((5 - 2) + 1));
      ArrayList<Produit> Produits=ServiceProduit.getInstance().getAllProduits();
       
       

    public ListProduitsFormClient(Form previous) {
         theme = UIManager.initFirstTheme("/theme_1");
        setTitle("List Produits");
      
//       for(int i=0;i<velos.size();i++){
//             SpanLabel sp1 = new SpanLabel();
//            sp1.setText(velos.get(i).toString());
//         add(sp1);
//         
          Container list = new InfiniteContainer() {
            @Override
            public Component[] fetchComponents(int index, int amount) {
                if (index == 0) {
                 
                }
                if (index + amount > Produits.size()) {
                    amount = Produits.size() - index;
                }
                if (amount <= 0) {
                    return null;
                }
                
                 EncodedImage placeholder = EncodedImage.createFromImage(theme.getImage("notes.png"), true);
                Component[] elements = new Component[Produits.size()];
                int nb = 0;

                for (Produit p : Produits) {
String url="http://localhost/VeloSymfonyIntegre/Velo/web/uploads/admin/"+p.getPhoto();
                    //Creating custom container
                    
                    Container element = new Container(BoxLayout.y());
                    Container line1 = new Container(BoxLayout.y());
                    Container line2 = new Container(new FlowLayout());
                    Label nameLabel = new Label(p.getPhoto());
                     
                     Label nameLabe2 = new Label("model :"+p.getModel());
                      Label nameLabe3 = new Label("price :"+p.getPrice()+" $");
                       Label nameLabe4 = new Label("quantity :"+p.getQuantity());
                        
                        
         ImageViewer img1=new ImageViewer(theme.getImage("outofstock.png"));
        
                       // nameLabe5.getAllStyles().setBgColor(ColorUtil.rgb(255, 0, 0));
                  
                      if(p.getQuantity().equals("0")){
                           line1.add(img1);
                        
                        
                      }
                        
                     
                     
                   
       
       
       
       // ImageViewer img2 = new ImageViewer(background2);
        
        //add(img);
       // add(img2);
        
       // show();
                  //  Label ageLabel = new Label(p.getId());
                    //Label ageLabel1 = new Label(p.getPrice());
                    //Label ageLabel2 = new Label(p.getQuantity());
               //     Label ageLabel3 = new Label((p.get("numTel"));

                    //Label ageLabel4 = new Label(p.getDateLivraison());
                    
                    Label ps = new Label("Velo N° "+nb+" :");
                    ps.getAllStyles().set3DText(true, true);
                    ps.getAllStyles().setFgColor(ColorUtil.rgb(255, 0, 0));
                    

                    //line2.add(ageLabel);
                   // line2.add(nameLabel);
                    line2.add(nameLabe2);
                    line2.add(nameLabe3);
                    line2.add(nameLabe4);
                    
                   
                    //line2.add(ageLabel1);
                    //line2.add(ageLabel2);
                    
                     URLImage background = URLImage.createToStorage(placeholder, url,
                url);
        
       
        
        
        ImageViewer img = new ImageViewer(background);
                    line2.add(img);
                    Button b = new Button("Add to Panier");
                    line2.add(b);
                     b.addActionListener((evt) -> {
                   
                    
                      ServiceVelo.getInstance().deleteVelo(p.getId()); 
                           Dialog.show("Success","Commande added",new Command("OK"));
                  
               
                    
                });
                     
                      Button b1 = new Button("Comment ");
                    line2.add(b1);
                     b1.addActionListener((evt) -> {
                         new ListProdComment(previous,p.getId()).show();
                   ServiceComment.getInstance().findProd(p.getId());
                   ArrayList<Comment>xD=ServiceComment.getInstance().findProd(p.getId());
   for(Comment e:xD)
                            System.out.println(e.getPhoto()+""+e.getComment());
                            
    
                 
                    
                    //  ServiceVelo.getInstance().deleteVelo(p.getId()); 
                        //   Dialog.show("Success","Commande added",new Command("OK"));
                  
               
                    
                });
                     
                     ShareButton sb = new ShareButton();
                     
//                     sb.setImageToShare(p.getPhoto(), "image/png");
//                     FaceBookAccess.setClientId("124a41af3060e90190aa83b489253f34");
                     //FaceBookAccess.setClientSecret("80b5d5a63a095e23690e07025b88db7a");
//                    FacebookShare fb=new FacebookShare();
                     line2.add(sb);
                     b1.addActionListener((evt) -> {
                         
                         //Form hi = new Form("ShareButton");

//hi.add(sb);

Image screenshot = Image.createImage(element.getWidth(), element.getHeight());
element.revalidate();
element.setVisible(true);
element.paintComponent(screenshot.getGraphics(), true);



//                 fb.share("tt");
                    //  ServiceVelo.getInstance().deleteVelo(p.getId()); 
                          // Dialog.show("Success","Commande added",new Command("OK"));
                 });       
               
                        Button b2 = new Button("Add to wishlist ");
                    line2.add(b2);
                     b2.addActionListener((ActionEvent evt) -> {
    
   try { 
        ServiceWish.getInstance().addToWish(p.getId(),15, p.getModel(), p.getPhoto());
        Dialog.show("Success","Commande added",new Command("OK"));
        ArrayList<Wish>xD=ServiceWish.getInstance().getAllwish();
   for(Wish e:xD)
                            System.out.println(e);
    } catch (IOException ex) {
        Dialog.show("Fail","Commande  not added",new Command("OK"));
    }
           
//       ArrayList<Wish>xD=ServiceWish.getInstance().getAllwish();
//      for(Wish e:xD)
//                             System.out.println(e);
        
        //  ServiceVelo.getInstance().deleteVelo(p.getId());
        
    
                  
               
                    
                });
                     
                     
                     
                    element.addAll(ps,line1,line2);

               
                    
                  /*  Button b = new Button("button");
                    b.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            Dialog.show("Info", p.getAdresse() + " and email : " + p.getAdresse2() + " years", "ok", null);
                        }
                    });
                    element.setLeadComponent(b);
                 */   elements[nb] = element;

                    //Using MultiButton
                    /*MultiButton mb = new MultiButton(p.getNom());
                    mb.setTextLine2(Integer.toString(p.getAge()));
                    mb.setTextLine3("Never show Id");
                    elements[i]=mb;*/
                    nb++;

                }
                return elements;
            }
        };
        list.setScrollableY(false);
      add(list);
      
              getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());

       }
      
      
    }
    
    

