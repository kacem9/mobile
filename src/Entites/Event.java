/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author root
 */
public class Event {
     int id  ;
 
    String Nom ;
    java.util.Date dt = new java.util.Date();
   java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
   String Date_event = sdf.format(dt);
    String Description ;
    String Lieu_event ;
    String Photo;
    Double Prix ;
    int Nbr_participant ;
    int etat ;
    int User;


    public Event() {
    }

    public Event(int id,String Nom,String Date_event, String Description, String Lieu_event, String Photo, Double Prix, int Nbr_participant, int etat) {
        this.id=id;
        this.Nom = Nom;
        this.Date_event=Date_event;
        this.Description = Description;
        this.Lieu_event = Lieu_event;
        this.Photo = Photo;
        this.Prix = Prix;
        this.Nbr_participant = Nbr_participant;
        this.etat = etat;
    }

    public Event(String Nom, String Description,String Date_event, String Lieu_event, String Photo, Double Prix, int Nbr_participant, int etat) {
        this.Nom = Nom;
        this.Description = Description;
        this.Date_event=Date_event;
        this.Lieu_event = Lieu_event;
        this.Photo = Photo;
        this.Prix = Prix;
        this.Nbr_participant = Nbr_participant;
        this.etat = etat;
    }

    public Event(int id, String Nom, String Description,String Date_event, String Lieu_event, String Photo, Double Prix, int Nbr_participant, int etat, int User) {
        this.id = id;
        this.Nom = Nom;
        this.Description = Description;
        this.Date_event=Date_event;
        this.Lieu_event = Lieu_event;
        this.Photo = Photo;
        this.Prix = Prix;
        this.Nbr_participant = Nbr_participant;
        this.etat = etat;
        this.User = User;
    }

   
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public Date getDt() {
        return dt;
    }

    public void setDt(Date dt) {
        this.dt = dt;
    }

    public SimpleDateFormat getSdf() {
        return sdf;
    }

    public void setSdf(SimpleDateFormat sdf) {
        this.sdf = sdf;
    }

    public String getDate_event() {
        return Date_event;
    }

    public void setDate_event(String Date_event) {
        this.Date_event = Date_event;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getLieu_event() {
        return Lieu_event;
    }

    public void setLieu_event(String Lieu_event) {
        this.Lieu_event = Lieu_event;
    }

    public String getPhoto() {
        return Photo;
    }

    public void setPhoto(String Photo) {
        this.Photo = Photo;
    }

    public Double getPrix() {
        return Prix;
    }

    public void setPrix(Double Prix) {
        this.Prix = Prix;
    }

    public int getNbr_participant() {
        return Nbr_participant;
    }

    public void setNbr_participant(int Nbr_participant) {
        this.Nbr_participant = Nbr_participant;
    }


    public int getUser() {
        return User;
    }

    public void setUser(int User) {
        this.User = User;
    }


    

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

   

}
