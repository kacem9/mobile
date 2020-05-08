/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Entites.Event;
import Services.ServicesEvent;
import com.codename1.components.ImageViewer;
import com.codename1.components.MultiButton;
import com.codename1.components.SpanLabel;
import com.codename1.components.ToastBar;
import com.codename1.l10n.ParseException;
import com.codename1.ui.Button;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import java.util.ArrayList;

/**
 *
 * @author root
 */
public class HomeForm extends Form {
//    
//    Form current;
//    private Resources theme;
//    
//    public HomeForm() {
//        super(null, BoxLayout.yCenter());
//        theme = UIManager.initFirstTheme("/theme");
//        Label lOption = new Label("Choisir option : ");
//        lOption.getStyle().setFgColor(0xf99f1b);
//        Button btnAddEvent = new Button("Ajouter Evenement(s)");
//        Button btnEventList = new Button("Afficher Evenement(s)");
//        FontImage.setMaterialIcon(btnAddEvent, FontImage.MATERIAL_ADD_COMMENT);
//        FontImage.setMaterialIcon(btnEventList, FontImage.MATERIAL_VIEW_LIST);
//        btnAddEvent.getStyle().setFgColor(0x00000);
//        btnEventList.getStyle().setFgColor(0x00000);
//        btnEventList.getStyle().setBorder(Border.createDashedBorder(CENTER, 0x00000));
//        btnAddEvent.getStyle().setBorder(Border.createDashedBorder(CENTER, 0x00000));
//         btnAddEvent.addActionListener((evt) -> {
//            new AddForm(this).show();
//        });
//        btnEventList.addActionListener((evt) -> {
//         
//            try {
//                new ListEventForm(this).show();
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//          
//        });
//        this.getToolbar().setTitle("L'interface de chef d'equipe");
//        this.getToolbar().add(BorderLayout.WEST, theme.getImage("driver.png"));
//        
//        this.getStyle().setBackgroundType(Style.BACKGROUND_IMAGE_SCALED);
//        this.setBgImage(theme.getImage("velo.png")); 
//        this.addAll(lOption,btnAddEvent, btnEventList);
//    }
    
}
