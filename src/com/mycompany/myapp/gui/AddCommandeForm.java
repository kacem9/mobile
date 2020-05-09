/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;
import com.mycompany.myapp.entities.Commande;

import com.mycompany.myapp.services.ServiceCommande;



/**
 *
 * @author bhk
 */
public class AddCommandeForm extends Form{

 public AddCommandeForm(Form previous) {
       setTitle("Add a new commande");
       setLayout(BoxLayout.y());
      
      TextField tfprix = new TextField("","prix");
       TextField tfadresse2= new TextField("", "adresse2");
        TextField tfadresse = new TextField("","adresse");
          TextField tfVille = new TextField("","ville");
       TextField tfcodePostal= new TextField("", "codePostal");
         TextField tfnumTel = new TextField("","numTel");
         Picker tfdateLivraison = new Picker();
         tfdateLivraison.setType(Display.PICKER_TYPE_DATE);
         // tfdateLivraison = new ("","dateLivraison");
       TextField tfquantite= new TextField("", "quantite");
        
       Button btnValider = new Button("Add commande");
               btnValider.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
               if ((tfprix.getText().length()==0)||(tfadresse2.getText().length()==0) 
                       ||(tfadresse.getText().length()==0 )
                     ||(tfVille.getText().length()==0 )||(tfcodePostal.getText().length()==0)
                      ||(tfnumTel.getText().length()==0) ||(tfquantite.getText().length()==0))
                  Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
              else
              {
                  try {
                      //  Commande t = new Commande(Integer.parseInt(tfStatus.getText()), tfName.getText());
    Commande t1 = new  Commande(
            tfdateLivraison.getDate(),
          Integer.parseInt(tfprix.getText()),
           tfadresse2.getText(),
          tfadresse.getText(),
           tfVille.getText(),
          tfcodePostal.getText(),
          
           Integer.parseInt(tfnumTel.getText()),
            Integer.parseInt(tfquantite.getText()));
 
                       if( ServiceCommande.getInstance().addCommande(t1))
                           Dialog.show("Success","Commande added",new Command("OK"));
                    else
                          Dialog.show("ERROR", "Server error", new Command("OK"));
                 } catch (NumberFormatException e) {
                     Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                  }
                  
                }
              
              
           }
     });
        
      addAll(tfprix,tfadresse2,tfadresse,tfVille,tfcodePostal,tfnumTel,tfdateLivraison,tfquantite,btnValider);
     getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
               
  }
  
  
}
