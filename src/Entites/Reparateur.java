
package Entites;


import java.util.Date;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


/**
 *
 * @author HP
 */
public class Reparateur {
   private int id ;
   private String username;
   private String username_canonical;
   private String email;
   private String email_canonical;
   private int enabled;
   private String salt;
   private String password;
   private Date last_login;
   private String confirmation_token;
   private Date password_requested_at;
   private String roles;
   private String Cin;
   private String Nom;
   private String Prenom;
   private String Sexe;
   private Date Date_naissance;
   private String Num_tel;
   private String Adresse;
   private String Poste;
   private String Civilite;
   private String Pays;
   private String Ville;
   private String Code_postal;
   private String photo;
   private int  tentative;
   private int etat;

    public Reparateur() {
    }

    public Reparateur(int id, String username, String username_canonical, String email, String email_canonical, int enabled, String salt, String password, Date last_login, String confirmation_token, Date password_requested_at, String roles, String Cin, String Nom, String Prenom, String Sexe, Date Date_naissance, String Num_tel, String Adresse, String Poste, String Civilite, String Pays, String Ville, String Code_postal, String photo) {
        this.id = id;
        this.username = username;
        this.username_canonical = username_canonical;
        this.email = email;
        this.email_canonical = email_canonical;
        this.enabled = enabled;
        this.salt = salt;
        this.password = password;
        this.last_login = last_login;
        this.confirmation_token = confirmation_token;
        this.password_requested_at = password_requested_at;
        this.roles = roles;
        this.Cin = Cin;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Sexe = Sexe;
        this.Date_naissance = Date_naissance;
        this.Num_tel = Num_tel;
        this.Adresse = Adresse;
        this.Poste = Poste;
        this.Civilite = Civilite;
        this.Pays = Pays;
        this.Ville = Ville;
        this.Code_postal = Code_postal;
        this.photo = photo;
      
    }

    public Reparateur(int id, String email, String Nom, String Prenom, String Num_tel, String Ville) {
        this.id = id;
        this.email = email;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Num_tel = Num_tel;
        this.Ville = Ville;
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

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLast_login() {
        return last_login;
    }

    public void setLast_login(Date last_login) {
        this.last_login = last_login;
    }

    public String getConfirmation_token() {
        return confirmation_token;
    }

    public void setConfirmation_token(String confirmation_token) {
        this.confirmation_token = confirmation_token;
    }

    public Date getPassword_requested_at() {
        return password_requested_at;
    }

    public void setPassword_requested_at(Date password_requested_at) {
        this.password_requested_at = password_requested_at;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getCin() {
        return Cin;
    }

    public void setCin(String Cin) {
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

    public String getNum_tel() {
        return Num_tel;
    }

    public void setNum_tel(String Num_tel) {
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "fos_user{" + "id=" + id + ", Nom=" + Nom + ", Prenom=" + Prenom + '}';
    }
   
   
   
   
   
   
   
   
    
}
