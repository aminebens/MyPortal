package ca.isimtl.myPortal.service;

import ca.isimtl.myPortal.model.User;
import java.util.List;

public interface UserService {
    
    User getUserConnexion(User user);
    
    User findById(int id);
     
    void saveUser(User user);
     
    void updateUser(User user);
 
    List<User> getAllUsers();
}
