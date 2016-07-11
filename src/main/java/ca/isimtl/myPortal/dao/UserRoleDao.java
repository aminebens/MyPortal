package ca.isimtl.myPortal.dao;

import ca.isimtl.myPortal.model.UserRole;
import java.util.List;

public interface UserRoleDao {
    
    List<UserRole> findAll();
     
    UserRole findByType(String type);
     
    UserRole findById(int id);
    
}
