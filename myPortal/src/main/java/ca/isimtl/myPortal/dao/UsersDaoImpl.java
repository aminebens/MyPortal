/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.isimtl.myPortal.dao;

import ca.isimtl.myPortal.model.Users;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Francois YOUALEU
 */
@Repository("UsersDao")
public class UsersDaoImpl extends AbstractDao<Integer, Users>implements UsersDao{

  
    public Users findUserConnexion(Users user) {
        return getUserConnexion(user);
    }
    
    
}
