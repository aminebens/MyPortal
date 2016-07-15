/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.isimtl.myPortal.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="groupe")
public class Group implements Serializable{
    
    @Id
    @GeneratedValue
    @Column(name = "id_groupe")
    private int id;
    
    @NotEmpty
    @Column(name = "nom", nullable = false)
    private String nom;
    
    @OneToMany(mappedBy = "groupe", cascade = CascadeType.ALL)
    private List<Etudiant> etudiants;
    
    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany
    @JoinTable(name = "cours_groupe",
            joinColumns = {@JoinColumn(name = "id_groupe")},
            inverseJoinColumns = {@JoinColumn(name = "id_cours")})
    private List<Cours> mesCours;

    public Group() {
    }

    public Group(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(List<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }

    public List<Cours> getMesCours() {
        return mesCours;
    }

    public void setMesCours(List<Cours> mesCours) {
        this.mesCours = mesCours;
    }
    
}
