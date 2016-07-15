/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.isimtl.myPortal.service;

import ca.isimtl.myPortal.dao.FactureDao;
import ca.isimtl.myPortal.dao.UserDao;
import ca.isimtl.myPortal.model.Facture;
import ca.isimtl.myPortal.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Nicolas
 */
@Service("factureService")
@Transactional
public class FactureServiceImpl {
    
    @Autowired
    private FactureDao factureDao;
    
    public Facture findByUserId(int id) {
        return factureDao.findByUserId(id);
    }
}
