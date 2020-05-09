/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;

/**
 *
 * @author root
 */
public class Participation {
    int id_participation ;
    int id_user ;
    int event ;

    public Participation() {
    }

    public Participation(int id_participation, int id_user, int event) {
        this.id_participation = id_participation;
        this.id_user = id_user;
        this.event = event;
    }

    public int getId_participation() {
        return id_participation;
    }

    public void setId_participation(int id_participation) {
        this.id_participation = id_participation;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getEvent() {
        return event;
    }

    public void setEvent(int event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "Participation{" + "id_participation=" + id_participation + ", id_user=" + id_user + ", event=" + event + '}';
    }
    
}
