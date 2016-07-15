/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.isimtl.myPortal.dao;

import ca.isimtl.myPortal.model.Prof;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Francois YOUALEU
 */
@Repository("profDao")
public class ProfDaoImpl extends AbstractDao<Integer, Prof> implements ProfDao{

    public Prof findById(int id) {
        return getByKey(id);
    }

    public List<Prof> getAll() {
        Criteria criteria = createEntityCriteria();
        return (List<Prof>) criteria.list();
    }

    public Prof findByIdPersonne(int id) {
        
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id_personne", id));
        return (Prof) criteria.uniqueResult();
    }
      
}
