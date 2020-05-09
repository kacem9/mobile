/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EspaceVendeur;

import Entites.Velo;
import Services.ServiceVelos;
import com.codename1.io.FileSystemStorage;
import com.codename1.ui.Button;
import com.codename1.ui.Calendar;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;
import java.io.IOException;

/**
 *
 * @author HP
 */
public class UpdateVelo extends Form{
    String path="";
    ServiceVelos sv=new ServiceVelos();
       public UpdateVelo(Form previous,String des,String date,String localisation,String quantity,String price_location,int id)
    {
        super(BoxLayout.y());
        
        Toolbar tb = getToolbar();
        tb.setTitleCentered(false);
      
        Container titleCmp = BoxLayout.encloseY(
                        
                new Label("Ajouter un Velo", "CenterTitle")
                        
                       
                );
        
        
       
        tb.setTitleComponent(titleCmp);
  
        
        FontImage arrowDown = FontImage.createMaterial(FontImage.MATERIAL_KEYBOARD_ARROW_DOWN, "Label", 3);
        
        setLayout(BoxLayout.y());
        TextField description = new TextField(des);
        TextArea taDescription = new TextArea("WriteHere", 2, 80, TextArea.BASELINE);
        TextField Localisation = new TextField(localisation);
        System.out.println(price_location);
        TextField tfPrix = new TextField(price_location);
        TextField Quantity = new TextField(quantity);
        Calendar c = new Calendar();
        Picker datePicker = new Picker();
        datePicker.setType(Display.PICKER_TYPE_DATE);
        System.out.println(datePicker.getText());
        String dateS = datePicker.toString().substring(datePicker.toString().indexOf("text = ") + 7, datePicker.toString().indexOf("text = ") + 15);
        Button imgBtn = new Button("parcourir");
        TextField tfimage = new TextField("","Veuillez saisir l'url de votre image");
        imgBtn.addActionListener(e -> {
            Display.getInstance().openGallery(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ev) {
                    if (ev != null && ev.getSource() != null) {
                        path = (String) ev.getSource();
                        System.out.println(path.substring(7));
                        Image img = null;
                        tfimage.setText(path.substring(7));//image heya just label nsob feha fel path
                        try {
                            img = Image.createImage(FileSystemStorage.getInstance().openInputStream(path));
                            System.out.println(img);
                        } catch (IOException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }
            }, Display.GALLERY_IMAGE);
        });
       
        
        Label D= new Label("Description :");
        Label ldate = new Label("Date circulatition :");
        Label L = new Label("Localisation :");
        Label ldescription = new Label("Description :");
        Label Q= new Label("Quantity :");
        Label lprix = new Label("Price location :");
        Label lphoto = new Label("Photo :");
        
        Button btnValider = new Button("Update");
        Button btnAnnuler = new Button("Annuler");
        
        addAll(D,description,L,Localisation,ldate,datePicker,lphoto,imgBtn,tfimage,Q,Quantity,lprix,tfPrix,btnValider,btnAnnuler);
        
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
        
        btnAnnuler.addActionListener((evt) -> {
            previous.showBack();
        });
        
      btnValider.addActionListener(new ActionListener() {
           @Override
            public void actionPerformed(ActionEvent evt) {
                if ((description.getText().length()==0)||(Localisation.getText().length()==0) ||(taDescription.getText().length()==0) ||(tfimage.getText().length()==0) ||(Quantity.getText().length()==0) ||(tfPrix.getText().length()==0) ||(datePicker.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    try {
                          Velo v=new Velo();
             v.setDate_circulation(datePicker.getText());
                    v.setPhoto(tfimage.getText());
                    v.setPrice_location(Integer.parseInt(tfPrix.getText()));
                            v.setDescription(description.getText());
                             v.setLocalitsation_velo(Localisation.getText());
                            v.setQuantity(Integer.parseInt(Quantity.getText()));
                    
      
                        if( sv.updatev(id, v))
                        {
                            System.out.println(v);
                            Dialog.show("Success","Connection accepted",new Command("OK"));
                        }else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (Exception e) {
                        Dialog.show("ERROR", "server error", new Command("OK"));
                    }
                    
                }
                
                
            }
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


}
