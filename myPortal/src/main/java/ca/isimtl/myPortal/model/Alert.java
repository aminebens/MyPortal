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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="alert")
public class Alert implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotEmpty
    @Column(name = "type", nullable = false)
    private String type;
    
    @NotEmpty
    @Column(name = "contenu", nullable = false)
    private String contenu;
    
    @Column(name = "idGroupe" , nullable = true)
    private Integer idGroupe;
    
    @Column(name = "idUserTo", nullable = true)
    private Integer idUserTo;
    
    @Column(name = "idUserFrom", nullable = false)
    private int idUserFrom;
    
    @Column(name = "date", columnDefinition="DATETIME",insertable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

   

    public Alert() {
    }

    public Alert(int id, String type, String contenu, Integer idGroupe, Integer idUserTo,int idUserFrom) {
        this.id = id;
        this.type = type;
        this.contenu = contenu;
        this.idGroupe = idGroupe;
        this.idUserTo = idUserTo;
        this.idUserFrom=idUserFrom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Integer getIdGroupe() {
        return idGroupe;
    }

    public void setIdGroupe(Integer idGroupe) {
        this.idGroupe = idGroupe;
    }

    public Integer getIdUserTo() {
        return idUserTo;
    }

    public void setIdUserTo(Integer idUserTo) {
        this.idUserTo = idUserTo;
    }

    public int getIdUserFrom() {
        return idUserFrom;
    }

    public void setIdUserFrom(int idUserFrom) {
        this.idUserFrom = idUserFrom;
    }
    
     public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
