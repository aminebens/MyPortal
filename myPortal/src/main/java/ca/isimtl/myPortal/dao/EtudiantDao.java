/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.isimtl.myPortal.dao;

import ca.isimtl.myPortal.model.Etudiant;
import java.util.List;

/**
 *
 * @author Francois YOUALEU
 */
public interface EtudiantDao {
    
    Etudiant findById(int id);
    
    Etudiant findByIdPersonne(int id);
    
    List<Etudiant> getAll();
    
    void saveEtudiant(Etudiant etu);
}
