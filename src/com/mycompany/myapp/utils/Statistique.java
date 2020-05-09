/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.utils;

import com.codename1.charts.ChartComponent;
import com.codename1.charts.models.CategorySeries;
import com.codename1.charts.renderers.DefaultRenderer;
import com.codename1.charts.renderers.SimpleSeriesRenderer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.charts.views.PieChart;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BorderLayout;
import com.mycompany.myapp.entities.Count;
import com.mycompany.myapp.gui.HomeForm;
import com.mycompany.myapp.services.ServiceStatistique;
import java.util.ArrayList;


/**
 *
 * @author user
 */
public class Statistique {
ArrayList<Count>comands = ServiceStatistique.getInstance().getAllStat();
    public Statistique() {
        
        
        
    }
    
     private DefaultRenderer buildCategoryRenderer(int[] colors) {
    DefaultRenderer renderer = new DefaultRenderer();
    renderer.setLabelsTextSize(60);
    renderer.setLegendTextSize(60);
    renderer.setMargins(new int[]{20, 30, 20, 20});
    for (int color : colors) {
        SimpleSeriesRenderer r = new SimpleSeriesRenderer();
        r.setColor(color);
        renderer.addSeriesRenderer(r);
    }
    return renderer;
}
 

protected CategorySeries buildCategoryDatase( String title,double[] values) {
   CategorySeries series = new CategorySeries(title);
    int k = 0;
    String[] categories = new String[]{"Sports Bike","Cyclocross Bike","Road Bike","Kids Bikes","Mountain Bikes"};
    for (double value : values) {
        series.add("Category : " +categories[k] , value);
        ++k;
    }

    return series;
}

public  Form createPieChartForm(Form previous) {
    // Generate the values
    double[] values = new double[]{comands.get(0).getValue(), comands.get(1).getValue(), comands.get(2).getValue(),comands.get(3).getValue(), comands.get(4).getValue()};

    // Set up the renderer
    int[] colors = new int[]{ColorUtil.BLUE, ColorUtil.GREEN, ColorUtil.MAGENTA, ColorUtil.GRAY, ColorUtil.CYAN};
    DefaultRenderer renderer = buildCategoryRenderer(colors);
    renderer.setZoomButtonsVisible(true);
    renderer.setZoomEnabled(true);
    renderer.setChartTitleTextSize(20);
    renderer.setDisplayValues(true);
    renderer.setShowLabels(true);
    SimpleSeriesRenderer r = renderer.getSeriesRendererAt(0);
    r.setGradientEnabled(true);
    r.setGradientStart(0, ColorUtil.BLUE);
    r.setGradientStop(0, ColorUtil.GREEN);
    r.setHighlighted(true);

    // Create the chart ... pass the values and renderer to the chart object.
    PieChart chart = new PieChart(buildCategoryDatase("hhhhhhh",values), renderer);

    // Wrap the chart in a Component so we can add it to a form
    ChartComponent c = new ChartComponent(chart);

    // Create a form and show it.
    Form f = new Form("Number of Bikes per Category", new BorderLayout());
    f.getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
    f.add(BorderLayout.CENTER, c);
    System.out.println("hhhhhhhhhhhhhhhhhhhhhhhh");
    
   return f;
    
}

}
