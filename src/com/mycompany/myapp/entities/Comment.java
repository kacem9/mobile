/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

import java.util.Date;

/**
 *
 * @author user
 */
public class Comment {
  private  int id,id_user,id_Prod;
  private String comment,Rate,model,type,price,quantity,photo;
 
   java.util.Date dt = new java.util.Date();
   java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
   String datePublication = sdf.format(dt);

    public Comment() {
    }

    public Comment(int id, int id_user, int id_Prod, String comment, String Rate, String model, String type, String price, String quantity, String photo, String datePublication) {
        this.id = id;
        this.id_user = id_user;
        this.id_Prod = id_Prod;
        this.comment = comment;
        this.Rate = Rate;
        this.model = model;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
        this.photo = photo;
        this.datePublication = datePublication;
    }

    public Comment(int id_user, int id_Prod, String comment, String photo, String datePublication) {
        this.id_user = id_user;
        this.id_Prod = id_Prod;
        this.comment = comment;
        this.photo = photo;
        this.datePublication = datePublication;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_Prod() {
        return id_Prod;
    }

    public void setId_Prod(int id_Prod) {
        this.id_Prod = id_Prod;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getRate() {
        return Rate;
    }

    public void setRate(String Rate) {
        this.Rate = Rate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(String datePublication) {
        this.datePublication = datePublication;
    }
    
}
