/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

/**
 *
 * @author HP
 */
public class Categories {
    private String Nom ,Age ;  
    private int id;

    public Categories(String Nom, String Age) {
        this.Nom = Nom;
        this.Age = Age;
    }

    public Categories(String Nom) {
        this.Nom = Nom;
    }

    public Categories(int id) {
        this.id = id;
    }

    public Categories() {
    }

    @Override
    public String toString() {
        return  Nom ;
    }

    public Categories(int id,String Nom) {
        this.Nom = Nom;
        this.id = id;
    }

   
    
    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String Age) {
        this.Age = Age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

  
    
    
}
