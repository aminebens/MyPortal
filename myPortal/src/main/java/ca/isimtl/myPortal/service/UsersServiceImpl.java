/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.isimtl.myPortal.service;

import ca.isimtl.myPortal.dao.UsersDao;
import ca.isimtl.myPortal.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Francois YOUALEU
 */
@Service("usersService")
@Transactional
public class UsersServiceImpl implements UsersService{
    
    @Autowired
    private UsersDao userDao;
    
    public Users getUserConnexion(Users user) {
        return userDao.getUserConnexion(user);
    }
}
