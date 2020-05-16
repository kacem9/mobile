
package Entites;

import java.util.List;
import javafx.collections.ObservableList;
import javafx.scene.control.CheckBox;

/**
 *
 * @author HP
 */
public class rendezvous {

private int Cin  ;
private String nom;
private String prenom  ;
private String email  ;
private String adresse ; 
private String message  ;
private String typepanne;
private int numtel;
public int user ;
private int fos ;

    public rendezvous(int Cin, String nom, String prenom, String email, String adresse, String message, String typepanne, int numtel,int user,int fos) {
        this.Cin = Cin;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.adresse = adresse;
        this.message = message;
        this.typepanne = typepanne;
        this.numtel = numtel;
         this.user = user;
         this.fos = fos;
    }


    public rendezvous(String typepanne,int Cin ) {
        this.Cin = Cin;
        this.typepanne = typepanne;
    }
     public rendezvous(String typepanne ,String message) {
      
        this.typepanne = typepanne;
        this.message = message;
    }

    public rendezvous(int Cin, String nom, String prenom, String email, String adresse, String message, String typepanne, int numtel, int user) {
        this.Cin = Cin;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.adresse = adresse;
        this.message = message;
        this.typepanne = typepanne;
        this.numtel = numtel;
        this.user = user;
        
    }

    public rendezvous() {
    }

    public int getCin() {
        return Cin;
    }

    public void setCin(int Cin) {
        this.Cin = Cin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTypepanne() {
        return typepanne;
    }

    public void setTypepanne(String typepanne) {
        this.typepanne = typepanne;
    }

    public int getNumtel() {
        return numtel;
    }

    public void setNumtel(int numtel) {
        this.numtel = numtel;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getFos() {
        return fos;
    }

    public void setFos(int fos) {
        this.fos = fos;
    }

    @Override
    public String toString() {
        return "rendezvous{" + "Cin=" + Cin + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", adresse=" + adresse + ", message=" + message + ", typepanne=" + typepanne + ", numtel=" + numtel +", user=" + user + ", fos=" + fos +'}';
    }





 

}
