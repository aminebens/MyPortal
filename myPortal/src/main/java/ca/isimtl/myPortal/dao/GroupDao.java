/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.isimtl.myPortal.dao;

import ca.isimtl.myPortal.model.Group;
import java.util.List;

/**
 *
 * @author yaantech
 */
public interface GroupDao {
    Group findById(int id);
    void saveGroup(Group group);
    List<Group> getAllGroups();
}
