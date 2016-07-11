/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.isimtl.myPortal.service;

import ca.isimtl.myPortal.dao.GroupDao;
import ca.isimtl.myPortal.model.Group;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("groupService")
@Transactional
public class GroupServiceImpl implements GroupService{
    
    @Autowired
    private GroupDao groupDao;

    public Group findById(int id) {
        return groupDao.findById(id);
    }

    public void saveGroup(Group group) {
        groupDao.saveGroup(group);
    }

   public void updateGroup(Group group) {
        Group entity = groupDao.findById(group.getId());
        if(entity != null){
            entity.setNom(group.getNom());
        }
    }
    
    public List<Group> getAllgroup() {
        return groupDao.getAllGroups();
    }

    
    
}
