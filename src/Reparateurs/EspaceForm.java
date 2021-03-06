
package Reparateurs;

import Entites.rendezvous;
import Entites.Fos_User;
import Entites.Reparateur;
import Entites.validrendezvous;
import Services.ListReparateurService;
import com.codename1.charts.ChartComponent;
import com.codename1.charts.models.CategorySeries;
import com.codename1.charts.renderers.DefaultRenderer;
import com.codename1.charts.renderers.SimpleSeriesRenderer;
import com.codename1.charts.views.PieChart;
import com.codename1.components.ImageViewer;
import com.codename1.components.ToastBar;
import com.codename1.l10n.ParseException;
import com.codename1.messaging.Message;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import com.codename1.util.regex.RE;
import com.nexmo.client.NexmoClient;
import com.nexmo.client.NexmoClientException;
import com.nexmo.client.auth.AuthMethod;
import com.nexmo.client.auth.TokenAuthMethod;
import com.nexmo.client.sms.SmsSubmissionResult;
import com.nexmo.client.sms.messages.TextMessage;
import java.io.IOException;
import java.util.ArrayList;
import utils.SessionUser;





public class EspaceForm extends Form {
    private boolean testcode;
    private void initStarRankStyle(Style s, Image star) {
    s.setBackgroundType(Style.BACKGROUND_IMAGE_TILE_BOTH);
    s.setBorder(Border.createEmpty());
    s.setBgImage(star); 
   s.setBgTransparency(0);
     }
public static int conn;
    public EspaceForm(Form previous)throws ParseException {
            super(BoxLayout.y());
        
    Toolbar tb = getToolbar();
    tb.setTitleCentered(false);
      
    Container titleCmp = BoxLayout.encloseY(
                        
                new Label("List Appointement", "CenterTitle") 
                );
    tb.setTitleComponent(titleCmp);
     FontImage arrowDown = FontImage.createMaterial(FontImage.MATERIAL_KEYBOARD_ARROW_DOWN, "Label", 3);
              EncodedImage enc ;
     
 Reparateur work=new Reparateur();
 rendezvous p=new rendezvous();
 ListReparateurService ws = new ListReparateurService();       
 ArrayList<rendezvous> rep = ws.getMaRendezvous();
 {for (int i = 0; i < rep.size(); i++) {
      int test=rep.get(i).getFos();
 System.out.println("fos="+test);
    // if(SessionUser.getUser().getId()==test){ 
Container c2 = new Container(BoxLayout.x()); 
Container c1 = new Container(BoxLayout.x());
Container c3 = new Container(BoxLayout.y());   
final rendezvous fos = rep.get(i);
int y=rep.get(i).getUser();
int k=rep.get(i).getCin();

String w=rep.get(i).getEmail();
Label ll = new Label("Appointement n°"+i+":");
c2.add(ll);
add(c2);         
Button b = new Button("Valid an appointement");
Button b1 = new Button("Delete Rdv");
Button b2 = new Button("Refuse");
 FontImage.setMaterialIcon(b1, FontImage.MATERIAL_DELETE);
 FontImage.setMaterialIcon(b2, FontImage.MATERIAL_MAIL);
FontImage.setMaterialIcon(b, FontImage.MATERIAL_ADD_COMMENT);
            Label l2 = new Label("Name: " + rep.get(i).getNom());
            Label l3 = new Label("Email: " + rep.get(i).getEmail());
            Label l4 = new Label("Adresse: " + rep.get(i).getAdresse());
            Label l5 = new Label("Message: " + rep.get(i).getMessage());
            Label l6 = new Label("Numtel: " + rep.get(i).getNumtel());
            Label l7 = new Label("Typepanne: " + rep.get(i).getTypepanne());
            c1.add(c3);
            c3.add(l2);
            c3.add(l3);
            c3.add(l4);
            c3.add(l5);
            c3.add(l6);
            c3.add(l7);
            c3.add(b);
            c3.add(b1);
            c3.add(b2);
 b.addActionListener(new ActionListener() {
    Form f1 = new Form("Valid this appointement",new FlowLayout());
    
        
              Label lOption = new Label("Valid this appointement : ");
              Picker dateheure = new Picker();
              
            
             
             ComboBox promo = new ComboBox("10%","20%","30%","40%","50%","60%","no promotion");
             ComboBox etat = new ComboBox("At home","Etablissement");
              TextField prix=new TextField("","Price");
              TextField message=new TextField("","Message");
              //TextField emailR=new TextField("","Email");
              Button btnConf = new Button("Save");
               
                
               @Override
               public void actionPerformed(ActionEvent evt) {
               //dateheure.setStrings(new String[]{"appointement", "appointement", "appointement", "appointement"});
    
               
               btnConf.addActionListener((evt1) -> {
                   try {
                       getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
                     
                      if ((dateheure.getText().length()==0)||(promo.getSelectedItem().toString().equals("")) ||(etat.getSelectedItem().toString().equals("")) ||(prix.getText().length()==0) ||(message.getText().length()==0))
                           Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                      else
                
                      {validrendezvous p=new validrendezvous( dateheure.getText(),prix.getText(),promo.getSelectedItem().toString(),etat.getSelectedItem().toString() ,message.getText());
                       ws.validsrendezvous(p,SessionUser.getUser().getId(),y,w);
                       ToastBar.showInfoMessage("succes validated");}
                       //previous.showBack();
                       //add(typepannet);add(typepanne);add(messaget);add(message);
                       //Message mk = new Message("Vous avez choisit de noter notre service avec "+promo.getSelectedItem()+"! MERCI ");
                       //Display.getInstance().sendMessage(new String[] {"nesrinezouaoui583@gmail.com"}, "Avis sur le service annonce dans l'application Souk El Medina", mk);
                ListReparateurService ser = new ListReparateurService();
                validrendezvous t=new validrendezvous();
                t.setMessage(message.getText());
                t.setPrix(prix.getText());
                t.setPromo("promo="+promo.getSelectedItem());
                t.setEtat("etat="+etat.getSelectedItem());
                t.setDateheure(dateheure.getText());
                ser.validsrendezvous(t,SessionUser.getUser().getId(),y,w);
                AuthMethod auth = new TokenAuthMethod("b696c599", "ev9gpTXEbt7vWlOT");  // (api_key,api_secret)
                NexmoClient client = new NexmoClient(auth);
                SmsSubmissionResult[] responses;
                try {
                    responses = client.getSmsClient().submitMessage(new TextMessage(
                            "nesrine",
                            "+21658967048",
                            "votre demande a été validée !"));
                    for (SmsSubmissionResult response : responses) {
                        System.out.println(response);
                    }
                } catch (IOException | NexmoClientException ex) {
                    
                }
                EspaceForm com=new EspaceForm(previous);
                com.show();
                EspaceForm  v= new EspaceForm(previous);
                       v.show();
                   } catch (ParseException ex) {
                     
                   }
             
            });
               
                
              f1.add(lOption);
              
              f1.add(prix);
              f1.add(promo);
             
              f1.add(etat);
           
              f1.add(message);
              f1.add(dateheure);
              f1.add(btnConf);
                              
                prix.addDataChangedListener((e,k)->{
                            RE r = new RE("([0-9]+(\\.[0-9]+)?)+");

           if (!r.match(prix.getText()))
           {
           Dialog.show("Alerte", "Le champ prix doit etre de type nombre", "Ok",null);
           testcode = false ;
           }else{testcode= true;}
               });
              f1.show();

                  Toolbar tb2= f1.getToolbar();
       tb2.addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, (ActionListener) (ActionEvent evt1) -> {
                   try {
                       //previous.showBack();
                       EspaceForm  v= new EspaceForm(previous);
                       v.show();
                   } catch (ParseException ex) {
                      
                   }
                
        });        
              
              

               }
                 }); 
    b1.addActionListener((evt) -> {
          if (Dialog.show("Delete", "Êtes vous sûr de supprimer ce rendezvous??", "Oui", "Non")) {
              try {
                  ws.DeleteMaRdv(p,k);
                  c3.remove();
                  c1.remove();
                  c2.remove();
                  EspaceForm  v= new  EspaceForm(previous);
                  v.show();
                          } catch (ParseException ex) {
                 
              }
          }
     });
        b2.addActionListener((ActionListener) (ActionEvent evt1) -> {
            try {
                ListReparateurService ser = new ListReparateurService();
                rendezvous t=new rendezvous();
                t.setNom(l2.getText());
                ser.getRendezvous();
                AuthMethod auth = new TokenAuthMethod("b696c599", "ev9gpTXEbt7vWlOT");  // (api_key,api_secret)
                NexmoClient client = new NexmoClient(auth);
                SmsSubmissionResult[] responses;
                try {
                    responses = client.getSmsClient().submitMessage(new TextMessage(
                            "nesrine",
                            "+21658967048",
                            "votre demande a été refusée !"));
                    for (SmsSubmissionResult response : responses) {
                        System.out.println(response);
                    }
                } catch (IOException | NexmoClientException ex) {
                    
                }
                EspaceForm com=new EspaceForm(previous);
                com.show();
            } catch (ParseException ex) {
        
               
            }
        });

    
    
add(c1);
 } 
 //}
 }
 getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
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
