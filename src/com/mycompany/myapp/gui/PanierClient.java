/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.charts.util.ColorUtil;
import com.codename1.components.ImageViewer;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.InfiniteContainer;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;

import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Panier;

import com.mycompany.myapp.entities.Velo;
import com.mycompany.myapp.entities.Wish;
import com.mycompany.myapp.services.ServiceCommande;
import com.mycompany.myapp.services.ServicePanier;
import com.mycompany.myapp.services.ServiceVelo;
import com.mycompany.myapp.services.ServiceWish;
import java.io.IOException;

import java.util.ArrayList;



/**
 *
 * @author bhk
 */
public class PanierClient extends Form{
    private Resources theme;
  //  int nombreAleatoire = 20 + (int)(Math.random() * ((5 - 2) + 1));
      ArrayList<Panier> wishs=ServicePanier.getInstance().getAllPanier();
       
       

    public PanierClient(Form previous) {
         theme = UIManager.initFirstTheme("/theme_1");
        setTitle("My cart");
      
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
                if (index + amount > wishs.size()) {
                    amount = wishs.size() - index;
                }
                if (amount <= 0) {
                    return null;
                }
                
                 EncodedImage placeholder = EncodedImage.createFromImage(theme.getImage("notes.png"), true);
                Component[] elements = new Component[wishs.size()];
                int nb = 0;
            ArrayList<Integer> qte=new ArrayList<>();
            ArrayList<Integer> prixTotal=new ArrayList<>();
                for (Panier w : wishs) {
String url="http://localhost/VeloSymfonyIntegre/Velo/web/uploads/admin/"+w.getPhoto();
                    //Creating custom container
                    
                    Container element = new Container(BoxLayout.y());
                    Container line1 = new Container(BoxLayout.y());
                    Container line2 = new Container(new FlowLayout());
                   
                     Label nameLabe2 = new Label(w.getNom());
                     TextField tfquantite=new TextField(1+"");
                     
                     Label nameLabe3 = new Label(tfquantite.getText());
                     Label nameLabe4 = new Label(w.getPrix()+"");
                     qte.add(1);
                     prixTotal.add(w.getPrix());
                     
                   
                   
       
       
       
       // ImageViewer img2 = new ImageViewer(background2);
        
        //add(img);
       // add(img2);
        
       // show();
                  //  Label ageLabel = new Label(p.getId());
                    //Label ageLabel1 = new Label(p.getPrice());
                    //Label ageLabel2 = new Label(p.getQuantity());
               //     Label ageLabel3 = new Label((p.get("numTel"));

                    //Label ageLabel4 = new Label(p.getDateLivraison());
                    
                    Label ps = new Label("Article N° "+nb+" :");
                    ps.getAllStyles().set3DText(true, true);
                    ps.getAllStyles().setFgColor(ColorUtil.rgb(255, 0, 0));
                   

                    //line2.add(ageLabel);
                   
                    line2.add(nameLabe2);
                    line1.add(tfquantite);
                    line2.add(nameLabe3);
                    line2.add(nameLabe4);
                   
                    //line2.add(ageLabel1);
                    //line2.add(ageLabel2);
                    
                     URLImage background = URLImage.createToStorage(placeholder, url,
                url);
        
       
        
        
        ImageViewer img = new ImageViewer(background);
                    line2.add(img);
//                    Button b = new Button("Add to Panier");
//                    line2.add(b);
//                     b.addActionListener((evt) -> {
//                   
//                    
//                      ServiceVelo.getInstance().deleteVelo(p.getId()); 
//                           Dialog.show("Success","Commande added",new Command("OK"));
//                  
//               
//                    
//                });
//                     
//                      Button b1 = new Button("Comment ");
//                    line2.add(b1);
//                     b1.addActionListener((evt) -> {
//                   
//                    
//                    //  ServiceVelo.getInstance().deleteVelo(p.getId()); 
//                           Dialog.show("Success","Commande added",new Command("OK"));
//                  
//               
//                    
//                });
                     
//                        Button b2 = new Button("Add to wishlist ");
//                    line2.add(b2);
//                     b2.addActionListener((ActionEvent evt) -> {
//    
////    try { 
////        ServiceWish.getInstance().addToWish(p.getId(),15, p.getDescription(), p.getPhoto());
////         Dialog.show("Success","Commande added",new Command("OK"));
////          ArrayList<Wish>xD=ServiceWish.getInstance().getAllwish();
////   for(Wish e:xD)
////                             System.out.println(e);
////    } catch (IOException ex) {
////        Dialog.show("Fail","Commande  not added",new Command("OK"));
////    }
//           
////       ArrayList<Wish>xD=ServiceWish.getInstance().getAllwish();
////      for(Wish e:xD)
////                             System.out.println(e);
//        
//        //  ServiceVelo.getInstance().deleteVelo(p.getId());
//        
//    
//                  
//               
//                    
//                });
                        
                    Button b2 = new Button("update data");
                         
                     b2.getUnselectedStyle().setBgTransparency(255);
        b2.getStyle().setMargin(20, 20, 30, 30);
                    line2.add(b2);
                     b2.addActionListener((ActionEvent evt) -> {
                         nameLabe3.setText(tfquantite.getText());
                         int valeurqte=Integer.parseInt(nameLabe3.getText());
                         int valeurprix=Integer.parseInt(nameLabe4.getText());
                         int valeurTotale=valeurqte*valeurprix;
                         nameLabe4.setText(valeurTotale+"");
                         qte.add(valeurqte);
                         prixTotal.add(valeurprix);
                         
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
                int prix=0;
                int total=0;
                for(Integer q :qte){
                    total=total+q;
                   
                }
                 for(Integer q :prixTotal){
                    prix=prix+q;
                   
                }
                 System.out.println("le total est :"+total);
                 Label ps = new Label("la quantite totale est :"+total+" produits");
                 
                  Label ps1 = new Label("le prix total est :"+prix+" $");
                    
          Button b2 = new Button("update all");
                         
                     b2.getUnselectedStyle().setBgTransparency(255);
        b2.getStyle().setMargin(20, 20, 30, 30);
                    add(b2);
                     b2.addActionListener((ActionEvent evt) -> {
                         ArrayList<Integer> qte1=new ArrayList<>();
            ArrayList<Integer> prixTotal1=new ArrayList<>();
                          for (Panier w1 : wishs) {
                         // qte.add(w1.getQuantite());
                     //prixTotal.add(w1.getPrix());
                     
                     int prix1=0;
                int total1=0;
                for(Integer q :qte){
                    total1=total1+q;
                   
                }
                 for(Integer q :prixTotal){
                    prix1=prix1+q;
                   
                }
                 System.out.println("le total est :"+total1+" articles");
                 ps.setText("la quantité totale est :"+total1+" articles");
                 ps1.setText("le prix total est :"+prix1+" $");
                 
                    
                         
                     }});
                          
                          
                Button b3 = new Button("Checkout");
                         
                     b3.getUnselectedStyle().setBgTransparency(255);
        b3.getStyle().setMargin(20, 20, 30, 30);
                    add(b3);
                     b3.addActionListener((ActionEvent evt) -> {
                     new AddCommandeForm(previous).show();
                     
                     
                     });
         
         
                     
                     
                     
                  add(ps);
                 add(ps1);
                 
                 
                 
                return elements;
            }
        };
        list.setScrollableY(false);
      add(list);
      
              getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());

       }
      
      
    }
    
    

