/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;



import javafx.scene.control.DatePicker;

/**
 *
 * @author HP
 */
public class validrendezvous {
    
private String emailR  ;
private String dateheure  ;
private String prix  ;
private String promo ; 
private String etat;  
private String message;  
private int reference;  
private int user ;
private int user_cc;

    public validrendezvous() {
    }

    public validrendezvous(String promo) {
        this.promo = promo;
    }

    public validrendezvous(String dateheure, String prix, String promo, String etat, String message) {
        this.dateheure = dateheure;
        this.prix = prix;
        this.promo = promo;
        this.etat = etat;
        this.message = message;
    }

    public validrendezvous(String emailR, String dateheure, String prix, String promo, String etat, String message) {
        this.emailR = emailR;
        this.dateheure = dateheure;
        this.prix = prix;
        this.promo = promo;
        this.etat = etat;
        this.message = message;
    }
    

    public validrendezvous(String emailR, String dateheure, String prix, String promo, String etat, String message, int reference, int user, int user_cc) {
        this.emailR = emailR;
        this.dateheure = dateheure;
        this.prix = prix;
        this.promo = promo;
        this.etat = etat;
        this.message = message;
        this.reference = reference;
        this.user = user;
        this.user_cc = user_cc;
    }

    public String getEmailR() {
        return emailR;
    }

    public void setEmailR(String emailR) {
        this.emailR = emailR;
    }

    public String getDateheure() {
        return dateheure;
    }

    public void setDateheure(String dateheure) {
        this.dateheure = dateheure;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getPromo() {
        return promo;
    }

    public void setPromo(String promo) {
        this.promo = promo;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getUser_cc() {
        return user_cc;
    }

    public void setUser_cc(int user_cc) {
        this.user_cc = user_cc;
    }



    @Override
    public String toString() {
        return "validrendezvous{" + "dateheure=" + dateheure + ", prix=" + prix + ", promo=" + promo + ", etat=" + etat + ", message=" + message + ", reference=" + reference + '}';
    }


}

