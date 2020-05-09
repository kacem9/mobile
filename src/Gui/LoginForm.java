/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entites.FosUser;
import Services.ServiceUser;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import java.io.IOException;
import java.util.Map;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import utils.SessionUser;
import utils.Statics;

/**
 *
 * @author root
 */
public class LoginForm extends Form {
    
    ConnectionRequest connectionRequest;
    public LoginForm(Resources theme) {
        super(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER));
        setUIID("LoginForm");
       
        
        getTitleArea().setUIID("Container");
        

      
        
        TextField login = new TextField("", "Login", 20, TextField.EMAILADDR) ;
        TextField password = new TextField("", "Password", 20, TextField.PASSWORD) ;
        login.getAllStyles().setMargin(LEFT, 0);
        password.getAllStyles().setMargin(LEFT, 0);
        Label loginIcon = new Label("", "WelcomeBlack");
        Label passwordIcon = new Label("", "WelcomeBlack");
        loginIcon.getAllStyles().setMargin(RIGHT, 0);
        passwordIcon.getAllStyles().setMargin(RIGHT, 0);
        FontImage.setMaterialIcon(loginIcon, FontImage.MATERIAL_PERSON_OUTLINE, 3);
        FontImage.setMaterialIcon(passwordIcon, FontImage.MATERIAL_LOCK_OUTLINE, 3);
        
        Button loginButton = new Button("LOGIN");
        loginButton.setUIID("LoginButton");
        
       /* loginButton.addActionListener(e -> {
            new ProfileForm(theme).show();
        });*/
        
      loginButton.addActionListener(e -> {
           String url = "http://localhost/velo/web/app_dev.php/api/login";
            connectionRequest = new ConnectionRequest(url, false);
            System.out.println(login.getText());
            System.out.println(password.getText());
            connectionRequest.addArgument("username", login.getText());
            connectionRequest.addArgument("Password", password.getText());
            connectionRequest.addResponseListener((action) -> {
                JSONParser j = new JSONParser();
                
                String json = new String(connectionRequest.getResponseData()) + "";
                if (json.equals("failed")) {
                    Dialog.show("Echec d'authenfication", "username ou mot de passe éronné", "Ok", null);
                } else {
                    try {
                        System.out.println(json);
                        Map<String, Object> user = j.parseJSON(new CharArrayReader(json.toCharArray()));
                        System.out.println(j.parseJSON(new CharArrayReader(json.toCharArray())));
                        
                        
                        if (user.size() > 0) {
                            new ProfileForm(theme).show();

                        }
                    } catch (IOException ex) {
                      //  Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            });
            NetworkManager.getInstance().addToQueue(connectionRequest);

        });
           
        Button createNewAccount = new Button("CREATE NEW ACCOUNT");
        createNewAccount.setUIID("CreateNewAccountButton");
         createNewAccount.addActionListener(e -> {
            new RegisterForm(theme).show();
        });
        // We remove the extra space for low resolution devices so things fit better
        Label spaceLabel;
        if(!Display.getInstance().isTablet() && Display.getInstance().getDeviceDensity() < Display.DENSITY_VERY_HIGH) {
            spaceLabel = new Label();
        } else {
            spaceLabel = new Label(" ");
        }
        
        
        Container by = BoxLayout.encloseY(
                

                spaceLabel,
                BorderLayout.center(login).
                        add(BorderLayout.WEST, loginIcon),
                BorderLayout.center(password).
                        add(BorderLayout.WEST, passwordIcon),
                loginButton,
                createNewAccount
        );
        add(BorderLayout.CENTER, by);
        
        // for low res and landscape devices
        by.setScrollableY(true);
        by.setScrollVisible(false);
       
    }
}
