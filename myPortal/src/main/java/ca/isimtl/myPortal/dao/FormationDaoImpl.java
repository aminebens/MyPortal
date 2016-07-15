/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.isimtl.myPortal.dao;

import ca.isimtl.myPortal.model.Formation;
import java.util.List;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Francois YOUALEU
 */
@Repository("formationDao")
public class FormationDaoImpl extends AbstractDao<Integer, Formation> implements FormationDao{

    public Formation findById(int id) {
        return getByKey(id);
    }

    public List<Formation> getAll() {
        Criteria criteria = createEntityCriteria();
        return (List<Formation>) criteria.list();
    }
    
}
