/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.isimtl.myPortal.service;

import ca.isimtl.myPortal.model.Cours;
import java.util.List;

/**
 *
 * @author Francois YOUALEU
 */
public interface CoursService {
    
    Cours findById(int id);
    
     void saveCours(Cours unCours);
    
    void updateCours(Cours unCours);
    
    void deleteCours(Cours unCours);
    
    List<Cours> getAll();
}
