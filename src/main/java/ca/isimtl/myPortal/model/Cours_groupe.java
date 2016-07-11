/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.isimtl.myPortal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Francois YOUALEU
 */

@Entity
@Table(name = "cours_groupe")
public class Cours_groupe {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotEmpty
    @Column(name = "id_groupe", nullable = false)
    private int idGroupe;
    
    @NotEmpty
    @Column(name = "id_cours", nullable = false)
    private int idCours;
    
    
}
