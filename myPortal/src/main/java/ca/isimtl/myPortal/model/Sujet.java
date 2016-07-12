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
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="sujet")
public class Sujet implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotEmpty
    @Column(name = "titre", nullable = false)
    private String titre;
    
    @NotEmpty
    @Column(name = "description", nullable = false)
    private String description;
    
    @OneToOne
    @JoinColumn(name="idUser")
    private User user;
    
    @NotEmpty
    @Column(name = "type", nullable = false)
    private String type;
    
    @NotNull
    @Column(name = "isResolu", nullable = false ,insertable=false)
    private Boolean isResolu;
    
    @NotNull
    @Column(name = "date_creation",  columnDefinition="DATETIME",insertable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_creation;

    public Sujet() {
    }

    public Sujet(int id, String titre, String description, String type, Boolean isResolu, Date date_creation) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.type = type;
        this.isResolu = isResolu;
        this.date_creation = date_creation;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getIsResolu() {
        return isResolu;
    }

    public void setIsResolu(Boolean isResolu) {
        this.isResolu = isResolu;
    }

    public Date getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }
    
    

}
