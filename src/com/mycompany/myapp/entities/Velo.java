/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

import java.util.Date;

/**
 *
 * @author HP
 */
public class Velo {
    
     private int id,quantity,etat_vendu,etat_location,price,user_id;
     private Date date_circulation;
     private Date datePublication;
     private String description ,localitsation_velo,photo ;
     private int price_location;
     private Categories categories_id;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    

    public Velo(Date date_circulation, Date datePublication, String description, String localitsation_velo, String photo) {
        this.date_circulation = date_circulation;
        this.datePublication = datePublication;
        this.description = description;
        this.localitsation_velo = localitsation_velo;
        this.photo = photo;
    }

    public Velo(int id, String description,int quantity,int price_location,int price) {
        this.id = id;
        this.quantity = quantity;
        this.description = description;
        this.price_location = price_location;
        this.price=price;
            

    }

    public Categories getCategories_id() {
        return categories_id;
    }

    public void setCategories_id(Categories categories_id) {
        this.categories_id = categories_id;
    }

  

           

    public Velo(int quantity, Date date_circulation, Date datePublication, String description, String localitsation_velo, int etat_vendu, int etat_location,int price_location) {
        this.quantity = quantity;
        this.etat_vendu = etat_vendu;
        this.etat_location = etat_location;
        this.date_circulation = date_circulation;
        this.datePublication = datePublication;
        this.description = description;
        this.localitsation_velo = localitsation_velo;

        this.price_location = price_location;

    }

    public Velo(Categories categories_id) {
        this.categories_id = categories_id;
    }



    public Velo() {
     
    }

  

     
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getEtat_vendu() {
        return etat_vendu;
    }

    public void setEtat_vendu(int etat_vendu) {
        this.etat_vendu = etat_vendu;
    }

    public int getEtat_location() {
        return etat_location;
    }

    public void setEtat_location(int etat_location) {
        this.etat_location = etat_location;
    }

    public Date getDate_circulation() {
        return date_circulation;
    }

    public void setDate_circulation(Date date_circulation) {
        this.date_circulation = date_circulation;
    }

    public Date getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(Date datePublication) {
        this.datePublication = datePublication;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocalitsation_velo() {
        return localitsation_velo;
    }

    public void setLocalitsation_velo(String localitsation_velo) {
        this.localitsation_velo = localitsation_velo;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getPrice_location() {
        return price_location;
    }

    public void setPrice_location(int price_location) {
        this.price_location = price_location;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
 
    
    
}

    public Velo( Date date_circulation, Date datePublication,int quantity, int price_location, Categories categories_id) {
        this.quantity = quantity;
        this.date_circulation = date_circulation;
        this.datePublication = datePublication;
        this.price_location = price_location;
        this.categories_id = categories_id;
    }

    @Override
    public String toString() {
        return "Velo{" + "id=" + id + ", quantity=" + quantity + ", etat_vendu=" + etat_vendu + ", etat_location=" + etat_location + ", user_id=" + user_id + ", date_circulation=" + date_circulation + ", datePublication=" + datePublication + ", description=" + description + ", localitsation_velo=" + localitsation_velo + ", photo=" + photo + ", price_location=" + price_location + ", categories_id=" + categories_id +  ", price=" + price+'}';
    }

 

  
}