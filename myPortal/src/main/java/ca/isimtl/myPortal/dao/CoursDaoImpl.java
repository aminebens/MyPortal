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

    public List<Cours> getAllCours() {
        Criteria criteria = createEntityCriteria();
        return (List<Cours>) criteria.list();
    }
    
}
