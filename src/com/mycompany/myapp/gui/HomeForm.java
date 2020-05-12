/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.charts.ChartComponent;
import com.codename1.charts.models.CategorySeries;
import com.codename1.charts.renderers.DefaultRenderer;
import com.codename1.charts.renderers.SimpleSeriesRenderer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.charts.views.PieChart;
import com.codename1.ui.Button;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.mycompany.myapp.entities.Categories;
import com.mycompany.myapp.utils.Statistique;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bhk
 */
public class HomeForm extends Form{
Form current;
    public HomeForm() {
        //Statistique st=new Statistique();
        current=this;
        setTitle("Home");
        setLayout(BoxLayout.y());
        
        add(new Label("Choose an option"));
       // Button btnAddTask = new Button("Add Task");
         Button btnAddCmd = new Button("Add  commande");
        Button btnListcmd = new Button("List Commandes");
         Button btnListvelos = new Button("List Velos");
         Button btnAddVelos = new Button("Add Velo");
         Button btnStat = new Button("Statistics");        
         Button btnShow = new Button(" Show Statistics");
         
         FontImage.setMaterialIcon(btnListvelos, FontImage.MATERIAL_DIRECTIONS_BIKE);
          FontImage.setMaterialIcon(btnListcmd, FontImage.MATERIAL_GRID_VIEW);
          FontImage.setMaterialIcon(btnAddCmd, FontImage.MATERIAL_ADD_CIRCLE_OUTLINE);
             FontImage.setMaterialIcon(btnAddVelos, FontImage.MATERIAL_ADD_CIRCLE_OUTLINE);
               FontImage.setMaterialIcon(btnStat, FontImage.MATERIAL_INSERT_CHART);
                FontImage.setMaterialIcon(btnShow, FontImage.MATERIAL_GRID_VIEW);
          
         
          btnAddCmd.getUnselectedStyle().setBgTransparency(255);
        btnAddCmd.getStyle().setMargin(50, 50, 70, 70);
        btnListcmd.getUnselectedStyle().setBgTransparency(255);
        btnListcmd.getStyle().setMargin(50, 50, 70, 70);
        btnListvelos.getUnselectedStyle().setBgTransparency(255);
        btnListvelos.getStyle().setMargin(50, 50, 70, 70);
         btnAddVelos.getUnselectedStyle().setBgTransparency(255);
        btnAddVelos.getStyle().setMargin(50, 50, 70, 70);
         btnStat.getUnselectedStyle().setBgTransparency(255);
        btnStat.getStyle().setMargin(50, 50, 70, 70);
         btnShow.getUnselectedStyle().setBgTransparency(255);
        btnShow.getStyle().setMargin(50, 50, 70, 70);
        
         btnAddCmd.addActionListener(e->new AddCommandeForm(current).show());
      //  btnAddTask.addActionListener(e-> new AddTaskForm(current).show());
        btnListcmd .addActionListener(e-> new ListCommandesForm(current).show());
         btnListvelos .addActionListener(e-> new ListVelosForm(current).show());
          btnAddVelos .addActionListener(e-> new AddVeloForm(current).show());
          btnStat.addActionListener(e-> new Statistique().createPieChartForm(current).show());
           btnShow .addActionListener(e-> new ListStatCategories(current).show());
        addAll(btnAddCmd,btnListcmd ,btnListvelos,btnAddVelos,btnStat,btnShow);
        
       // Form home = new Form("Home");
        Form listCommande = new ListCommandesForm(current);
        Form ajoutCommande = new AddCommandeForm(current);
        Form listVelos=new ListVelosForm(current);
        Form addVelo=new AddVeloForm(current);
        
//        f1.getToolbar().addCommandToLeftBar("back", FontImage.createMaterial(FontImage.MATERIAL_HOME, new Style()), (evt) -> {
//            this.showBack();
//        });
//        
//        f2.getToolbar().addCommandToLeftBar("back", FontImage.createMaterial(FontImage.MATERIAL_HOME, new Style()), (evt) -> {
//            this.showBack();
//        });
        
        ajoutCommande.getToolbar().addCommandToOverflowMenu("say hello", FontImage.createMaterial(FontImage.MATERIAL_ARROW_DROP_UP, new Style()), (evt) -> {
            System.out.println("Hello all");
        });
        listCommande.getToolbar().addCommandToOverflowMenu("say goodbye", FontImage.createMaterial(FontImage.MATERIAL_BORDER_HORIZONTAL, new Style()), (evt) -> {
            System.out.println("Goodbye");
        });
        
        listVelos.getToolbar().addCommandToOverflowMenu("say goodbye", FontImage.createMaterial(FontImage.MATERIAL_BORDER_HORIZONTAL, new Style()), (evt) -> {
            System.out.println("Goodbye");
        });
        
        
        //right home side menu 
        
        this.getToolbar().addCommandToOverflowMenu("account :", null, (evt) -> {
            
            
            
           // listVelos.show();
        });
        
        //left home side menu 
         this.getToolbar().addCommandToSideMenu("", null, (evt) -> {
            
            
            
           // listVelos.show();
        });
        
        
            this.getToolbar().addCommandToSideMenu("  List velos  ", FontImage.createMaterial(FontImage.MATERIAL_LIST, new Style()), (evt) -> {
            
            
            
            listVelos.show();
        });
        
            
             this.getToolbar().addCommandToSideMenu("  Add velo  ", FontImage.createMaterial(FontImage.MATERIAL_ADD, new Style()), (evt) -> {
            
            
            
            addVelo.show();
        });
        this.getToolbar().addCommandToSideMenu("  list Commandes ",FontImage.createMaterial(FontImage.MATERIAL_LIST, new Style()), (evt) -> {
            
            
            listCommande.show();
        });
        
         this.getToolbar().addCommandToSideMenu("  Add commande  ", FontImage.createMaterial(FontImage.MATERIAL_ADD, new Style()), (evt) -> {
            
            
            ajoutCommande.show();
        });
         
       
      //  this.show();
    }
    
    
   


    
    
}
