/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.isimtl.myPortal.service;

import ca.isimtl.myPortal.dao.FormationDao;
import ca.isimtl.myPortal.model.Formation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Francois YOUALEU
 */
@Service("formationService")
@Transactional
public class FormationServiceImpl implements FormationService{

    @Autowired
    private FormationDao formationDao;

    public Formation findById(int id) {
        return formationDao.findById(id);
    }

    public List<Formation> getAll() {
        return formationDao.getAll();
    }
}
