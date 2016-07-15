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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Francois YOUALEU
 */
@Entity
@Table(name="cours")
public class Cours implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name = "id_cours")
    private int id;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_matiere", nullable = false)
    private Matiere uneMat;
    
    @NotEmpty
    @Column(name = "plage_horaire", nullable = false)
    private String plageHoraire;
    
    @NotEmpty
    @Column(name = "libelle", nullable = false)
    private String libelle;
    
    @NotEmpty
    @Column(name = "session", nullable = false)
    private String maSession;

    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "date_debut", nullable = false)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    @Temporal(javax.persistence.TemporalType.DATE)
    private LocalDate  dateDebut;
    
    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "date_fin", nullable = false)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    @Temporal(javax.persistence.TemporalType.DATE)
    private LocalDate  dateFin;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_prof")
    private Prof prof;

    public Cours(int id, Matiere uneMat, String plageHoraire, String libelle, String maSession, LocalDate dateDebut, LocalDate dateFin, Prof prof) {
        this.id = id;
        this.uneMat = uneMat;
        this.plageHoraire = plageHoraire;
        this.libelle = libelle;
        this.maSession = maSession;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.prof = prof;
    }

    public Cours() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Matiere getUneMat() {
        return uneMat;
    }

    public void setUneMat(Matiere uneMat) {
        this.uneMat = uneMat;
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

    public Prof getProf() {
        return prof;
    }

    public void setProf(Prof prof) {
        this.prof = prof;
    }

   
    
}
