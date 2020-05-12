/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import com.codename1.notifications.LocalNotification;
import com.codename1.notifications.LocalNotificationCallback;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import java.io.IOException;

/**
 *
 * @author root
 */
public class BackgroundLocationDemo extends Form implements LocalNotificationCallback {
            //...
     private Resources theme;

            public void init(Object context) {
                  try {
            theme = Resources.openLayered("/theme");
            UIManager.getInstance().setThemeProps(theme.getTheme(theme.getThemeResourceNames()[0]));
        } catch(IOException e){
            e.printStackTrace();
        }
            }
 int badgeNumber = 0;
            public void start(Form previous) {
             
        Form hi = new Form("Hi World");
        hi.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        hi.addComponent(new Label("ID"));
        final TextField id = new TextField();
        hi.addComponent(id);
        
        hi.addComponent(new Label("Title"));
        final TextField title = new TextField();
        hi.addComponent(title);
        
        hi.addComponent(new Label("Body"));
        final TextField body = new TextField();
        hi.addComponent(body);
        
        
        hi.addComponent(new Label("Interval"));
        final ComboBox interval = new ComboBox(new Object[]{ "None", "Minute", "Hour", "Day", "Week"});
        hi.addComponent(interval);
        
        
        Button b = new Button("Send Notification");
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LocalNotification n = new LocalNotification();
                n.setAlertBody(body.getText());
                n.setAlertTitle(title.getText());
                n.setId(id.getText());
                n.setBadgeNumber(badgeNumber++);

                int repeatType = LocalNotification.REPEAT_NONE;
                String selRepeat = (String)interval.getModel().getItemAt(interval.getModel().getSelectedIndex());
                if ("Minute".equals(selRepeat)) {
                    repeatType = LocalNotification.REPEAT_MINUTE;
                } else if ("Hour".equals(selRepeat)) {
                    repeatType = LocalNotification.REPEAT_HOUR;
                } else if ("Day".equals(selRepeat)) {
                    repeatType = LocalNotification.REPEAT_DAY;
                } else if( "Week".equals(selRepeat)) {
                    repeatType = LocalNotification.REPEAT_WEEK;
                }

                Display.getInstance().scheduleLocalNotification(n, System.currentTimeMillis() + 10 * 1000, repeatType);
            }
        });
        hi.addComponent(b);
        
        Button cancel = new Button("Cancel Notification");
            
        cancel.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                Display.getInstance().cancelLocalNotification(id.getText());
            }
            
        });
        
        
        hi.addComponent(cancel);
        
        Button clearBadgeNumber = new Button("Clear Badge");
        clearBadgeNumber.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Display.getInstance().setBadgeNumber(0);
            }
        });
        hi.addComponent(clearBadgeNumber);
        hi.getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
        hi.show();
 
            }

            public void stop() {
                Display.getInstance().getCurrent();
            }

            public void destroy() {
                //...
            }

            public void localNotificationReceived(String notificationId) {
                System.out.println("Received local notification "+notificationId);
            }
        }
       
