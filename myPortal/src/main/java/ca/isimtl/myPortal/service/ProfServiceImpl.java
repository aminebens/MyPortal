/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.isimtl.myPortal.service;

import ca.isimtl.myPortal.dao.ProfDao;
import ca.isimtl.myPortal.model.Prof;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Francois YOUALEU
 */
@Service("profService")
@Transactional
public class ProfServiceImpl implements ProfService{
    
    @Autowired
    ProfDao profDao;

    public Prof findById(int id) {
        return profDao.findById(id);
    }

    public List<Prof> getAll() {
        return profDao.getAll();
    }
    
    public Prof findByIdPersonne(int id){
        return profDao.findByIdPersonne(id);
    }
    
}
