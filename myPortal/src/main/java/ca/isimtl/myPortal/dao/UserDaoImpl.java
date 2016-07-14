/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.isimtl.myPortal.dao;

import ca.isimtl.myPortal.model.User;
import ca.isimtl.myPortal.service.UserRoleService;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Francois YOUALEU
 */
@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

    @Autowired
    UserRoleService userRoleService;
    
    public User findById(int id) {
        return getByKey(id);
    }
    
    public User findByLogin(String login) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("login", login));
        User user = (User)crit.uniqueResult();
        if(user!=null){
            Hibernate.initialize(user.getUserRole());
        }
        return user;
    }

    public void saveUser(User user) {
        persist(user);
    }
    
    public List<User> getAllUsers() {
        Criteria criteria = createEntityCriteria();
        return (List<User>) criteria.list();
    }

    public List<User> getContacts() {
        Criteria criteria = createEntityCriteria();      
        criteria.add(Restrictions.not(Restrictions.eq("userRole", userRoleService.findById(2))));
        return (List<User>) criteria.list();
    }

    public List<User> getAdmin() {
        Criteria criteria = createEntityCriteria();      
        criteria.add(Restrictions.not(Restrictions.eq("userRole", userRoleService.findById(6))));
        return (List<User>) criteria.list();
    }    
}
