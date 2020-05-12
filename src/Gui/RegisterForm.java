/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entites.FosUser;
import Services.ServiceUser;
import com.codename1.components.ImageViewer;
import com.codename1.components.MultiButton;
import com.codename1.components.SpanLabel;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.FileSystemStorage;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.list.GenericListCellRenderer;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.JSONParser;
import com.codename1.io.Log;
import com.codename1.io.NetworkManager;
import static com.codename1.io.rest.Rest.options;
import com.codename1.processing.Result;
import com.codename1.ui.AutoCompleteTextField;
import com.codename1.ui.FontImage;
import com.codename1.ui.Graphics;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.util.regex.RE;
import java.io.ByteArrayInputStream;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.control.ChoiceBox;

/**
 *
 * @author Asus
 */
public class RegisterForm extends Form {

    String path;
    private Resources theme;
    private String newfilePath = "";

    private boolean testTel;
    private boolean testcode;
   public static FosUser ip;
    final DefaultListModel<String> options = new DefaultListModel<>();

  

    public RegisterForm(Resources theme) {

        super(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER));
        //super(new BoxLayout.y());

        getTitleArea().setUIID("Container");

        Toolbar tb = getToolbar();
        tb.setTitleCentered(false);

        Container titleCmp = BoxLayout.encloseY(
                new Label("Registration Form", "CenterTitle")
        );

        tb.setTitleComponent(titleCmp);

        Button haveaccount = new Button("YOU HAVE AN ACCOUNT? Login");
        haveaccount.setUIID("CreateNewAccountButton");

        TextField username = new TextField("", "Username", 20, TextField.EMAILADDR);
        //username.setHint("username");
        username.getAllStyles().setMargin(LEFT, 0);
        TextField password = new TextField();
        password.setHint("password");
        password.setConstraint(TextField.PASSWORD);

        password.getAllStyles().setMargin(LEFT, 0);
        //--------------------------------------------------------------------------------------------  

        Label loginIcon = new Label("", "WelcomeBlack");
        Label passwordIcon = new Label("", "WelcomeBlack");
        Label telIcon = new Label("", "WelcomeBlack");
        Label emailIcon = new Label("", "WelcomeBlack");
        Label adresseIcon = new Label("", "WelcomeBlack");
        Label nomIcon = new Label("", "WelcomeBlack");
        Label prenomIcon = new Label("", "WelcomeBlack");
        Label cinIcon = new Label("", "WelcomeBlack");
        Label civiliteIcon = new Label("", "WelcomeBlack");
        Label sexeIcon = new Label("", "WelcomeBlack");
        Label roleIcon = new Label("", "WelcomeBlack");
        Label paysIcon = new Label("", "WelcomeBlack");
        Label villeIcon = new Label("", "WelcomeBlack");
        Label dateIcon = new Label("", "WelcomeBlack");
        Label posteIcon = new Label("", "WelcomeBlack");
        Label codeIcon = new Label("", "WelcomeBlack");
        Label photoIcon = new Label("", "WelcomeBlack");
        loginIcon.getAllStyles().setMargin(RIGHT, 0);
        passwordIcon.getAllStyles().setMargin(RIGHT, 0);
        //--------------------------------------------------------------------------------------------  
        FontImage.setMaterialIcon(loginIcon, FontImage.MATERIAL_PERSON_OUTLINE, 3);
        FontImage.setMaterialIcon(passwordIcon, FontImage.MATERIAL_LOCK_OUTLINE, 3);
        FontImage.setMaterialIcon(telIcon, FontImage.MATERIAL_CONTACT_PHONE, 3);
        FontImage.setMaterialIcon(emailIcon, FontImage.MATERIAL_EMAIL, 3);
        FontImage.setMaterialIcon(adresseIcon, FontImage.MATERIAL_HOME_WORK, 3);
        FontImage.setMaterialIcon(nomIcon, FontImage.MATERIAL_PERSON_OUTLINE, 3);
        FontImage.setMaterialIcon(prenomIcon, FontImage.MATERIAL_PERSON_OUTLINE, 3);
        FontImage.setMaterialIcon(cinIcon, FontImage.MATERIAL_PAYMENT, 3);
        FontImage.setMaterialIcon(civiliteIcon, FontImage.MATERIAL_WC, 3);
        FontImage.setMaterialIcon(sexeIcon, FontImage.MATERIAL_WC, 3);
        FontImage.setMaterialIcon(roleIcon, FontImage.MATERIAL_PERSON_OUTLINE, 3);
        FontImage.setMaterialIcon(paysIcon, FontImage.MATERIAL_EMOJI_FLAGS, 3);
        FontImage.setMaterialIcon(villeIcon, FontImage.MATERIAL_LANGUAGE, 3);
        FontImage.setMaterialIcon(dateIcon, FontImage.MATERIAL_CALENDAR_TODAY, 3);
        FontImage.setMaterialIcon(posteIcon, FontImage.MATERIAL_WORK_OUTLINE, 3);
        FontImage.setMaterialIcon(codeIcon, FontImage.MATERIAL_RECENT_ACTORS, 3);
        FontImage.setMaterialIcon(photoIcon, FontImage.MATERIAL_ADD_A_PHOTO, 3);
        //--------------------------------------------------------------------------------------------  
  
