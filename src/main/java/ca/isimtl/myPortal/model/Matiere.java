/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.isimtl.myPortal.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Francois YOUALEU
 */
public class Matiere implements Serializable{
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotEmpty
    @Column(name = "no_cours", nullable = false)
    private String noCours;
    
    @NotEmpty
    @Column(name = "titre", nullable = false)
    private String titre;
    
    @NotEmpty
    @Column(name = "description", nullable = false)
    private String description;
    
    @NotEmpty
    @Column(name = "duree", nullable = false)
    private String duree;
    
    @NotEmpty
    @Column(name = "prix", nullable = false)
    private String prix;

    public Matiere() {
    }

    public Matiere(int id, String noCours, String titre, String description, String duree, String prix) {
        this.id = id;
        this.noCours = noCours;
        this.titre = titre;
        this.description = description;
        this.duree = duree;
        this.prix = prix;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNoCours() {
        return noCours;
    }

    public void setNoCours(String noCours) {
        this.noCours = noCours;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }
    
}
