/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.isimtl.myPortal.dao;

import ca.isimtl.myPortal.model.Group;
import java.util.List;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

/**
 *
 * @author yaantech
 */
@Repository("groupDao")
public class GroupDaoImpl extends AbstractDao<Integer, Group> implements GroupDao{

    public Group findById(int id) {
        return getByKey(id);
    }

    public void saveGroup(Group group) {
        persist(group);
    }
    public List<Group> getAllGroups() {
        Criteria criteria =createEntityCriteria();
        return (List<Group>) criteria.list();
    }
    
}
