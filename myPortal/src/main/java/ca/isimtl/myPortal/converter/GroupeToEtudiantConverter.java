/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.isimtl.myPortal.converter;

import ca.isimtl.myPortal.model.Group;
import ca.isimtl.myPortal.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class GroupeToEtudiantConverter implements Converter<Object, Group> {
    
    @Autowired
    GroupService groupService;
    
    public Group convert(Object s) {
        Integer id = Integer.parseInt((String)s);
        Group group = groupService.findById(id);
        return group; 
    }
    
}
