/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Entites.Event;
import Services.ServicesEvent;
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
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import java.io.IOException;
import java.util.Date;
import javafx.scene.control.DatePicker;


/**
 *
 * @author root
 */

public class AddForm extends Form{
//    String path ;
//
//    public AddForm(Form previous) {
//        
//        setTitle("Add a new Event");
//        setLayout(BoxLayout.y());
//        TextField tfNom = new TextField();
//        TextArea taDescription = new TextArea("WriteHere", 2, 80, TextArea.BASELINE);
//        TextField tfLieuEvent = new TextField();
//        TextField tfPrix = new TextField();
//        TextField tfNbrparticipant = new TextField();
//        Calendar c = new Calendar();
//        Picker datePicker = new Picker();
//        datePicker.setType(Display.PICKER_TYPE_DATE);
//        System.out.println(datePicker.getText());
//        String dateS = datePicker.toString().substring(datePicker.toString().indexOf("text = ") + 7, datePicker.toString().indexOf("text = ") + 15);
//        Button imgBtn = new Button("parcourir");
//        TextField tfimage = new TextField("","Veuillez saisir l'url de votre image");
//        imgBtn.addActionListener(e -> {
//            Display.getInstance().openGallery(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent ev) {
//                    if (ev != null && ev.getSource() != null) {
//                        path = (String) ev.getSource();
//                        System.out.println(path.substring(7));
//                        Image img = null;
//                        tfimage.setText(path.substring(7));//image heya just label nsob feha fel path
//                        try {
//                            img = Image.createImage(FileSystemStorage.getInstance().openInputStream(path));
//                            System.out.println(img);
//                        } catch (IOException e) {
//                            System.out.println(e.getMessage());
//                        }
//                    }
//                }
//            }, Display.GALLERY_IMAGE);
//        });
//        ComboBox cbCategories = new ComboBox("Evénement sportif","Bourse aux velos","Balade avec les velos"); //a modifier
//        Label lcategories = new Label("Categories :");
//        Label lnom = new Label("Nom :");
//        Label ldate = new Label("Date Event :");
//        Label llieu = new Label("Lieu Event :");
//        Label ldescription = new Label("Description :");
//        Label lnbr= new Label("Nombre de participant :");
//        Label lprix = new Label("Prix :");
//        Label lphoto = new Label("Photo :");
//        
//        Button btnValider = new Button("Save");
//        Button btnAnnuler = new Button("Annuler");
//        
//        addAll(lnom,tfNom,lcategories,cbCategories,ldate,datePicker,llieu,tfLieuEvent,lphoto,imgBtn,tfimage,lnbr,tfNbrparticipant,lprix,tfPrix,ldescription,taDescription,btnValider,btnAnnuler);
//        
//        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
//        
//        btnAnnuler.addActionListener((evt) -> {
//            previous.showBack();
//        });
//        
//      btnValider.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent evt) {
//                if ((tfNom.getText().length()==0)||(tfLieuEvent.getText().length()==0) ||(taDescription.getText().length()==0) ||(tfimage.getText().length()==0) ||(tfNbrparticipant.getText().length()==0) ||(tfPrix.getText().length()==0) ||(datePicker.getText().length()==0))
//                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
//                else
//                {
//                    try {
//                                               
//                        Event ev = new Event(tfNom.getText(),datePicker.getText(),taDescription.getText(),tfLieuEvent.getText(),tfimage.getText(),Double.valueOf(tfPrix.getText()),Integer.parseInt(tfNbrparticipant.getText()),0);
//                       // ev.setNom(tfNom.getText());
//                       // ev.setDescription(taDescription.getText());
//                      //  ev.setLieu_event(tfLieuEvent.getText());
//                      //  ev.setDate_event(datePicker.getText());
//                      //  ev.setPhoto(tfimage.getText());
//                      //  ev.setPrix(Double.valueOf(tfPrix.getText()));
//                      //  ev.setNbr_participant(Integer.parseInt(tfNbrparticipant.getText()));
//                     //   ev.setEtat(0);
//                        if( ServicesEvent.getInstance().AjouterEvent(ev))
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
//    }
    
    
}
