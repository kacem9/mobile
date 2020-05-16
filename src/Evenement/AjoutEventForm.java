/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Evenement;

import Entites.Event;
import Entites.Fos_User;
import Services.ServicesEvent;
import com.codename1.capture.Capture;
import com.codename1.io.FileSystemStorage;
import com.codename1.notifications.LocalNotification;
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
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;
import java.io.IOException;
import utils.SessionUser;


/**
 *
 * @author root
 */
public class AjoutEventForm extends Form{
  String path ;
//    private FileUploader file ;
//    String fileNameInServer;
//    private String imgPath ;
     Fos_User u=new Fos_User();
    public AjoutEventForm(Form previous)
    {
        super(BoxLayout.y());
        
        Toolbar tb = getToolbar();
        tb.setTitleCentered(false);
      
        Container titleCmp = BoxLayout.encloseY(
                        
                new Label("Ajouter un evenement", "CenterTitle")
                        
                       
                );
        
        
       
        tb.setTitleComponent(titleCmp);
  
        
        FontImage arrowDown = FontImage.createMaterial(FontImage.MATERIAL_KEYBOARD_ARROW_DOWN, "Label", 3);
        
        setLayout(BoxLayout.y());
        TextField tfid = new TextField();
        TextField tfNom = new TextField();
        TextArea taDescription = new TextArea("WriteHere", 2, 80, TextArea.BASELINE);
        TextField tfLieuEvent = new TextField();
        TextField tfPrix = new TextField();
        TextField tfNbrparticipant = new TextField();
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
                        tfimage.setText(path.substring(7));
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
//        Button picture = new Button("parcourir");
//        picture.setMaterialIcon(FontImage.MATERIAL_CLOUD_UPLOAD);
//        TextField path = new TextField();
//        
//        picture.addPointerReleasedListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent evt) {
//                 try{
//                imgPath = Capture.capturePhoto();
//                
//                System.out.println(imgPath);
//                String link =imgPath.toString();
//                int pod = link.indexOf("/",2);
//                String news = link.substring(pod+2,link.length());
//                System.out.println(""+news);
//                
//                FileUploader fu = new FileUploader("http://localhost/symfony/Velo/web");
//                     System.out.println("done");
//                fileNameInServer =fu.upload(news);
//                     System.out.println("done 1");
//                path.setText(fileNameInServer);
//                     System.out.println("done 2");
//            }catch (IOException ex){
//                ex.printStackTrace();
//            }catch (Exception ex){
//                ex.printStackTrace();
//            }
//            }
//        }) ;     
           
       
        
        ComboBox cbCategories = new ComboBox("Evénement sportif","Bourse aux velos","Balade avec les velos"); //a modifier
        Label lcategories = new Label("Categories :");
        Label lnom = new Label("Nom :");
        Label ldate = new Label("Date Event :");
        Label llieu = new Label("Lieu Event :");
        Label ldescription = new Label("Description :");
        Label lnbr= new Label("Nombre de participant :");
        Label lprix = new Label("Prix :");
        Label lphoto = new Label("Photo :");
        Label id = new Label("id");
        Button btnValider = new Button("Save");
        Button btnAnnuler = new Button("Annuler");
        
        addAll(id,tfid,lnom,tfNom,ldate,datePicker,llieu,tfLieuEvent,lphoto,imgBtn,tfimage,lnbr,tfNbrparticipant,lprix,tfPrix,ldescription,taDescription,btnValider,btnAnnuler);
        
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
        
        btnAnnuler.addActionListener((evt) -> {
            previous.showBack();
        });
        
//      btnValider.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent evt) {
//                if ((tfNom.getText().length()==0)||(tfLieuEvent.getText().length()==0) ||(taDescription.getText().length()==0)||(tfimage.getText().length()==0) ||(tfNbrparticipant.getText().length()==0) ||(tfPrix.getText().length()==0) ||(datePicker.getText().length()==0))
//                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
//                else
//                {
//                    try {
//                        ServicesEvent se = new ServicesEvent();
//                        Event ev = new Event(Integer.parseInt(tfid.getText()),tfNom.getText(),datePicker.getText(),taDescription.getText() ,tfLieuEvent.getText(), tfimage.getText(), Double.valueOf(tfPrix.getText()), Integer.parseInt(tfNbrparticipant.getText()), 0);
//                         //  ev.setId(Integer.parseInt(tfid.getText()));
//                        // ev.setNom(tfNom.getText());
//                       // ev.setDescription(taDescription.getText());
//                      //  ev.setLieu_event(tfLieuEvent.getText());
//                      //  ev.setDate_event(datePicker.getText());
//                      //  ev.setPhoto(tfimage.getText());
//                      //  ev.setPrix(Double.valueOf(tfPrix.getText()));
//                      //  ev.setNbr_participant(Integer.parseInt(tfNbrparticipant.getText()));
//                     //   ev.setEtat(0);
//                    // ev.setUser(u.getId());
//                        if( se.AjouterEvent(ev))
//                        {
//                            System.out.println(ev);
//                            Dialog.show("Success","Connection accepted",new Command("OK"));
//                        }else
//                            Dialog.show("ERROR", "Server error", new Command("OK"));
//                    } catch (Exception e) {
//                        Dialog.show("ERROR", "server error", new Command("OK"));
//                    }
//                    
//                }
//                
//                
//            }
//        });

        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfNom.getText().length()==0)||(tfLieuEvent.getText().length()==0) ||(taDescription.getText().length()==0) ||(tfimage.getText().length()==0) ||(tfNbrparticipant.getText().length()==0) ||(tfPrix.getText().length()==0) ||(datePicker.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    try {
                                               
                        Event ev = new Event(Integer.parseInt(tfid.getText()),tfNom.getText(),datePicker.getText(),taDescription.getText(),tfLieuEvent.getText(),tfimage.getText(),Double.valueOf(tfPrix.getText()),Integer.parseInt(tfNbrparticipant.getText()),0);
                       // ev.setNom(tfNom.getText());
                       // ev.setDescription(taDescription.getText());
                      //  ev.setLieu_event(tfLieuEvent.getText());
                      //  ev.setDate_event(datePicker.getText());
                      //  ev.setPhoto(tfimage.getText());
                      //  ev.setPrix(Double.valueOf(tfPrix.getText()));
                      //  ev.setNbr_participant(Integer.parseInt(tfNbrparticipant.getText()));
                     //   ev.setEtat(0);
                    // ev.setUser(u.getId());
                     int idu=SessionUser.getUser().getId();
                        if( ServicesEvent.getInstance().AjouterEvent(ev,idu))
                        {
                            System.out.println(ev);
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
