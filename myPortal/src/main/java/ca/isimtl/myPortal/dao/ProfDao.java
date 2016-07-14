/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.isimtl.myPortal.dao;

import ca.isimtl.myPortal.model.Prof;
import java.util.List;

/**
 *
 * @author Francois YOUALEU
 */
public interface ProfDao {
    
     Prof findById(int id);
     
     List<Prof> getAll();
     
     Prof findByIdPersonne(int id);
}
