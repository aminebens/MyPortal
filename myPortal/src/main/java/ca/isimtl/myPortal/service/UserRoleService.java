package ca.isimtl.myPortal.service;

import ca.isimtl.myPortal.model.UserRole;
import java.util.List;

public interface UserRoleService {
    
    UserRole findById(int id);
 
    UserRole findByType(String type);
     
    List<UserRole> findAll();
    
}
