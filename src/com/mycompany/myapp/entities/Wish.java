/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

/**
 *
 * @author user
 */
public class Wish {
    
   private int id,id_prod,id_user;
   private String photo,nom;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Wish{" + "id=" + id + ", id_prod=" + id_prod + ", id_user=" + id_user + ", photo=" + photo + ", nom=" + nom + '}';
    }
    

    

    public int getId_prod() {
        return id_prod;
    }

    public void setId_prod(int id_prod) {
        this.id_prod = id_prod;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Wish() {
    }

   

    public Wish(int id_prod, int id_user, String nom, String photo) {
        this.id_prod = id_prod;
        this.id_user = id_user;
        this.nom = nom;
        this.photo = photo;
    }
    
}
