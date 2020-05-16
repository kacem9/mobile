/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.Command;

import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;

import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.InfiniteContainer;
import com.codename1.ui.Label;

import com.codename1.ui.layouts.BoxLayout;

import com.mycompany.myapp.entities.Commande;
import com.mycompany.myapp.entities.Count;
import com.mycompany.myapp.services.ServiceCommande;
import com.mycompany.myapp.services.ServiceStatistique;

import java.util.ArrayList;
//import java.util.Iterator;

/**
 *
 * @author bhk
 */
public class ListStatCategories extends Form{
ArrayList<Count>comands = ServiceStatistique.getInstance().getAllStat();
    public ListStatCategories(Form previous) {
        setTitle("List Categories");
       
        //System.out.println("");
       //Iterator iterator = ts.iterator(); 
       /*
     Form h = new Form("commendes :", new GridLayout(4));
     
       for(int i=0;i<ts.size();i++){
          // System.out.println(iterator.next().toString());
          Container element = new Container(BoxLayout.y());
     Form hi = new Form("commande N°: " +i, new BoxLayout(BoxLayout.Y_AXIS));
            
             SpanLabel sp1 = new SpanLabel(ts.get(i).getAdresse());
              SpanLabel sp2 = new SpanLabel(ts.get(i).getAdresse2());
              SpanLabel sp3 = new SpanLabel(ts.get(i).getCodePostal());
             
           
            
         hi.addAll(sp1,sp2,sp3);
         h.add(hi);
         
       }
       */
       // TextField txt=new TextField("","Rechercher ...", 20, TextField.ANY);
       // txt.addActionListener(a);
       
        

                
               

                    //Creating custom container
                  
                    Container element = new Container(BoxLayout.y());
                    Container line1 = new Container(BoxLayout.y());
                    Container line2 = new Container(BoxLayout.y());
                    Label adresse=new Label("categories :" );
                    adresse.getAllStyles().setFgColor(ColorUtil.rgb(108	,178,	108));
                    
                    Label coun=new Label(" categorie Sports Bike  :" +comands.get(0).getValue()+" velos");
                    Label coun1=new Label(" categorie Cyclocross Bike  :" +comands.get(1).getValue()+" velos");
                    Label coun2=new Label(" categorie Road Bike  :" +comands.get(2).getValue()+" velos");
                    Label coun3=new Label(" categorie Kids Bikes  :" +comands.get(3).getValue()+" velos");
                    Label coun4=new Label(" categorie Mountain Bikes  :" +comands.get(4).getValue()+" velos");
                 
                    
                    //Label ps = new Label("categorie N° "+nb+" :");
                    //ps.getAllStyles().set3DText(true, true);
                    //ps.getAllStyles().setFgColor(ColorUtil.rgb(255, 0, 0));
                    line2.add(coun);
                    line2.add(coun1);
                    line2.add(coun2);
                    line2.add(coun3);
                    line2.add(coun4);
                   // line2.add(adresse);
                   
                   
                    element.addAll(line1,line2);

               
                    
                  /*  Button b = new Button("button");
                    b.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            Dialog.show("Info", p.getAdresse() + " and email : " + p.getAdresse2() + " years", "ok", null);
                        }
                    });
                    element.setLeadComponent(b);
                 */  

                    //Using MultiButton
                    /*MultiButton mb = new MultiButton(p.getNom());
                    mb.setTextLine2(Integer.toString(p.getAge()));
                    mb.setTextLine3("Never show Id");
                    elements[i]=mb;*/
                   

                
               add(element);
      
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
    }
    
    
}
