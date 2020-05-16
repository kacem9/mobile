/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author bhk
 */
public class FosUser implements Serializable {

    int id;
    String Cin, Prenom, Nom, Sexe, roles, Civilite, Pays, Ville, Code_postal, Poste, Email, Username, Photo, Adresse, Num_tel, Password, username_canonical, email_canonical,
            salt, confirmation_token;
    java.util.Date dt = new java.util.Date();
    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String Date_naissance = sdf.format(dt);
    boolean enabled;
    Date password_requested_at, last_login;

    public FosUser() {
    }

    public FosUser(Integer id) {
        this.id = id;
    }

    public FosUser(int id, String Cin, String Prenom, String Nom, String Sexe, String roles, String Civilite, String Pays, String Ville, String Code_postal, String Poste, String Email, String Username, String Photo, String Adresse, String Num_tel, String Password, String username_canonical, String email_canonical, String salt, String confirmation_token, boolean enabled, Date password_requested_at, Date last_login, String Date_naissance) {
        this.id = id;
        this.Cin = Cin;
        this.Prenom = Prenom;
        this.Nom = Nom;
        this.Sexe = Sexe;
        this.roles = roles;
        this.Civilite = Civilite;
        this.Pays = Pays;
        this.Ville = Ville;
        this.Code_postal = Code_postal;
        this.Poste = Poste;
        this.Email = Email;
        this.Username = Username;
        this.Photo = Photo;
        this.Adresse = Adresse;
        this.Num_tel = Num_tel;
        this.Password = Password;
        this.username_canonical = username_canonical;
        this.email_canonical = email_canonical;
        this.salt = salt;
        this.confirmation_token = confirmation_token;
        this.enabled = enabled;
        this.password_requested_at = password_requested_at;
        this.last_login = last_login;
        this.Date_naissance = Date_naissance;
    }

    public FosUser(int id, String Cin, String Prenom, String Nom, String Sexe, String roles, String Civilite, String Pays, String Ville, String Code_postal, String Poste, String Email, String Username, String Photo, String pays, String ville) {
        this.id = id;
        this.Cin = Cin;
        this.Prenom = Prenom;
        this.Nom = Nom;
        this.Sexe = Sexe;
        this.roles = roles;
        this.Civilite = Civilite;
        this.Pays = Pays;
        this.Ville = Ville;
        this.Code_postal = Code_postal;
        this.Poste = Poste;
        this.Email = Email;
        this.Username = Username;
        this.Photo = Photo;
        this.Pays = Pays;
        this.Ville = Ville;
    }

    public FosUser(int id, String Prenom, String photo, String roles, String Sexe) {
        this.id = id;
        this.Photo = photo;
        this.Prenom = Prenom;
        this.roles = roles;
        this.Sexe = Sexe;

    }
//constructeur register
    public FosUser(String Username, String Password, String Date_naissance, String Poste, String Cin, String Nom, String Prenom, String Email, String Num_tel, String Code_postal, String Adresse, String Photo, String Civilite, String Pays, String Ville, String Sexe, String roles) {
        this.Cin = Cin;
        this.Prenom = Prenom;
        this.Nom = Nom;
        this.Civilite = Civilite;
        this.Code_postal = Code_postal;
        this.Poste = Poste;
        this.Email = Email;
        this.Username = Username;
        this.Photo = Photo;
        this.Civilite = Civilite;
        this.Sexe = Sexe;
        this.roles = roles;
        this.Adresse = Adresse;
        this.Num_tel = Num_tel;
        this.Password = Password;
         this.Pays = Pays;
        this.Ville = Ville;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCin() {
        return Cin;
    }

    public void setCin(String Cin) {
        this.Cin = Cin;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getSexe() {
        return Sexe;
    }

    public void setSexe(String Sexe) {
        this.Sexe = Sexe;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
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

    public String getPoste() {
        return Poste;
    }

    public void setPoste(String Poste) {
        this.Poste = Poste;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPhoto() {
        return Photo;
    }

    public void setPhoto(String Photo) {
        this.Photo = Photo;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    public String getNum_tel() {
        return Num_tel;
    }

    public void setNum_tel(String Num_tel) {
        this.Num_tel = Num_tel;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getUsername_canonical() {
        return username_canonical;
    }

    public void setUsername_canonical(String username_canonical) {
        this.username_canonical = username_canonical;
    }

    public String getEmail_canonical() {
        return email_canonical;
    }

    public void setEmail_canonical(String email_canonical) {
        this.email_canonical = email_canonical;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getConfirmation_token() {
        return confirmation_token;
    }

    public void setConfirmation_token(String confirmation_token) {
        this.confirmation_token = confirmation_token;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Date getPassword_requested_at() {
        return password_requested_at;
    }

    public void setPassword_requested_at(Date password_requested_at) {
        this.password_requested_at = password_requested_at;
    }

    public Date getLast_login() {
        return last_login;
    }

    public void setLast_login(Date last_login) {
        this.last_login = last_login;
    }

    public String getDate_naissance() {
        return Date_naissance;
    }

    public void setDate_naissance(String Date_naissance) {
        this.Date_naissance = Date_naissance;
    }

    @Override
    public String toString() {
        return "Fos_user{" + "id=" + id + ", Cin=" + Cin + ", Prenom=" + Prenom + ", Nom=" + Nom + ", Sexe=" + Sexe + ", roles=" + roles + ", Civilite=" + Civilite + ", Pays=" + Pays + ", Ville=" + Ville + ", Code_postal=" + Code_postal + ", Poste=" + Poste + ", Email=" + Email + ", Username=" + Username + ", Photo=" + Photo + ", Adresse=" + Adresse + ", Num_tel=" + Num_tel + ", Password=" + Password + ", username_canonical=" + username_canonical + ", email_canonical=" + email_canonical + ", salt=" + salt + ", confirmation_token=" + confirmation_token + ", enabled=" + enabled + ", password_requested_at=" + password_requested_at + ", last_login=" + last_login + ", Date_naissance=" + Date_naissance + '}';
    }

}
