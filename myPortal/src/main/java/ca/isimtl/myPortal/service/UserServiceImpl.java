package ca.isimtl.myPortal.service;

import ca.isimtl.myPortal.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ca.isimtl.myPortal.dao.UserDao;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
    
    @Autowired
    private UserDao userDao;
    
    public User findById(int id) {
        return userDao.findById(id);
    }
    
    public User findByLogin(String login) {
        User user = userDao.findByLogin(login);
        return user;
    }

    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    public void updateUser(User user) {
        User entity = userDao.findById(user.getId());
        if(entity != null){
            entity.setNom(user.getNom());
            entity.setPrenom(user.getPrenom());
            entity.setLogin(user.getLogin());
            entity.setPwd(user.getPwd());
            entity.setEmail(user.getEmail());
            entity.setTelephone(user.getTelephone());
            entity.setDateNaissance(user.getDateNaissance());
            entity.setAdresse(user.getAdresse());
            entity.setNumeroAssuranceSociale(user.getNumeroAssuranceSociale());
            entity.setActive(user.getActive());
            entity.setUserRole(user.getUserRole());
        }
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}
