/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entites.FosUser;
import Services.ServiceUser;
import com.codename1.components.FloatingActionButton;
import com.codename1.components.ImageViewer;
import com.codename1.components.MultiButton;
import com.codename1.components.ScaleImageLabel;
import com.codename1.io.ConnectionRequest;
import static com.codename1.io.Log.e;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;

import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import utils.SessionUser;

/**
 *
 * @author root
 */
public class ProfileForma extends SideMenuBaseForma {
 private static final String apiKey = "AIzaSyA4N1uhqDRC55eqZ3ZrJ9S_OQ3nL4vPYKg";
    final DefaultListModel<String> options = new DefaultListModel<>();
    public ProfileForma(FosUser u, Resources res) {
        super(BoxLayout.y());
        Toolbar tb = getToolbar();
        tb.setTitleCentered(false);
        Label Nom = new Label("Name");
        TextField nom = new TextField();
        nom.setEditable(false);
        nom.setText(u.getNom());
        Label Email = new Label("Email");
        TextField email = new TextField();
        email.setEditable(false);
        email.setText(u.getEmail());
        Label Tel = new Label("Tel");
        TextField tel = new TextField();
        tel.setEditable(false);
        tel.setText(u.getNum_tel());
        Label Adresse = new Label("Adresse");
        TextField adresse = new TextField();
        adresse.setEditable(false);
        adresse.setText(u.getAdresse());
        Label Username = new Label("Username");
        TextField username = new TextField();
        username.setEditable(false);
        username.setText(u.getUsername());
        Label Prenom = new Label("Prenom");
        TextField prenom = new TextField();
        prenom.setEditable(false);
        prenom.setText(u.getPrenom());
        Button menuButton = new Button("");
        Button valider = new Button("valider");
        valider.setVisible(false);

        
        Button update = new Button("update");
        menuButton.setUIID("Title");
        FontImage.setMaterialIcon(menuButton, FontImage.MATERIAL_MENU);
        menuButton.addActionListener(e -> getToolbar().openSideMenu());

        Container titleCmp = BoxLayout.encloseY(
                FlowLayout.encloseIn(menuButton),
                new Label("Achteur Interface", "CenterTitle")
        );

        tb.setTitleComponent(titleCmp);

        EncodedImage placeholder = EncodedImage.createFromImage(Image.createImage(300, 500, 0xffff0000), true);
        URLImage img_user = URLImage.createToStorage(placeholder, u.getPhoto() + ".cache",
                "http://localhost/Velo//web//uploads//admin//" + u.getPhoto());

        ImageViewer imgUser = new ImageViewer();
        imgUser.setImage(img_user);
        update.addActionListener((evt) -> {
            nom.setEditable(true);
            email.setEditable(true);
            prenom.setEditable(true);
            tel.setEditable(true);
            adresse.setEditable(true);
            username.setEditable(true);
            update.setVisible(false);
            valider.setVisible(true);
        });

        valider.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                ConnectionRequest cnx = new ConnectionRequest();
                cnx.setUrl("http://localhost/Velo/web/app_dev.php/api/User/Upd?"
                        + "id=" + u.getId()
                        + "&nom=" + nom.getText()
                        + "&email=" + email.getText()
                        + "&Prenom=" + prenom.getText()
                        + "&Adresse=" + adresse.getText()
                        + "&numTel=" + tel.getText()
                        + "&username=" + username.getText()
                );
                cnx.addResponseListener(new ActionListener<NetworkEvent>() {
                    @Override
                    public void actionPerformed(NetworkEvent evt) {
                        byte[] data = (byte[]) evt.getMetaData();
                        String s = new String(data);
                        System.out.println(s);
                        boolean v = Dialog.show("Confirmation", "Modif successful", "Ok", null);
                        if (v) {

                            nom.setEditable(false);
                            email.setEditable(false);
                            prenom.setEditable(false);
                            adresse.setEditable(false);
                            tel.setEditable(false);
                            username.setEditable(false);
                        }
                    }
                });
                NetworkManager.getInstance().addToQueue(cnx);

            }
        });

        this.add(imgUser);
        this.add(Nom);
        this.add(nom);
        this.add(Prenom);
        this.add(prenom);
        this.add(Username);
        this.add(username);
        this.add(Adresse);
        this.add(adresse);
        this.add(Tel);
        this.add(tel);
        this.add(Email);
        this.add(email);
        this.add(update);
        this.add(valider);

         setupSideMenu(res);
        /* Image img = res.getImage("profile-background.jpg");
        if(img.getHeight() > Display.getInstance().getDisplayHeight() / 3) {
            img = img.scaledHeight(Display.getInstance().getDisplayHeight() / 3);
        }
        ScaleImageLabel sl = new ScaleImageLabel(img);
        sl.setUIID("BottomPad");
        sl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);

        Label facebook = new Label("786 followers", res.getImage("facebook-logo.png"), "BottomPad");
        Label twitter = new Label("486 followers", res.getImage("twitter-logo.png"), "BottomPad");
        facebook.setTextPosition(BOTTOM);
        twitter.setTextPosition(BOTTOM);
        
        add(LayeredLayout.encloseIn(
                sl,
                BorderLayout.south(
                    GridLayout.encloseIn(3, 
                            facebook,
                            FlowLayout.encloseCenter(
                                new Label(res.getImage("profile-pic.jpg"), "PictureWhiteBackgrond")),
                            twitter
                    )
                )
        ));
       /* TextField username = new TextField(FosUser.getUsername());
        username.setUIID("TextFieldBlack");
        addStringValue("Username", username);
        TextField email = new TextField(SessionManager.getEmail(), "Email", 20, TextField.EMAILADDR);
        email.setUIID("TextFieldBlack");
        addStringValue("Email", email);
        
        TextField telephone = new TextField(Integer.toString(SessionManager.getTel()), "Num_tel", 20, TextField.EMAILADDR);
        email.setUIID("TextFieldBlack");
        addStringValue("Num_tel", telephone);
        
        TextField password = new TextField(SessionManager.getPass(), "Password", 20, TextField.PASSWORD);
        password.setUIID("TextFieldBlack");
        addStringValue("Password", password);*/
    }

    private Image createCircleLine(int color, int height, boolean first) {
        Image img = Image.createImage(height, height, 0);
        Graphics g = img.getGraphics();
        g.setAntiAliased(true);
        g.setColor(0xcccccc);
        int y = 0;
        if (first) {
            y = height / 6 + 1;
        }
        g.drawLine(height / 2, y, height / 2, height);
        g.drawLine(height / 2 - 1, y, height / 2 - 1, height);
        g.setColor(color);
        g.fillArc(height / 2 - height / 4, height / 6, height / 2, height / 2, 0, 360);
        return img;
    }

    private void addStringValue(String s, Component v) {
        add(BorderLayout.west(new Label(s, "PaddedLabel")).
                add(BorderLayout.CENTER, v));

    }

    @Override
    protected void showEventForm(Resources res) {
        new EventForm(res).show();
    }

    @Override
    protected void showLocationsForm(Resources res) {
        new LocationForm(res).show();
    }

    @Override
    protected void showVelosForm(Resources res) {
        new VelosForm(res).show();
    }

    @Override
    protected void showReclamationsForm(Resources res) {
        new ReclamationsForm(res).show();
    }

    @Override
    protected void showReparationsForm(Resources res) {
        new ReparationsForm(res).show();
    }
}
