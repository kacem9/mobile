/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entites.FosUser;
import Services.Service_bcrypt;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.messaging.Message;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//import java.util.logging.Level;
//import java.util.logging.Logger;
/**
 *
 * @author root
 */
public class LoginForm extends Form {

    ConnectionRequest connectionRequest;
    Boolean v, v1;

    public LoginForm(Resources theme) {
        super(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER));
        setUIID("LoginForm");

        getTitleArea().setUIID("Container");

        TextField login = new TextField("", "Login", 20, TextField.EMAILADDR);
        TextField password = new TextField("", "Password", 20, TextField.PASSWORD);
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

//        loginButton.addActionListener(e -> {
//            String url = "http://localhost/velo/web/app_dev.php/api/login";
//            connectionRequest = new ConnectionRequest(url, false);
//            System.out.println(login.getText());
//            System.out.println(password.getText());
//            connectionRequest.addArgument("username", login.getText());
//            connectionRequest.addArgument("Password", password.getText());
//            connectionRequest.addResponseListener((action) -> {
//                JSONParser j = new JSONParser();
//
//                String json = new String(connectionRequest.getResponseData()) + "";
//                FosUser t = new FosUser();
//                if (json.equals("failed")) {
//                    Dialog.show("Echec d'authenfication", "username ou mot de passe éronné", "Ok", null);
//                } else/* if (ServiceUser.getInstance().checkRole(login.getText(), t).equals("Vendeur"))*/ {
//                    try {
//
//                        System.out.println(json);
//                        Map<String, Object> user = j.parseJSON(new CharArrayReader(json.toCharArray()));
//                        System.out.println(j.parseJSON(new CharArrayReader(json.toCharArray())));
//
//                        if (user.size() > 0) {
//                            new ProfileForm().show();
//
//                        }
//                    } catch (IOException ex) {
//                        //  Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//                /*  else if(ServiceUser.getInstance().checkRole(login.getText(),t).equals("Vendeur")) {
//                    try {
//                        System.out.println(json);
//                        Map<String, Object> user = j.parseJSON(new CharArrayReader(json.toCharArray()));
//                        System.out.println(j.parseJSON(new CharArrayReader(json.toCharArray())));
//                        
//                        
//                        if (user.size() > 0) {
//                            new LocationForm(theme).show();
//
//                        }
//                    } catch (IOException ex) {
//                      //  Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }*/
//
//            });
//            NetworkManager.getInstance().addToQueue(connectionRequest);
//        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                ConnectionRequest cnx = new ConnectionRequest();
                cnx.setUrl("http://localhost/Velo/web/app_dev.php/api/users/alluser");
                cnx.addResponseListener(new ActionListener<NetworkEvent>() {
                    @Override
                    public void actionPerformed(NetworkEvent evt) {
                        boolean i = false;
                        for (FosUser e : getListUsers(new String(cnx.getResponseData()))) {
                            String crypted = e.getPassword();
                            if ((login.getText().equals(e.getUsername())) && (Service_bcrypt.checkpw(password.getText(), crypted))) {
                                System.out.println("rooooooooooooooooooooole" + e.getRoles());

                                if ((e.getRoles().equals("[" + "VENDEUR, ROLE_USER" + "]"))) {
                                    // u = e;
                                    new ProfileFormv(e,theme).show();

                                } else if ((e.getRoles().equals("[" + "CHEF, ROLE_USER" + "]"))) {
                                    //u = e;

                                    new ProfileFormc(e,theme).show();
                                } else if ((e.getRoles().equals("[" + "ACHTEUR, ROLE_USER" + "]"))) {
                                 
                                    //u = e;

                                    new ProfileForma(e, theme).show();
                                } else if ((e.getRoles().equals("[" + "REPARATEUR, ROLE_USER" + "]"))) {
                                    //u = e;

                                    new ProfileFormr(e,theme).show();
                                }

                                i = true;
                            }

                        }
                        if (!i) {
                            v = Dialog.show("Erreur", "Denied", "Ok", null);
                        } else {
                            v1 = Dialog.show("Bienvenue", "Success", "Ok", null);
                        }
                    }
                });
                NetworkManager.getInstance().addToQueue(cnx);
            }
        });

        Button createNewAccount = new Button("CREATE NEW ACCOUNT");
        createNewAccount.setUIID("CreateNewAccountButton");
        createNewAccount.addActionListener(e -> {
            new RegisterForm(theme).show();
        });
    
        // We remove the extra space for low resolution devices so things fit better
        Label spaceLabel;
        if (!Display.getInstance().isTablet() && Display.getInstance().getDeviceDensity() < Display.DENSITY_VERY_HIGH) {
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

    public ArrayList<FosUser> getListUsers(String json) {
        ArrayList<FosUser> listUsers = new ArrayList<>();
        try {
            JSONParser j = new JSONParser();
            Map<String, Object> users = j.parseJSON(new CharArrayReader(json.toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) users.get("root");
            for (Map<String, Object> obj : list) {
                FosUser e = new FosUser();
                e.setId((int) Float.parseFloat(obj.get("id").toString()));
                e.setUsername(obj.get("username").toString());
                e.setEmail(obj.get("email").toString());
                e.setPassword(obj.get("password").toString());
                e.setRoles(obj.get("roles").toString());
                e.setNom(obj.get("nom").toString());
                e.setPrenom(obj.get("Prenom").toString());
                e.setAdresse(obj.get("Adresse").toString());

                e.setNum_tel(obj.get("numTel").toString());
                e.setSexe(obj.get("Sexe").toString());
                e.setCivilite(obj.get("Civilite").toString());
                e.setPays(obj.get("Pays").toString());
                e.setVille(obj.get("Ville").toString());
                e.setCode_postal(obj.get("codePostal").toString());
                e.setPhoto(obj.get("photo").toString());
                e.setCin(obj.get("Cin").toString());
                e.setDate_naissance(obj.get("dateNaissance").toString());
                listUsers.add(e);
                System.out.println(e.toString());

            }

        } catch (IOException ex) {

        }
        return listUsers;
    }

}
