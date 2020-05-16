/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EspaceClient;

import Gui.LoginForm;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.Layout;
import com.codename1.ui.util.Resources;

/**
 *
 * @author root
 */
public abstract class SideMenuBaseForm extends Form {

    public SideMenuBaseForm(String title, Layout contentPaneLayout) {
        super(title, contentPaneLayout);
    }

    public SideMenuBaseForm(String title) {
        super(title);
    }

    public SideMenuBaseForm() {
    }

    public SideMenuBaseForm(Layout contentPaneLayout) {
        super(contentPaneLayout);
    }
    
    public void setupSideMenu(Resources res) {
        

        
        
        
        getToolbar().addMaterialCommandToSideMenu("  Evenements", FontImage.MATERIAL_DASHBOARD,  e -> showEventForm(res));
   //     getToolbar().addMaterialCommandToSideMenu("  Velos", FontImage.MATERIAL_DIRECTIONS_BIKE,  e -> showVelosForm(res));
       
   
   getToolbar().addMaterialCommandToSideMenu("  Locations", FontImage.MATERIAL_DIRECTIONS_BIKE,  e -> showLocationsForm(res));
                getToolbar().addMaterialCommandToSideMenu("orders", FontImage.MATERIAL_AC_UNIT, e->{new AffichageCommande().getF().show();});
                            getToolbar().addMaterialCommandToSideMenu("Card", FontImage.MATERIAL_AC_UNIT, e->{new AfficherPanier().getF().show();});
                             getToolbar().addMaterialCommandToSideMenu(" Reparations ", FontImage.MATERIAL_SETTINGS,  e -> showReparationsForm(res));
                 //     getToolbar().addMaterialCommandToSideMenu("Home", FontImage.MATERIAL_AC_UNIT, e-> ProfileFormv(res));
   
//  getToolbar().addMaterialCommandToSideMenu("  Locations", FontImage.MATERIAL_DIRECTIONS_BIKE,  e -> showLocationsForm(res));
        //   getToolbar().addMaterialCommandToSideMenu("  Reclamations", FontImage.MATERIAL_ACCESS_TIME,  e -> showReclamationsForm(res));
       // getToolbar().addMaterialCommandToSideMenu(" Reparations ", FontImage.MATERIAL_SETTINGS,  e -> showReparationsForm(res));
        getToolbar().addMaterialCommandToSideMenu("  Logout", FontImage.MATERIAL_EXIT_TO_APP,  e -> new LoginForm(res).show());
    }
    
    
   // protected abstract void showEventForm(Resources res);
    protected abstract void showLocationsForm(Resources res);

    protected abstract void showEventForm(Resources res) ;

     protected abstract void showReparationsForm(Resources res);
}

