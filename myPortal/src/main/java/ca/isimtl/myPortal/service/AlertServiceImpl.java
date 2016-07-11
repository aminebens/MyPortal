/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.isimtl.myPortal.service;

import ca.isimtl.myPortal.dao.AlertDao;
import ca.isimtl.myPortal.model.Alert;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("alertService")
@Transactional
public class AlertServiceImpl implements AlertService{

    @Autowired
    AlertDao alertDao;
    public List<Alert> findByIdUserTO(Integer idUserTo) {
       return alertDao.findByIdUserTO(idUserTo);
    }

    public List<Alert> findByIdGroup(Integer idGroup) {
        return alertDao.findByIdGroup(idGroup);
    }

    public Alert findByid(int id) {
        return alertDao.findByid(id);
    }

    public void saveAlert(Alert alert) {
        alertDao.saveAlert(alert);
    }

    public void updateAlert(Alert alert) {
        Alert entity = alertDao.findByid(alert.getId());
        if(entity!=null){
           entity.setIdGroupe(alert.getIdGroupe());
           entity.setIdUserTo(alert.getIdUserTo());
           entity.setContenu(alert.getContenu());
           entity.setType(alert.getType());
           entity.setIdUserFrom(alert.getIdUserFrom());
        }
    }

    public List<Alert> getAllAlert() {
        return alertDao.getAllAlert();
    }
    
}