        TextField Adresse = new TextField();
        Adresse.setHint("Adresse");
        TextField poste = new TextField();
        poste.setHint("poste");
        TextField nom = new TextField();
        nom.setHint("nom");
        TextField prenom = new TextField();
        prenom.setHint("prenom");
        TextField cin = new TextField();
        cin.setHint("cin");
        TextField email = new TextField();
        email.setHint("email");
        TextField code_postal = new TextField();
        code_postal.setHint("code_postal");
        TextField tel = new TextField();
        tel.setHint("tel");
        TextField Pays = new TextField();
        Pays.setHint("pays");
        TextField Ville = new TextField();
        Ville.setHint("ville");
        Picker datePicker = new Picker();
        datePicker.setType(Display.PICKER_TYPE_DATE);
        ComboBox Sexe = new ComboBox("Homme", "Femme");
        ComboBox Civilite = new ComboBox("Mademoiselle", "Monsieur", "Madame");
        ComboBox roles = new ComboBox("Chef", "Vendeur", "Achteur", "Reparateur");

        datePicker.setDate(new Date());
        ImageViewer i = new ImageViewer();
        Button imgBtn = new Button("parcourir");

        code_postal.addDataChangedListener((e, k) -> {
            RE r = new RE("([0-9]+(\\.[0-9]+)?)+");

            if (!r.match(code_postal.getText())) {
                Dialog.show("Alerte", "Le champ CODE POSTAL doit etre de type nombre", "Ok", null);
                testcode = false;
            } else {
                testcode = true;
            }
        });
        cin.addDataChangedListener((e, k) -> {
            RE r = new RE("([0-9]+(\\.[0-9]+)?)+");

            if (!r.match(tel.getText())) {
                Dialog.show("Alerte", "Le champ cin doit etre de type nombre et comporte 8 chiffres", "Ok", null);
                testTel = false;
            } else {
                testTel = true;
            }
        });
        tel.addDataChangedListener((e, k) -> {
            RE r = new RE("([0-9]+(\\.[0-9]+)?)+");

            if (!r.match(tel.getText())) {
                Dialog.show("Alerte", "Le champ Téléphone doit etre de type nombre et comporte 8 chiffres", "Ok", null);
                testTel = false;
            } else {
                testTel = true;
            }
        });
        TextField tfimage = new TextField("", "Veuillez saisir l'url de votre image");
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
        haveaccount.addActionListener(e -> {
            new LoginForm(theme).show();
        });
        Button Register = new Button();
        Register.setText("Register");
        Register.setUIID("LoginButton");

