/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EspaceVendeur;

import Entites.Event;
import Entites.Velo;
import Services.ServiceVelos;
import com.codename1.components.ImageViewer;
import com.codename1.io.FileSystemStorage;
import com.codename1.ui.Button;
import com.codename1.ui.Calendar;
import com.codename1.ui.ComboBox;
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
import com.codename1.ext.filechooser.FileChooser;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;
import com.codename1.notifications.LocalNotification;

import java.io.IOException;
import utils.SessionUser;
import utils.UploadFile;

/**
 *
 * @author HP
 */
public class AddVeloL  extends Form{
    String newfilePath="";
    String path="";
    Container imgCtn=new Container();
    ServiceVelos sv=new ServiceVelos();
       public AddVeloL(Form previous)
    {
        super(BoxLayout.y());
        
        Toolbar tb = getToolbar();
        tb.setTitleCentered(false);
      
        Container titleCmp = BoxLayout.encloseY(
                        
                new Label("Add a Bike", "CenterTitle")
                        
                       
                );
        
        
       
        tb.setTitleComponent(titleCmp);
  
        
        FontImage arrowDown = FontImage.createMaterial(FontImage.MATERIAL_KEYBOARD_ARROW_DOWN, "Label", 3);
        
        setLayout(BoxLayout.y());
        TextField description = new TextField();
        TextArea taDescription = new TextArea("WriteHere", 2, 80, TextArea.BASELINE);
        TextField Localisation = new TextField();
        TextField tfPrix = new TextField();
        TextField Quantity = new TextField();
        Calendar c = new Calendar();
        Picker datePicker = new Picker();
        datePicker.setType(Display.PICKER_TYPE_DATE);
        System.out.println(datePicker.getText());
        String dateS = datePicker.toString().substring(datePicker.toString().indexOf("text = ") + 7, datePicker.toString().indexOf("text = ") + 15);
        Button imgBtn = new Button("parcourir");
        TextField tfimage = new TextField("","Veuillez saisir l'url de votre image");
        ImageViewer i = new ImageViewer();
               imgBtn.addActionListener((evt1) -> {
                ActionListener callback = e -> {
                    if (e != null && e.getSource() != null) {
                        try {
                            this.newfilePath = (String) e.getSource();
                            i.setImage(Image.createImage(this.newfilePath));
                            System.out.println(this.newfilePath);
                            try {
                                this.newfilePath = UploadFile.uploadImage(newfilePath, null);
                                  tfimage.setText(newfilePath.substring(7));
                            } catch (Exception ex) {
                                System.out.println(ex.getMessage());
                            }
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }
                    }
                };
                if (FileChooser.isAvailable()) {
                    FileChooser.showOpenDialog(".jpg,image/jpg,.jpeg", callback);
                                                    System.out.println( this.newfilePath);

                } else {
                    Display.getInstance().openGallery(callback, Display.GALLERY_IMAGE);
                } 
            });
       
        
        Label D= new Label("Description :");
        Label ldate = new Label("Date circulatition :");
        Label L = new Label("Localisation :");
        Label ldescription = new Label("Description :");
        Label Q= new Label("Quantity :");
        Label lprix = new Label("Price location :");
        Label lphoto = new Label("Photo :");
        
        Button btnValider = new Button("Save");
        Button btnAnnuler = new Button("Annuler");
        
        addAll(D,description,L,Localisation,ldate,datePicker,lphoto,imgBtn,imgCtn,tfimage,Q,Quantity,lprix,tfPrix,btnValider,btnAnnuler);
        
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
                    
      int idu=SessionUser.getUser().getId();
                        if( sv.addrec(v,idu))
                        {
                            System.out.println(v);
                            Dialog.show("Success","Connection accepted",new Command("OK"));
                          LocalNotification n = new LocalNotification();
        n.setId("notification");
        n.setAlertBody("Your Bike added ");
        n.setAlertTitle("Succefull !!");
        //n.setAlertSound("/notification_sound_bells.mp3"); //file name must begin with notification_sound
        
        Display.getInstance().scheduleLocalNotification(
                n,
                System.currentTimeMillis() + 10 * 1000, // fire date/time
                LocalNotification.REPEAT_MINUTE  // Whether to repeat and what frequency
        ); 
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
