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
import com.mycompany.myapp.services.ServiceCommande;

import java.util.ArrayList;
//import java.util.Iterator;

/**
 *
 * @author bhk
 */
public class ListCommandesForm extends Form{
ArrayList<Commande>comands = ServiceCommande.getInstance().getAllCommandes();
    public ListCommandesForm(Form previous) {
        setTitle("List Commndes");
       
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
       
        Container list = new InfiniteContainer() {
            @Override
            public Component[] fetchComponents(int index, int amount) {
                if (index == 0) {
                 
                }
                if (index + amount > comands.size()) {
                    amount = comands.size() - index;
                }
                if (amount <= 0) {
                    return null;
                }
                
                
                Component[] elements = new Component[comands.size()];
                int nb = 0;

                for (Commande p : comands) {

                    //Creating custom container
                  
                    Container element = new Container(BoxLayout.y());
                    Container line1 = new Container(BoxLayout.y());
                    Container line2 = new Container(BoxLayout.y());
                    Label adresse=new Label("adresse :" );
                    adresse.getAllStyles().setFgColor(ColorUtil.rgb(108	,178,	108));
                    Label nameLabel = new Label(p.getAdresse());
                    
                    Label adresse1=new Label("adresse mail :");
                    adresse1.getAllStyles().setFgColor(ColorUtil.rgb(108	,178,	108));
                    Label ageLabel = new Label(p.getAdresse2());
                    Label adresse2=new Label("code postal :");
                    adresse2.getAllStyles().setFgColor(ColorUtil.rgb(108	,178,	108));
                    Label ageLabel1 = new Label(p.getCodePostal());
                    Label adresse3=new Label("ville :");
                    adresse3.getAllStyles().setFgColor(ColorUtil.rgb(108	,178,	108));
                    Label ageLabel2 = new Label(p.getVille());
               //     Label ageLabel3 = new Label((p.get("numTel"));

                    //Label ageLabel4 = new Label(p.getDateLivraison());
                    
                    Label ps = new Label("commande N° "+nb+" :");
                    ps.getAllStyles().set3DText(true, true);
                    ps.getAllStyles().setFgColor(ColorUtil.rgb(255, 0, 0));
                    
                    line2.add(adresse);
                    line2.add(ageLabel);
                    line2.add(adresse1);
                    line2.add(nameLabel);
                    line2.add(adresse2);
                    line2.add(ageLabel1);
                    line2.add(adresse3);
                    line2.add(ageLabel2);
                    Button b = new Button("Supprimer");
                    line2.add(b);
                     b.addActionListener((evt) -> {
                   
                    
                      ServiceCommande.getInstance().deleteCommande(p.getId()); 
                           Dialog.show("Success","Commande added",new Command("OK"));
                  
               
                    
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
