/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.isimtl.myPortal.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Nicolas
 */
@Entity
@Table(name = "facture")
public class Facture {
    
    // attributs
    @NotNull
    @Id
    @Column(name = "id_etudiant", nullable = false)
    private int id;
    
    @NotEmpty
    @Column(name = "password", nullable = false)
    private int idEtudiant;
    
    @NotNull
    @Column(name = "dateCreation",  columnDefinition="DATETIME",insertable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    
    @NotEmpty
    @Column(name = "montant", nullable = false)
    private double montant;
    
    @NotEmpty
    @Column(name = "montant", nullable = true)
    private String typePaiement;
    
    // constructors
    public Facture(int id, int idEtudiant, Date date, double montant, String typePaiement) {
        this.id = id;
        this.idEtudiant = idEtudiant;
        this.date = date;
        this.montant = montant;
        this.typePaiement = typePaiement;
    }
    
    public Facture(){}
    
    // getters setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEtudiant() {
        return idEtudiant;
    }

    public void setIdEtudiant(int idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getTypePaiement() {
        return typePaiement;
    }

    public void setTypePaiement(String typePaiement) {
        this.typePaiement = typePaiement;
    }
    
}
