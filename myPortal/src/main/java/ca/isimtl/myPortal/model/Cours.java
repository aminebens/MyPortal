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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotEmpty
    @Column(name = "id_matiere", nullable = false)
    private int idMatiere;
    
    @NotEmpty
    @Column(name = "plage_horaire", nullable = false)
    private String plageHoraire;
    
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
    
    @NotEmpty
    @Column(name = "id_prof", nullable = false)
    private int idProf;

    public Cours(int id, int idMatiere, String plageHoraire, String maSession, LocalDate dateDebut, LocalDate dateFin, int idProf) {
        this.id = id;
        this.idMatiere = idMatiere;
        this.plageHoraire = plageHoraire;
        this.maSession = maSession;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.idProf = idProf;
    }

    public Cours() {
    }

    public int getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(int idMatiere) {
        this.idMatiere = idMatiere;
    }

    public int getIdProf() {
        return idProf;
    }

    public void setIdProf(int idProf) {
        this.idProf = idProf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlageHoraire() {
        return plageHoraire;
    }

    public void setPlageHoraire(String plageHoraire) {
        this.plageHoraire = plageHoraire;
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
    
}
