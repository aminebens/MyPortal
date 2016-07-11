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
    
    User getUserConnexion(User user);
    
    User findById(int id);
 
    void saveUser(User user);
     
    List<User> getAllUsers();

}
