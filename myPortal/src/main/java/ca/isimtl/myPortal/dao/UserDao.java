/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.isimtl.myPortal.dao;

import ca.isimtl.myPortal.model.User;
import java.util.List;

/**
 *
 * @author Francois YOUALEU
 */
public interface UserDao {
    
    User findById(int id);
    
    User findByLogin(String login);
 
    void saveUser(User user);
     
    List<User> getAllUsers();
    
    List<User> getContacts();
    
    List<User> getAdmin();
    
    List<User> getEtidiantAcconts();

}
