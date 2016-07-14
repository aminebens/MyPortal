/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.isimtl.myPortal.service;

import ca.isimtl.myPortal.dao.EtudiantDao;
import ca.isimtl.myPortal.model.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Francois YOUALEU
 */
@Service("etudiantService")
@Transactional
public class EtudiantServiceImpl implements EtudiantService{

    @Autowired
    EtudiantDao etudiant;
    
    public Etudiant findById(int id) {
        return etudiant.findById(id);
    }

    public Etudiant findByIdPersonne(int id) {
        return etudiant.findByIdPersonne(id);
    }
  
}
