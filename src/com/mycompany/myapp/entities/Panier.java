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
public class Panier {
    
   private int id,id_prod,id_user,quantite;
   private String photo,nom;
   private int prix;

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getId() {
        return id;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
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

    public Panier() {
    }

   

    public Panier(int id_prod, int id_user,int quantite, String nom, String photo,int prix) {
        this.id_prod = id_prod;
        this.id_user = id_user;
        this.quantite=quantite;
        this.nom = nom;
        this.photo = photo;
        this.prix=prix;
    }
    
}
