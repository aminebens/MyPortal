/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.isimtl.myPortail.entity;

import org.joda.time.LocalDate;

/**
 *
 * @author Francois YOUALEU
 */
public class CoursEntity {
    
    private int id;
   
    private String titreMatiere;
   
    private String plageHoraire;
    
    private String libelle;
    
    private String maSession;

    private LocalDate  dateDebut;
    
    private LocalDate  dateFin;
    
    private String  nomProf;

    public CoursEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitreMatiere() {
        return titreMatiere;
    }

    public void setTitreMatiere(String titreMatiere) {
        this.titreMatiere = titreMatiere;
    }

    public String getPlageHoraire() {
        return plageHoraire;
    }

    public void setPlageHoraire(String plageHoraire) {
        this.plageHoraire = plageHoraire;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getMaSession() {
        return maSession;
    }

    public void setMaSession(String maSession) {
        this.maSession = maSession;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public String getNomProf() {
        return nomProf;
    }

    public void setNomProf(String nomProf) {
        this.nomProf = nomProf;
    }
      
}
