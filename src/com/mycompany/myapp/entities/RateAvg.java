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
public class RateAvg {
   private int id,id_Prod ,nbComment;

    public RateAvg() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_Prod() {
        return id_Prod;
    }

    public void setId_Prod(int id_Prod) {
        this.id_Prod = id_Prod;
    }

    public int getNbComment() {
        return nbComment;
    }

    public void setNbComment(int nbComment) {
        this.nbComment = nbComment;
    }

    public double getAvgRate() {
        return avgRate;
    }

    public void setAvgRate(double avgRate) {
        this.avgRate = avgRate;
    }

    public RateAvg(int id, int id_Prod, int nbComment, double avgRate) {
        this.id = id;
        this.id_Prod = id_Prod;
        this.nbComment = nbComment;
        this.avgRate = avgRate;
    }

    public RateAvg(int id_Prod, int nbComment, double avgRate) {
        this.id_Prod = id_Prod;
        this.nbComment = nbComment;
        this.avgRate = avgRate;
    }
   private double avgRate;
}
