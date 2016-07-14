/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.isimtl.myPortal.dao;

import ca.isimtl.myPortal.model.Cours;
import java.util.List;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Francois YOUALEU
 */
@Repository("coursDao")
public class CoursDaoImpl extends AbstractDao<Integer, Cours> implements CoursDao{

    public List<Cours> getAll() {
        Criteria criteria = createEntityCriteria();
        return (List<Cours>) criteria.list();
    }

    public Cours findById(int id) {
        return getByKey(id);
    }

    public void saveCours(Cours unCours) {
        persist(unCours);
    }

    public void deleteCours(Cours unCours) {
        delete(unCours);
    }
    
}
