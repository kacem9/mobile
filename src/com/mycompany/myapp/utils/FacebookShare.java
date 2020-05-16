/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.utils;

import com.codename1.share.ShareService;
import com.codename1.ui.Image;

/**
 *
 * @author user
 */
public class FacebookShare extends ShareService{

    public FacebookShare(String name, Image icon) {
        super(name, icon);
    }

    @Override
    public void share(String text, String image, String mime) {
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean canShareImage() {
        return false;
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void share(String text) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
