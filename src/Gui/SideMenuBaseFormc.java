/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

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
public abstract class SideMenuBaseFormc extends Form {

    public SideMenuBaseFormc(String title, Layout contentPaneLayout) {
        super(title, contentPaneLayout);
    }

    public SideMenuBaseFormc(String title) {
        super(title);
    }

    public SideMenuBaseFormc() {
    }

    public SideMenuBaseFormc(Layout contentPaneLayout) {
        super(contentPaneLayout);
    }
    
    public void setupSideMenu(Resources res) {
        

        
        
        
        getToolbar().addMaterialCommandToSideMenu("  Evenements", FontImage.MATERIAL_DASHBOARD,  e -> showEventForm(res));
      
        getToolbar().addMaterialCommandToSideMenu("  Logout", FontImage.MATERIAL_EXIT_TO_APP,  e -> new LoginForm(res).show());
    }
    
    
    protected abstract void showEventForm(Resources res);
   
}

