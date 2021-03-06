package ca.isimtl.myPortal.service;

import ca.isimtl.myPortal.model.User;
import java.util.List;

public interface UserService {
    
    User findById(int id);
    
    User findByLogin(String login);
     
    void saveUser(User user);
     
    void updateUser(User user);
 
    List<User> getAllUsers();
    
    User getLogedInUser();
    
    List<User> getContacts();
    
    List<User> getAdmin();
    
    List<User> getEtidiantAcconts();
    
}