        Register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((username.getText().equals("")) || (password.getText().equals("")) || (datePicker.getText().equals("")) || (poste.getText().equals(""))
                        || (cin.getText().equals("")) || (nom.getText().equals("")) || (prenom.getText().equals("")) || (email.getText().equals(""))
                        || (tel.getText().equals("")) || (code_postal.getText().equals("")) || (Adresse.getText().equals("")) || (tfimage.getText().equals(""))
                        || (Pays.getText().equals("")) || (Ville.getText().equals("")) || (Sexe.getSelectedItem().toString().equals(""))
                        || (roles.getSelectedItem().toString().equals("")) || (Civilite.getSelectedItem().toString().equals(""))) {
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                } else {
                    try {
                        FosUser t = new FosUser(username.getText(), password.getText(), datePicker.getText(),
                                poste.getText(), cin.getText(), nom.getText(), prenom.getText(), email.getText(),
                                tel.getText(), code_postal.getText(), Adresse.getText(), tfimage.getText(), Civilite.getSelectedItem().toString(), Pays.getText(), Ville.getText(),
                                Sexe.getSelectedItem().toString(), roles.getSelectedItem().toString());
                        if (ServiceUser.getInstance().adduser(t)) {
                            Dialog.show("Success", "Connection accepted", new Command("OK"));
                        } else {
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                        }
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }

                }

            }
        });

        /*  addAll(username, password, datePicker, poste, cin, nom, prenom, email, tel, Civilite, Sexe, roles, code_postal, Pays, Ville 
                ,Adresse,imgBtn, tfimage, Register,haveaccount);*/
        Label spaceLabel;
        if (!Display.getInstance().isTablet() && Display.getInstance().getDeviceDensity() < Display.DENSITY_VERY_HIGH) {
            spaceLabel = new Label();
        } else {
            spaceLabel = new Label(" ");
        }

        Container by = BoxLayout.encloseY(
                spaceLabel,
                BorderLayout.center(username).
                        add(BorderLayout.WEST, loginIcon),
                BorderLayout.center(password).
                        add(BorderLayout.WEST, passwordIcon),
                BorderLayout.center(tel).
                        add(BorderLayout.WEST, telIcon),
                BorderLayout.center(email).
                        add(BorderLayout.WEST, emailIcon),
                BorderLayout.center(Adresse).
                        add(BorderLayout.WEST, adresseIcon),
                BorderLayout.center(nom).
                        add(BorderLayout.WEST, nomIcon),
                BorderLayout.center(prenom).
                        add(BorderLayout.WEST, prenomIcon),
                BorderLayout.center(cin).
                        add(BorderLayout.WEST, cinIcon),
                BorderLayout.center(Civilite).
                        add(BorderLayout.WEST, civiliteIcon),
                BorderLayout.center(Sexe).
                        add(BorderLayout.WEST, sexeIcon),
                BorderLayout.center(roles).
                        add(BorderLayout.WEST, roleIcon),
                BorderLayout.center(Pays).
                        add(BorderLayout.WEST, paysIcon),
                BorderLayout.center(Ville).
                        add(BorderLayout.WEST, villeIcon),
                BorderLayout.center(datePicker).
                        add(BorderLayout.WEST, dateIcon),
                BorderLayout.center(code_postal).
                        add(BorderLayout.WEST, codeIcon),
                BorderLayout.center(poste).
                        add(BorderLayout.WEST, posteIcon),
                BorderLayout.center(tfimage).
                        add(BorderLayout.WEST, photoIcon),
                imgBtn,
                Register,
                haveaccount
        );
        add(BorderLayout.CENTER, by);

        // for low res and landscape devices
        by.setScrollableY(true);
        by.setScrollVisible(false);

    }

    private Map<String, Object> createListEntry(String name) {
        Map<String, Object> entry = new HashMap<>();
        entry.put("", name);

        return entry;
    }

    public boolean isNumber(String s) {
        RE r = new RE("(20|21|22|70|71|50|51)[0-9][0-9][0-9][0-9][0-9][0-9]$");
        boolean matcher = r.match(s);
        return matcher;
    }

}
