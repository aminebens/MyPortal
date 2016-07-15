/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.isimtl.myPortal.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Type;

import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Francois YOUALEU
 */
@Entity
@Table(name = "formation")
public class Formation implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id_formation")
    private int id;

    @NotEmpty
    @Column(name = "titre", nullable = false)
    private String titre;

    @NotEmpty
    @Column(name = "duree", nullable = false)
    private int duree;

    @Column(name = "prix", nullable = false)
    private Double prix;

    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "date_creation", nullable = false)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    @Temporal(javax.persistence.TemporalType.DATE)
    private LocalDate dateCreation;

    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany
    @JoinTable(name = "matiere_formation",
            joinColumns = {
                @JoinColumn(name = "id_formation")},
            inverseJoinColumns = {
                @JoinColumn(name = "id_matiere")})
    private List<Matiere> mesMatieres;

    public Formation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
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

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }

    public List<Matiere> getMesMatieres() {
        return mesMatieres;
    }

    public void setMesMatieres(List<Matiere> mesMatieres) {
        this.mesMatieres = mesMatieres;
    }
    
}
