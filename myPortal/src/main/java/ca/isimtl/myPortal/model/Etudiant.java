/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.isimtl.myPortal.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Francois YOUALEU
 */
@Entity
@Table(name = "etudiant")
public class Etudiant implements Serializable{
    
    @NotNull
    @Id
    @Column(name = "id_etudiant", nullable = false)
    private int id;
    
    @Size(min = 3, max = 12)
    @Column(name = "code_permanent", nullable = false)
    private String codePermanent;
    
    @Column(name = "is_international", nullable = false)
    private Boolean isInternational;
    
    @Column(name = "id_groupe", nullable = false)
    private int idGroupe;
    
    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private User user;

    public Etudiant() {
    }

    public Etudiant(int id, String codePermanent, Boolean isInternational, int idGroupe, User user) {
        this.id = id;
        this.codePermanent = codePermanent;
        this.isInternational = isInternational;
        this.idGroupe = idGroupe;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodePermanent() {
        return codePermanent;
    }

    public void setCodePermanent(String codePermanent) {
        this.codePermanent = codePermanent;
    }

    public Boolean getIsInternational() {
        return isInternational;
    }

    public void setIsInternational(Boolean isInternational) {
        this.isInternational = isInternational;
    }

    public int getIdGroupe() {
        return idGroupe;
    }

    public void setIdGroupe(int idGroupe) {
        this.idGroupe = idGroupe;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
}
