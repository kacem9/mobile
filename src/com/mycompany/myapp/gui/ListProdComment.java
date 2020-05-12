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
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.InfiniteContainer;
import com.codename1.ui.Label;
import com.codename1.ui.Slider;
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.geom.Dimension;


import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Comment;


import com.mycompany.myapp.services.ServiceComment;
import com.mycompany.myapp.utils.Rating;



import java.util.ArrayList;




/**
 *
 * @author bhk
 */
public class ListProdComment extends Form{
    private Resources theme;
    Form previous;
  //  int nombreAleatoire = 20 + (int)(Math.random() * ((5 - 2) + 1));
      
       
       

    public ListProdComment(Form previous,int id) {
        ArrayList<Comment> velos=ServiceComment.getInstance().findProd(id);
         theme = UIManager.initFirstTheme("/theme_1");
        setTitle("comment");
      
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
                if (index + amount > velos.size()) {
                    amount = velos.size() - index;
                }
                if (amount <= 0) {
                    return null;
                }
                
                 EncodedImage placeholder = EncodedImage.createFromImage(theme.getImage("notes.png"), true);
                Component[] elements = new Component[velos.size()];
                int nb = 0;

                
String url="http://localhost/VeloSymfonyIntegre/Velo/web/uploads/admin/"+velos.get(0).getPhoto();
  URLImage background = URLImage.createToStorage(placeholder, url,
                url);
        Container element1 = new Container(BoxLayout.y());
       Container line = new Container(new FlowLayout());
        
        
        ImageViewer img = new ImageViewer(background);
                    line.add(img);
                    element1.add(line);
                    add(element1);
                    //Creating custom container
                    int s=1;
                    for (Comment p : velos) {
                    Container element = new Container(BoxLayout.y());
                    Container line1 = new Container(BoxLayout.y());
                    Container line2 = new Container(new FlowLayout());
                    
                    String[] filter = new String[] {"blue", "red","green","yellow"};
                    String etoiless = "*****";
                    String comment=p.getComment();
                    
                                    
                      
                   
                        String com=comment.replace('o','*');

    
                  
                                    
                    
                    
                   
                     
                     Label nameLabe2 = new Label(com);
                     Label nameLabe3 = new Label(p.getDatePublication());
                     
                     
                   
       
       
       
       // ImageViewer img2 = new ImageViewer(background2);
        
        //add(img);
       // add(img2);
        
       // show();
                  //  Label ageLabel = new Label(p.getId());
                    //Label ageLabel1 = new Label(p.getPrice());
                    //Label ageLabel2 = new Label(p.getQuantity());
               //     Label ageLabel3 = new Label((p.get("numTel"));

                    //Label ageLabel4 = new Label(p.getDateLivraison());
                    
                    Label ps = new Label("Comment N° "+s+" :");
                    ps.getAllStyles().set3DText(true, true);
                    ps.getAllStyles().setFgColor(ColorUtil.rgb(30,144,255));
                    

                    //line2.add(ageLabel);
                    //line2.add(nameLabel);
                    line2.add(nameLabe2);
                   
                    line2.add(nameLabe3);
                    //line2.add(ageLabel2);
                    
                   
                 
                     
                     
                     
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
                    s++;
                    
                    }
                    
                
                return elements;
            }
        };
          
          TextField tfcomment = new TextField("","comment");
         
        list.setScrollableY(false);
        
      add(list);
      
         
       add(tfcomment);
        //Rating.getInstance().showStarPickingForm();
        Slider starRank = new Slider();
    starRank.setEditable(true);
    starRank.setMinValue(0);
    starRank.setMaxValue(10);
    Font fnt = Font.createTrueTypeFont("native:MainLight", "native:MainLight").
            derive(Display.getInstance().convertToPixels(5, true), Font.STYLE_PLAIN);
    Style s = new Style(0xffff33, 0, fnt, (byte)0);
    Image fullStar = FontImage.createMaterial(FontImage.MATERIAL_STAR, s).toImage();
    s.setOpacity(100);
    s.setFgColor(0);
    Image emptyStar = FontImage.createMaterial(FontImage.MATERIAL_STAR, s).toImage();
    initStarRankStyle(starRank.getSliderEmptySelectedStyle(), emptyStar);
    initStarRankStyle(starRank.getSliderEmptyUnselectedStyle(), emptyStar);
    initStarRankStyle(starRank.getSliderFullSelectedStyle(), fullStar);
    initStarRankStyle(starRank.getSliderFullUnselectedStyle(), fullStar);
    starRank.setPreferredSize(new Dimension(fullStar.getWidth() * 5, fullStar.getHeight()));
       
    add(starRank);
    
    
        Button b = new Button("Add Comment");
        FontImage.setMaterialIcon(b, FontImage.MATERIAL_ADD);
          
         
          b.getUnselectedStyle().setBgTransparency(255);
        b.getStyle().setMargin(20, 20, 20, 20);
                    add(b);
                    Comment c= new Comment();
                     starRank.addActionListener((evt1) -> {
                   
                       System.out.println(starRank.getProgress());  
                     b.addActionListener((evt) -> {
                         Label sp=new Label();
      
          add(sp);
                  
                    sp.setText("your comment : "+tfcomment.getText());
                   
                    c.setId_user(15);
                    
                    c.setId_Prod(velos.get(0).getId());
                    
                    c.setComment(tfcomment.getText());
                        double rte=starRank.getProgress()/2;
                         Label ps1 = new Label("your rate is : "+rte+" /5");
                         add(ps1);
                    c.setRate(rte+"");
                    
                    if( ServiceComment.getInstance().addComment(c.getId_user(),c.getId_Prod(), c.getComment(),c.getDatePublication(),c.getRate()))
                           Dialog.show("Success","Comment added",new Command("OK"));
                    else
                          Dialog.show("ERROR", "Server error", new Command("OK"));
                      
                         //  Dialog.show("Success","Comment added",new Command("OK"));
                           
                  
             
                    
                });
                     
                   
                   });
      
              getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());

       }
      private void initStarRankStyle(Style s, Image star) {
    s.setBackgroundType(Style.BACKGROUND_IMAGE_TILE_BOTH);
    s.setBorder(Border.createEmpty());
    s.setBgImage(star);
    s.setBgTransparency(0);
}
      
    }
    
    

