/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.isimtl.myPortal.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Francois YOUALEU
 */
@Entity
@Table(name="user")
public class Users implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "login", nullable = false)
    private String login;
    
    @Column(name = "password", nullable = false)
    private String pwd;
    
    @Column(name = "nom", nullable = false)
    private String nom;
    
    @Column(name = "prenom", nullable = false)
    private String prenom;
    
    @DateTimeFormat(pattern="dd/MM/yyyy")
    @Column(name="date_naissance", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateNaissance;
    
    @Column(name = "telephone", nullable = false)
    private String telephone;
    
    @Column(name = "email", nullable = false)
    private String email;
    
    @Column(name = "adresse", nullable = false)
    private String adresse;
    
    @Column(name = "NAS", nullable = true)
    private String numeroAssuranceSociale;
    
    @Column(name = "photo", nullable = true)
    private String photo;
    
    @Column(name = "role_id", nullable = false)
    private int roleID;
    
    @Column(name = "titre", nullable = true)
    private String titre;
    
    @Column(name = "active", nullable = false)
    private Boolean active;

    public Users() {
    }

    public Users(int id, String login, String pwd, String nom, String prenom, Date dateNaissance, String telephone, String email, String adresse, String numeroAssuranceSociale, String photo, int roleID, String titre, Boolean active) {
        this.id = id;
        this.login = login;
        this.pwd = pwd;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.telephone = telephone;
        this.email = email;
        this.adresse = adresse;
        this.numeroAssuranceSociale = numeroAssuranceSociale;
        this.photo = photo;
        this.roleID = roleID;
        this.titre = titre;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
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

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
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

    public String getNumeroAssuranceSociale() {
        return numeroAssuranceSociale;
    }

    public void setNumeroAssuranceSociale(String numeroAssuranceSociale) {
        this.numeroAssuranceSociale = numeroAssuranceSociale;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
    
}
