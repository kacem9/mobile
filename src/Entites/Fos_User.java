/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;

import java.util.Date;



/**
 *
 * @author root
 */
public class Fos_User {
    int id ;
    String username ;
    String username_canonical ;
    String email ;
    String email_canonical ;
    String password ;
    String roles ;
    int Cin ;
    String Nom ;
    String Prenom ;
    String Sexe ;
    Date Date_naissance ;
    int Num_tel ;
    String Adresse ;
    String Poste ;
    String Civilite ;
    String Pays ;
    String Ville ;
    String Code_postal ;

    public Fos_User() {
    }

    public Fos_User(int id, String username, String username_canonical, String email, String email_canonical, String password, String roles, int Cin, String Nom, String Prenom, String Sexe,  int Num_tel, String Adresse, String Poste, String Civilite, String Pays, String Ville, String Code_postal) {
        this.id = id;
        this.username = username;
        this.username_canonical = username_canonical;
        this.email = email;
        this.email_canonical = email_canonical;
        this.password = password;
        this.roles = roles;
        this.Cin = Cin;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Sexe = Sexe;
       
        this.Num_tel = Num_tel;
        this.Adresse = Adresse;
        this.Poste = Poste;
        this.Civilite = Civilite;
        this.Pays = Pays;
        this.Ville = Ville;
        this.Code_postal = Code_postal;
    }

    

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername_canonical() {
        return username_canonical;
    }

    public void setUsername_canonical(String username_canonical) {
        this.username_canonical = username_canonical;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail_canonical() {
        return email_canonical;
    }

    public void setEmail_canonical(String email_canonical) {
        this.email_canonical = email_canonical;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public int getCin() {
        return Cin;
    }

    public void setCin(int Cin) {
        this.Cin = Cin;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    public String getSexe() {
        return Sexe;
    }

    public void setSexe(String Sexe) {
        this.Sexe = Sexe;
    }

    public Date getDate_naissance() {
        return Date_naissance;
    }

    public void setDate_naissance(Date Date_naissance) {
        this.Date_naissance = Date_naissance;
    }

    public int getNum_tel() {
        return Num_tel;
    }

    public void setNum_tel(int Num_tel) {
        this.Num_tel = Num_tel;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    public String getPoste() {
        return Poste;
    }

    public void setPoste(String Poste) {
        this.Poste = Poste;
    }

    public String getCivilite() {
        return Civilite;
    }

    public void setCivilite(String Civilite) {
        this.Civilite = Civilite;
    }

    public String getPays() {
        return Pays;
    }

    public void setPays(String Pays) {
        this.Pays = Pays;
    }

    public String getVille() {
        return Ville;
    }

    public void setVille(String Ville) {
        this.Ville = Ville;
    }

    public String getCode_postal() {
        return Code_postal;
    }

    public void setCode_postal(String Code_postal) {
        this.Code_postal = Code_postal;
    }

    @Override
    public String toString() {
        return "Fos_User{" + "id=" + id + ", username=" + username + ", username_canonical=" + username_canonical + ", email=" + email + ", email_canonical=" + email_canonical + ", password=" + password + ", roles=" + roles + ", Cin=" + Cin + ", Nom=" + Nom + ", Prenom=" + Prenom + ", Sexe=" + Sexe + ", Date_naissance=" + Date_naissance + ", Num_tel=" + Num_tel + ", Adresse=" + Adresse + ", Poste=" + Poste + ", Civilite=" + Civilite + ", Pays=" + Pays + ", Ville=" + Ville + ", Code_postal=" + Code_postal + '}';
    }
}
