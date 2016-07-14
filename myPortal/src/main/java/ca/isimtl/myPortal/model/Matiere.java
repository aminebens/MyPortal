/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.isimtl.myPortal.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Francois YOUALEU
 */
@Entity
@Table(name = "matiere")
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
       
    @Column(name = "duree", nullable = false)
    private int duree;
    
    @Column(name = "prix", nullable = false)
    private Double prix;

    public Matiere() {
    }

    public Matiere(int id, String noCours, int duree, Double prix) {
        this.id = id;
        this.noCours = noCours;
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

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }
    
}
