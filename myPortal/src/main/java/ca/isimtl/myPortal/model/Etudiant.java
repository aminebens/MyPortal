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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Francois YOUALEU
 */
@Entity
@Table(name = "etudiant")
public class Etudiant implements Serializable{
    
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private int id;
    
    @Size(min = 3, max = 12)
    @Column(name = "code_permanent", nullable = false)
    private String codePermanent;
    
    @Column(name = "is_international", nullable = false)
    private Boolean isInternational;
    
    @OneToOne
    @JoinColumn(name="id_groupe")
    private Group group;
    
    @OneToOne
    @JoinColumn(name="id_personne")
    private User user;

    public Etudiant() {
    }

    public Etudiant(int id, String codePermanent, Boolean isInternational, Group group, User user) {
        this.id = id;
        this.codePermanent = codePermanent;
        this.isInternational = isInternational;
        this.group = group;
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

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
}
