/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.isimtl.myPortal.dao;

import ca.isimtl.myPortal.model.Alert;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author yaantech
 */
@Repository("alertDao")
public class AlertDaoImpl extends AbstractDao<Integer, Alert> implements AlertDao{

    public List<Alert> findByIdUserTO(Integer idUserTo) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("idUserTo", idUserTo));
        return (List<Alert>) criteria.list();
    }

    public List<Alert> findByIdGroup(Integer idGroup) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("idGroupe", idGroup));
        return (List<Alert>) criteria.list();
    }

    public Alert findByid(int id) {
        return getByKey(id);
    }

    public void saveAlert(Alert alert) {
        persist(alert);
    }

    public List<Alert> getAllAlert() {
        Criteria criteria = createEntityCriteria();
        return (List<Alert>) criteria.list();
    }

    public List<Alert> findByIdUserFrom(Integer idUserFrom) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("idUserFrom", idUserFrom));
        return (List<Alert>) criteria.list();
    }

    public void deleteAlert(Alert alert) {
        delete(alert);
    }
    
}
