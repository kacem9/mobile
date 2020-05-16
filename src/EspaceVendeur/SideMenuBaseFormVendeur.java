/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EspaceVendeur;

import Gui.LoginForm;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.Layout;
import com.codename1.ui.util.Resources;

/**
 *
 * @author HP
 */
public abstract class SideMenuBaseFormVendeur  extends Form {

    public SideMenuBaseFormVendeur() {
    }

    public SideMenuBaseFormVendeur(String title) {
        super(title);
    }

    public SideMenuBaseFormVendeur(Layout contentPaneLayout) {
        super(contentPaneLayout);
    }

    public SideMenuBaseFormVendeur(String title, Layout contentPaneLayout) {
        super(title, contentPaneLayout);
    }
 public void setupSideMenuBaseFormVendeur(Resources res) {
        

        
        
        
       
        getToolbar().addMaterialCommandToSideMenu("  Locations", FontImage.MATERIAL_DIRECTIONS_BIKE,  e -> showLocationsForm(res));
        
        getToolbar().addMaterialCommandToSideMenu("  Logout", FontImage.MATERIAL_EXIT_TO_APP,  e -> new LoginForm(res).show());
    }
    
    
     protected abstract void showLocationsForm(Resources res);
    
}
