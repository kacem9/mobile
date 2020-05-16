/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EspaceClient;

import Entites.LigneDeCommandeProduit;
import Services.LigneDeCommandeServices;
import com.codename1.components.Accordion;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Font;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;

import java.util.ArrayList;

/**
 *
 * @author hatem
 */
public class AfficherLigneCommandes {

    LigneDeCommandeServices lcs = new LigneDeCommandeServices();
    private Form f;
    Button btnModif;
    public static Integer X =0;
    private Label createForFont(Font fnt, String s) {
        Label l = new Label(s);
        l.getUnselectedStyle().setFont(fnt);
        return l;
    }

    public AfficherLigneCommandes(Integer id) {
        f = new Form("Lignes de commande", new BorderLayout());
        Accordion accr = new Accordion();
        ArrayList<LigneDeCommandeProduit> lstlcp = lcs.getLignesCommandeProduit(id);
        System.out.println(id);
        System.out.println(lstlcp);
        for (LigneDeCommandeProduit lcp : lstlcp) {
        

            Label l1 = new Label(lcp.getLibelle() + " " + lcp.getDescription()+""+lcp.getIdLigneDeCommande());
            accr.addContent(l1, new SpanLabel(lcp.getAdresse() + " " + lcp.getAdresse2()));
            System.out.println("add" + lcp.getAdresse());

        }

        f.add(BorderLayout.CENTER, accr);
        f.show();

    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
}
