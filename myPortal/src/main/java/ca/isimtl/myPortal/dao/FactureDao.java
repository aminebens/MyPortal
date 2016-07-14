/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.isimtl.myPortal.dao;

import ca.isimtl.myPortal.model.Facture;

/**
 *
 * @author Nicolas
 */
public interface FactureDao {
    
        Facture findByUserId(int idUser);
}
